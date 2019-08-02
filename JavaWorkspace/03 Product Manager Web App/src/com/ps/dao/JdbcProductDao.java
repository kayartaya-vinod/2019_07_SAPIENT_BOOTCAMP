package com.ps.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.ps.entity.Product;
import com.ps.utils.DbUtil;

public class JdbcProductDao implements ProductDao {

	@Override
	public Integer addNewProduct(Product product) throws DaoException {

		return null;
	}

	@Override
	public Product getProduct(Integer productId) throws DaoException {

		return null;
	}

	@Override
	public void updateProduct(Product product) throws DaoException {

	}

	@Override
	public Product deleteProduct(Integer productId) throws DaoException {

		return null;
	}

	@Override
	public Collection<Product> getAllProducts() throws DaoException {
		Collection<Product> products = new ArrayList<>();

		String sql = "select * from products";
		try (Connection conn = DbUtil.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();) {
			while (rs.next()) {
				Product p = toProduct(rs);
				products.add(p);
			}
		} catch (Exception ex) {
			throw new DaoException(ex); // exception funneling
		}

		return products;
	}

	private Product toProduct(ResultSet rs) throws SQLException {
		Product p = new Product();
		p.setProductId(rs.getInt("PRODUCT_ID"));
		p.setProductName(rs.getString("PRODUCT_NAME"));
		p.setQuantityPerUnit(rs.getString("QUANTITY_PER_UNIT"));
		p.setUnitPrice(rs.getDouble("UNIT_PRICE"));
		p.setUnitsOnOrder(rs.getInt("UNITS_ON_ORDER"));
		p.setUnitsInStock(rs.getInt("UNITS_IN_STOCK"));
		p.setDiscontinued(rs.getInt("DISCONTINUED") == 1 ? true : false);
		p.setReorderLevel(rs.getInt("REORDER_LEVEL"));
		return p;
	}

	@Override
	public Collection<Product> getProductsNotInStock() throws DaoException {
		Collection<Product> products = new ArrayList<>();

		String sql = "select * from products where units_in_stock=0";
		try (Connection conn = DbUtil.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();) {
			while (rs.next()) {
				Product p = toProduct(rs);
				products.add(p);
			}
		} catch (Exception ex) {
			throw new DaoException(ex); // exception funneling
		}

		return products;
	}

	@Override
	public Collection<Product> getDiscontinuedProducts() throws DaoException {
		Collection<Product> products = new ArrayList<>();

		String sql = "select * from products where discontinued=1";
		try (Connection conn = DbUtil.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();) {
			while (rs.next()) {
				Product p = toProduct(rs);
				products.add(p);
			}
		} catch (Exception ex) {
			throw new DaoException(ex); // exception funneling
		}

		return products;
	}

	@Override
	public Collection<Product> getProductsByPriceRange(Double min, Double max) throws DaoException {

		return null;
	}

	@Override
	public Collection<Product> getProductsByName(String namePattern) throws DaoException {

		return null;
	}

	@Override
	public Integer count() {

		return null;
	}

}
