package com.hm.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.common.exception.ServiceException;
import com.hm.common.vo.CommonPageObject;
import com.hm.common.vo.CustomerAllInfo;
import com.hm.sys.dao.CommonDao;
import com.hm.sys.entity.CustomerInfo;
import com.hm.sys.entity.CustomerInfoExample;
import com.hm.sys.entity.CustomerTypeExample;
import com.hm.sys.service.SysCommonService;
/**
 * 
 * 叶云彤
 * @author tarena
 *
 */
@Service
public class SysCommonServiceImpl implements SysCommonService {

	@Autowired
	private CommonDao commonDao;
	
	@Override
	public List<CustomerInfo> selectByExample(CustomerTypeExample example) {
		
		return commonDao.selectByExample(new CustomerInfoExample());
	}

	@Override
	public CommonPageObject<CustomerAllInfo> findPageObjects(String name, Integer pageCurrent) {
		// 1.验证参数合法性
				// 1.1验证pageCurrent的合法性，
				// 不合法抛出IllegalArgumentException异常
				if (pageCurrent == null || pageCurrent < 1)
					throw new IllegalArgumentException("当前页码不正确");
				// 2.基于条件查询总记录数
				// 2.1) 执行查询
				int rowCount = commonDao.getRowCount(name);
				// 2.2) 验证查询结果，假如结果为0不再执行如下操作
				if (rowCount == 0)
					throw new ServiceException("记录不存在");
				// 3.基于条件查询当前页记录(pageSize定义为2)
				// 3.1)定义pageSize
				int pageSize = 3;
				// 3.2)计算startIndex
				int startIndex = (pageCurrent - 1) * pageSize;
				// 3.3)执行当前数据的查询操作
				List<CustomerAllInfo> records =commonDao.findPageObjects(name, startIndex, pageSize);
				// 4.对分页信息以及当前页记录进行封装
				// 4.1)构建PageObject对象
				CommonPageObject<CustomerAllInfo> pageObject = new CommonPageObject<>();
				// 4.2)封装数据
				pageObject.setPageCurrent(pageCurrent);
				pageObject.setPageSize(pageSize);
				pageObject.setRowCount(rowCount);
				pageObject.setRecords(records);
				
				int pageCount=(rowCount-1)/pageSize+1;
				pageObject.setPageCount(pageCount);
				
				// 5.返回封装结果。
				return pageObject;

	}



	}

