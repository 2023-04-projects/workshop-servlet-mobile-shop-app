package com.khadri.stock.mobile.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.khadri.stock.mobile.dao.MobileDao;
import com.khadri.stock.mobile.dao.StockDao;
import com.khadri.stock.mobile.form.MobileForm;
import com.khadri.stock.mobile.form.StockForm;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class StockAddServlet extends HttpServlet {
	StockDao stockDao;
	MobileForm mobileForm;
	MobileDao mobileDao;

//StockForm form = new StockForm();
	public void init() throws ServletException {
		stockDao = new StockDao();
		mobileDao= new MobileDao();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NumberFormatException {
		System.out.println("Entered StockAddServlet doPost(-,-)");

		String type = req.getParameter("type");
		String productBrand = req.getParameter("productBrand");
		String productprice = req.getParameter("productprice");
		String productModel = req.getParameter("productModel");
		String arrivedDateTime = req.getParameter("arrivedDateTime");

		Double price = 0.0;
		if (productprice != null && !productprice.isEmpty()) {
		    try {
		        price = Double.parseDouble(productprice);
		    } catch (NumberFormatException e) {
		        e.printStackTrace();
		        System.out.println("Invalid price format.");
		    }
		} else {
		    System.out.println("productprice parameter is missing or empty.");
		}
		Date sqlDate = null;
		if (arrivedDateTime != null && !arrivedDateTime.isEmpty()) {
		    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		    try {
		        java.util.Date parsedDate = dateFormat.parse(arrivedDateTime);
		        sqlDate = new Date(parsedDate.getTime());
		    } catch (ParseException e) {
		        e.printStackTrace();
		        // Handle the parse exception if needed
		    }
		} else {
		    System.out.println("arrivedDateTime parameter is missing or empty.");
		}


		// Create a new MobileForm instance with parsed values
		MobileForm mobileForm = new MobileForm(productBrand, Double.parseDouble(productprice), productModel, sqlDate);

		 // Create a new MobileForm instance with parsed values
		// MobileForm mobileForm = new MobileForm(productBrand, Double.parseDouble(productprice), productModel, sqlDate);
		
		//date=dateFormat.parse(arrivedDateTime);
		//mobileForm= new MobileForm( productBrand, Double.parseDouble(productprice), productModel, dateFormat.parse(arrivedDateTime));
		if (type != null) {
			System.out.println("entered in to if block");
			try {
				StockForm form = stockDao.selectStockTypeRecord(type);
				if (form != null) {
					System.out.println("entered in to if form block");
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
	

	private void insertIntoStockType(String type, StockForm form) throws Exception {
		System.out.println("insertIntoStockType method"+type);
		switch (type) {

		case "Mobile":
			System.out.println("switch mobile  method" +mobileForm);
			mobileDao.insertMobile(mobileForm);
			break;

		default:
			break;
		}
	}
}