package com.khadri.jakarta.modify.product.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.khadri.jakarta.product.dao.ProductDao;
import com.khadri.jakarta.product.form.ProductForm;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProductModifySearchPageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ProductDao dao;
	private List<ProductForm> listOfForms;

	@Override
	public void init() throws ServletException {
		dao = new ProductDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//RequestDispatcher requestDispatcher = req.getRequestDispatcher("/ProductModifyServlet");
		//requestDispatcher.forward(req, resp);   
		System.out.println("Entered into ProductModifySearchPageServlet dopost(-,-)");
		String productId = req.getParameter("Id");
		PrintWriter pw = resp.getWriter();
		if (productId == null || productId.isEmpty()) {
			StringBuffer sb = new StringBuffer();
			sb.append("<html><body><table><thead><h2>Search Product</h2></thead>");
			sb.append("<form action = 'productmodify' method = 'get'");
			sb.append("<tbody><tr><td>ProductId :<input type= 'text' name ='Id'><td/></tr>");
			sb.append("<tr><td><input type='submit' value='search'></td></tr>");
			sb.append("<table border='1'>");
			sb.append("<thead>");
			sb.append("<tr>");
			sb.append("<th>ProductId</th>");
			sb.append("<th>ProductName</th>");
			sb.append("</tr>");
			sb.append("</thead>");
			sb.append("<tbody>");
			sb.append("<tbody>");
			pw.println(sb);

		} else {
			StringBuffer sb = new StringBuffer();
			listOfForms = dao.viewProductData(productId);
			sb.append("<html><body><table><thead><h2>Search Product</h2></thead>");
			sb.append("<form action = 'modifyForm' method = 'get'");
			sb.append("<tbody><tr><td>ProductId :<input type= 'text' name ='Id'><td/></tr>");
			sb.append("<tr><td><input type='submit' value='search'></td></tr>");

			sb.append("<table border='1'>");
			sb.append("<thead>");
			sb.append("<tr>");
			sb.append("<th>ProductId</th>");
			sb.append("<th>ProductName</th>");
			sb.append("</tr>");
			sb.append("</thead>");
			sb.append("<tbody>");
			listOfForms.stream().forEach(eachProduct -> {
				sb.append("<tr>");
				sb.append("<td><a href='modify.html' target='bottom_right'> " + eachProduct.getId()
						+ "</a></td>");
				sb.append("<td>" + eachProduct.getName() + "</td>");
				sb.append("</tr>");
			});
			sb.append("</tbody>");
			sb.append("</table>");
			pw.println(sb);
		}
	}
}
