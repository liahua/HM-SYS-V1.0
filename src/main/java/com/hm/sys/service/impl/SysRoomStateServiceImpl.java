package com.hm.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.sys.dao.RoomStateMapper;

import com.hm.sys.service.SysRoomStateService;


@Service
public class SysRoomStateServiceImpl implements SysRoomStateService{

	@Autowired
	private RoomStateMapper roomStateMapper;
	
	//客房状态浏览

	@Override
	public List<Map<String, Object>> findRoomState() {
		return roomStateMapper.findRoomState();
	}
	

}
