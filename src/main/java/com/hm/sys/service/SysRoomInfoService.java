package com.hm.sys.service;

import java.util.List;
import java.util.Map;


public interface SysRoomInfoService {
	//客房信息浏览
	List<Map<String,Object>> findRoomInfo();

}
