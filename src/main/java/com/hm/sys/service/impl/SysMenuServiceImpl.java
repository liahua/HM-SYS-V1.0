package com.hm.sys.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;


import com.hm.common.exception.ServiceException;
import com.hm.sys.dao.SysMenusMapper;

import com.hm.sys.dao.SysRoleMenusMapper;

import com.hm.sys.entity.SysMenus;
import com.hm.sys.entity.SysMenusExample;
import com.hm.sys.service.SysMenuService;
import com.hm.sys.vo.Node;

@Service
public class SysMenuServiceImpl implements SysMenuService {
	@Autowired
	private SysMenusMapper sysMenusMapper;
	@Autowired
	private SysRoleMenusMapper sysRoleMenusMapper;
	
	/**
	 * 查询菜单信息
	 */
	@Override
	public List<SysMenus> getObjects(SysMenusExample example) {
		List<SysMenus> objects = sysMenusMapper.selectByExample(example);
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
		int cCount = sysMenusMapper.getChildCount(id);
		if (cCount > 0)
			throw new ServiceException("请先删除子菜单");
		int row = sysMenusMapper.deleteByPrimaryKey(id);
		if (row == 0)
			throw new ServiceException("该选项可能已经不存在了");
		// 删除菜单关系数据
		sysRoleMenusMapper.deleteObjectByMenuId(id);
		return row;
	}

	@Override
	public List<Node> findZtreeMenuNodes() {
		List<Node> findZtreeMenuNodes = sysMenusMapper.findZtreeMenuNodes();
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
			row = sysMenusMapper.insert(record);
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
		int row = sysMenusMapper.updateByPrimaryKey(record);
		if (row == 0)
			throw new ServiceException("该选项可能已经不存在了");
		return row;
	}

}
