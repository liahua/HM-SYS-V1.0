package com.hm.sys.dao;

import com.hm.sys.entity.RoomStat;
import com.hm.sys.entity.RoomStatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoomStatMapper {
    int countByExample(RoomStatExample example);

    int deleteByExample(RoomStatExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoomStat record);

    int insertSelective(RoomStat record);

    List<RoomStat> selectByExample(RoomStatExample example);

    RoomStat selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoomStat record, @Param("example") RoomStatExample example);

    int updateByExample(@Param("record") RoomStat record, @Param("example") RoomStatExample example);

    int updateByPrimaryKeySelective(RoomStat record);

    int updateByPrimaryKey(RoomStat record);
}