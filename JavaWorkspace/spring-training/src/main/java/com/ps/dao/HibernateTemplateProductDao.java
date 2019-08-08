package com.ps.dao;

import java.util.Collection;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ps.entity.Product;

@SuppressWarnings({ "deprecation", "unchecked" })
@Repository
public class HibernateTemplateProductDao implements ProductDao {
	
	@Autowired
	HibernateTemplate template;

	@Override
	public Integer addNewProduct(Product product) throws DaoException {
		template.persist(product);
		return product.getProductId();
	}

	@Override
	public Product getProduct(Integer productId) throws DaoException {
		return template.get(Product.class, productId);
	}

	@Override
	public void updateProduct(Product product) throws DaoException {
		template.merge(product);
	}

	@Override
	public Product deleteProduct(Integer productId) throws DaoException {
		Product p = this.getProduct(productId);
		template.delete(p);
		return p;
	}

	
	@Override
	public Collection<Product> getAllProducts() throws DaoException {
		// SQL --> select * from products
		// HQL --> from Product
		return (Collection<Product>) template.find("from Product");
	}
	
	@Override
	public Collection<Product> getProductsByPriceRange(Double min, Double max) throws DaoException {
		return (Collection<Product>) template.find("from Product where unitPrice between ?0 and ?1", min, max);
	}
	
	@Override
	public Collection<Product> getProductsNotInStock() throws DaoException {
		DetachedCriteria dc = DetachedCriteria.forClass(Product.class);
		dc.add(Restrictions.eq("unitsInStock", 0));
		return (Collection<Product>) template.findByCriteria(dc);
	}
	@Override
	public int count() throws DaoException {
		DetachedCriteria dc = DetachedCriteria.forClass(Product.class);
		dc.setProjection(Projections.rowCount());
		return ((Long)template.findByCriteria(dc).get(0)).intValue();
	}

}







