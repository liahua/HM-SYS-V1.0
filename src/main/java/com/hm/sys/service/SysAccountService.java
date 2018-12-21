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
	int doDayCheck();
	
	/**
	 * 日明细查询 
	 */

	DayAccount doFindDayAccount(String date);
}
