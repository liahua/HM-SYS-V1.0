package com.hm.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.sys.dao.CustomerInfoMapper;
import com.hm.sys.entity.CustomerInfo;
import com.hm.sys.entity.CustomerInfoExample;
import com.hm.sys.entity.CustomerTypeExample;
import com.hm.sys.service.SysCustomerService;
@Service
public class SysCustomerServiceImpl implements SysCustomerService{

	
	@Autowired
	private CustomerInfoMapper customerInfoMapper;
	@Override
	public List<CustomerInfo> selectByExample(CustomerTypeExample example) {
//		CustomerInfoExample example1 = new CustomerInfoExample();
//		Criteria cri = example1.createCriteria();
//		cri.andCreatedtimeBetween(value1, value2);
		
		return customerInfoMapper.selectByExample(new CustomerInfoExample());
	}

}
