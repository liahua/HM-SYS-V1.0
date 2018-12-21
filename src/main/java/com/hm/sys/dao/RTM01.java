package com.hm.sys.dao;

import com.hm.sys.entity.RoomType;
import com.hm.sys.entity.RoomTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RTM01 {

	//基于条件查询总记录数
		int getRowCount(String rtName);

		//数据库查询数据封装到RoomType
		List<RoomType> findPageObjects(@Param("username")String rtName,
			      @Param("startIndex")Integer startIndex,
			      @Param("pageSize")Integer pageSize);
		
		//房间类型数据查询
		List<RoomType> findObjectsType(@Param("rtName")RoomTypeExample example);

		int deleteRoomType(Integer[] ids);
}