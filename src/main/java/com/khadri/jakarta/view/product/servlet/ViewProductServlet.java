package com.khadri.jakarta.view.product.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.khadri.jakarta.product.dao.ProductDao;
import com.khadri.jakarta.product.form.ProductForm;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ViewProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ProductDao dao;
	private List<ProductForm> listOfForms;

	@Override
	public void init() throws ServletException {
		dao = new ProductDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("Entered into ProductViewProductServlet dopost(-,-)");
		String productId = req.getParameter("Id");
		PrintWriter pw = resp.getWriter();
		if (productId == null || productId.isEmpty()) {
			StringBuffer sb = new StringBuffer();
			sb.append("<html><body><table><thead><h2>Search Product</h2></thead>");
			sb.append("<form action = 'productview' method = 'get'");
			sb.append("<tbody><tr><td>ProductId :<input type= 'text' name ='Id'><td/></tr>");
			sb.append("<tr><td><input type='submit' value='scarch'></td></tr>");

			pw.println(sb);

		} else {
			StringBuffer sb = new StringBuffer();
			listOfForms = dao.viewProductData(productId);
			sb.append("<html><body><table><thead><h2>Search Product</h2></thead>");
			sb.append("<form action = 'productview' method = 'get'");
			sb.append("<tbody><tr><td>ProductId :<input type= 'text' name ='Id'><td/></tr>");
			sb.append("<tr><td><input type='submit' value='scarch'></td></tr>");

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
				sb.append("<td><a href='search_product.html' target='bottom_right'> " + eachProduct.getId()
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