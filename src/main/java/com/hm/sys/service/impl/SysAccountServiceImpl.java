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
		statAmount(statMap);

		// 入住人数统计
		Integer manCount = 0;
		Integer stayCount = 0;
		stayAmount(manCount,stayCount);
		
		// 订单统计
		OrderInfoExample orderInfoExample = new OrderInfoExample();
		com.hm.sys.entity.OrderInfoExample.Criteria criteria = orderInfoExample.createCriteria();
		criteria.andCreatedtimeBetween(initDate(0), initDate(24));
		List<OrderInfo> orderInfolist = orderInfoMapper.selectByExample(orderInfoExample);

		return null;
	}
	
	/**
	 * 得到指定的时间对象
	 * @param hour 小时数
	 */
	private Date initDate(Integer hour) {
		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.set(Calendar.HOUR, hour);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	private void stayAmount(Integer manCount, Integer stayCount) {
		StayInfoExample stayInfoExample = new StayInfoExample();
		Criteria criteria = stayInfoExample.createCriteria();
		criteria.andIsCheckoutEqualTo(1);

		List<StayInfo> stayList = stayInfoMapper.selectByExample(stayInfoExample);
		Long now = System.currentTimeMillis();
		for (StayInfo si : stayList) {
			if (now > si.getStayDate().getTime() && now < si.getLeaveDate().getTime()) {
				stayCount++;
				manCount += si.getStayManCount();
			}
		}
	}

	private void statAmount(HashMap<String, Integer> statMap) {
		List<DynamicRoomInfo> roomList = roomInfoMapper.findObjects();

		for (DynamicRoomInfo dri : roomList) {
			String stat = dri.getStat();
			Integer count = statMap.get(stat);
			if (count == null) {
				statMap.put(stat, 1);
			} else {
				statMap.put(stat, count + 1);
			}
		}

	}

}
