package com.hm.common.utils;

import java.util.List;







public class ListUtil {

	public static <T> boolean isEmpty(List<T> list) {
		return list.isEmpty()||list==null;
	}

	public static <T> int count(List<T> list) {
		
		return list.size();
	}

}
