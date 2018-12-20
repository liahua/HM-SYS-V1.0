package com.hm.sys.dao;

import com.hm.sys.entity.RoomState;
import com.hm.sys.entity.RoomStateExample;
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
    
    
  //客房状态浏览
    List<Map<String,Object>> findRoomState();
}