package com.hm.sys.service;

import java.util.List;
import java.util.Map;

import com.hm.sys.entity.SysMenus;
import com.hm.sys.entity.SysMenusExample;
import com.hm.sys.vo.Node;

public interface SysMenuService {
	
	public List<SysMenus> getObjects(SysMenusExample example);
	
	public int deleteObject(Integer id);
	
	public List<Node> findZtreeMenuNodes();
	
	public int insert(SysMenus record);
	
	public int update(SysMenus record);

}
