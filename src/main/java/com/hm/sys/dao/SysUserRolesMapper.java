package com.hm.sys.dao;

import com.hm.sys.entity.SysUserRoles;
import com.hm.sys.entity.SysUserRolesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserRolesMapper {
    int countByExample(SysUserRolesExample example);

    int deleteByExample(SysUserRolesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysUserRoles record);

    int insertSelective(SysUserRoles record);

    List<SysUserRoles> selectByExample(SysUserRolesExample example);

    SysUserRoles selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysUserRoles record, @Param("example") SysUserRolesExample example);

    int updateByExample(@Param("record") SysUserRoles record, @Param("example") SysUserRolesExample example);

    int updateByPrimaryKeySelective(SysUserRoles record);

    int updateByPrimaryKey(SysUserRoles record);
}