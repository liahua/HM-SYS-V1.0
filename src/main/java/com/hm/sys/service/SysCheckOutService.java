package com.hm.sys.service;

import com.hm.common.vo.CheckOutVoDetails;
import com.hm.common.vo.CheckoutSettlementVoDetail;

public interface SysCheckOutService {

	

	/**
	 * 
	* @Function: SysCheckOutService.java
	* @Description: 该函数的功能描述
	*
	* @param CheckOutVoDetails 应包含RooNameId以及CustomerInfo
	* @return
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: 李志学
	* @date: 2018年12月22日 下午2:51:29 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2018年12月22日     李志学          v1.0.0               修改原因
	 */
	CheckOutVoDetails checkOutDepencyRoomNameIdCustomerInfo(CheckOutVoDetails CheckOutVoDetails);
	CheckOutVoDetails checkOutDepencyOrderInfo(CheckOutVoDetails CheckOutVoDetails);
	/**
	 * 
	* @Function: SysCheckOutService.java
	* @Description: 该函数的功能描述
	*
	* @param checkOutVoDetail 所有属性不应为null
	* @return 账单明细
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: 李志学
	* @date: 2018年12月22日 下午2:51:42 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2018年12月22日     李志学          v1.0.0               修改原因
	 */
	CheckoutSettlementVoDetail CheckoutSettlement(CheckOutVoDetails checkOutVoDetail);

}
