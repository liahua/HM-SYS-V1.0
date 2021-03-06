package com.hm.sys.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.sys.dao.CheckInMapper;
import com.hm.sys.dao.CustomerCheckInMapper;
import com.hm.sys.dao.CustomerInfoMapper;
import com.hm.sys.dao.OrderInfoMapper;
import com.hm.sys.entity.CustomerInfo;
import com.hm.sys.entity.OrderInfo;
import com.hm.sys.service.SysStayCheckInService;
import com.hm.sys.vo.SysCustomerOrderResult;

/**
 * @author Xianggc
 */
@Service
public class SysStayCheckInServiceImpl implements SysStayCheckInService{
	@Autowired
	private CustomerCheckInMapper customerCheckInMapper;
	@Autowired
	private CheckInMapper checkInMapper;
	@Autowired
	CustomerInfoMapper customerInfoMapper;
	@Autowired
	OrderInfoMapper orderInfoMapper;
	
	public Map<String, Object> findCustomerOrderbyCardNum(Integer cardNum) {
		//1.对参数进行校验
				if(cardNum==null)
				throw new IllegalArgumentException("参数值无效");
				//2.查询用户以及对应的订单信息
				SysCustomerOrderResult result=
						customerCheckInMapper.findCustomerOrderbyCardNum(cardNum);
				//4.查询结果进行封装
				Map<String,Object> map=new HashMap<>();
				map.put("customer", result);
				return map;
	}

	@Override
	public int insertStayInfo(Integer cardNum,CustomerInfo record,OrderInfo record0) {
		Map<String, Object> map = findCustomerOrderbyCardNum(cardNum);
		if(map!=null) {
			checkInMapper.insertStayInfo();
		}else {
			customerInfoMapper.insertSelective(record);
			orderInfoMapper.insert(record0);
		}
		return 1;	
	}

}
