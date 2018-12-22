package com.hm.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.common.vo.JsonResult;
import com.hm.sys.entity.OrderInfo;
import com.hm.sys.service.SysOrderService;

@RequestMapping("/order/")
@Controller
public class SysOrderController {
	@Autowired
	private SysOrderService sysOrderService;

	@RequestMapping("doOrderListUI")
	public String doOrderListUI(){
		return "order/order_list";
	}
	//顾客查看自己的订单信息
	@RequestMapping("selectByPrimaryKey")
	@ResponseBody
	public List<OrderInfo>  selectByPrimaryKey(){
		//获取客户的唯一编号
		Integer userId = 1;
		List<OrderInfo> selcetUserList = sysOrderService.selcetUserList(userId);
		return selcetUserList;
	}
	
	
	//通过它指定控制器处理哪些URL请求
	@RequestMapping("UserOrderl")
	public String UserOrder( ) {
		//操作的是获取页面串过来的数据
		
		//将数据封装到OrderInfo里面
		//模拟的数据
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setRoomId(2);
		sysOrderService.insertSelective(orderInfo);
		return "预定成功";

	}
	@RequestMapping("OrderDelete")
	@ResponseBody
	public JsonResult OrderDelete(Integer id) {
		sysOrderService.deleteByPrimaryKey(id);
		return new JsonResult("删除成功");
	}
}
