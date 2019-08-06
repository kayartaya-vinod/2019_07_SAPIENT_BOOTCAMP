package com.ps.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ps.dao.DaoException;
import com.ps.dao.DaoFactory;
import com.ps.dao.ProductDao;
import com.ps.entity.Category;

@WebServlet("/category-picture")
public class CategoryPictureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String input = request.getParameter("cat_id");
		Integer categoryId = new Integer(input);
		
		Category c1;
		try {
			ProductDao dao = DaoFactory.getProductDao("hibernate");
			c1 = dao.getCategory(categoryId);
		} catch (DaoException e) {
			throw new ServletException(e);
		}
		
		response.setContentType("image/jpeg");
		ServletOutputStream out = response.getOutputStream();
		out.write(c1.getPicture());
		out.close();
		
		
	}

}
