package com.hm.sys.dao;

import com.hm.common.vo.DynamicRoomInfo;
import com.hm.sys.entity.RoomInfo;
import com.hm.sys.entity.RoomInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoomInfoMapper {
    int countByExample(RoomInfoExample example);

    int deleteByExample(RoomInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoomInfo record);

    int insertSelective(RoomInfo record);

    List<RoomInfo> selectByExample(RoomInfoExample example);

    RoomInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoomInfo record, @Param("example") RoomInfoExample example);

    int updateByExample(@Param("record") RoomInfo record, @Param("example") RoomInfoExample example);

    int updateByPrimaryKeySelective(RoomInfo record);

    int updateByPrimaryKey(RoomInfo record);

	int deleteRoomInfo(Integer[] ids);

	int getRowCount(String roomName);

	List<DynamicRoomInfo> findObjects();

	List<RoomInfo> findPageObjects(String roomName, int startIndex, int pageSize);

	List<RoomInfo> findObjectsInfo(RoomInfoExample example);
}