package com.hm.sys.service;

import java.util.List;

import com.hm.sys.entity.CustomerInfo;
import com.hm.sys.entity.OrderInfo;

public interface SysOrderService {
	int insertSelective(OrderInfo record);

	int deleteByPrimaryKey(Integer id);

	List<OrderInfo> selcetUserList(Integer userId);

	/**
	 * 
	 * @Function: SysOrderService.java
	 * @Description: 该函数的功能描述
	 *
	 * @param customerInfo       至少包含customerId
	 * @param orderInfoQueryType 2.查询类型为已预定订单 1.查询类型为已取消订单 null.查询类型为全部订单
	 *
	 * @return OrderInfo链表
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: 李志学
	 * @date: 2018年12月22日 上午11:57:49
	 *
	 *        Modification History: Date Author Version Description
	 *        ---------------------------------------------------------* 2018年12月22日
	 *        李志学 v1.0.0 修改原因
	 */
	List<OrderInfo> findOrderInfo(CustomerInfo customerInfo, Integer orderInfoQueryType);

}
