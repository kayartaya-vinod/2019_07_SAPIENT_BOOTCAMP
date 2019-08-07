package com.ps.cfg;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.ps.dao.DummyProductDao;
import com.ps.dao.JdbcProductDao;
import com.ps.dao.ProductDao;

// This is a configuration file (a substitute for earlier XML configuration file)
// This class defines beans (object) that are loaded into the spring container.
// A bean is defined using a function returning the bean, and annotated as @Bean
@Configuration
@PropertySource({ "classpath:jdbc-info.properties" })
public class AppConfig1 {

	@Value("${jdbc.driver_class_name}")
	private String driver;
	
	@Value("${jdbc.url}")
	private String url;
	
	@Value("${jdbc.username}")
	private String user;
	
	@Value("${jdbc.password}")
	private String password;

	@Bean(name="dao")
	public ProductDao jdbcDao() {
		return new JdbcProductDao(driver, url, user, password);
	}

	@Bean
	public ProductDao dummyDao() {
		return new DummyProductDao();
	}
}
