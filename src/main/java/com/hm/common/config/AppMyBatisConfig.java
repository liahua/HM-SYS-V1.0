package com.hm.common.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.github.pagehelper.PageHelper;

/**
 * mybatis整合配置
 * 
 * @author lord Dec 12, 2018-6:45:46 PM
 */
@Configuration
@MapperScan(basePackages = "com.hm.**.dao")
public class AppMyBatisConfig {
	@Bean("sqlSessionFactory")
	public SqlSessionFactoryBean newSqlSessionFactoryBean(@Autowired DataSource dataSource) throws IOException {
		SqlSessionFactoryBean fBean = new SqlSessionFactoryBean();

		// configuration配置驼峰规则
		org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
		configuration.setMapUnderscoreToCamelCase(true);

		// configuration配置分页查询插件
		PageHelper pageHelper = new PageHelper();
		Properties prop = new Properties();
		prop.setProperty("dialect", "mysql");
		pageHelper.setProperties(prop);
		configuration.addInterceptor(pageHelper);

		// 导入configuration
		fBean.setConfiguration(configuration);
		// 导入数据源
		fBean.setDataSource(dataSource);
		// 关联映射文件
		Resource[] mapperLocations = new PathMatchingResourcePatternResolver()
				.getResources("classpath:mapper/sys/*.xml");
		// 导入映射文件
		fBean.setMapperLocations(mapperLocations);
		return fBean;
	}
}
