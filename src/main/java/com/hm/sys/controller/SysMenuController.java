package com.hm.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.common.vo.JsonResult;
import com.hm.sys.entity.SysMenus;
import com.hm.sys.entity.SysMenusExample;
import com.hm.sys.service.SysMenuService;



@Controller
@RequestMapping("/menu/")
public class SysMenuController {
	
	@Autowired
	private SysMenuService sysMenuService;
	@RequestMapping("doMenuUI")
	public String doMenuUI() {
		return "menu/menu";
	}
	
	@RequestMapping()
	public String doMenuAddUI() {
		return "menu/menu_add";
	}
	
	@RequestMapping("doGetObjects")
	@ResponseBody
	public JsonResult doGetObjects() {
		return new JsonResult(sysMenuService.getObjects());
	}
	@RequestMapping("doDeleteObject")
	@ResponseBody
	public JsonResult doDeleteObject(Integer id) {
		sysMenuService.deleteObject(id);
		return new JsonResult("delete is ok");
	}
	
	@RequestMapping("doFindZtreeMenuNodes")
	 @ResponseBody
	 public JsonResult doFindZtreeMenuNodes(){
		 return new JsonResult(
		 sysMenuService.findZtreeMenuNodes());
	 }
	@RequestMapping("doInsertObject")
	 @ResponseBody
	public JsonResult doInsertObject(SysMenus record) {
		sysMenuService.insert(record);
		return new JsonResult("insert is ok ");
	}
	@RequestMapping("doUpdateObject")
	 @ResponseBody
	public JsonResult doUpdateObject(SysMenus record) {
		sysMenuService.update(record);
		return new JsonResult("update is OK");
	}
}
