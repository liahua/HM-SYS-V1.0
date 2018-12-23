package com.test.common;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.junit.Test;

import com.hm.sys.dao.AccountInfoMapper;
import com.hm.sys.entity.AccountInfo;
import com.hm.sys.entity.AccountInfoExample;
import com.hm.sys.entity.AccountInfoExample.Criteria;
import com.hm.sys.service.impl.SysAccountServiceImpl;

public class TestService extends TestBase{
	
	@Test
	public void doTestService() {
		SysAccountServiceImpl ac = ctx.getBean(SysAccountServiceImpl.class);
		for(int i =1 ;i<=31;i++) {
			ac.doDayCheck("2018-12-"+i);
		}
	}
	
	@Test
	public void doTestTable() {
		AccountInfoMapper bean = ctx.getBean(AccountInfoMapper.class);
		
		AccountInfoExample aie = new AccountInfoExample();
		Criteria cc = aie.createCriteria();
		cc.andDayBetween(start(), end());
		
		List<AccountInfo> list = bean.selectByExample(aie);
		
		System.out.println(list.size());
		for(AccountInfo a : list) {
			AccountInfoExample aie1 = new AccountInfoExample();
			Criteria cc1 = aie1.createCriteria();
			cc1.andIdEqualTo(a.getId());
			
			AccountInfo ai = new AccountInfo();
			ai.setId(a.getId());
			ai.setDay(a.getDay());
			ai.setManCount(a.getManCount());
			ai.setOrderCount(new Random().nextInt(100));
			ai.setOrderMoney(BigDecimal.valueOf(10000*new Random().nextDouble()).setScale(2,BigDecimal.ROUND_HALF_DOWN).doubleValue());
			ai.setCashCount(BigDecimal.valueOf(10000*new Random().nextDouble()).setScale(2,BigDecimal.ROUND_HALF_DOWN).doubleValue());
			ai.setCheckinCount(BigDecimal.valueOf(10000*new Random().nextDouble()).setScale(2,BigDecimal.ROUND_HALF_DOWN).doubleValue());
			
			bean.updateByExample(ai, aie1);
		}
		
	}

	private Date end() {
		Calendar c = Calendar.getInstance(Locale.CHINA);
		c.set(Calendar.YEAR,2018);
		c.set(Calendar.MONTH,11);
		c.set(Calendar.DAY_OF_MONTH,30);
		System.out.println(c.getTime());
		return c.getTime();
	}

	private Date start() {
		Calendar c = Calendar.getInstance(Locale.CHINA);
		c.set(Calendar.YEAR,2018);
		c.set(Calendar.MONTH,11);
		c.set(Calendar.DAY_OF_MONTH,20);
		System.out.println(c.getTime());
		return c.getTime();
	}
}
