package com.ps.dao.tests;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;

import com.ps.cfg.AppConfig4;
import com.ps.dao.DaoException;
import com.ps.dao.HibernateTemplateProductDao;
import com.ps.entity.Product;

@ContextConfiguration(classes = AppConfig4.class) 
public class HibernateTemplateProductDaoTests {

	@Autowired
	@Qualifier("hibernateTemplateProductDao")
	HibernateTemplateProductDao dao;

	@Test
	public void testGetAllProduccts() throws DaoException {
		Collection<Product> list = dao.getAllProducts();
		Assert.assertEquals(77, list.size());
	}
}
