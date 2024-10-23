package com.khadri.jakartha.servlet.modify;

import java.io.IOException;
import java.io.PrintWriter;

import com.khadri.jakartha.servlet.dao.ModifyDao;
import com.khadri.jakartha.servlet.modify.form.ModifyForm;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ModifyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ModifyDao dao;

	@Override
	public void init() throws ServletException {
		dao = new ModifyDao();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String mobileModelNo = req.getParameter("MobileModelNumber");
		String mobileName = req.getParameter("MobileName");
		String mobileBrand = req.getParameter("MobileBrand");
		String mobileCost = req.getParameter("MobileCost");
		String mobileQty = req.getParameter("MobileQuantity");

		ModifyForm form = new ModifyForm();
		form.setMobileModelNumber(mobileModelNo);
		form.setMobileName(mobileName);
		form.setMobileBrand(mobileBrand);
		form.setMobileCost(Double.parseDouble(mobileCost));
		form.setMobileQuantity(Integer.parseInt(mobileQty));
		int updateMovie = 0;
		try {
			updateMovie = dao.updateMovie(form);
		} catch (Exception e) {
			System.out.println("exception occurs" + e);
		}
		PrintWriter pw = resp.getWriter();
		if (updateMovie == 1) {
			pw.println(updateMovie + "  Modified sucessfully!!!! ");
		} else {
			pw.println("@@@@@Something went wrong@@@@@");
		}
	}
}
