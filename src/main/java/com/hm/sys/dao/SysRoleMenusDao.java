package com.hm.sys.dao;

import com.hm.sys.entity.SysRoleMenus;
import com.hm.sys.entity.SysRoleMenusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRoleMenusDao {

    /**
     * 根据MenuId进行删除菜单关系数据
     * @param id
     * @return
     */
    int deleteObjectByMenuId(Integer id);
    /**
     * 根据RoleId删除角色与菜单的关系
     * @param id
     * @return
     */
    int deleteObjectByRoleId(Integer id);
    /**
     * 添加角色与菜单的关系
     * @param integer
     * @param menuIds
     * @return
     */
    int insertObject(
			@Param("roleId")Integer roleId,
			@Param("menuIds")Integer[] menuIds);
    /**
     * 根据角色id查找菜单id
     * @param roleId
     * @return
     */
    List<Integer> getMenuIdByRoleId(Integer roleId);
}