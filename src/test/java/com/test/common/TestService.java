package com.test.common;

import org.junit.Test;

import com.hm.sys.service.impl.SysAccountServiceImpl;

public class TestService extends TestBase{
	
	@Test
	public void doTestService() {
		SysAccountServiceImpl ac = ctx.getBean(SysAccountServiceImpl.class);
		for(int i =1 ;i<=31;i++) {
			ac.doDayCheck("2018-12-"+i);
		}
	}
}
