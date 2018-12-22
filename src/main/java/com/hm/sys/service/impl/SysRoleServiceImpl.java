package com.hm.sys.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.incrementer.PostgreSQLSequenceMaxValueIncrementer;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;

import com.hm.common.exception.ClassExceptionTest;
import com.hm.common.exception.ServiceException;
import com.hm.common.utils.IntegerUtil;
import com.hm.common.vo.PageObject;
import com.hm.sys.dao.SysMenusDao;

import com.hm.sys.dao.SysRoleMenusDao;
import com.hm.sys.dao.SysRolesDao;
import com.hm.sys.dao.SysUserRolesDao;
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
	private SysRolesDao sysRolesDao;
	@Autowired
	private SysRoleMenusDao sysRoleMenusDao;
	@Autowired
	private SysUserRolesDao sysUserRolesDao;
	/**
	 * 将查询信息呈现至分页查询页面
	 */
	@Override
	public PageObject<SysRoles> findPageObjects(String name, Integer pageCurrent) {
		//检查当前查询页码合法性
		if(IntegerUtil.isIllegality(pageCurrent))
			throw new IllegalArgumentException("当前页码不正确");
		//查询信息总数
		int rowCount = sysRolesDao.getRowCount(name);
		if(rowCount==0)
			throw new IllegalArgumentException("当前系统中可能没有任何信息");
		//基于条件查询当前页信息
		//定义当前页数据数量
		int pageSize=2;
		//上一页结束的位置
		int startIndex=(pageCurrent-1)*pageSize;
		//执行操作
		List<SysRoles> findPageObjects = sysRolesDao.findPageObjects(name, startIndex, pageSize);
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
	/**
	 * 根据id删除角色信息
	 * 并删除与菜单,用户相关关系
	 */
	@Override
	public int deleteObject(Integer id) {
		//检验id是否合法
		if(IntegerUtil.isIllegality(id))
			throw new ServiceException("选择项不能为空");
		int deleteObj= sysRolesDao.deleteByPrimaryKey(id);
		if(deleteObj==0)
			throw new ServiceException("该条信息可能已经不存在了");
		//删除菜单关系
		sysRoleMenusDao.deleteObjectByRoleId(id);
		//删除用户关系
		sysUserRolesDao.deleteObjectByRoleId(id);
	
		return deleteObj;
	}
	
	@Override
	public int insert(SysRoles record, Integer[] menuIds) {
		if(record==null)
			throw new ServiceException("修改后数据不能为空");
		if(StringUtils.isEmpty(record.getName()))
			throw new ServiceException("角色名不能为空");
		if(menuIds==null||menuIds.length==0)
			throw new ServiceException("角色权限不能为空");
		
		int insert = sysRolesDao.insert(record);
		sysRoleMenusDao.insertObject(record.getId(), menuIds);
		return insert;
	}
	/**
	 * 根据id查询角色信息
	 */
	@Override
	public Map<String, Object> getObjectById(Integer id) {
		if(IntegerUtil.isIllegality(id))
			throw new ServiceException("获取无效信息,请重试");
		SysRoles role = sysRolesDao.selectByPrimaryKey(id);
		if(role==null)
			throw new ServiceException("信息可能已经不存在了");
		List<Integer> menuids = sysRoleMenusDao.getMenuIdByRoleId(id);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("role", role);
		map.put("menusids", menuids);
		return map;
	}
	/**
	 * 更改操作
	 */
	@Override
	public int update(SysRoles record, Integer[] menuIds) {
		//验证修改内容
		if(record==null)
			throw new ServiceException("修改后数据不能为空");
		if(StringUtils.isEmpty(record.getName()))
			throw new ServiceException("角色名不能为空");
		if(menuIds==null||menuIds.length==0)
			throw new ServiceException("角色权限不能为空");
		
		int updateObj = sysRolesDao.updateByPrimaryKeySelective(record);
		if(updateObj==0)
			throw new ServiceException("修改失败,对象可能已经不存在");
		sysRoleMenusDao.deleteObjectByRoleId(record.getId());
		sysRoleMenusDao.insertObject(record.getId(), menuIds);
		
		return updateObj;
	}


}
