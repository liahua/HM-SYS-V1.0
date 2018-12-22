package com.hm.sys.service.impl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hm.common.exception.ServiceException;
import com.hm.common.utils.IntegerUtil;
import com.hm.common.utils.ListUtil;
import com.hm.sys.dao.StayInfoMapper;
import com.hm.sys.entity.CustomerInfo;
import com.hm.sys.entity.StayInfo;
import com.hm.sys.entity.StayInfoExample;
import com.hm.sys.entity.StayInfoExample.Criteria;
import com.hm.sys.service.SysStayInfoService;





@Service
public class SysStayInfoServiceImpl implements SysStayInfoService{

	@Autowired
	private StayInfoMapper stayInfoMapper;
	@Override
	public List<StayInfo> findStayInfo(CustomerInfo customerInfo,Integer isCheckOut) {
		if(isCheckOut!=null&&isCheckOut!=0&&isCheckOut!=1) {
			throw new ServiceException("不合法的查询状态");
		}
		Integer id = customerInfo.getId();
		if(IntegerUtil.isIllegality(id)) {
			throw new ServiceException("无此用户信息");
		}
		StayInfoExample stayInfoExample = new StayInfoExample();
		Criteria criteria = stayInfoExample.createCriteria();
		criteria.andCustomerIdEqualTo(id);
		if(isCheckOut!=null) {
			criteria.andIsCheckoutEqualTo(id);
		}
		List<StayInfo> stayInfos = stayInfoMapper.selectByExample(stayInfoExample);
		if(ListUtil.isEmpty(stayInfos)) {
			if(isCheckOut==null) {
				throw new ServiceException("无入住信息");
			}else if(isCheckOut==1) {
				throw new ServiceException("无已支付的入住信息");
			}else if(isCheckOut==0) {
				throw new ServiceException("无需支付的入住信息");
			}
		}
		return stayInfos;
	}

}
