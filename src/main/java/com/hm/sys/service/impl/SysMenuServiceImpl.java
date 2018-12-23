package com.hm.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;


import com.hm.common.exception.ServiceException;
import com.hm.sys.dao.SysMenusDao;

import com.hm.sys.dao.SysRoleMenusDao;

import com.hm.sys.entity.SysMenus;
import com.hm.sys.entity.SysMenusExample;
import com.hm.sys.service.SysMenuService;
import com.hm.sys.vo.Node;

@Service
public class SysMenuServiceImpl implements SysMenuService {
	@Autowired
	private SysMenusDao sysMenusDao;
	@Autowired
	private SysRoleMenusDao sysRoleMenusDao;
	
	/**
	 * 查询菜单信息
	 */
	@Override
	public List<Map<String, Object>> getObjects() {
		List<Map<String, Object>> objects = sysMenusDao.getObjects();
		return objects;
	}
	/**
	 * 根据菜单id删除信息
	 * 并删除角色与菜单关系
	 */
	@Override
	public int deleteObject(Integer id) {
		// 验证
		if (id == null || id < 0)
			throw new ServiceException("请选择需要删除的对象");
		int cCount = sysMenusDao.getChildCount(id);
		if (cCount > 0)
			throw new ServiceException("请先删除子菜单");
		int row = sysMenusDao.deleteByPrimaryKey(id);
		if (row == 0)
			throw new ServiceException("该选项可能已经不存在了");
		// 删除菜单关系数据
		sysRoleMenusDao.deleteObjectByMenuId(id);
		return row;
	}

	@Override
	public List<Node> findZtreeMenuNodes() {
		List<Node> findZtreeMenuNodes = sysMenusDao.findZtreeMenuNodes();
		return findZtreeMenuNodes;
	}
	/**
	 * 菜单添加操作
	 */
	@Override
	public int insert(SysMenus record) {
		// 验证
		if (record == null)
			throw new ServiceException("修改对象不能为空");
		if (StringUtils.isEmpty(record.getName()))
			throw new ServiceException("菜单名不能为空");
		int row;
		try {
			row = sysMenusDao.insert(record);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("保存失败");
		}

		return row;
	}
	/**
	 * 惨淡更改操作
	 */
	@Override
	public int update(SysMenus record) {
		if (record == null)
			throw new ServiceException("修改选项不能为空");
		if (StringUtils.isEmpty(record.getName()))
			throw new ServiceException("菜单名不能为空");
		int row = sysMenusDao.updateByPrimaryKey(record);
		if (row == 0)
			throw new ServiceException("该选项可能已经不存在了");
		return row;
	}

}
