package com.hm.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.StringUtil;
import com.hm.common.exception.ServiceException;
import com.hm.common.utils.IntegerUtil;
import com.hm.common.utils.ListUtil;
import com.hm.common.vo.CheckOutVoDetails;
import com.hm.sys.dao.RoomInfoMapper;
import com.hm.sys.dao.StayInfoMapper;
import com.hm.sys.entity.RoomInfo;
import com.hm.sys.entity.RoomInfoExample;
import com.hm.sys.entity.RoomInfoExample.Criteria;
import com.hm.sys.entity.StayInfo;
import com.hm.sys.entity.StayInfoExample;
import com.hm.sys.service.SysCheckOutService;

@Service
public class SysCheckOutServiceImpl implements SysCheckOutService{


	@Autowired
	private RoomInfoMapper roomInfoMapper;
	@Autowired
	private StayInfoMapper stayInfoMapper;

	@Override
	public CheckOutVoDetails checkOutDepencyRoomId(String roomNameId) {
		//1.roomId是否合法
		//2.roomId是否存在roomEntity
		//3.roomId是否存在未支付
		CheckOutVoDetails checkOutVoDetails = new CheckOutVoDetails();
		
		if(StringUtil.isEmpty(roomNameId)) {
			throw new ServiceException("房间号不正确");
		}
		//查找符合roomNameId的房间的信息
		RoomInfo roomInfo = findRoomFromRoomInfo(roomNameId);
		Integer roomId = roomInfo.getId();
		List<StayInfo> stayInfos=findStayInfoFromRoomId(roomId);
		
		
		
		
	
		return null;
	}
	private List<StayInfo> findStayInfoFromRoomId(Integer roomId) {
		
		return null;
	}
	/**
	 * 
	 * @param roomNameId
	 * @return 返回所有拥有roomNameId的房间信息 
	 */
	public RoomInfo findRoomFromRoomInfo(String roomNameId){
		RoomInfoExample roomInfoExample = new RoomInfoExample();
		Criteria criteria = roomInfoExample.createCriteria();
		criteria.andRoomNameEqualTo(roomNameId);
		List<Criteria> oredCriteria = roomInfoExample.getOredCriteria();
		oredCriteria.add(criteria);
		List<RoomInfo> roomsInfo = roomInfoMapper.selectByExample(roomInfoExample);
		if(ListUtil.isEmpty(roomsInfo)) {
			throw new ServiceException("无此房间");
		}else if(ListUtil.count(roomsInfo)>1){
			throw new ServiceException("房间名重复,联系管理员查改");
		}
		RoomInfo roomInfo = roomsInfo.get(1);
		return roomInfo;
	}

}
