package com.hm.sys.dao;


import com.hm.sys.entity.RoomInfo;
import com.hm.sys.entity.RoomInfoExample;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface RIM01 {


	List<Map<String, Object>> findRoomInfo();
	

		int deleteRoomInfo(@Param("ids")Integer... ids);
		

		 int getRowCount(@Param("roomName")String roomName);
	
		 List<RoomInfo> findPageObjects(
				 @Param("roomName")String roomName,
				 @Param("startIndex")Integer startIndex,
				 @Param("pageSize")Integer pageSize);
		 
		 int insertRoomInfo(RoomInfo entity);
		 
		 List<RoomInfo> findObjectsInfo(RoomInfoExample example);


		List<RoomInfo> selectByExample(RoomInfoExample roomInfoExample);
}