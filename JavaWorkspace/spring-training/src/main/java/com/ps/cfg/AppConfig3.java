package com.ps.cfg;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource({ "classpath:jdbc-info.properties" })
@ComponentScan(basePackages = { "com.ps.dao" })
// ComponentScan --> scans in the given package and subpackage folders
// for classes that are annotated as @Component/@Repository/@Controller/@Service/@Configuration
// and instatiates using the no-arg constructor and loads them into the spring container
// as beans.
public class AppConfig3 {

	@Value("${jdbc.driver_class_name}")
	private String driver;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username}")
	private String username;
	@Value("${jdbc.password}")
	private String password;

	// bean representing a connection pool
	@Bean
	public DataSource dataSource() {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName(driver);
		bds.setUrl(url);
		bds.setUsername(username);
		bds.setPassword(password);
		bds.setInitialSize(5);
		bds.setMaxTotal(100);
		bds.setMaxIdle(10);
		bds.setMaxWaitMillis(50);
		return bds;
	}

}
