package com.hm.sys.service;

import java.util.List;

import com.hm.sys.entity.CustomerInfo;
import com.hm.sys.entity.CustomerTypeExample;

public interface SysCustomerService {
	  List<CustomerInfo> selectByExample(CustomerTypeExample example);
}
