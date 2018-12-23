package com.hm.sys.dao;

import com.hm.sys.entity.SysMenus;
import com.hm.sys.entity.SysMenusExample;
import com.hm.sys.vo.Node;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SysMenusDao {
	
	public List<Map<String, Object>> getObjects();
	
	int deleteByPrimaryKey(Integer id);
	
	int insert(SysMenus record);
	
	int updateByPrimaryKey(SysMenus record);
	
	int getChildCount(Integer id);

	List<Node> findZtreeMenuNodes();
}