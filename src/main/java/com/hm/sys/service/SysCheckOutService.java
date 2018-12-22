package com.hm.sys.service;

import java.util.List;

import com.hm.common.vo.CheckOutVoDetails;

import com.hm.sys.entity.CheckInfo;

public interface SysCheckOutService {

	/*
	 * 业务流程:结算--支付
	 * 			--其他
	 * 对于一个customer允许存在多个未支付stayInfo
	 * 对于一个customer,结算一定生成对应当次stayInfo的checkInfo
	 * 
	 * 
	 * 对于结算按钮:当点击结算按钮时,将视此刻系统时间为实际离店时间leave_date,会将customer下所有历史未支付订单以及本次未支付订单显示出来,可以通过每一个未支付订单"明细"按钮显示checkInfo;
	 * 			对于所有未支付订单都有一个checkbox复选框
	 * 注:历史未支付订单由"其他"按钮产生;
	 * 
	 * 
	 * 
	 * 
	 * 当点击"其他"按钮时,自动将本次stayInfo的leave_date同步为orderInfo的checkout_date
	 * 
	 * 
	 */
	

	/**
	 * 
	* @Function: SysCheckOutService.java
	* @Description: 结算按钮触发
	*
	* @param CheckOutVoDetails 应包含CustomerInfo唯一性识别信息
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
	CheckOutVoDetails checkOutDepencyCustomerInfo(CheckOutVoDetails CheckOutVoDetails);
	CheckOutVoDetails checkOutDepencyOrderInfo(CheckOutVoDetails CheckOutVoDetails);
	/**
	 * 
	* @Function: SysCheckOutService.java
	* @Description: 通过checkOutVoDetail 计算所有未支付stayInfo付款金额,以及生成checkInfo明细,存入数据库,并返回明细表
	*
	* @param checkOutVoDetail 包含所有未支付stayInfo
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
	List<CheckInfo> CalculateUnpayBillDetails(CheckOutVoDetails checkOutVoDetail);

}
