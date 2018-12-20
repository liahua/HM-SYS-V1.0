package com.hm.sys.service.impl;

import org.springframework.stereotype.Service;

import com.hm.common.utils.IntegerUtil;
import com.hm.common.vo.CheckOutVoDetails;
import com.hm.sys.service.SysCheckOutService;

@Service
public class SysCheckOutServiceImpl implements SysCheckOutService{

	@Override
	public CheckOutVoDetails checkOutOrder(Integer roomId) {
		if(IntegerUtil.isIllegality(roomId)) {
			
		}
		return null;
	}

}
