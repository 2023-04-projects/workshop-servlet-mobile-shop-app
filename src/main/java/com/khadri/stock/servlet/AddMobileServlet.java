package com.khadri.stock.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.khadri.stock.mobile.dao.MobileDao;
import com.khadri.stock.mobile.form.MobileForm;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddMobileServlet extends HttpServlet {
	private MobileDao dao;
	PrintWriter pw;
	MobileForm form;

	public void init() throws ServletException {
		dao = new MobileDao();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

		System.out.println("Entered into AddMobileServlet doPost(-,-)");
		String mobileModelNo = req.getParameter("mobileModelNo");
		String mobileName = req.getParameter("mobileName");
		String mobileBrand = req.getParameter("mobileBrand");
		String mobileCost = req.getParameter("mobileCost");
		String mobileQuantity = req.getParameter("mobileQuantity");
		 form = new MobileForm(Integer.parseInt(mobileModelNo), mobileName, mobileBrand,
				Double.parseDouble(mobileCost), Integer.parseInt(mobileQuantity));
		int result = dao.insertMobile(form);

		try {
			pw = resp.getWriter();
		} catch (IOException e) {
			System.out.println("IOException" + e);
			e.printStackTrace();
		}
		if (result > 0) {
			pw.println(result + " Inserted Successfully!!!!!");
		} else {
			pw.println("@@@@@Something went wrong@@@@@");
		}
	}
}
