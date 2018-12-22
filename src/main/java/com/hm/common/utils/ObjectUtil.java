package com.hm.common.utils;


public class ObjectUtil {

	public static boolean isEmpty(Object...objects) {
		for (Object object : objects) {
			if(object==null) {
				return true;
			}
		}
		return false;
	}

}
