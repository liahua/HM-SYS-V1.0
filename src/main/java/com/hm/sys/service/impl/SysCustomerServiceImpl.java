package com.hm.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.common.vo.CustomerAllInfo;
import com.hm.common.vo.PageObject;
import com.hm.sys.dao.CustomerInfoMapper;
import com.hm.sys.entity.CustomerInfo;
import com.hm.sys.entity.CustomerInfoExample;
import com.hm.sys.entity.CustomerTypeExample;
import com.hm.sys.service.SysCustomerService;
/**
 * 
 * 
 * @author 叶云彤
 *
 */
@Service
public class SysCustomerServiceImpl implements SysCustomerService{

	@Autowired
	private CustomerInfoMapper customerInfoMapper;
	
	/**
	 * 页面数据 
	 */
	@Override
	public List<CustomerInfo> selectByExample(CustomerTypeExample example) {
//		CustomerInfoExample example1 = new CustomerInfoExample();
//		Criteria cri = example1.createCriteria();
//		cri.andCreatedtimeBetween(value1, value2);
		
		return customerInfoMapper.selectByExample(new CustomerInfoExample());
	}

	@Override
	public PageObject<CustomerAllInfo> findPageObjects(String name, Integer pageCurrent) {

		
		
		
		
		
		return null;
	}

}
