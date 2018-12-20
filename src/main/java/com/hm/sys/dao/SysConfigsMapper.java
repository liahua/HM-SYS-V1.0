package com.hm.sys.dao;

import com.hm.sys.entity.SysConfigs;
import com.hm.sys.entity.SysConfigsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysConfigsMapper {
    int countByExample(SysConfigsExample example);

    int deleteByExample(SysConfigsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysConfigs record);

    int insertSelective(SysConfigs record);

    List<SysConfigs> selectByExample(SysConfigsExample example);

    SysConfigs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysConfigs record, @Param("example") SysConfigsExample example);

    int updateByExample(@Param("record") SysConfigs record, @Param("example") SysConfigsExample example);

    int updateByPrimaryKeySelective(SysConfigs record);

    int updateByPrimaryKey(SysConfigs record);
}