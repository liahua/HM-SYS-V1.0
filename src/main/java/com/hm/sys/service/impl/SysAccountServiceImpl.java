package com.hm.sys.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.StringUtil;
import com.hm.common.exception.ServiceException;
import com.hm.common.utils.ListUtil;
import com.hm.common.vo.DayAccount;
import com.hm.common.vo.DynamicRoomInfo;
import com.hm.sys.dao.AccountInfoMapper;
import com.hm.sys.dao.AccountRoomMapper;
import com.hm.sys.dao.CheckInfoMapper;
import com.hm.sys.dao.DynamicRoomMapper;
import com.hm.sys.dao.OrderInfoMapper;
import com.hm.sys.dao.StayInfoMapper;
import com.hm.sys.entity.AccountInfo;
import com.hm.sys.entity.AccountInfoExample;
import com.hm.sys.entity.AccountRoom;
import com.hm.sys.entity.AccountRoomExample;
import com.hm.sys.entity.CheckInfo;
import com.hm.sys.entity.CheckInfoExample;
import com.hm.sys.entity.OrderInfo;
import com.hm.sys.entity.OrderInfoExample;
import com.hm.sys.entity.StayInfo;
import com.hm.sys.entity.StayInfoExample;
import com.hm.sys.entity.StayInfoExample.Criteria;
import com.hm.sys.service.SysAccountService;

/**
 * )账单
 * 
 * @author 邹文豪
 *
 */
@Service
public class SysAccountServiceImpl implements SysAccountService {

	@Autowired
	private DynamicRoomMapper roomInfoMapper;

	@Autowired
	private StayInfoMapper stayInfoMapper;

	@Autowired
	private OrderInfoMapper orderInfoMapper;

	@Autowired
	private CheckInfoMapper checkInfoMapper;

	@Autowired
	private AccountRoomMapper accountRoomMapper;

	@Autowired
	private AccountInfoMapper accountInfoMapper;

	private Date startTime = null;

	private Date endTime = null;

	private Date date = null;

	/**
	 * 日明细统计
	 */
	@Override
	public synchronized DayAccount doDayCheck(String date) {
		resetTime(date);

		DayAccount da = doFindAccountByDate();

		if (da != null) {
			return da;
		}
		
		da = new DayAccount();
		
		// 各种房间状态统计
		HashMap<Integer, Integer> filledMap = new HashMap<>();
		HashMap<Integer, Integer> unFilledMap = new HashMap<>();
		statAccount(filledMap, unFilledMap);

		// 写入数据库
		List<AccountRoom> arList = new ArrayList<>();
		for (int i = 1; i <= 4; i++) {
			AccountRoom ar = new AccountRoom();
			ar.setDay(this.date);
			ar.setRoomTypeId(i);

			Integer fillNum = filledMap.get(i);
			// System.out.println("fillNum"+fillNum);
			ar.setFilledNum(fillNum != null ? fillNum : 0);

			Integer unFilledNum = unFilledMap.get(i);
			// System.out.println("unFilledNum"+unFilledNum);
			ar.setUnfilledNum(unFilledNum != null ? unFilledNum : 0);

			arList.add(ar);
			accountRoomMapper.insert(ar);
		}
		da.setRoomList(arList);

		// 日账单统计
		AccountInfo accountInfo = new AccountInfo();

		accountInfo.setDay(this.date);
		// 入住人数统计
		accountInfo.setManCount(stayManAccount());

		// 押金统计
		accountInfo.setCashCount(cashAccount());

		// 订单统计
		orderAccount(accountInfo);

		// 结算统计
		accountInfo.setCheckinCount(checkinAccount());

		da.setAccountInfo(accountInfo);
		accountInfoMapper.insert(accountInfo);

		return da;
	}

	private DayAccount doFindAccountByDate() {
		AccountInfoExample infoExample = new AccountInfoExample();
		com.hm.sys.entity.AccountInfoExample.Criteria icriteria = infoExample.createCriteria();
		icriteria.andDayEqualTo(this.date);

		List<AccountInfo> info = accountInfoMapper.selectByExample(infoExample);
		if(info.size()==0) {
			return null;
		}
		
		AccountRoomExample roomExample = new AccountRoomExample();
		com.hm.sys.entity.AccountRoomExample.Criteria rcriterria = roomExample.createCriteria();
		rcriterria.andDayEqualTo(this.date);
		
		List<AccountRoom> room = accountRoomMapper.selectByExample(roomExample);
		if(room.size()==0) {
			return null;
		}
		
		DayAccount dayAccount = new DayAccount();
		dayAccount.setAccountInfo(info.get(0));
		dayAccount.setRoomList(room);
		return dayAccount;
	}

