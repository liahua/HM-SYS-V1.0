package com.hm.sys.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hm.common.vo.PageObject;
import com.hm.sys.entity.SysMenus;
import com.hm.sys.entity.SysMenusExample;
import com.hm.sys.entity.SysRoles;
import com.hm.sys.entity.SysRolesExample;
import com.hm.sys.vo.Node;

public interface SysRoleService {
	/**
     * 本方法中要分页查询角色信息,并查询角色总记录数据
     * @param pageCurrent 当表要查询的当前页的页码值
     * @return 封装当前实体数据以及分页信息
     */
	PageObject<SysRoles> findPageObjects(
			String name,
			Integer pageCurrent);

}
