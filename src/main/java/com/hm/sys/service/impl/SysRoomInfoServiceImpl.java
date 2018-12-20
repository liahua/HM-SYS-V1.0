package com.hm.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.sys.dao.RoomInfoMapper;

import com.hm.sys.service.SysRoomInfoService;


@Service
public class SysRoomInfoServiceImpl implements SysRoomInfoService{

	@Autowired
	private RoomInfoMapper roomInfoMapper;
	
	//客房信息浏览

	@Override
	public List<Map<String, Object>> findRoomInfo() {
		return roomInfoMapper.findRoomInfo();
	}
	

}
