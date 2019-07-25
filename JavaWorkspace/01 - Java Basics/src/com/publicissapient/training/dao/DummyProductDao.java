package com.publicissapient.training.dao;

import com.publicissapient.training.entity.Product;

public class DummyProductDao implements ProductDao {

	@Override
	public Integer addProduct(Product product) throws DaoException {
		System.out.println("DummyProductDao.addProduct() called");
		return null;
	}

	@Override
	public Product getProduct(Integer productId) throws DaoException {
		System.out.println("DummyProductDao.getProduct() called");
		return null;
	}

	@Override
	public Product updateProduct(Product product) throws DaoException {
		System.out.println("DummyProductDao.updateProduct() called");
		return null;
	}

}
