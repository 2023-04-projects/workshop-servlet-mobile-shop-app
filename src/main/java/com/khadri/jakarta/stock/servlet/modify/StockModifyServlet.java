package com.khadri.jakarta.stock.servlet.modify;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.khadri.jakarta.stock.dao.StockDao;
import com.khadri.jakarta.stock.form.BackCoverForm;
import com.khadri.jakarta.stock.form.ChargerForm;
import com.khadri.jakarta.stock.form.HeadSetForm;
import com.khadri.jakarta.stock.form.MobileForm;
import com.khadri.jakarta.stock.form.PowerBankForm;
import com.khadri.jakarta.stock.form.StockForm;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class StockModifyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private StockForm form;
	private MobileForm mobileForm;
	private ChargerForm chargerForm;
	private PowerBankForm powerBankForm;
	private HeadSetForm headSetForm;
	private BackCoverForm backCoverForm;
	private StockDao stockDao;

	public void init() throws ServletException {
		stockDao = new StockDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    System.out.println("Entered into StockModifyServlet doGet(-,-)");
	    double productPrice;
	    String productModel = req.getParameter("product_model");
	    String productPriceStr = req.getParameter("product_price");
	    PrintWriter pw = resp.getWriter();
	    resp.setContentType("text/html");

	    if (productModel == null || productPriceStr == null) {
	        StringBuffer sb = new StringBuffer();
	        sb.append("<form>");
	        sb.append("<label>Product Model:</label><input type='text' name='product_model'><br/>");
	        sb.append("<label>Product price:</label><input type='text' name='product_price'><br/>");
	        sb.append("<input type='submit' value='modify'>");
	        sb.append("</form>");
	        pw.println(sb);
	    } else {
	        try {
	            productPrice = Double.parseDouble(productPriceStr);
	        } catch (NumberFormatException e) {
	            pw.println("Error: Invalid product price. Please enter a numeric value.");
	            return;
	        }

	        StockDao stockDao = new StockDao();
	        try {
	            stockDao.updateMobilePrice(productPrice, productModel);
	            stockDao.updateChargerPrice(productPrice, productModel);
	            stockDao.updatePowerBankPrice(productPrice, productModel);
	            stockDao.updateHeadSetPrice(productPrice, productModel);
	            stockDao.updateBackCoverPrice(productPrice, productModel);
	            pw.println("Product price modified successfully!");
	        } catch (Exception e) {
	            pw.println("Error: Could not modify the product price.");
	            e.printStackTrace();
	        }
	    }
	}
}
