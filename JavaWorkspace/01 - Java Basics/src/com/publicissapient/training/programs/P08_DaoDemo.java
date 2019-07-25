package com.publicissapient.training.programs;

import com.publicissapient.training.dao.DaoException;
import com.publicissapient.training.dao.DaoFactory;
import com.publicissapient.training.dao.ProductDao;

public class P08_DaoDemo {

	public static void main(String[] args) throws DaoException {
		
		ProductDao dao;
		dao = DaoFactory.getProductDao("csv");
		
		dao.getProduct(12);
		
	}
}
