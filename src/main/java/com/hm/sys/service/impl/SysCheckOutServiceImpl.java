package com.hm.sys.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.StringUtil;
import com.hm.common.exception.ServiceException;
import com.hm.common.vo.CheckOutVoDetails;
import com.hm.sys.entity.CustomerInfo;
import com.hm.sys.entity.RoomInfo;
import com.hm.sys.entity.StayInfo;
import com.hm.sys.service.SysCheckOutService;
import com.hm.sys.service.SysCustomerService;
import com.hm.sys.service.SysRoomInfoService;

@Service
public class SysCheckOutServiceImpl implements SysCheckOutService {


	@Autowired
	private SysCustomerService sysCustomerService;
	@Autowired
	private SysRoomInfoService sysRoomInfoService;

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
		List<StayInfo> stayInfo=findStayInfo(customerInfo);
		
		checkOutVoDetail.setRoomInfo(roomInfo);
		checkOutVoDetail.setCustomerInfo(customerInfo);
		System.out.println(checkOutVoDetail);
		return null;
	}

	private List<StayInfo> findStayInfo(CustomerInfo customerInfo) {
		
		return null;
	}

	

	






	@Override
	public CheckOutVoDetails checkOutDepencyOrderInfo(CheckOutVoDetails CheckOutVoDetails) {
		// TODO Auto-generated method stub
		return null;
	}

}
