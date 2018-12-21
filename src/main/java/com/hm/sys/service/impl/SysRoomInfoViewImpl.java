package com.hm.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.sys.dao.RoomInfoMapper;
import com.hm.sys.entity.RoomInfo;
import com.hm.sys.entity.RoomInfoExample;
import com.hm.sys.service.SysRoomInfoViewService;

/**
 * 
 * @author lord
 *
 */
@Service
public class SysRoomInfoViewImpl implements SysRoomInfoViewService{
	@Autowired
	private RoomInfoMapper roomInfoMapper;
	/**
	 * 查找房间信息
	 */
	@Override
	public List<RoomInfo> findObjectsInfo(RoomInfoExample room) {
		
		return roomInfoMapper.findObjectsInfo(room);
	}

}
