package com.khadri.stock.mobile.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.khadri.stock.mobile.dao.BackCoverDao;
import com.khadri.stock.mobile.dao.ChargerDao;
import com.khadri.stock.mobile.dao.HeadSetDao;
import com.khadri.stock.mobile.dao.MobileDao;
import com.khadri.stock.mobile.dao.PowerBankDao;
import com.khadri.stock.mobile.dao.StockDao;
import com.khadri.stock.mobile.form.BackCoverForm;
import com.khadri.stock.mobile.form.ChargerForm;
import com.khadri.stock.mobile.form.HeadSetForm;
import com.khadri.stock.mobile.form.MobileForm;
import com.khadri.stock.mobile.form.PowerBankForm;
import com.khadri.stock.mobile.form.StockForm;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class StockAddServlet extends HttpServlet {
	StockForm form;
	StockDao stockDao;
	MobileForm mobileForm;
	MobileDao mobileDao;
	ChargerForm chargerForm;
	ChargerDao chargerDao;
	PowerBankForm powerBankForm;
	PowerBankDao powerBankDao;
	HeadSetForm headSetForm;
	HeadSetDao headSetDao;
	BackCoverForm backCoverForm;
	BackCoverDao backCoverDao;

	public void init() throws ServletException {
		stockDao = new StockDao();
		mobileDao = new MobileDao();
		chargerDao = new ChargerDao();
		powerBankDao= new PowerBankDao();
		headSetDao=new HeadSetDao();
		backCoverDao=new BackCoverDao();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, NumberFormatException {
		System.out.println("Entered StockAddServlet doPost(-,-)");

		String type = req.getParameter("type");
		String productBrand = req.getParameter("Product_brand");
		String productPrice = req.getParameter("product_price");
		String productModel = req.getParameter("product_model");
		String arrivedDateTime = req.getParameter("arrived_date_time");

		Double price = 0.0;
		if (productPrice != null && !productPrice.isEmpty()) {
			try {
				price = Double.parseDouble(productPrice);
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
			}
		} else {
			System.out.println("arrivedDateTime parameter is missing or empty.");
		}

		mobileForm = new MobileForm(productBrand, Double.parseDouble(productPrice), productModel, sqlDate);
		chargerForm = new ChargerForm(productBrand, Double.parseDouble(productPrice), productModel, sqlDate);
		powerBankForm = new PowerBankForm(productBrand, Double.parseDouble(productPrice), productModel, sqlDate);
		backCoverForm = new BackCoverForm(productBrand, Double.parseDouble(productPrice), productModel, sqlDate);
		headSetForm = new HeadSetForm(productBrand, Double.parseDouble(productPrice), productModel, sqlDate);



		if (type != null) {
			System.out.println("entered in to if block");
			try {
				form = stockDao.selectStockTypeRecord(type);
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
				System.out.println("inserted Successfully");

			} catch (Exception e) {
				System.out.println("@@@@@@@Something went wrong@@@@@@@");

				e.printStackTrace();
			}
		}
	}

	private void insertIntoStockType(String type, StockForm form) throws Exception {
		System.out.println("insertIntoStockType method" + type);
		switch (type) {
		case "Mobile":
			System.out.println("entered into switch case mobile  method");
			mobileDao.insertMobile(mobileForm);
			System.out.println("inserted into switch case mobile  method");
			break;
		case "Charger":
			System.out.println("entered into switch case charger method");
			chargerDao.insertCharger(chargerForm);
			break;
		case "PowerBank":
			System.out.println("entered into switch case powerbank method");
			powerBankDao.insertPowerBank(powerBankForm);
			break;
		case "HeadSet":
			System.out.println("entered into switch case headset  method");
			headSetDao.insertHeadSet(headSetForm);
			break;
		case "BackCover":
			System.out.println("entered into switch case backcover  method");
			backCoverDao.insertBackCover(backCoverForm);
			break;
		default:
			break;
		}
	}
}