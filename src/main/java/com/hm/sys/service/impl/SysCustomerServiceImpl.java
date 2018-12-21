package com.hm.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.hm.common.exception.ServiceException;
import com.hm.common.utils.IntegerUtil;
import com.hm.common.utils.ListUtil;
import com.hm.common.utils.ObjectUtil;
import com.hm.common.vo.CustomerAllInfo;
import com.hm.common.vo.PageObject;
import com.hm.sys.dao.CustomerInfoMapper;
import com.hm.sys.entity.CustomerInfo;
import com.hm.sys.entity.CustomerInfoExample;
import com.hm.sys.entity.CustomerTypeExample;
import com.hm.sys.service.SysCustomerService;

/**
 * 
 * 
 * @author 叶云彤
 *
 */
@Service
public class SysCustomerServiceImpl implements SysCustomerService {

	@Autowired
	private CustomerInfoMapper customerInfoMapper;

	/**
	 * 页面数据
	 */
	@Override
	public List<CustomerInfo> selectByExample(CustomerTypeExample example) {
//		CustomerInfoExample example1 = new CustomerInfoExample();
//		Criteria cri = example1.createCriteria();
//		cri.andCreatedtimeBetween(value1, value2);

		return customerInfoMapper.selectByExample(new CustomerInfoExample());
	}

	@Override
	public PageObject<CustomerAllInfo> findPageObjects(String name, Integer pageCurrent) {

		return null;
	}

	@Override
	public CustomerInfo findCustomerInfo(Integer id) {
		CustomerInfo CustomerInfo = customerInfoMapper.selectByPrimaryKey(id);
		if (ObjectUtil.isEmpty(CustomerInfo)) {
			throw new ServiceException("无此客户id");
		}
		return CustomerInfo;
	}

	@Override
	public CustomerInfo findCustomerInfo(CustomerInfo customerInfo) {
		CustomerInfo customerInfoReal = new CustomerInfo();
		Integer id = customerInfo.getId();
		/**
		 * id合法
		 */
		if (!IntegerUtil.isIllegality(id)) {
			customerInfoReal = findCustomerInfo(id);
			if (!ObjectUtil.isEmpty(customerInfoReal)) {
				return customerInfoReal;
			}
		}
		int cardType = customerInfo.getCardTypeId();
		String cardNum = customerInfo.getCardNum();
		/**
		 * cardType||cardNum为空
		 */
		if ((!IntegerUtil.isIllegality(cardType)) && (!StringUtils.isEmpty(cardNum))) {
			customerInfoReal = findCustomerInfo(cardType, cardNum);
			if (!ObjectUtil.isEmpty(customerInfoReal)) {
				return customerInfoReal;
			}
		}

		String customerName = customerInfo.getCustomerName();
		String telephone = customerInfo.getTelephone();
		if ((!StringUtils.isEmpty(customerName)) && (!StringUtils.isEmpty(telephone))) {
			customerInfoReal = findCustomerInfo(customerName, telephone);
			if (!ObjectUtil.isEmpty(customerInfoReal)) {
				return customerInfoReal;
			}

		}
		// TODO
		throw new ServiceException("无法找到客户信息,请重新输入");

	}

	@Override
	public CustomerInfo findCustomerInfo(String customerName, String telephone) {
		CustomerInfoExample customerInfoExample = new CustomerInfoExample();
		customerInfoExample.or().andCustomerNameEqualTo(customerName).andTelephoneEqualTo(telephone);
		List<CustomerInfo> customerInfo = customerInfoMapper.selectByExample(customerInfoExample);
		if (ListUtil.isEmpty(customerInfo)) {
			throw new ServiceException("无此客户信息");
		} else if (ListUtil.count(customerInfo) > 1) {
			throw new ServiceException("存在两个或两个以上客户姓名与电话号码相同状况");
		}
		return customerInfo.get(0);
	}

	@Override
	public CustomerInfo findCustomerInfo(int cardTypeId, String cardNum) {
		CustomerInfoExample customerInfoExample = new CustomerInfoExample();
		customerInfoExample.or().andCardTypeIdEqualTo(cardTypeId).andCardNumEqualTo(cardNum);
		List<CustomerInfo> customerInfo = customerInfoMapper.selectByExample(customerInfoExample);
		if (ListUtil.isEmpty(customerInfo)) {
			throw new ServiceException("无此客户信息");
		} else if (ListUtil.count(customerInfo) > 1) {
			throw new ServiceException("存在两个或两个以上客户信息证件号证件密码一致情况");
		}
		return customerInfo.get(0);
	}

}
