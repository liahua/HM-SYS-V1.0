package com.hm.sys.service;

import java.util.List;

import com.hm.sys.entity.RoomInfo;
import com.hm.sys.entity.RoomInfoExample;

public interface SysRoomInfoViewService {
	List<RoomInfo> findObjectsInfo(RoomInfoExample example);
}
