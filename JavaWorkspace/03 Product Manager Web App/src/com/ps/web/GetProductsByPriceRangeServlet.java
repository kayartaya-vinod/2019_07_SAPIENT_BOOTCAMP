package com.ps.web;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ps.dao.DaoException;
import com.ps.dao.DaoFactory;
import com.ps.dao.ProductDao;
import com.ps.entity.Product;

@WebServlet("/get-products-by-price-range")
public class GetProductsByPriceRangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			// Responsibilities of a controller servlet
			// 1. Read the input from the request (if any)
			String input = request.getParameter("min_price");
			Double min = new Double(input);
			input = request.getParameter("max_price");
			Double max = new Double(input);
			
			// 2. Get the model data from service/dao
			ProductDao dao = DaoFactory.getProductDao("hibernate");
			Collection<Product> list = dao.getProductsByPriceRange(min, max);
			
			// 3. Store the model data in a place (scope) accessible to the view
			// There are 3 scopes for servlet - request, session, application
			request.setAttribute("products", list);
			request.setAttribute("title", String.format("List of products priced between $%.1f and $%.1f", min, max));
			
			// 4. forward the request/response to the view (JSP)
			String viewName = "/WEB-INF/pages/display-products.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(viewName);
			rd.forward(request, response);
		} catch (DaoException | NumberFormatException e) {
			// report the error to the user in a user-friendly manner
			throw new ServletException(e);
		}
		
	}

}




