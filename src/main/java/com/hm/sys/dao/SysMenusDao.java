package com.hm.sys.dao;

import com.hm.sys.entity.SysMenus;
import com.hm.sys.entity.SysMenusExample;
import com.hm.sys.vo.Node;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysMenusDao {
	
	List<SysMenus> selectByExample(SysMenusExample example);
	
	int deleteByPrimaryKey(Integer id);
	
	int insert(SysMenus record);
	
	int updateByPrimaryKey(SysMenus record);
	
	int getChildCount(Integer id);

	List<Node> findZtreeMenuNodes();
}