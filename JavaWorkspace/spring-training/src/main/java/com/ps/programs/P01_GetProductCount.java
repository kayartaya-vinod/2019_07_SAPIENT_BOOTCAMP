package com.ps.programs;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ps.cfg.AppConfig3;
import com.ps.dao.DaoException;
import com.ps.dao.ProductDao;

public class P01_GetProductCount {

	public static void main(String[] args) throws DaoException {

		// a variable representing spring container
		AnnotationConfigApplicationContext ctx;

		// create a new spring container using the AppConfig1 as configuration file
		ctx = new AnnotationConfigApplicationContext(AppConfig3.class);

		ProductDao dao = ctx.getBean("dao", ProductDao.class);
		System.out.println("There are " + dao.count() + " products.");

		// close the spring container when no longer required
		ctx.close();
	}
}
