package com.hm.sys.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.common.exception.ServiceException;
import com.hm.common.vo.PageObject;
import com.hm.sys.dao.SysRoomInfoViewDao;
import com.hm.sys.entity.RoomInfo;
import com.hm.sys.entity.RoomInfoExample;
import com.hm.sys.service.SysRoomInfoViewService;

/**
 * 
* Copyright: Copyright (c) 2018 lord
* 
* @ClassName: SysRoomInfoViewImpl.java
* @Description: 房间信息预览业务逻辑层 实现房间信息数据的查找和分页页面处理
*
* @version: v1.0.0
* @author: lord
* @date: Dec 21, 2018 11:28:01 PM 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* Dec 21, 2018     lord           v1.0.0			新增
 */
@Service
public class SysRoomInfoViewImpl implements SysRoomInfoViewService{
	/**
	 * 调用房间信息dao接口
	 */
	@Autowired
	private SysRoomInfoViewDao sysRoomInfoViewDao;
	/**
	 * 查找房间信息
	 */
	@Override
	public List<RoomInfo> findObjectsInfo(RoomInfoExample room) {
		
		return sysRoomInfoViewDao.findObjectsInfo(room);
	}
	/**
	 * 基于房间名称做分页查询
	 */
	@Override
	public PageObject<RoomInfo> findPageObjects(String roomName, Integer pageCurrent) {
		//1.对方法参数进行校验
		if(pageCurrent==null||pageCurrent<1)
		throw new IllegalArgumentException("页码值不正确");
		//2.依据条件查询总记录数
		int rowCount=sysRoomInfoViewDao.getRowCount(roomName);
		//3.对总记录数进行校验(等于0表示没有记录)
		if(rowCount==0)
	    throw new ServiceException("记录不存在");
		//4.依据条件查询当前页要显示的记录
		int pageSize=2;//页面大小
		int startIndex=(pageCurrent-1)*pageSize;//起始位置
		List<RoomInfo> records=
				sysRoomInfoViewDao.findPageObjects(roomName,
						startIndex, pageSize);
		//5.对查询结果进行封装并返回。
		PageObject<RoomInfo> pageObject=new PageObject<>();
		pageObject.setRowCount(rowCount);
		pageObject.setRecords(records);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setPageSize(pageSize);
		//6.房间总页数
		int pageCount=(rowCount-1)/pageSize+1;
		pageObject.setPageCount(pageCount);
		
		return pageObject;
	}
	
	@Override
	public Map<String, Object> findObjectById(Integer id) {
		//1.对参数进行校验
		if(id==null)
		throw new IllegalArgumentException("参数值无效");
		//2.查询房间信息
		RoomInfo result = sysRoomInfoViewDao.findObjectById(id);
		//4.查询结果进行封装
		Map<String,Object> map=new HashMap<>();
		map.put("room", result);//key要与页面取值方式保持一致
		return map;
	}
}
