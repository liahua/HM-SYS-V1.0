package com.hm.sys.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.common.vo.CommonPageObject;
import com.hm.common.vo.CustomerAllInfo;
import com.hm.common.vo.JsonResultCustomer;
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
	/**
	 *  叶云彤
	 * 删除模块
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("doDeleteObject")
	@ResponseBody
	public JsonResultCustomer doDeleteObject(Integer id){
	 sysCommonService.deleteObject(id);
	return new JsonResultCustomer("delete Ok");
	}
/**
 *  	叶云彤
 * 根据id查询-修改
 * 
 * @param id
 * @return
 */
	@RequestMapping("doFindObjectById")
	@ResponseBody
	 public JsonResultCustomer doFindObjectById(Integer id){
		
	    	Map<String,Object> map=sysCommonService.findObjectById(id);
	    	
	    	return new JsonResultCustomer(map);
	 }

		/**
		 * 角色修改
		 * @return
		 */
		@RequestMapping("doRoleEditUI")
		public String doRoleEditUI() {
			return "customer/customer_edit";
		}
		
		@RequestMapping("doUpdateObject")
		@ResponseBody
		public JsonResultCustomer doUpdateObject(CustomerAllInfo entity, Integer[] menuIds) {
			sysCommonService.updateObject(entity, menuIds);
			return new JsonResultCustomer("update ok");

		}
		/**
		 * 叶云彤
		 * 保存数据
		 * @param entity
		 * @param menuIds
		 * @return
		 */
		@RequestMapping("doSaveObject")
		@ResponseBody
		public JsonResultCustomer doSaveObject(CustomerAllInfo entity, Integer[] menuIds) {
			sysCommonService.saveObject(entity, menuIds);
			return new JsonResultCustomer("保存成功");
		}
	
}
