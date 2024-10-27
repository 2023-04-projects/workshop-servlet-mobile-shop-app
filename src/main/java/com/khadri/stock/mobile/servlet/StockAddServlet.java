package com.khadri.stock.mobile.servlet;

import java.io.IOException;

import com.khadri.stock.mobile.dao.StockDao;
import com.khadri.stock.mobile.form.StockForm;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class StockAddServlet extends HttpServlet {
 StockDao stockDao = new StockDao();
//StockForm form = new StockForm();
	public void init() throws ServletException {
		stockDao = new StockDao();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Entered StockAddServlet doGet(-,-)");

		String type = req.getParameter("type");
		//String arrivedDateTime = req.getParameter("arrivedDateTime");
		//String productBrand = req.getParameter("productBrand");
		//String productPrice = req.getParameter("productPrice");
		//String productModel = req.getParameter("productModel");
	
		if(type !=null) {
			System.out.println("entered in to if block");
			try {
				StockForm form = stockDao.getInsertStock(type);
				if(form!=null) {
					System.out.println("entered in to if form block");

					int qty=form.getQty()+1;
					stockDao. updateStockQty(type,qty);
				}else {
					System.out.println("entered in to else block");

					stockDao.insertIntoStock(type, 1);
				}
			
				insertIntoStockType(type);
				System.out.println("inserted Successfully");

			}catch(Exception e) {
				System.out.println("@@@@@@@Something went wrong@@@@@@@");

				e.printStackTrace();
			}
		}
	}
	private void insertIntoStockType(String type)throws Exception{
		switch (type) {
		case "mobile":
			 stockDao.insertMobileTypeData();
			break;

		default:
			break;
		}
	}
}