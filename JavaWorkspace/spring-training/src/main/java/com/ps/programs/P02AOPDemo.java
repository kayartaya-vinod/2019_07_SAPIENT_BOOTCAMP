package com.ps.programs;

import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ps.cfg.AppConfig4;
import com.ps.dao.DaoException;
import com.ps.dao.ProductDao;
import com.ps.entity.Product;

public class P02AOPDemo {

	static Logger logger = Logger.getLogger("P02_AOPDemo");

	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig4.class);
		ProductDao dao = ctx.getBean("hibernateTemplateProductDao", ProductDao.class);

		logger.log(Level.SEVERE, "dao is an instanceof {0}", dao.getClass().getName());

		int pc = dao.count();
		logger.log(Level.SEVERE, "There are {0} products.", pc);

		try {
			Product p = dao.getProduct(2);
			if (p != null) {
				logger.log(Level.SEVERE, "p.name = {0}", p.getProductName());
				logger.log(Level.SEVERE, "p.price = ${0}", p.getUnitPrice());

				p.setUnitPrice(p.getUnitPrice() + 1);

				dao.updateProduct(p);

				p = dao.getProduct(2);
				logger.log(Level.SEVERE, "After updating the price...");
				logger.log(Level.SEVERE, "p.name = {0}", p.getProductName());
				logger.log(Level.SEVERE, "p.price = ${0}", p.getUnitPrice());

			}
		} catch (DaoException e) {
			logger.log(Level.SEVERE, "There was an error! {0}", e.getMessage());
		}

		Collection<Product> list = dao.getProductsByPriceRange(50.0, 250.0);
		if (list != null) {
			logger.log(Level.SEVERE, "There are {0} products between $50 and $250.", list.size());
		}

		list = dao.getProductsByPriceRange(250.0, 50.0);
		if (list != null) {
			logger.log(Level.INFO, "There are {0} products between $250 and $50.", list.size());

		}

		list = dao.getProductsNotInStock();
		if (list != null) {
			logger.log(Level.SEVERE, "{0} products are not in stock", list.size());
		}

		ctx.close();

	}
}
