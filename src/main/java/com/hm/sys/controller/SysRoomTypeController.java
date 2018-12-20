package com.hm.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.common.vo.JsonResult;
import com.hm.common.vo.PageObject;
import com.hm.sys.entity.RoomType;
import com.hm.sys.service.SysRoomTypeService;

@Controller
@RequestMapping("/room/")
public class SysRoomTypeController {
	
	 @Autowired
	  private SysRoomTypeService sysRoomTypeService;
	  /**
	   * 通过此方法返回日志列表页面
	   * 方法映射：建议和方法名相同
	   * 思考：如下方法如何被调用？反射技术
	   */
	 @RequestMapping("doRoomTypeUI")
		public String doRoomTypeUI(){
			return "room/room_type";
		}
	  
	  /**
	   * 执行日志删除操作
	   * @param ids
	   * @return
	   * log/doDeleteObjects.do?ids=70,71
	   */
	  @RequestMapping("doDeleteRoomType")
	  @ResponseBody
	  public JsonResult doDeleteRoomType(Integer... ids) {
		  sysRoomTypeService.deleteRoomType(ids);
		return new JsonResult("delete ok");
	}
	  //../log/doFindPageObjects.do?pageCurrent=1
	  @RequestMapping("doFindPageObjects")
	  @ResponseBody
	  public JsonResult doFindPageObjects(   
			  String rtName,
			  Integer pageCurrent){
		  PageObject<RoomType> pageObject=
				  sysRoomTypeService.findPageObjects(rtName,
							 pageCurrent);
		  return new JsonResult(pageObject);
}
}
