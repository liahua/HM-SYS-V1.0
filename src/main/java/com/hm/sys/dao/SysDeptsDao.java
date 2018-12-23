package com.hm.sys.dao;

import com.hm.sys.entity.SysDepts;
import com.hm.sys.entity.SysDeptsExample;
import com.hm.sys.vo.Node;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SysDeptsDao {
	
	List<Map<String,Object>> getObjects();
	
	int updateByPrimaryKey(SysDepts record);
	
	int insert(SysDepts record);
	
	int deleteByPrimaryKey(Integer id);
	
	List<Node> findZtreeDeptNodes();
	
	int getChildCount(Integer id);
}