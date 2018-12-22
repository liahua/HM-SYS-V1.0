package com.hm.sys.service;

import java.util.List;

import com.hm.sys.entity.CustomerInfo;
import com.hm.sys.entity.StayInfo;

public interface SysStayInfoService {
	/**
	 * 
	 * @Function: SysStayInfoService.java
	 * @Description: 该函数的功能描述
	 *
	 * @param customerInfo 必须包含customerId
	 * @param isCheckOut   0为未支付,1为支付,null为查询全部入住信息
	 * @return 入住信息链表
	 * 
	 * @throws：isCheckOut 为0 抛未查到未支付入住信息 为1抛未查到已支付入住信息 为null 该客户无入住信息;
	 *                    无此用户信息==customerInfo中无customerId
	 * 
	 * 
	 *
	 * @version: v1.0.0
	 * @author: 李志学
	 * @date: 2018年12月22日 上午10:04:44
	 *
	 *        Modification History: Date Author Version Description
	 *        ---------------------------------------------------------* 2018年12月22日
	 *        李志学 v1.0.0 修改原因
	 */
	List<StayInfo> findStayInfo(CustomerInfo customerInfo, Integer isCheckOut);

}
