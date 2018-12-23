package com.hm.sys.service;

import java.util.List;
import java.util.Map;

import com.hm.common.vo.CommonPageObject;
import com.hm.common.vo.CustomerAllInfo;
import com.hm.sys.entity.CustomerInfo;
import com.hm.sys.entity.CustomerTypeExample;

public interface SysCommonService {
	/**
	 * 
	 * @author 叶云彤
	 *		定义业务接口
	 *
	 */
	
		List<CustomerInfo> selectByExample(CustomerTypeExample example);

		/**
		 * 本方法中要分页查询角色信息,并查询角色总记录数据
		 * 
		 * @param pageCurrent 当表要查询的当前页的页码值
		 * @return 叶云彤
		 */
		CommonPageObject<CustomerAllInfo> findPageObjects(String name, Integer pageCurrent);
		/**
		 * 删除模块
		 * @param id
		 * @return 叶云彤
		 */
		int deleteObject(Integer id);
		/**
		 * 查询-修改
		 * 叶云彤
		 */
		Map<String,Object> findObjectById(Integer id) ;
		/**
		 * 叶云彤
		 * 保存
		 * @param entity
		 * @param menuIds
		 * @return
		 */
		 int saveObject(CustomerAllInfo entity,Integer[] menuIds);
		 /**
		  * 叶云彤
		  * 修改数据
		  * 
		  * @param entity
		  * @param menuIds
		  * @return
		  */
		 int updateObject(CustomerAllInfo entity,Integer[] menuIds);
		
}
