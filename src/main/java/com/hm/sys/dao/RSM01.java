package com.hm.sys.dao;

import com.hm.sys.entity.RoomInfo;
import com.hm.sys.entity.RoomInfoExample;
import com.hm.sys.entity.RoomState;
import com.hm.sys.entity.RoomStateExample;

import java.util.List;


import org.apache.ibatis.annotations.Param;

public interface RSM01 {
  
    
    /**
	 * 执行日志删除操作
	 * @return
	 */	
	int deleteRoomState(@Param("ids")Integer... ids);
	
     /**
      * 基于条件(用户名)查询系统中的总记录数，
      * 我们会在业务层基于总记录数进行总页数
      * 的计算操作
      * @param username
      * @return
      */
	 int getRowCount(@Param("stat")String stat);
	 /**
	  * 基于条件查询当前页要显示的记录
	  * @param stat 查询条件
	  * @param startIndex 当前页的起始位置
	  * @param pageSize 页面大小(每页要显示的记录数)
	  * @return
	  */
	 List<RoomState> findPageObjects(
			 @Param("stat")String stat,
			 @Param("startIndex")Integer startIndex,
			 @Param("pageSize")Integer pageSize);
	 
	 int insertRoomState(RoomState entity);
	 
	 List<RoomState> findObjectsState(RoomStateExample example);

	List<RoomInfo> findObjectsInfo(RoomInfoExample room);
	 
}