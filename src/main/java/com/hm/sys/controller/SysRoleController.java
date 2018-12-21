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
	@RequestMapping("doDeleteObject")
	@ResponseBody
	public JsonResult doDeleteObject(Integer id) {
		sysRoleService.deleteObject(id);
		return new JsonResult("delete is ok");
	}
	@RequestMapping("doInsertObject")
	@ResponseBody
	public JsonResult doInsertObject(SysRoles record, Integer[] menuIds) {
		sysRoleService.insert(record, menuIds);
		return new JsonResult("insert is ok");
	}
	/**
	 * 通过角色id获取角色信息
	 * @param id
	 * @return
	 */
	@RequestMapping("dogetObjectById")
	@ResponseBody
	public JsonResult dogetObjectById(Integer id) {
		Map<String, Object> objectById = sysRoleService.getObjectById(id);
		return new JsonResult(objectById);
	}
	
	@RequestMapping("doupdateObject")
	@ResponseBody
	public JsonResult doupdateObject(SysRoles record, Integer[] menuIds) {
		sysRoleService.update(record, menuIds);
		return new JsonResult("update is ok");
		
	}
	
	
}
