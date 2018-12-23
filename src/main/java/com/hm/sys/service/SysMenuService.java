package com.hm.sys.service;

import java.util.List;
import java.util.Map;

import com.hm.sys.entity.SysMenus;
import com.hm.sys.entity.SysMenusExample;
import com.hm.sys.vo.Node;

public interface SysMenuService {

	public List<Map<String, Object>> getObjects();

	int deleteObject(Integer id);

	List<Node> findZtreeMenuNodes();

	int insert(SysMenus record);

	int update(SysMenus record);

}
