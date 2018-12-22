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
	DayAccount doDayCheck(String date);
	
}
