package com.hm.sys.dao;

import com.hm.sys.entity.SysUserRoles;
import com.hm.sys.entity.SysUserRolesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserRolesDao {
    /**
     * 根据角色id删除 用户关系
     * @param id
     * @return
     */
    int deleteObjectByRoleId(Integer id);
}