package com.hm.sys.service;

import java.util.List;

import com.hm.common.vo.CustomerAllInfo;
import com.hm.common.vo.PageObject;
import com.hm.sys.entity.CustomerInfo;
import com.hm.sys.entity.CustomerTypeExample;
/**
 * 
 * @author 叶云彤
 *
 */
public interface SysCustomerService {
	  List<CustomerInfo> selectByExample(CustomerTypeExample example);
	  
	  /**
	      * 本方法中要分页查询角色信息,并查询角色总记录数据
	      * @param pageCurrent 当表要查询的当前页的页码值
	      * @return 封装当前实体数据以及分页信息
	      */
		 PageObject<CustomerAllInfo> findPageObjects(
				 String name,Integer pageCurrent);
		 

	  
}
