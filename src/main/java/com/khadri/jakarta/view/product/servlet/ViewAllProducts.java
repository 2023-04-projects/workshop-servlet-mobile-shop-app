package com.khadri.jakarta.view.product.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.khadri.jakarta.product.dao.ProductDao;
import com.khadri.jakarta.product.form.ProductForm;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ViewAllProducts extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ProductDao dao;
	private List<ProductForm> listOfForms;

	public void init() throws ServletException {
		dao = new ProductDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("Entered into ProductViewProductServlet dopost(-,-)");

		String productId = req.getParameter("getId()");
		PrintWriter pw = resp.getWriter();
		if (productId == null || productId.isEmpty()) {
			listOfForms = dao.selectProductData();
			StringBuffer sb = new StringBuffer();
			sb.append("<table border='1'>");
			sb.append("<thead>");
			sb.append("<tr>");
			sb.append("<th>ProductId</th>");
			sb.append("<th>ProductName</th>");
			sb.append("</tr>");
			sb.append("</thead>");
			sb.append("<tbody>");
			sb.append("<tbody>");
			listOfForms.stream().forEach(eachProduct -> {
				sb.append("<tr>");
				sb.append("<td><a href='modify.html' target='bottom_right'> " + eachProduct.getId() + "</a></td>");
				sb.append("<td>" + eachProduct.getName() + "</td>");
				sb.append("</tr>");
			});
			sb.append("</tbody>");
			pw.println(sb);

		}

	}
}
