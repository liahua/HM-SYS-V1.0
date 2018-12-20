package com.hm.sys.dao;


import com.hm.sys.entity.RoomType;
import com.hm.sys.entity.RoomTypeExample;
import java.util.List;


import org.apache.ibatis.annotations.Param;

public interface RoomTypeMapper {
	
    int countByExample(RoomTypeExample example);

    int deleteByExample(RoomTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoomType record);

    int insertSelective(RoomType record);

    List<RoomType> selectByExample(RoomTypeExample example);

    RoomType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoomType record, @Param("example") RoomTypeExample example);

    int updateByExample(@Param("record") RoomType record, @Param("example") RoomTypeExample example);

    int updateByPrimaryKeySelective(RoomType record);

    int updateByPrimaryKey(RoomType record);
    
    
    
    /**
	 * 执行日志删除操作
	 * @return
	 */	
	int deleteRoomType(@Param("ids")Integer... ids);
	
     /**
      * 基于条件(用户名)查询系统中的总记录数，
      * 我们会在业务层基于总记录数进行总页数
      * 的计算操作
      * @param username
      * @return
      */
	 int getRowCount(@Param("rtName")String rtName);
	 /**
	  * 基于条件查询当前页要显示的记录
	  * @param rtName 查询条件
	  * @param startIndex 当前页的起始位置
	  * @param pageSize 页面大小(每页要显示的记录数)
	  * @return
	  */
	 List<RoomType> findPageObjects(
			 @Param("rtName")String rtName,
			 @Param("startIndex")Integer startIndex,
			 @Param("pageSize")Integer pageSize);
	 
	 int insertRoomType(RoomType entity);
	 

}