package com.hm.common.utils;

public class IntegerUtil {

	/**
	 * 
	 * @param integer
	 * @return 参数如果为null || <1 返回true
	 */
	public static boolean isIllegality(Integer integer) {
		return integer == null || integer < 1;

	}

}
