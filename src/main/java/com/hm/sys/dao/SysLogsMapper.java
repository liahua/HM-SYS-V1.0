package com.hm.sys.dao;

import com.hm.sys.entity.SysLogs;
import com.hm.sys.entity.SysLogsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysLogsMapper {
    int countByExample(SysLogsExample example);

    int deleteByExample(SysLogsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysLogs record);

    int insertSelective(SysLogs record);

    List<SysLogs> selectByExample(SysLogsExample example);

    SysLogs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysLogs record, @Param("example") SysLogsExample example);

    int updateByExample(@Param("record") SysLogs record, @Param("example") SysLogsExample example);

    int updateByPrimaryKeySelective(SysLogs record);

    int updateByPrimaryKey(SysLogs record);
}