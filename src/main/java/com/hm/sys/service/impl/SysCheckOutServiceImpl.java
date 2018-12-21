package com.hm.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.StringUtil;
import com.hm.common.exception.ServiceException;
import com.hm.common.utils.IntegerUtil;
import com.hm.common.utils.ListUtil;
import com.hm.common.utils.ObjectUtil;
import com.hm.common.vo.CheckOutVoDetails;
import com.hm.sys.dao.CustomerInfoMapper;
import com.hm.sys.dao.RoomInfoMapper;
import com.hm.sys.dao.StayInfoMapper;
import com.hm.sys.entity.CustomerInfo;
import com.hm.sys.entity.RoomInfo;
import com.hm.sys.entity.RoomInfoExample;
import com.hm.sys.entity.RoomInfoExample.Criteria;
import com.hm.sys.entity.StayInfo;
import com.hm.sys.entity.StayInfoExample;
import com.hm.sys.service.SysCheckOutService;

@Service
public class SysCheckOutServiceImpl implements SysCheckOutService {

	@Autowired
	private RoomInfoMapper roomInfoMapper;
	@Autowired
	private StayInfoMapper stayInfoMapper;
	@Autowired
	private CustomerInfoMapper customerInfoMapper;

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
		RoomInfo roomInfo = findRoomFromRoomInfo(roomNameId);

		CustomerInfo customerInfo = findCustomerInfo(checkOutVoDetail.getCustomerInfo());

//		通过CardTypeCardNum查找CustomerInfo
//		通过CustomerNameTelephone查找CustomerInfo
//		通过id查找CustomerInfo

		checkOutVoDetail.setRoomInfo(roomInfo);
		return null;
	}

	private CustomerInfo findCustomerInfo(CustomerInfo customerInfo) {
		CustomerInfo customerInfoReal = new CustomerInfo();
		Integer id = customerInfo.getId();
		/**
		 * id合法
		 */
		if (!IntegerUtil.isIllegality(id)) {
			customerInfoReal = findCustomerInfo(id);
			if (!ObjectUtil.isEmpty(customerInfoReal)) {
				return customerInfoReal;
			}
		}
		String cardType = customerInfo.getCardType();
		String cardNum = customerInfo.getCardNum();
		/**
		 * cardType||cardNum为空
		 */
		if ((!StringUtils.isEmpty(cardType)) && (!StringUtils.isEmpty(cardNum))) {
			customerInfoReal = findCustomerInfo(cardType, cardNum);
			if (!ObjectUtil.isEmpty(customerInfoReal)) {
				return customerInfoReal;
			}
		}

		String customerName = customerInfo.getCustomerName();
		String telephone = customerInfo.getTelephone();
		if ((!StringUtils.isEmpty(customerName)) && (!StringUtils.isEmpty(telephone))) {
			customerInfoReal = findCustomerInfo(customerName, telephone);
			if (!ObjectUtil.isEmpty(customerInfoReal)) {
				return customerInfoReal;
			}

		}

		return null;
	}

	private CustomerInfo findCustomerInfo(String cardType, String cardNum) {
		
		return null;
	}

	private CustomerInfo findCustomerInfo(Integer id) {
		CustomerInfo CustomerInfo = customerInfoMapper.selectByPrimaryKey(id);
		return CustomerInfo;
	}

	/**
	 * 
	 * @param roomNameId
	 * @return 返回所有拥有roomNameId的房间信息
	 */
	public RoomInfo findRoomFromRoomInfo(String roomNameId) {
		RoomInfoExample roomInfoExample = new RoomInfoExample();
		Criteria criteria = roomInfoExample.createCriteria();
		criteria.andRoomNameEqualTo(roomNameId);
		List<Criteria> oredCriteria = roomInfoExample.getOredCriteria();
		oredCriteria.add(criteria);
		List<RoomInfo> roomsInfo = roomInfoMapper.selectByExample(roomInfoExample);
		if (ListUtil.isEmpty(roomsInfo)) {
			throw new ServiceException("无此房间");
		} else if (ListUtil.count(roomsInfo) > 1) {
			throw new ServiceException("房间名重复,联系管理员查改");
		}
		RoomInfo roomInfo = roomsInfo.get(1);
		return roomInfo;
	}

	@Override
	public CheckOutVoDetails checkOutDepencyOrderInfo(CheckOutVoDetails CheckOutVoDetails) {
		// TODO Auto-generated method stub
		return null;
	}

}
