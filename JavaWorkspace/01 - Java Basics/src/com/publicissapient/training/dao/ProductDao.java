package com.publicissapient.training.dao;

import com.publicissapient.training.entity.Product;

public interface ProductDao {

	// CRUD OPERATIONS
	public Integer addProduct(Product product) throws DaoException;

	public Product getProduct(Integer productId) throws DaoException;

	public Product updateProduct(Product product) throws DaoException;

	// QUERIES

}
