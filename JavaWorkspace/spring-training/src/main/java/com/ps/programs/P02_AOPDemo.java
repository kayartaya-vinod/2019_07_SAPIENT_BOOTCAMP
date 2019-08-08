package com.ps.programs;

import java.util.Collection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ps.cfg.AppConfig4;
import com.ps.dao.DaoException;
import com.ps.dao.ProductDao;
import com.ps.entity.Product;

public class P02_AOPDemo {

	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig4.class);
		ProductDao dao = ctx.getBean("hibernateTemplateProductDao", ProductDao.class);

		System.out.println("dao is an instanceof " + dao.getClass().getName());

		int pc = dao.count();
		System.out.println("There are " + pc + " products.");

		try {
			Product p = dao.getProduct(2);
			System.out.println("p.name = " + p.getProductName());
			System.out.println("p.price = $" + p.getUnitPrice());
			
			p.setUnitPrice(p.getUnitPrice() + 1);
			
			dao.updateProduct(p);
			
			p = dao.getProduct(2);
			System.out.println("After updating the price...");
			System.out.println("p.name = " + p.getProductName());
			System.out.println("p.price = $" + p.getUnitPrice());
			
			
		} catch (DaoException e) {
			e.printStackTrace();
		}

		Collection<Product> list = dao.getProductsByPriceRange(50.0, 250.0);
		System.out.println("There are " + list.size() + " products between $50 and $250.");

		list = dao.getProductsByPriceRange(250.0, 50.0);
		System.out.println("There are " + list.size() + " products between $250 and $50.");

		list = dao.getProductsNotInStock();
		System.out.println(list.size() + " products are not in stock");

		ctx.close();

	}
}
