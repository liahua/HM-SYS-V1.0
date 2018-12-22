package com.hm.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.common.vo.JsonResult;
import com.hm.common.vo.PageObject;
import com.hm.sys.entity.RoomInfo;
import com.hm.sys.entity.RoomInfoExample;
import com.hm.sys.service.SysRoomInfoViewService;
/**
 * 
* Copyright: Copyright (c) 2018 lord
* 
* @ClassName: SysRoomInfoViewController.java
* @Description:
*
* @version: v1.0.0
* @author: lord
* @date: Dec 21, 2018 11:29:47 PM 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* Dec 21, 2018     lord           v1.0.0
 */
@Controller
@RequestMapping("/view/")
public class SysRoomInfoViewController {
	@Autowired
	private SysRoomInfoViewService sysRoomInfoViewService;
/**
 * 
* @Function: SysRoomInfoViewController.java
* @Description: 该函数的功能描述
*
* @param:描述1描述
* @return：返回房间信息预览页面
* @throws：异常描述
*
* @version: v1.0.0
* @author: lord
* @date: Dec 21, 2018 11:29:57 PM 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* Dec 21, 2018     lord           v1.0.0               修改原因
 */
	@RequestMapping("doRoomViewUI")
	public String doRoomInfoUI(){
		return "room/room_view";
	}
	/**
	 * 
	 * @param room 返回jason格式的房间信息
	 * @return
	 */
	@RequestMapping("doRoomView")
	@ResponseBody
	public JsonResult doRoomView(RoomInfoExample room){
		return new JsonResult(sysRoomInfoViewService.findObjectsInfo(room));
	}
	//根据id去查找相关房间的信息
    @RequestMapping("doFindObjectById")
    @ResponseBody
    public JsonResult doFindObjectById(Integer id){
   	 return new JsonResult(sysRoomInfoViewService.findObjectById(id));
    }
	//查找分页信息
	@RequestMapping("doFindPageObjectsInfo")
	@ResponseBody
	public JsonResult doFindPageObjectsInfo(   
			String roomName,
			Integer pageCurrent){
		PageObject<RoomInfo> pageObject=
				sysRoomInfoViewService.findPageObjects(roomName,
						pageCurrent);
		return new JsonResult(pageObject);		  
	}
	//将方法返回值转换为json格式的字符串返回
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseBody
	public JsonResult doHandleException(
			IllegalArgumentException e){
		System.out.println("SysRoomInfoController.doHandleException");
		e.printStackTrace();
		return new JsonResult(e);
	}
}
