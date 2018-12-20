package com.hm.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.common.utils.IntegerUtil;
import com.hm.common.vo.CheckOutVoDetails;
import com.hm.sys.dao.RoomInfoMapper;
import com.hm.sys.entity.RoomInfoExample;
import com.hm.sys.service.SysCheckOutService;

@Service
public class SysCheckOutServiceImpl implements SysCheckOutService{


	@Autowired
	private RoomInfoMapper roomInfoMapper;

	@Override
	public CheckOutVoDetails checkOutDepencyRoomId(Integer roomNameId) {
		//1.roomId是否合法
		//2.roomId是否存在roomEntity
		//3.roomId是否存在未支付
		
		if(IntegerUtil.isIllegality(roomNameId)) {
			throw new IllegalArgumentException("房间号不正确");
		}
		RoomInfoExample roomInfoExample = new RoomInfoExample();
		new RoomInfoExample();
		
		
		return null;
	}

}
