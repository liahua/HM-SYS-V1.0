package com.hm.sys.service;

import java.util.List;
import java.util.Map;

import com.hm.sys.entity.SysDepts;
import com.hm.sys.entity.SysDeptsExample;
import com.hm.sys.vo.Node;

public interface SysDeptService {
	
	List<Map<String,Object>> getObjects();
	
		
	int deleteObject(Integer id);
	
	public int insertObject(SysDepts entity);
	
	public List<Node> findZtreeDeptNodes();
	
	public int updateObject(SysDepts entity);

}
