package com.khadri.stock.mobile.servlet;

import java.io.IOException;

import com.khadri.stock.mobile.dao.StockDao;
import com.khadri.stock.mobile.form.MobileForm;
import com.khadri.stock.mobile.form.StockForm;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class StockAddServlet extends HttpServlet {
	StockDao stockDao;
	MobileForm form;

//StockForm form = new StockForm();
	public void init() throws ServletException {
		stockDao = new StockDao();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Entered StockAddServlet doPost(-,-)");

		String type = req.getParameter("type");
		String arrivedDateTime = req.getParameter("arrivedDateTime");
		String productBrand = req.getParameter("productBrand");
		String productPrice = req.getParameter("productPrice");
		String productModel = req.getParameter("productModel");

		if (type != null) {
			System.out.println("entered in to if block");
			try {
				StockForm form = stockDao.selectStockTypeRecord(type);
				if (form != null) {
					System.out.println("entered in to if form block" + form);
					int qty = form.getQty() + 1;
					stockDao.updateStockQty(type, qty);

					insertIntoStockType(type, form);
				} else {
					System.out.println("entered in to else block");
					stockDao.insertIntoStock(type, 1);
					insertIntoStockType(type, form);
				}
				insertIntoStockType(type, form);
				System.out.println("inserted Successfully");

			} catch (Exception e) {
				System.out.println("@@@@@@@Something went wrong@@@@@@@");

				e.printStackTrace();
			}
		}
	}

	private void insertIntoStockType(String type, StockForm stockForm) throws Exception {
		switch (type) {
		case "mobile":
			stockDao.insertMobileTypeData(form);
			break;

		default:
			break;
		}
	}
}