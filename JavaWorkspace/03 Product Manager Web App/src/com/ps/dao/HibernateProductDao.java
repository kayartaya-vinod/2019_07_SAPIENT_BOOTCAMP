package com.ps.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ps.entity.Category;
import com.ps.entity.Product;
import com.ps.utils.HibernateUtil;

public class HibernateProductDao implements ProductDao {
	SessionFactory factory = HibernateUtil.getSessionFactory();

	@Override
	public Integer addNewProduct(Product product) throws DaoException {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			session.persist(product);
			tx.commit();
			return product.getProductId();
		} catch (Exception e) {
			tx.rollback();
			throw new DaoException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Product getProduct(Integer productId) throws DaoException {
		Session session = factory.openSession();
		Product p1 = session.get(Product.class, productId);
		session.close();
		return p1;
	}

	@Override
	public void updateProduct(Product product) throws DaoException {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.merge(product);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			throw new DaoException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Product deleteProduct(Integer productId) throws DaoException {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Product product = this.getProduct(productId);
			if (product == null) {
				throw new DaoException("Invalid product id: " + productId);
			}
			session.delete(product);
			tx.commit();
			return product;
		} catch (HibernateException e) {
			tx.rollback();
			throw new DaoException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public Category getCategory(Integer categoryId) throws DaoException {
		try(Session session = factory.openSession()) {
			return session.get(Category.class, categoryId);
		}
		catch(Exception ex) {
			throw new DaoException(ex);
		}
	}

	@Override
	public Collection<Product> getAllProducts() throws DaoException {
		try (Session session = factory.openSession();) {
			Query<Product> qry = session.createQuery("from Product", Product.class);
			List<Product> list = qry.getResultList();
			return list;
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public Collection<Product> getProductsNotInStock() throws DaoException {
		try (Session session = factory.openSession();) {
			Query<Product> qry = session.createQuery("from Product where unitsInStock=0", Product.class);
			List<Product> list = qry.getResultList();
			return list;
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public Collection<Product> getDiscontinuedProducts() throws DaoException {
		try (Session session = factory.openSession();) {
			Query<Product> qry = session.createQuery("from Product where discontinued=true", Product.class);
			List<Product> list = qry.getResultList();
			return list;
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public Collection<Product> getProductsByPriceRange(Double min, Double max) throws DaoException {
		try (Session session = factory.openSession();) {
			Query<Product> qry = session.createQuery("from Product where unitPrice between :MIN and :MAX",
					Product.class);
			qry.setParameter("MIN", min);
			qry.setParameter("MAX", max);
			List<Product> list = qry.getResultList();
			return list;
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public Collection<Product> getProductsByName(String namePattern) throws DaoException {
		try (Session session = factory.openSession();) {
			Query<Product> qry = session.createQuery("from Product where productName like ?", Product.class);
			qry.setParameter(0, "%" + namePattern + "%");
			List<Product> list = qry.getResultList();
			return list;

		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Integer count() throws DaoException {
		try (Session session = factory.openSession();) {
			Query qry = session.createQuery("select count(p) from Product p");
			Object count = qry.uniqueResult();
			return new Integer(count.toString());
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

}

