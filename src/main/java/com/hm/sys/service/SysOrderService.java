package com.hm.sys.service;

import java.util.List;

import com.hm.sys.entity.OrderInfo;

public interface SysOrderService {
	int insertSelective(OrderInfo record);
	 int deleteByPrimaryKey(Integer id);
	 
	List<OrderInfo> selcetUserList(Integer userId);
}
