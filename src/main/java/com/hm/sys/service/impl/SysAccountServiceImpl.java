package com.hm.sys.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.common.utils.ListUtil;
import com.hm.common.vo.DynamicRoomInfo;
import com.hm.sys.dao.AccountInfoMapper;
import com.hm.sys.dao.AccountRoomMapper;
import com.hm.sys.dao.CheckInfoMapper;
import com.hm.sys.dao.DynamicRoomMapper;
import com.hm.sys.dao.OrderInfoMapper;
import com.hm.sys.dao.StayInfoMapper;
import com.hm.sys.entity.AccountInfo;
import com.hm.sys.entity.AccountRoom;
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

	/**
	 * 日明细
	 */
	@Override
	public int doDayCheck() {
		resetTime();
		// 各种房间状态统计
		HashMap<Integer, Integer> filledMap = new HashMap<>();
		HashMap<Integer, Integer> unFilledMap = new HashMap<>();
		statAccount(filledMap, unFilledMap);

		// 写入数据库
		for (int i = 1; i <= 4; i++) {
			AccountRoom ar = new AccountRoom();
			ar.setDay(new Date());
			ar.setRoomTypeId(i);

			Integer fillNum = filledMap.get(i);
			System.out.println("fillNum"+fillNum);
			ar.setFilledNum(fillNum != null ? fillNum : 0);
			
			Integer unFilledNum = unFilledMap.get(i);
			System.out.println("unFilledNum"+unFilledNum);
			ar.setUnfilledNum(unFilledNum != null ? unFilledNum : 0);

			accountRoomMapper.insert(ar);
		}

		// 日账单统计
		AccountInfo accountInfo = new AccountInfo();
		
		accountInfo.setDay(new Date());
		// 入住人数统计
		accountInfo.setManCount(stayManAccount());

		// 押金统计
		accountInfo.setCashCount(cashAccount());

		// 订单统计
		orderAccount(accountInfo);

		// 结算统计
		accountInfo.setCheckinCount(checkinAccount());

		int row = accountInfoMapper.insert(accountInfo);

		return row;
	}

	private void resetTime() {
		startTime = initDate(0);
		endTime = initDate(24);
	}

	private Double checkinAccount() {
		CheckInfoExample checkInfoExample = new CheckInfoExample();
		com.hm.sys.entity.CheckInfoExample.Criteria criteria = checkInfoExample.createCriteria();
		criteria.andCheckDateBetween(startTime, endTime);

		List<CheckInfo> checkList = checkInfoMapper.selectByExample(checkInfoExample);
		double checkinCount = 0d;

		if (ListUtil.isEmpty(checkList)) {
			return checkinCount;
		}

		for (CheckInfo ci : checkList) {
			Float checkinMoney = ci.getPaidUpMoney();

			if (checkinMoney != null)
				checkinCount += checkinMoney;
		}
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
		return cashCount;
	}

	private void orderAccount(AccountInfo accountInfo) {
		OrderInfoExample orderInfoExample = new OrderInfoExample();
		com.hm.sys.entity.OrderInfoExample.Criteria criteria = orderInfoExample.createCriteria();
		criteria.andCreatedtimeBetween(startTime, endTime);
		List<OrderInfo> orderInfoList = orderInfoMapper.selectByExample(orderInfoExample);
		if (ListUtil.isEmpty(orderInfoList)) {
			return;
		}
		
		Integer orderCount = 0;
		Double orderMoney = 0d;
		for (OrderInfo oi : orderInfoList) {
			Float om = oi.getOrderMoney();
			if (om != null)
				orderMoney += om;
		}
		orderCount = orderInfoList.size();
		
		accountInfo.setOrderCount(orderCount);
		accountInfo.setOrderMoney(orderMoney);
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

		Long now = System.currentTimeMillis();
		for (StayInfo si : stayList) {
			if (now > si.getStayDate().getTime() && now < si.getLeaveDate().getTime()) {
				Integer stayManCount = si.getStayManCount();
				if (stayManCount != null)
					manCount += stayManCount;
			}
		}
		//System.out.println("manCount" + manCount);
		return manCount;
	}

	private void statAccount(Map<Integer, Integer> filledMap, Map<Integer, Integer> unFilledMap) {
		List<DynamicRoomInfo> roomList = roomInfoMapper.findObjects();
		if (ListUtil.isEmpty(roomList)) {
			return;
		}

		System.out.println("房间数："+roomList.size());
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
