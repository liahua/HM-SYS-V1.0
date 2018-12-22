package com.hm.sys.service;

import com.hm.common.vo.DayAccount;

/**
 * 
 * @author 邹文豪
 *
 */
public interface SysAccountService {
	/**
	 * 日明细统计
	 */
	int doDayCheck(String date);
	
	/**
	 *  查询
	 */
	DayAccount doFindDayAccounts(String start,String end);
	
}
