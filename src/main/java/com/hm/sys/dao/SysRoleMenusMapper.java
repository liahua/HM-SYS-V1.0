package com.hm.sys.dao;

import com.hm.sys.entity.SysRoleMenus;
import com.hm.sys.entity.SysRoleMenusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRoleMenusMapper {
    int countByExample(SysRoleMenusExample example);

    int deleteByExample(SysRoleMenusExample example);

    int deleteByPrimaryKey(Integer id);
    /**
     * 根据MenuId进行删除菜单关系数据
     * @param id
     * @return
     */
    int deleteObjectByMenuId(Integer id);

    int insert(SysRoleMenus record);

    int insertSelective(SysRoleMenus record);

    List<SysRoleMenus> selectByExample(SysRoleMenusExample example);

    SysRoleMenus selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysRoleMenus record, @Param("example") SysRoleMenusExample example);

    int updateByExample(@Param("record") SysRoleMenus record, @Param("example") SysRoleMenusExample example);

    int updateByPrimaryKeySelective(SysRoleMenus record);

    int updateByPrimaryKey(SysRoleMenus record);
}