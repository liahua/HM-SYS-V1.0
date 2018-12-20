package com.hm.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;

import com.hm.common.exception.ClassExceptionTest;
import com.hm.common.vo.PageObject;
import com.hm.sys.dao.SysMenusMapper;

import com.hm.sys.dao.SysRoleMenusMapper;
import com.hm.sys.dao.SysRolesMapper;
import com.hm.sys.entity.SysMenus;
import com.hm.sys.entity.SysMenusExample;
import com.hm.sys.entity.SysRoles;
import com.hm.sys.entity.SysRolesExample;
import com.hm.sys.service.SysDeptService;
import com.hm.sys.service.SysMenuService;
import com.hm.sys.service.SysRoleService;
import com.hm.sys.vo.Node;
@Service
public class SysRoleServiceImpl implements SysRoleService {
	@Autowired
	private SysRolesMapper sysRolesMapper;

	@Override
	public PageObject<SysRoles> findPageObjects(String name, Integer pageCurrent) {
		//检查当前查询页码合法性
		if(pageCurrent==null||pageCurrent<0)
			throw new IllegalArgumentException("当前页码不正确");
		//查询信息总数
		int rowCount = sysRolesMapper.getRowCount(name);
		if(rowCount==0)
			throw new IllegalArgumentException("当前系统中可能没有任何信息");
		//基于条件查询当前页信息
		//定义当前页数据数量
		int pageSize=2;
		//上一页结束的位置
		int startIndex=(pageCurrent-1)*pageSize;
		//执行操作
		List<SysRoles> findPageObjects = sysRolesMapper.findPageObjects(name, startIndex, pageSize);
		//对分页信息及当前页进行封装
		//1.构建封装对象
		PageObject<SysRoles> pageObject = new PageObject<>();
		
		//封装信息内容
		pageObject.setPageCount((rowCount-1)/pageSize+1);
		pageObject.setRowCount(rowCount);
		pageObject.setPageSize(pageSize);
		pageObject.setRecords(findPageObjects);
		pageObject.setPageCurrent(pageCurrent);
		
		return pageObject;
	}

	
	
	
	
	

}
