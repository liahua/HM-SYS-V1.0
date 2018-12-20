package com.hm.sys.dao;

import com.hm.sys.entity.SysDepts;
import com.hm.sys.entity.SysDeptsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysDeptsMapper {
    int countByExample(SysDeptsExample example);

    int deleteByExample(SysDeptsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysDepts record);

    int insertSelective(SysDepts record);

    List<SysDepts> selectByExample(SysDeptsExample example);

    SysDepts selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysDepts record, @Param("example") SysDeptsExample example);

    int updateByExample(@Param("record") SysDepts record, @Param("example") SysDeptsExample example);

    int updateByPrimaryKeySelective(SysDepts record);

    int updateByPrimaryKey(SysDepts record);
}