	private void resetTime(String date) {
		if (!StringUtil.isEmpty(date)) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				this.date = sdf.parse(date);
			} catch (ParseException e) {
				throw new ServiceException("日期格式有误");
			}

		} else {
			this.date = new Date();
		}
		startTime = initDate(0);
		endTime = initDate(24);
	}

	private Double checkinAccount() {
		CheckInfoExample checkInfoExample = new CheckInfoExample();
		com.hm.sys.entity.CheckInfoExample.Criteria criteria = checkInfoExample.createCriteria();
		criteria.andCheckDateBetween(startTime, endTime);

		List<CheckInfo> checkList = checkInfoMapper.selectByExample(checkInfoExample);
		double checkinCount = 0d;

		// System.out.println("checkinCount" + checkinCount);
		if (ListUtil.isEmpty(checkList)) {
			return checkinCount;
		}

		for (CheckInfo ci : checkList) {
			Double checkinMoney = ci.getPaidUpMoney();

			if (checkinMoney != null)
				checkinCount += checkinMoney;
		}
		// System.out.println("checkinCount" + checkinCount);
		return checkinCount;
	}

	private Double cashAccount() {
		// 当天入住的入住信息
		StayInfoExample stayInfoExample = new StayInfoExample();
		Criteria criteria = stayInfoExample.createCriteria();
		criteria.andStayDateBetween(startTime, endTime);

		double cashCount = 0d;
		List<StayInfo> stayList = stayInfoMapper.selectByExample(stayInfoExample);

		if (ListUtil.isEmpty(stayList)) {
			return cashCount;
		}
		for (StayInfo si : stayList) {
			Float cash = si.getCash();
			if (cash != null)
				cashCount += cash;
		}
		// System.out.println("cashCount" + cashCount);
		return cashCount;
	}

	private void orderAccount(AccountInfo accountInfo) {
		OrderInfoExample orderInfoExample = new OrderInfoExample();
		com.hm.sys.entity.OrderInfoExample.Criteria criteria = orderInfoExample.createCriteria();
		criteria.andCreatedtimeBetween(startTime, endTime);
		List<OrderInfo> orderInfoList = orderInfoMapper.selectByExample(orderInfoExample);

		Integer orderCount = 0;
		Double orderMoney = 0d;

		if (ListUtil.isEmpty(orderInfoList)) {
			accountInfo.setOrderCount(orderCount);
			accountInfo.setOrderMoney(orderMoney);
			return;
		}

		for (OrderInfo oi : orderInfoList) {
			Float om = oi.getOrderMoney();
			if (om != null)
				orderMoney += om;
		}
		orderCount = orderInfoList.size();

//		System.out.println("orderCount" + orderCount);
//		System.out.println("orderMoney" + orderMoney);

		accountInfo.setOrderCount(orderCount);
		accountInfo.setOrderMoney(orderMoney);
		return;
	}

	/**
	 * 得到指定的时间对象
	 * 
	 * @param hour 小时数
	 */
	private Date initDate(Integer hour) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	private Integer stayManAccount() {
		// 未支付的入住信息
		StayInfoExample stayInfoExample = new StayInfoExample();
		Criteria criteria = stayInfoExample.createCriteria();
		criteria.andIsCheckoutEqualTo(0);

		int manCount = 0;
		List<StayInfo> stayList = stayInfoMapper.selectByExample(stayInfoExample);
		if (ListUtil.isEmpty(stayList)) {
			return manCount;
		}

		Long now = this.date.getTime();
		for (StayInfo si : stayList) {
			if (now > si.getStayDate().getTime() && now < si.getLeaveDate().getTime()) {
				Integer stayManCount = si.getStayManCount();
				if (stayManCount != null)
					manCount += stayManCount;
			}
		}
		// System.out.println("manCount" + manCount);
		return manCount;
	}

	private void statAccount(Map<Integer, Integer> filledMap, Map<Integer, Integer> unFilledMap) {
		List<DynamicRoomInfo> roomList = roomInfoMapper.findObjects();
		if (ListUtil.isEmpty(roomList)) {
			return;
		}

		// System.out.println("房间数："+roomList.size());
		for (DynamicRoomInfo dri : roomList) {
			String stat = dri.getStat();
			Integer rtId = dri.getRtId();
			if ("已入住".equals(stat)) {
				Integer count = filledMap.get(rtId);
				filledMap.put(rtId, count == null ? 1 : count + 1);
			} else {
				Integer count = unFilledMap.get(rtId);
				unFilledMap.put(rtId, count == null ? 1 : count + 1);
			}
		}

	}

}
