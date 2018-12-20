package com.hm.sys.dao;

import com.hm.sys.entity.SysDicts;
import com.hm.sys.entity.SysDictsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysDictsMapper {
    int countByExample(SysDictsExample example);

    int deleteByExample(SysDictsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysDicts record);

    int insertSelective(SysDicts record);

    List<SysDicts> selectByExample(SysDictsExample example);

    SysDicts selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysDicts record, @Param("example") SysDictsExample example);

    int updateByExample(@Param("record") SysDicts record, @Param("example") SysDictsExample example);

    int updateByPrimaryKeySelective(SysDicts record);

    int updateByPrimaryKey(SysDicts record);
}