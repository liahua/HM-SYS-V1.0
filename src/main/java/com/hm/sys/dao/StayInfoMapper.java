package com.hm.sys.dao;

import com.hm.sys.entity.StayInfo;
import com.hm.sys.entity.StayInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StayInfoMapper {
    int countByExample(StayInfoExample example);

    int deleteByExample(StayInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StayInfo record);

    int insertSelective(StayInfo record);

    List<StayInfo> selectByExample(StayInfoExample example);

    StayInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StayInfo record, @Param("example") StayInfoExample example);

    int updateByExample(@Param("record") StayInfo record, @Param("example") StayInfoExample example);

    int updateByPrimaryKeySelective(StayInfo record);

    int updateByPrimaryKey(StayInfo record);
}