package com.hm.sys.service;

import java.util.List;

import com.hm.sys.entity.SysMenus;
import com.hm.sys.entity.SysMenusExample;
import com.hm.sys.vo.Node;

public interface SysMenuService {

	List<SysMenus> getObjects(SysMenusExample example);

	int deleteObject(Integer id);

	List<Node> findZtreeMenuNodes();

	int insert(SysMenus record);

	int update(SysMenus record);

}
