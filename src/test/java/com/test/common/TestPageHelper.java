package com.test.common;

import org.junit.Test;


public class TestPageHelper extends TestBase{
	@Test
	public void testPageHelper() {
		
		/*
		// 从spring容器中获取mapper代理对象
		TbItemMapper mapper = ctx.getBean(TbItemMapper.class);
		// 执行查询并分页,TbItemExample是逆向工程自动生成的，用来进行条件查询，这里不设置则表示无条件
		TbItemExample example = new TbItemExample();
		// 分页处理，显示第一页的10条数据
		 * 
		PageHelper.startPage(1, 10);
		
		
		
		
		List<TbItem> list = mapper.selectByExample(example);// 查询
		// 取商品列表
		for (TbItem item : list) {
			System.out.println(item.getTitle());
		}
		// 取分页信息
		PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
		long total = pageInfo.getTotal(); // 获取总记录数
		System.out.println("共有商品信息：" + total);*/
	}
}
