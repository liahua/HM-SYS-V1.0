package com.hm.sys.dao;

import com.hm.common.vo.DynamicRoomInfo;
import com.hm.sys.entity.RoomInfo;
import com.hm.sys.entity.RoomInfoExample;
import com.hm.sys.entity.RoomType;
import com.hm.sys.entity.RoomTypeExample;

import java.util.List;
import java.util.Map;

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

	List<Map<String, Object>> findRoomInfo();

	int deleteRoomInfo(@Param("ids") Integer... ids);

	int getRowCount(@Param("roomName") String roomName);

	List<RoomInfo> findPageObjects(@Param("roomName") String roomName, @Param("startIndex") Integer startIndex,
			@Param("pageSize") Integer pageSize);

	int insertRoomInfo(RoomInfo entity);

	List<RoomInfo> findObjectsInfo(RoomInfoExample example);
}