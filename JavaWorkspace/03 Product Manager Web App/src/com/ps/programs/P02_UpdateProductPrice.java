package com.ps.programs;

import com.ps.dao.DaoException;
import com.ps.dao.DaoFactory;
import com.ps.dao.ProductDao;
import com.ps.entity.Product;

public class P02_UpdateProductPrice {

	public static void main(String[] args) throws DaoException {
		
		ProductDao dao = DaoFactory.getProductDao("hibernate");
		Product p1 = dao.getProduct(1);
		System.out.println(p1);
		p1.setUnitPrice(p1.getUnitPrice() + 1);
		dao.updateProduct(p1);

		Product p2 = dao.getProduct(1);
		System.out.println(p2);
		
	}
}
