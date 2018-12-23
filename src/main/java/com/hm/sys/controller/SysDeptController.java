package com.hm.sys.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.common.vo.JsonResult;

import com.hm.sys.entity.SysDepts;
import com.hm.sys.entity.SysDeptsExample;
import com.hm.sys.service.SysDeptService;
import com.hm.sys.vo.Node;

@Controller
@RequestMapping("/dept/")
public class SysDeptController {
	@Autowired
	private SysDeptService sysDeptService;
	
	@RequestMapping("doDeptUI")
	public String doDept() {
		System.out.println("2");
		return "dept/dept";
		//dept/doDeptUI.do
	}
	
	@RequestMapping("doAddDept")
	public String doAddDept() {
		System.out.println("doAddDept");
		return "dept/dept_add";
	}
	
	@RequestMapping("dogetObjects")
	@ResponseBody
	public JsonResult dogetObjects() {
		List<Map<String, Object>> objects = sysDeptService.getObjects();
		return new JsonResult(objects);
	}
	
	@RequestMapping("doDeleteObject")
	@ResponseBody
	public JsonResult doDeleteObject(Integer id) {
		int row = sysDeptService.deleteObject(id);
		return new JsonResult("delete is ok"+row);//测试时没有弹框"delete is ok"
	}
	
	@RequestMapping("doInsertObject")
	@ResponseBody
	public JsonResult doInsertObject(SysDepts entity) {
		sysDeptService.insertObject(entity);
		return new JsonResult("insert is ok");
	}
	
	@RequestMapping("doFindZtreeDeptNodes")
	@ResponseBody
	public JsonResult doFindZtreeDeptNodes() {
		List<Node> DeptNodes = sysDeptService.findZtreeDeptNodes();
		return new JsonResult(DeptNodes);
	}
	
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(SysDepts entity) {
		sysDeptService.updateObject(entity);
		return new JsonResult("update is ok");
	}
	
}
