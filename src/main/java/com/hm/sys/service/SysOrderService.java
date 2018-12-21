package com.hm.sys.service;

import com.hm.sys.entity.OrderInfo;

public interface SysOrderService {
	int insertSelective(OrderInfo record);
}
