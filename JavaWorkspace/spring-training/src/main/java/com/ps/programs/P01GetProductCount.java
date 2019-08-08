package com.ps.programs;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ps.cfg.AppConfig1;
import com.ps.dao.DaoException;
import com.ps.dao.ProductDao;

public class P01GetProductCount {
	static Logger logger = Logger.getLogger("P02_AOPDemo");

	public static void main(String[] args) throws DaoException {

		AnnotationConfigApplicationContext ctx;

		ctx = new AnnotationConfigApplicationContext(AppConfig1.class);

		ProductDao dao = ctx.getBean("dao", ProductDao.class);
		logger.log(Level.SEVERE, "There are {0} products", dao.count());

		ctx.close();
	}
}
