package com.ps.dao;

import java.util.Collection;

import com.ps.entity.Category;
import com.ps.entity.Product;

public interface ProductDao {

	// CRUD operations

	public Integer addNewProduct(Product product) throws DaoException;

	public Product getProduct(Integer productId) throws DaoException;

	public void updateProduct(Product product) throws DaoException;

	public Product deleteProduct(Integer productId) throws DaoException;
	
	// ideally this should be in CategoryDao interface (but ... an exception)
	public default Category getCategory(Integer categoryId) throws DaoException  {
		throw new DaoException("Method not implemented yet!");
	}

	// Queries

	public Collection<Product> getAllProducts() throws DaoException;

	public Collection<Product> getProductsNotInStock() throws DaoException;

	public Collection<Product> getDiscontinuedProducts() throws DaoException;

	public Collection<Product> getProductsByPriceRange(Double min, Double max) throws DaoException;

	public Collection<Product> getProductsByName(String namePattern) throws DaoException;

	public Integer count() throws DaoException;

}