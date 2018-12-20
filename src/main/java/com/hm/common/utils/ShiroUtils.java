package com.hm.common.utils;

import org.apache.shiro.SecurityUtils;

import com.hm.sys.entity.SysUsers;

public class ShiroUtils {
	public static SysUsers getUser() {
		return(SysUsers)SecurityUtils
				.getSubject().getPrincipal();
		
	}
}
