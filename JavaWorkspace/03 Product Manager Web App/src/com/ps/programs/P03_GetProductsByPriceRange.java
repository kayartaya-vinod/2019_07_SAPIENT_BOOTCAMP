package com.ps.programs;

import java.util.Collection;

import com.ps.dao.DaoException;
import com.ps.dao.DaoFactory;
import com.ps.dao.ProductDao;
import com.ps.entity.Product;

public class P03_GetProductsByPriceRange {

	public static void main(String[] args) throws DaoException {
		
		ProductDao dao = DaoFactory.getProductDao("hibernate");
		Collection<Product> list = dao.getProductsByPriceRange(50.0, 250.0);
		
		for(Product p: list) {
			System.out.println(p.getProductName() + " --> " + p.getUnitPrice());
		}
		
	}
}
