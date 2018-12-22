package com.hm.sys.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.StringUtil;
import com.hm.common.exception.ServiceException;
import com.hm.common.vo.CheckOutVoDetails;
import com.hm.sys.entity.CheckInfo;
import com.hm.sys.entity.CustomerInfo;
import com.hm.sys.entity.OrderInfo;
import com.hm.sys.entity.RoomInfo;
import com.hm.sys.entity.StayInfo;
import com.hm.sys.service.SysCheckOutService;
import com.hm.sys.service.SysCustomerService;
import com.hm.sys.service.SysOrderService;
import com.hm.sys.service.SysRoomInfoService;
import com.hm.sys.service.SysStayInfoService;
import com.mysql.fabric.xmlrpc.base.Data;

@Service
public class SysCheckOutServiceImpl implements SysCheckOutService {

	@Autowired
	private SysCustomerService sysCustomerService;
	@Autowired
	private SysRoomInfoService sysRoomInfoService;
	@Autowired
	private SysStayInfoService sysStayInfoService;
	@Autowired
	private SysOrderService sysOrderService;

	@Override
	public CheckOutVoDetails checkOutDepencyRoomNameIdCustomerInfo(CheckOutVoDetails checkOutVoDetail) {
		// 1.roomId是否合法
		// 2.roomId是否存在roomEntity
		// 3.roomId是否存在未支付
		if (checkOutVoDetail == null || checkOutVoDetail.getRoomInfo() == null
				|| checkOutVoDetail.getCustomerInfo() == null) {
			throw new ServiceException("房间号或者用户信息为空");
		}
		String roomNameId = checkOutVoDetail.getRoomInfo().getRoomName();

		if (StringUtil.isEmpty(roomNameId)) {
			throw new ServiceException("房间号不正确");
		}
		// 查找符合roomNameId的房间的信息
		RoomInfo roomInfo = sysRoomInfoService.findRoomFromRoomInfo(roomNameId);

//		通过CardTypeIdCardNum查找CustomerInfo
//		通过CustomerNameTelephone查找CustomerInfo
//		通过id查找CustomerInfo
		CustomerInfo customerInfo = sysCustomerService.findCustomerInfo(checkOutVoDetail.getCustomerInfo());
		// 通过customerInfo查找入住信息
		List<StayInfo> stayInfos = sysStayInfoService.findStayInfo(customerInfo,
				checkOutVoDetail.getStayInfoQueryType());
		// 根据stayInfo查找OrderInfos
		ArrayList<OrderInfo> orderInfos = new ArrayList<>();
		Map<Integer, OrderInfo> stayAndOrderInfoMap = new HashMap<>();
		for (StayInfo stayInfo : stayInfos) {
			OrderInfo orderInfo=sysOrderService.findOrderInfo(stayInfo.getOrderId());
			orderInfos.add(orderInfo);
			stayAndOrderInfoMap.put(stayInfo.getId(), orderInfo);
		}
	
		
		checkOutVoDetail.setRoomInfo(roomInfo);
		checkOutVoDetail.setCustomerInfo(customerInfo);
		checkOutVoDetail.setStayInfos(stayInfos);
		checkOutVoDetail.setOrderInfos(orderInfos);
		checkOutVoDetail.setStayAndOrderInfoMap(stayAndOrderInfoMap);
		return checkOutVoDetail;
	}

	

	@Override
	public List<CheckInfo> CalculateBillDetails(CheckOutVoDetails checkOutVoDetail) {
	
//	  1.假定本次stayInfo的离店时间为now();
		Date leaveTime=getCurrentTime();
//	  2.根据折扣比率计算每日房价
		
//	  3.根据orderInfo,stayInfo计算lateArrivalDay,stayDay,earlyLeaveDay
//	  4.根据lateArrivalDay,stayDay,earlyLeaveDay分别计算lateArrivalNeedPay,stayDayNeedPay,earlyLeaveNeedPay
//	  5.根据lateArrivalNeedPay,stayDayNeedPay,earlyLeaveNeedPay计算dueMoney
//	  6.根据dueMoney-(orderMoney+cashPledge)计算paidUpMoney
//	  7.存入CheckInfo
//	  8.根据stayInfo列表中其他stayInfo,获取checkInfo
//	  9.将checkInfo放入list集合中
//	  8.回显
		
		
		
		
		
		return null;
	}



	private Date getCurrentTime() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public CheckOutVoDetails checkOutDepencyOrderInfo(CheckOutVoDetails CheckOutVoDetails) {
		// TODO Auto-generated method stub
		return null;
	}



	



}
