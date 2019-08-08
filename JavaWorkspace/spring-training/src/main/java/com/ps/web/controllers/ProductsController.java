package com.ps.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ps.dao.DaoException;
import com.ps.dao.ProductDao;

@Controller
public class ProductsController {

	@Autowired
	@Qualifier("hibernateTemplateProductDao")
	ProductDao dao;

	public ProductsController() {
		System.out.println("ProductsController instantiated!");
	}

	@RequestMapping(path = "/get-all-products", method = RequestMethod.GET)
	public String getAllProducts(Model model) throws DaoException {
		model.addAttribute("products", dao.getAllProducts());
		return "/WEB-INF/pages/display-products.jsp";
	}
}
