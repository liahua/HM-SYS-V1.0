package com.hm.sys.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.common.vo.DayAccount;
import com.hm.common.vo.DynamicRoomInfo;
import com.hm.sys.dao.OrderInfoMapper;
import com.hm.sys.dao.RoomInfoMapper;
import com.hm.sys.dao.StayInfoMapper;
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
	private RoomInfoMapper roomInfoMapper;

	@Autowired
	private StayInfoMapper stayInfoMapper;

	@Autowired
	private OrderInfoMapper orderInfoMapper;

	/**
	 * 日明细
	 */
	@Override
	public DayAccount doDayCheck() {
		// 各种房间状态统计
		HashMap<String, Integer> statMap = new HashMap<>();
		statAccount(statMap);

		// 入住人数统计
		Integer manCount = stayManAccount();

		// 押金统计
		Double cashCount = cashAccount();

		// 订单统计
		Integer orderCount = 0;
		Double orderMoney = 0d;
		orderAccount(orderCount, orderMoney);

		//结算统计
		
		
		return null;
	}

	private Double cashAccount() {
		// 当天入住的入住信息
		StayInfoExample stayInfoExample = new StayInfoExample();
		Criteria criteria = stayInfoExample.createCriteria();
		criteria.andStayDateBetween(initDate(0), initDate(24));

		double cashCount = 0d;
		List<StayInfo> stayList = stayInfoMapper.selectByExample(stayInfoExample);

		if (stayList.size() == 0) {
			return cashCount;
		}
		for(StayInfo si : stayList) {
			cashCount += si.getCash();
		}
		
		return cashCount;
	}

	private void orderAccount(Integer orderCount, Double orderMoney) {
		OrderInfoExample orderInfoExample = new OrderInfoExample();
		com.hm.sys.entity.OrderInfoExample.Criteria criteria = orderInfoExample.createCriteria();
		criteria.andCreatedtimeBetween(initDate(0), initDate(24));
		List<OrderInfo> orderInfoList = orderInfoMapper.selectByExample(orderInfoExample);
		if (orderInfoList.size() == 0) {
			return;
		}

		for (OrderInfo oi : orderInfoList) {
			orderMoney += oi.getOrderMoney();
		}
		orderCount = orderInfoList.size();
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
		if (stayList.size() == 0) {
			return manCount;
		}

		Long now = System.currentTimeMillis();
		for (StayInfo si : stayList) {
			if (now > si.getStayDate().getTime() && now < si.getLeaveDate().getTime()) {
				manCount += si.getStayManCount();
			}
		}
		return manCount;
	}

	private void statAccount(HashMap<String, Integer> statMap) {
		List<DynamicRoomInfo> roomList = roomInfoMapper.findObjects();
		if (roomList.size() == 0) {
			return;
		}

		for (DynamicRoomInfo dri : roomList) {
			String stat = dri.getStat();
			String rtName = dri.getRtName();

			if ("已入住".equals(stat)) {
				Integer count = statMap.get(rtName);
				statMap.put(rtName, count == null ? 1 : count + 1);
			} else {
				Integer count = statMap.get(rtName + "&");
				statMap.put(rtName + "&", count == null ? 1 : count + 1);
			}
		}

	}

}
