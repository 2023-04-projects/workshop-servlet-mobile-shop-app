package com.khadri.jakarta.product.servlet.add;

import java.io.IOException;
import java.io.PrintWriter;

import com.khadri.jakarta.product.dao.ProductDao;
import com.khadri.jakarta.product.form.ProductForm;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProductAddServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ProductDao dao;
	private ProductForm form;

	public void init() throws ServletException {
		dao = new ProductDao();
		form = new ProductForm();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Entered into AddMobileServlet doPost(-,-)");
		String name = req.getParameter("productName");
		form.setName(name);
		int result = dao.insertMobileData(form);

		PrintWriter pw = resp.getWriter();

		if (result == 1) {
			pw.println(result + " Inserted Successfully!!!!!");
		} else {
			pw.println("@@@@@Something went wrong@@@@@");
		}

	}

}
