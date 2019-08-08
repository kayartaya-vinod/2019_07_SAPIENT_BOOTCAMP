package com.ps.cfg;

import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.ps.entity.Category;
import com.ps.entity.Product;
import com.ps.entity.Supplier;

@EnableWebMvc
@EnableTransactionManagement
@EnableAspectJAutoProxy
@Configuration
@PropertySource({ "classpath:jdbc-info.properties" })
@ComponentScan(basePackages = { "com.ps.dao", "com.ps.aspects", "com.ps.web.controllers" })
public class AppConfig4 {
	
	Logger logger = Logger.getLogger("AppConfig4");
	
	public AppConfig4() {
		logger.info("AppConfig4 instantiated!");
	}
	
	@Bean
	public HibernateTransactionManager txMgr(SessionFactory sf) {
		return new HibernateTransactionManager(sf);
	}

	@Bean
	public HibernateTemplate ht(SessionFactory sf) {
		return new HibernateTemplate(sf);
	}

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

	// This bean can produce an instanceof SessionFactory
	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource ds) {
		LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
		lsfb.setDataSource(ds);

		Properties props = new Properties();
		props.setProperty("hibernate.show_sql", "false");
		props.setProperty("hibernate.format_sql", "true");
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		lsfb.setHibernateProperties(props);

		lsfb.setAnnotatedClasses(Product.class, Category.class, Supplier.class);

		return lsfb;
	}

}
