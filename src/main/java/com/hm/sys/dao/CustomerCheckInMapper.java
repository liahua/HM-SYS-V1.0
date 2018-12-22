package com.hm.sys.dao;

import com.hm.sys.vo.SysCustomerOrderResult;

public interface CustomerCheckInMapper {
	/**
	 * 基于身份证号查询客户自身信息以及对应的订单信息
	 * @param id
	 * @author Xianggc
	 */
	SysCustomerOrderResult findCustomerOrderbyCardNum(Integer cardNum);
}
