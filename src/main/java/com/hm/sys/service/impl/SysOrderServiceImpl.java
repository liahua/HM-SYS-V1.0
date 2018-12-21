package com.hm.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.hm.common.exception.ServiceException;
import com.hm.sys.dao.OrderInfoMapper;
import com.hm.sys.dao.RoomStateMapper;
import com.hm.sys.entity.OrderInfo;
import com.hm.sys.entity.RoomState;
import com.hm.sys.service.SysOrderService;
@Transactional(timeout=30,rollbackFor=RuntimeException.class)
@Service
public class SysOrderServiceImpl implements SysOrderService{
	
	@Autowired
	private OrderInfoMapper orderInfoMapper;
	
	@Autowired
	private RoomStateMapper roomStateMapper;

	@SuppressWarnings("unused")
	@Override
	public int insertSelective(OrderInfo record)  {
		
		//插入预定的订单
		orderInfoMapper.insertSelective(record);
		//修改房间的状态
		Integer roomId = record.getRoomId();
		RoomState roomState=new RoomState();
		//比如预定的状态是1
		roomState.setStat("1");
		roomState.setId(roomId);
		roomStateMapper.updateByPrimaryKey(roomState);
		//1.验证
		if(record==null)
		throw new ServiceException("无法为空，资料不能为空");
		if(StringUtils.isEmpty(record.getRoomId()))
		throw new ServiceException("");
		//3.返回数据
		return 1;
	}

	
}
