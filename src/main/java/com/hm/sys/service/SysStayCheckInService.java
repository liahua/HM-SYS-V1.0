package com.hm.sys.service;

import java.util.Map;

public interface SysStayCheckInService {
	/**
	 * 查询客户以及客户对应的订单关联信息
	 *  @return 客户以及订单信息，用户对应的角色信息
	 * @author Xianggc
	 */
	Map<String,Object> findCustomerOrderbyCardNum(Integer CardNum);
}
