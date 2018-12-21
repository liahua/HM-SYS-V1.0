package com.hm.sys.dao;

import com.hm.sys.entity.RoomState;
import com.hm.sys.entity.RoomStateExample;
import com.hm.sys.entity.RoomType;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface RoomStateMapper {
    int countByExample(RoomStateExample example);

    int deleteByExample(RoomStateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoomState record);

    int insertSelective(RoomState record);

    List<RoomState> selectByExample(RoomStateExample example);

    RoomState selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoomState record, @Param("example") RoomStateExample example);

    int updateByExample(@Param("record") RoomState record, @Param("example") RoomStateExample example);

    int updateByPrimaryKeySelective(RoomState record);

    int updateByPrimaryKey(RoomState record);
    
    
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
	 
}