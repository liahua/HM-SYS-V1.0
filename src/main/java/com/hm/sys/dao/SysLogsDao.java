package com.hm.sys.dao;

import com.hm.sys.entity.SysLogs;
import com.hm.sys.entity.SysLogsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysLogsDao {
    /**
     * 将日志信息封装到sysroles对象添加到List集合,使用json格式在分页页面展示
     * @param name          查询条件:用户名
     * @param StartIndex	当前页面起始位置(起始信息下标)
     * @param pagesize		当前页面显示信息条数
     * @return
     */
    public List<SysLogs> getObjects(@Param("username")String username,@Param("startIndex")Integer startIndex, @Param("pageSize")Integer pageSize);
    /**
     * 根据输入的username查询相关数据数量
     * @param username
     * @return
     */
    int getRowCount(@Param("username")String username);
    /**
     * 根据选择id删除信息(多选)
     * @param ids
     * @return
     */
    int deleteObjects(@Param("ids")Integer...ids);
    /**
     * 添加日志信息
     * @param record
     * @return
     */
    int insert(SysLogs record);
}