package com.khadri.jakarta.modify.product.servlet;

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

public class ProductModifyPageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ProductDao dao;

	@Override
	public void init() throws ServletException {
		dao = new ProductDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Entered into ModifyPageServlet doGet(-,-)");
		List<ProductForm> listOfProduct = new ArrayList<>();
		PrintWriter pw = resp.getWriter();
		String productId = req.getParameter("Id");

		 

		StringBuffer sb = new StringBuffer();
		sb.append("<html><body><table><thead><h2>ProductModify</h2></thead>");
		sb.append("<form action='modifyp' method='post'>");
		sb.append("<tbody><tr><td>ProductId:<input type='text' name='ID'></td></tr>");
		sb.append("<tr><td><input type='submit' value='Modify'></td></tr>");
		sb.append("<table border='1'>");
		sb.append("<thead>");
		sb.append("<tr>");
		
		sb.append("<th>ProductId</th>");
		sb.append("<th>ProductName</th>");
		sb.append("</tr>");
		sb.append("</thead>");
		sb.append("<tbody>");
		sb.append("<tbody>");

		listOfProduct.stream().forEach(eachForm -> {

			sb.append("<tr>");
			sb.append("<td><a href='modify_product.html' target='bottom_right'> " + eachForm.getId() + "</a></td>");
			sb.append("<td>" + eachForm.getName() + "</td>");
			sb.append("</tr>");
		});

		sb.append("</tbody>");

		pw.println(sb);

	}
}
