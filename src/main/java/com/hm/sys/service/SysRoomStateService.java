package com.hm.sys.service;

import java.util.List;
import java.util.Map;


public interface SysRoomStateService {
	//客房状态浏览
	List<Map<String,Object>> findRoomState();

}
