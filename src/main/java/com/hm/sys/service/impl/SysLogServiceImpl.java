package com.hm.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.common.exception.ServiceException;
import com.hm.common.utils.IntegerUtil;
import com.hm.common.vo.PageObject;
import com.hm.sys.dao.SysLogsDao;
import com.hm.sys.entity.SysLogs;
import com.hm.sys.service.SysLogService;
@Service
public class SysLogServiceImpl implements SysLogService {
	@Autowired
	private SysLogsDao sysLogsDao; 
	@Override
	public PageObject<SysLogs> getObjects(String username, Integer pageCurrent) {
		if(IntegerUtil.isIllegality(pageCurrent))
			throw new IllegalArgumentException("当前页码出错,请刷新");
		int rowCount = sysLogsDao.getRowCount(username);
		if(rowCount==0)
			throw new ServiceException("没有相关信息,请重新输入查询");

		int pageSize = 3;
		int startIndex=(pageCurrent-1)*pageSize;
		//执行操作
		List<SysLogs> objects = sysLogsDao.getObjects(username, startIndex, pageSize);
		//构建pageObject对象
		PageObject<SysLogs> pageObject=new PageObject<>();
		pageObject.setPageCount((rowCount-1)/pageSize+1);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setPageSize(pageSize);
		pageObject.setRecords(objects);
		pageObject.setRowCount(rowCount);


		return pageObject;
	}

	@Override
	public int deleteObjects(Integer... ids) {
		if(ids==null||ids.length<0)
			throw new IllegalArgumentException("请选择需要删除的数据");
		System.out.println(ids.toString());
		int rows;
		try {			
			rows = sysLogsDao.deleteObjects(ids);
		} catch (Throwable e) {
			e.printStackTrace();
			throw new ServiceException("系统故障");
		}
		if(rows==0)
			throw new ServiceException("该数据可能已经不存在了");
		
		return rows;
	}



}
