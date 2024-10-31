package com.khadri.jakarta.product.servlet.modify;

import java.io.IOException;
import java.io.PrintWriter;

import com.khadri.jakarta.product.dao.ProductDao;
import com.khadri.jakarta.product.form.ProductForm;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProductModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDao dao;
	private ProductForm form;

	@Override
	public void init() throws ServletException {
		dao = new ProductDao();
		form = new ProductForm();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  int result ;
		System.out.println("Entered into ModifyProductServlet dopost(-,-)");
		String id = req.getParameter("ID");
		String name = req.getParameter("Name");
		if (id != null && !id.isEmpty()) {
			int parseInt = Integer.parseInt(id);
		    form.setId(parseInt);
		} else {
		    System.out.println("ID parameter is missing or empty.");
		}
		form.setName(name);
		result = dao.updateProduct(form);
		 

		PrintWriter pw = resp.getWriter();

		if (result == 1) {
			pw.println(result + "  Modified sucessfully!!!! ");
		} else {
			pw.println("@@@@@Something went wrong@@@@@");
		}
	}

}
