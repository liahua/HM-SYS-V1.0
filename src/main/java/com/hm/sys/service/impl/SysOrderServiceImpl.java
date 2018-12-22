package com.hm.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.hm.common.exception.ServiceException;
import com.hm.common.utils.IntegerUtil;
import com.hm.common.utils.ListUtil;
import com.hm.sys.dao.OrderInfoMapper;
import com.hm.sys.dao.RoomStateMapper;
import com.hm.sys.entity.CustomerInfo;
import com.hm.sys.entity.OrderInfo;
import com.hm.sys.entity.OrderInfoExample;
import com.hm.sys.entity.OrderInfoExample.Criteria;
import com.hm.sys.entity.RoomState;
import com.hm.sys.entity.StayInfo;
import com.hm.sys.entity.StayInfoExample;
import com.hm.sys.service.SysOrderService;

@Transactional(timeout = 30, rollbackFor = RuntimeException.class)
@Service
public class SysOrderServiceImpl implements SysOrderService {

	@Autowired
	private OrderInfoMapper orderInfoMapper;

	@Autowired
	private RoomStateMapper roomStateMapper;

	@SuppressWarnings("unused")
	@Override
	public int insertSelective(OrderInfo record) {

		// 插入预定的订单
		orderInfoMapper.insertSelective(record);
		// 修改房间的状态
		Integer roomId = record.getRoomId();
		RoomState roomState = new RoomState();
		// 比如预定的状态是1
		roomState.setStat("1");
		roomState.setId(roomId);
		roomStateMapper.updateByPrimaryKey(roomState);
		// 1.验证
		if (record == null)
			throw new ServiceException("无法为空，资料不能为空");
		if (StringUtils.isEmpty(record.getRoomId()))
			throw new ServiceException("房间ID不能空白");
		// 3.返回数据
		return 1;
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {// 这个id是订单的id
		// 删除订单信息
		orderInfoMapper.deleteByPrimaryKey(id);
		// 从订单信息中获取房间的id
		OrderInfo orderInfo = orderInfoMapper.selectByPrimaryKey(id);
		// 修改房间信息
		RoomState roomState = new RoomState();
		roomState.setStat("2");
		roomState.setId(orderInfo.getRoomId());
		roomStateMapper.updateByPrimaryKey(roomState);
		return 0;
	}

	@Override
	public List<OrderInfo> selcetUserList(Integer userId) {
		OrderInfoExample example = new OrderInfoExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andCustomerIdEqualTo(userId);
		List<OrderInfo> list = orderInfoMapper.selectByExample(example);
		return list;
	}

	@Override
	public List<OrderInfo> findOrderInfo(CustomerInfo customerInfo, Integer orderInfoQueryType) {
		Integer id = customerInfo.getId();
		if (IntegerUtil.isIllegality(id)) {
			throw new ServiceException("无此用户信息");
		}
		OrderInfoExample orderInfoExample = new OrderInfoExample();
		Criteria criteria = orderInfoExample.createCriteria();
		criteria.andCustomerIdEqualTo(id);
		if (orderInfoQueryType != null) {
			criteria.andOrderStatIdEqualTo(orderInfoQueryType);
		}
		List<OrderInfo> orderInfos = orderInfoMapper.selectByExample(orderInfoExample);
		if (ListUtil.isEmpty(orderInfos)) {
			if (orderInfoQueryType == null) {
				throw new ServiceException("预定订单中无订单");
			} else if (orderInfoQueryType == 1) {
				throw new ServiceException("无确认的订单");
			} else if (orderInfoQueryType == 2) {
				throw new ServiceException("无取消的订单");
			}
		}
		return orderInfos;
	}

}
