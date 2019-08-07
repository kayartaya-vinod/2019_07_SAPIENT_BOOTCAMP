package com.ps.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ps.entity.Product;
import com.ps.utils.HibernateUtil;

public class P01_GetOneProduct {

	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession(); // creates a new instanceof Session 
		// a session represents a DB connection; must be closed ASAP
		
		Product p1 = session.get(Product.class, 9); // 9--> Product_id
		
		session.close();
		factory.close();
		
		System.out.println(p1);
	}
	
}
