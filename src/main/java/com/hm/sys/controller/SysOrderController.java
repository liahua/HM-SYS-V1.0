package com.hm.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	//通过它指定控制器处理哪些URL请求
	@RequestMapping("UserOrder")
	public String UserOrder() {
		//操作的是获取页面串过来的数据
		
		//将数据封装到OrderInfo里面
		//先模拟一下数据
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setId(1);
		orderInfo.setRoomId(2);
		// ......
		sysOrderService.insertSelective(orderInfo);
		return new String("预定成功");
	
	}
}
