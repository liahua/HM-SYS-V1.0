package com.hm.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;

import com.hm.common.exception.ClassExceptionTest;
import com.hm.common.exception.ServiceException;
import com.hm.common.utils.IntegerUtil;
import com.hm.sys.dao.SysDeptsDao;

import com.hm.sys.dao.SysUsersDao;

import com.hm.sys.entity.SysDepts;
import com.hm.sys.entity.SysDeptsExample;
import com.hm.sys.service.SysDeptService;
import com.hm.sys.vo.Node;
@Service
public class SysDeptServiceImpl implements SysDeptService {
	@Autowired
	private SysDeptsDao sysDeptsDao;
	@Autowired
	private SysUsersDao sysUsersDao;
	@Override
	/**
	 * 查询sys_depts表内容
	 */
	public List<SysDepts> getObjects(SysDeptsExample example) {
		List<SysDepts> selectByExample = sysDeptsDao.selectByExample(example);
		System.out.println("1");
		return selectByExample;
	}
	
	@Override
	public List<Node> findZtreeDeptNodes() {
		List<Node> fZtree = sysDeptsDao.findZtreeDeptNodes();
		return fZtree;
	}
	/**
	 * 修改部门信息
	 */
	@Override
	public int updateObject(SysDepts entity) {
		//验证
		if(entity==null)
			throw new ServiceException("保存对象不能为空");
		if(StringUtils.isEmpty(entity.getName()))
			throw new ServiceException("部门名称不能为空");
		//更新数据
		int row = sysDeptsDao.updateByPrimaryKey(entity);
		if(row==0)
			throw new ServiceException("记录可能已经不存在");
		return row;
	}
	/**
	 * 添加部门信息
	 */
	@Override
	public int insertObject(SysDepts entity) {
		if(entity==null)
			throw new ServiceException("保存对象不能为空");
		if(StringUtils.isEmpty(entity.getName()))
			throw new ServiceException("部门名称不能为空");
		int row;
		try {
			row = sysDeptsDao.insert(entity);
		} catch (Exception e) {
			e.printStackTrace();
			throw new  ServiceException("保存失败");
		}

		return row;
	}

	@Override
	/**
	 * 部门删除操作
	 */
	public int deleteObject(Integer id) {
		//检测id是否正确
		if(IntegerUtil.isIllegality(id)) 
			throw new ServiceException("id不合法");
		int cCount = sysDeptsDao.getChildCount(id);
		if(cCount>0)
			throw new ServiceException("存在子部门，不能删除");
		int userCount = sysUsersDao.getCountByDeptId(id);
		if(userCount>0)
			throw new ServiceException("该部门还有"+userCount+"个员工，请妥善处理");
		int row = sysDeptsDao.deleteByPrimaryKey(id);
		if(row==0)
			throw new ServiceException("不存在该部门");
		return row;
	}


}
