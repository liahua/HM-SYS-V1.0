package com.hm.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;

import com.hm.common.exception.ClassExceptionTest;

import com.hm.sys.dao.SysDeptsMapper;

import com.hm.sys.dao.SysUsersMapper;

import com.hm.sys.entity.SysDepts;
import com.hm.sys.entity.SysDeptsExample;
import com.hm.sys.service.SysDeptService;
import com.hm.sys.vo.Node;
@Service
public class SysDeptServiceImpl implements SysDeptService {
	@Autowired
	private SysDeptsMapper sysDeptsMapper;
	@Autowired
	private SysUsersMapper sysUsersMapper;
	@Override
	/**
	 * 查询sys_depts表内容
	 */
	public List<SysDepts> getObjects(SysDeptsExample example) {
		List<SysDepts> selectByExample = sysDeptsMapper.selectByExample(example);
		System.out.println("1");
		return selectByExample;
	}

	@Override
	public List<Node> findZtreeDeptNodes() {
		List<Node> fZtree = sysDeptsMapper.findZtreeDeptNodes();
		return fZtree;
	}

	@Override
	public int updateObject(SysDepts entity) {
		//验证
		if(entity==null)
			throw new ClassExceptionTest("保存对象不能为空");
		if(StringUtils.isEmpty(entity.getName()))
			throw new ClassExceptionTest("部门名称不能为空");
		//更新数据
		int row = sysDeptsMapper.updateByPrimaryKey(entity);
		if(row==0)
			throw new ClassExceptionTest("记录可能已经不存在");
		return row;
	}

	@Override
	public int insertObject(SysDepts entity) {
		if(entity==null)
			throw new ClassExceptionTest("保存对象不能为空");
		if(StringUtils.isEmpty(entity.getName()))
			throw new ClassExceptionTest("部门名称不能为空");
		int row;
		try {
			row = sysDeptsMapper.insert(entity);
		} catch (Exception e) {
			e.printStackTrace();
			throw new  ClassExceptionTest("保存失败");
		}

		return row;
	}

	@Override
	/**
	 * 部门删除操作
	 */
	public int deleteObject(Integer id) {
		//检测id是否正确
		if(id==null||id<0) 
			throw new ClassExceptionTest("id不合法");
		int cCount = sysDeptsMapper.getChildCount(id);
		if(cCount>0)
			throw new ClassExceptionTest("存在子部门，不能删除");
		int userCount = sysUsersMapper.getCountByDeptId(id);
		if(userCount>0)
			throw new ClassExceptionTest("该部门还有"+userCount+"个员工，请妥善处理");
		int row = sysDeptsMapper.deleteByPrimaryKey(id);
		if(row==0)
			throw new ClassExceptionTest("不存在该部门");
		return row;
	}


}
