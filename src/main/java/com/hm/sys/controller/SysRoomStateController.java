package com.hm.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.common.vo.JsonResult;
import com.hm.common.vo.PageObject;
import com.hm.sys.entity.RoomState;
import com.hm.sys.entity.RoomStateExample;
import com.hm.sys.service.SysRoomStateService;


@Controller
@RequestMapping("/room/")
public class SysRoomStateController {
	
	@Autowired
	  private SysRoomStateService sysRoomStateService;
	
	@RequestMapping("doRoomStateUI")
	public String doRoomStateUI(){
		return "room/room_state";
	}
	
	  /**
	   * 执行日志删除操作
	   * @param ids
	   * @return
	   * log/doDeleteObjects.do?ids=70,71
	   */
	  @RequestMapping("doDeleteRoomState")
	  @ResponseBody
	  public JsonResult doDeleteRoomState(Integer... ids) {
		  sysRoomStateService.deleteRoomState(ids);
		return new JsonResult("delete ok");
	}
	  //../log/doFindPageObjects.do?pageCurrent=1
	  @RequestMapping("doFindPageObjectsState")
	  @ResponseBody
	  public JsonResult doFindPageObjectsState(   
			  String stat,
			  Integer pageCurrent){
		  PageObject<RoomState> pageObject=
				  sysRoomStateService.findPageObjects(stat,
							 pageCurrent);
		  return new JsonResult(pageObject);		  
}
	  
	  //将方法返回值转换为json格式的字符串返回
	  //在将对象转换为json格式字符串时会调用对象的get方法获取值
	  
	  @ExceptionHandler(IllegalArgumentException.class)
	  @ResponseBody
	  public JsonResult doHandleException(
			  IllegalArgumentException e){
		  System.out.println("sysRoomStateController.doHandleException");
		  e.printStackTrace();
		  return new JsonResult(e);
	  }
	  
	  @RequestMapping("doFindObjectsState")
		@ResponseBody
		public JsonResult doFindObjectsState(RoomStateExample example){
			 return new JsonResult(sysRoomStateService.findObjectsState(example));
}
}
