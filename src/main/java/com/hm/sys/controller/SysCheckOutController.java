package com.hm.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.common.vo.CheckOutVoDetails;

import com.hm.common.vo.JsonResult;
import com.hm.sys.entity.CheckInfo;
import com.hm.sys.entity.CustomerInfo;
import com.hm.sys.entity.RoomInfo;
import com.hm.sys.service.SysCheckOutService;
import com.sun.org.apache.regexp.internal.recompile;

@Controller
@RequestMapping("/checkOut/")
public class SysCheckOutController {

	@Autowired
	private SysCheckOutService sysCheckOutService;

	/**
	 * 
	 * @Function: SysCheckOutController.java
	 * @Description: 通过stayInfo查找orderInfo 可 通过结算按钮触发
	 *
	 * @param checkOutVoDetail 至少要包含保证Customer唯一性的信息.需明确指定stayInfoQueryType
	 * @return
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: 李志学
	 * @date: 2018年12月22日 下午5:52:36
	 *
	 *        Modification History: Date Author Version Description
	 *        ---------------------------------------------------------* 2018年12月22日
	 *        李志学 v1.0.0 修改原因
	 */
	@RequestMapping("checkOutDepencyRoomNameIdCustomerInfo")
	@ResponseBody
	public JsonResult checkOutDepencyRoomNameIdCustomerInfo(@RequestBody CheckOutVoDetails checkOutVoDetail) {

		/*
		 * CheckOutVoDetails checkOutVoDetails1 = new CheckOutVoDetails(); RoomInfo
		 * roomInfo = new RoomInfo(); roomInfo.setRoomName("2202");
		 * checkOutVoDetails1.setRoomInfo(roomInfo); CustomerInfo customerInfo = new
		 * CustomerInfo(); customerInfo.setId(1);
		 * checkOutVoDetails1.setCustomerInfo(customerInfo);
		 * System.out.println("checkOutVoDetails1"+checkOutVoDetails1);
		 */

		CheckOutVoDetails checkOutVoDetails = sysCheckOutService.checkOutDepencyCustomerInfo(checkOutVoDetail);
		return new JsonResult(checkOutVoDetails);
	}

	/**
	 * 
	 * @Function: SysCheckOutController.java
	 * @Description: 通过checkOutVoDetail 计算付款金额,以及生成checkInfo明细,回显明细表 通过"查看明细"按钮触发
	 * @param checkOutVoDetail
	 * @return
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: 李志学
	 * @date: 2018年12月22日 下午4:08:38
	 *
	 *        Modification History: Date Author Version Description
	 *        ---------------------------------------------------------* 2018年12月22日
	 *        李志学 v1.0.0 修改原因
	 */
	public JsonResult CalculateBillDetails(@RequestBody CheckOutVoDetails checkOutVoDetail) {
		List<CheckInfo> checkInfoEntity = sysCheckOutService.CalculateBillDetails(checkOutVoDetail);
		return new JsonResult(checkInfoEntity);
	}
	// 支付按钮 判断是否选中thisTimeStayInfo.未选中,只将选中的stayinfo的支付状态update.选中,则追加insert
	// checkout,以及更新update thisTimeStayInfo状态
	// "其他"按钮 同上,但是无update StayInfo的支付状态
	// 系统每24小时自检一次,将所有stayInfo leave_date==null的订单
	// 关联orderInfo,获取orderInfo.checkOutTime
	// equals比较.相等,即更新stayInfo的leave_date==orderInfo.checkInfo,并将添加未手动结费备注
	
	/**
	 * 
	* @Function: SysCheckOutController.java
	* @Description: 该函数的功能描述 
	*
	* @return
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: 李志学
	* @date: 2018年12月23日 下午3:52:51 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2018年12月23日     李志学          v1.0.0               修改原因
	 */
	public JsonResult payStayInfos() {
		return null;
	}

}
