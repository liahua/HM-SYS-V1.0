package com.hm.sys.dao;

import com.hm.sys.entity.SysUsers;
import com.hm.sys.entity.SysUsersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUsersDao {
    /**
     * 根据deptId查询部门人数
     * @param id
     * @return
     */
    int getCountByDeptId(Integer id);
}