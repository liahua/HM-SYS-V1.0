package com.hm.sys.service;

import java.util.List;

import com.hm.common.vo.CheckOutVoDetails;

import com.hm.sys.entity.CheckInfo;

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
	* @Description: 通过checkOutVoDetail 计算付款金额,以及生成checkInfo明细,存入数据库,并返回明细表
	*
	* @param checkOutVoDetail
	* @return
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: 李志学
	* @date: 2018年12月22日 下午4:07:17 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2018年12月22日     李志学          v1.0.0               修改原因
	 */
	List<CheckInfo> CalculateBillDetails(CheckOutVoDetails checkOutVoDetail);

}
