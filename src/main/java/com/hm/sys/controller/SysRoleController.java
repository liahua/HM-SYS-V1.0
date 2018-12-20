package com.hm.sys.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.common.vo.JsonResult;
import com.hm.common.vo.PageObject;
import com.hm.sys.entity.SysDepts;
import com.hm.sys.entity.SysDeptsExample;
import com.hm.sys.entity.SysRoles;
import com.hm.sys.entity.SysRolesExample;
import com.hm.sys.service.SysDeptService;
import com.hm.sys.service.SysRoleService;
import com.hm.sys.vo.Node;

@Controller
@RequestMapping("/role/")
public class SysRoleController {
	@Autowired
	private SysRoleService sysRoleService;
	
	@RequestMapping("doRoleUI")
	public String doRoleUI() {
		System.out.println("Role");
		return "role/role";
		//dept/doDeptUI.do
	}
	
	@RequestMapping("doAddRole")
	public String doAddRole() {
		return "role/role_add";
	}
	@RequestMapping("dogetPageObjects")
	@ResponseBody
	public JsonResult dogetPageObjects(String name, Integer pageCurrent){
		PageObject<SysRoles> findPageObjects = sysRoleService.findPageObjects(name, pageCurrent);
		return new JsonResult(findPageObjects);
		
	}
	
	
}
