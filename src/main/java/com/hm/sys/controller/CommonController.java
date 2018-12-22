package com.hm.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.common.vo.CommonPageObject;
import com.hm.common.vo.CustomerAllInfo;
import com.hm.common.vo.JsonResultCustomer;
import com.hm.common.vo.PageObject;
import com.hm.sys.entity.CustomerTypeExample;
import com.hm.sys.service.SysCommonService;
/**
 * 
 * 客户管理  
 * @author 叶云彤
 *
 */
@Controller
@RequestMapping("/common/")
public class CommonController {

	@Autowired
	private SysCommonService sysCommonService;
	/**
	 * 普通客户
	 * 
	 * @return 叶云彤
	 */
	@RequestMapping("doCommonUI")
	public String doCommonUI() {
		return "customer/customer";
	}
	
	@RequestMapping("selectByExample")
	@ResponseBody
		public JsonResultCustomer selectByExample(CustomerTypeExample example) {
			return new JsonResultCustomer(sysCommonService.selectByExample(example));
		}
	
	/**
	 * 
	 * 交互前台传的数据
	 * 
	 * 
	 * @param example
	 * @return 叶云彤
	 */
	
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResultCustomer doFindPageObjects(String name, Integer pageCurrent) {
		CommonPageObject<CustomerAllInfo> pageObject =sysCommonService.findPageObjects(name, pageCurrent);
		//System.out.println(sysCommonService.findPageObjects(name, pageCurrent));
		return new JsonResultCustomer(pageObject);
	}
}
