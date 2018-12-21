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

	int deleteRoomType(Integer[] ids);

	int getRowCount(String rtName);

	List<RoomType> findPageObjects(String rtName, int startIndex, int pageSize);

	List<RoomType> findObjectsType(RoomTypeExample example);
}