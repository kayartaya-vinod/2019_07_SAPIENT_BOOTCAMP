package com.publicissapient.training.dao;

import com.publicissapient.training.entity.Product;

public class CsvProductDao implements ProductDao {

	@Override
	public Integer addProduct(Product product) throws DaoException {
		System.out.println("CsvProductDao.addProduct() called");
		return null;
	}

	@Override
	public Product getProduct(Integer productId) throws DaoException {
		System.out.println("CsvProductDao.getProduct() called");
		return null;
	}

	@Override
	public Product updateProduct(Product product) throws DaoException {
		System.out.println("CsvProductDao.updateProduct() called");
		return null;
	}

}
