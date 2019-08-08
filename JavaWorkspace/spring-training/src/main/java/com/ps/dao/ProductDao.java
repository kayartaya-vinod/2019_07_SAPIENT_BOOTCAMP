package com.ps.dao;

import java.util.Collection;

import org.springframework.transaction.annotation.Transactional;

import com.ps.entity.Product;

public interface ProductDao {
	@Transactional(readOnly = false)
	public default Integer addNewProduct(Product product) throws DaoException {
		throw new DaoException("Not implemented!");
	}

	public default Product getProduct(Integer productId) throws DaoException {
		throw new DaoException("Not implemented!");
	}

	@Transactional(readOnly = false)
	public default void updateProduct(Product product) throws DaoException {
		throw new DaoException("Not implemented!");
	}

	@Transactional(readOnly = false)
	public default Product deleteProduct(Integer productId) throws DaoException {
		throw new DaoException("Not implemented!");
	}

	public int count() throws DaoException;

	public default Collection<Product> getAllProducts() throws DaoException {
		throw new DaoException("Not implemented!");
	}

	public default Collection<Product> getProductsByPriceRange(Double min, Double max) throws DaoException {
		throw new DaoException("Not implemented!");
	}

	public default Collection<Product> getProductsNotInStock()  throws DaoException {
		throw new DaoException("Not implemented!");
	}
}
