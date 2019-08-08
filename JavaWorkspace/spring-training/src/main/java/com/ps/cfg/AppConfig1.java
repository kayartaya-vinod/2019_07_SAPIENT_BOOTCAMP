package com.ps.cfg;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

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
	
	public AppConfig1() {
		System.out.println("AppConfig1 instantiated!");
	}

	@Scope("singleton")
	@Bean(name="dao")
	public ProductDao jdbcDao() {
		System.out.println("AppConfig1.jdbcDao() called");
		return new JdbcProductDao(driver, url, user, password);
	}

	@Scope("prototype")
	@Bean
	public ProductDao dummyDao() {
		
		System.out.println("Inside the AppConfig1.dummyDao() 'this.getClass().getName()' is " + this.getClass().getName());
		for(int i=1; i<=5; i++) {
			System.out.println("Inside the loop, i is " + i);
			this.jdbcDao();
		}
		
		System.out.println("AppConfig1.dummyDao() called");
		return new DummyProductDao();
	}
}
