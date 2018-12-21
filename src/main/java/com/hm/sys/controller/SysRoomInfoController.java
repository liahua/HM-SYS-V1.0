package com.hm.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.common.vo.JsonResult;
import com.hm.common.vo.PageObject;
import com.hm.sys.entity.RoomInfo;
import com.hm.sys.service.SysRoomInfoService;


@Controller
@RequestMapping("/room/")
public class SysRoomInfoController {
	
	@Autowired
	  private SysRoomInfoService sysRoomInfoService;
	
	@RequestMapping("doRoomInfoUI")
	public String doRoomInfoUI(){
	return "room/room_info";
	}

	  /**
	   * 执行日志删除操作
	   * @param ids
	   * @return
	   * log/doDeleteObjects.do?ids=70,71
	   */
	  @RequestMapping("doDeleteRoomInfo")
	  @ResponseBody
	  public JsonResult doDeleteRoomInfo(Integer... ids) {
		  sysRoomInfoService.deleteRoomInfo(ids);
		return new JsonResult("delete ok");
	}
	  //../log/doFindPageObjects.do?pageCurrent=1
	  @RequestMapping("doFindPageObjectsInfo")
	  @ResponseBody
	  public JsonResult doFindPageObjectsInfo(   
			  String roomName,
			  Integer pageCurrent){
		  PageObject<RoomInfo> pageObject=
				  sysRoomInfoService.findPageObjects(roomName,
							 pageCurrent);
		  return new JsonResult(pageObject);		  
}
	  
	  //将方法返回值转换为json格式的字符串返回
	  //在将对象转换为json格式字符串时会调用对象的get方法获取值
	  
	  @ExceptionHandler(IllegalArgumentException.class)
	  @ResponseBody
	  public JsonResult doHandleException(
			  IllegalArgumentException e){
		  System.out.println("SysRoomInfoController.doHandleException");
		  e.printStackTrace();
		  return new JsonResult(e);
	  }
}
