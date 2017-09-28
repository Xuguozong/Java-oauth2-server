package com.fu.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;

import com.github.pagehelper.PageHelper;

/**
 * 
 * @ClassName: MybatisConfiguation
 * @Description: mabatis的初始配置类
 * @author 041897
 * @date 2017年9月28日下午3:43:05
 */
@Configuration
@MapperScan(basePackages = "com.fu.dao")
public class MybatisConfiguation {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private ResourceLoader resourceLoader;

	// 分页插件
	@Bean
	public Interceptor pageHelper() {
		// 分页插件
		PageHelper pageHelper = new PageHelper();
		Properties properties = new Properties();
		properties.setProperty("reasonable", "false");
		properties.setProperty("supportMethodsArguments", "true");
		properties.setProperty("returnPageInfo", "check");
		properties.setProperty("params", "count=countSql");
		pageHelper.setProperties(properties);
		return pageHelper;
	}

	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() throws IOException {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource);
		sqlSessionFactory.setTypeAliasesPackage("com.fu.entity");

		sqlSessionFactory.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
		sqlSessionFactory.setMapperLocations(ResourcePatternUtils.getResourcePatternResolver(resourceLoader)
				.getResources("classpath:com/fu/mappers/*.xml"));
		Interceptor[] interceptors = new Interceptor[1];
		interceptors[0] = pageHelper();
		sqlSessionFactory.setPlugins(interceptors);
		return sqlSessionFactory;
	}
}
