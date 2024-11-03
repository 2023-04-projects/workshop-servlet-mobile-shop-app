package com.khadri.jakarta.stock.servlet.modify;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.khadri.jakarta.stock.dao.StockDao;
import com.khadri.jakarta.stock.form.BackCoverForm;
import com.khadri.jakarta.stock.form.ChargerForm;
import com.khadri.jakarta.stock.form.HeadSetForm;
import com.khadri.jakarta.stock.form.MobileForm;
import com.khadri.jakarta.stock.form.PowerBankForm;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class StockModifySearchPageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private StockDao stockDao;

	@Override
	public void init() throws ServletException {
		stockDao = new StockDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Entered into StockModifySearchPageServlet doGet(-,-)");

		String productBrand = req.getParameter("product_brand");
		String productModel = req.getParameter("product_model");

		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		StringBuilder sb = new StringBuilder();

		sb.append("<h3>Search Results:</h3>");
		sb.append("<table border='1'>");
		sb.append("<tr><th>Brand</th><th>Model</th><th>Price</th><th>Arrived Date</th></tr>");
		List<MobileForm> mobileList = stockDao.viewMobileData(productBrand, productModel);
		if (mobileList.isEmpty()) {
		} else {
			for (MobileForm mobile : mobileList) {
				sb.append("<tr>");
				sb.append("<td>").append(mobile.getProductBrand()).append("</td>");
				sb.append(
						"<td><a href='stockmodifyservlet?model=").append(mobile.getProductModel()).append("'>")
	              .append(mobile.getProductModel()).append("</a></td>");				sb.append("<td>").append(mobile.getProductPrice()).append("</td>");
				sb.append("<td>").append(mobile.getArrivedDateTime()).append("</td>");
				sb.append("</tr>");
			}
		}
		List<ChargerForm> chargerList = stockDao.viewChargerData(productBrand, productModel);

		if (chargerList.isEmpty()) {
		} else {
			for (ChargerForm charger : chargerList) {
				sb.append("<tr>");
				sb.append("<td>").append(charger.getProductBrand()).append("</td>");
				sb.append("<td><a href='stockmodifyservlet?model=").append(charger.getProductModel()).append("'>")
	              .append(charger.getProductModel()).append("</a></td>");				sb.append("<td>").append(charger.getProductPrice()).append("</td>");
				sb.append("<td>").append(charger.getArrivedDateTime()).append("</td>");
				sb.append("</tr>");
			}
		}
		List<PowerBankForm> powerbankList = stockDao.viewPowerBankData(productBrand, productModel);

		if (powerbankList.isEmpty()) {
		} else {
			for (PowerBankForm powerbank : powerbankList) {
				sb.append("<tr>");
				sb.append("<td>").append(powerbank.getProductBrand()).append("</td>");
				sb.append("<td><a href='stockmodifyservlet?model=").append(powerbank.getProductModel()).append("'>")
	              .append(powerbank.getProductModel()).append("</a></td>");				sb.append("<td>").append(powerbank.getProductPrice()).append("</td>");
				sb.append("<td>").append(powerbank.getArrivedDateTime()).append("</td>");
				sb.append("</tr>");
			}
		}
		List<HeadSetForm> headsetList = stockDao.viewHeadSetData(productBrand, productModel);

		if (headsetList.isEmpty()) {
		} else {
			for (HeadSetForm headset : headsetList) {
				sb.append("<tr>");
				sb.append("<td>").append(headset.getProductBrand()).append("</td>");
				sb.append("<td><a href='stockmodifyservlet?model=").append(headset.getProductModel()).append("'>")
	              .append(headset.getProductModel()).append("</a></td>");				sb.append("<td>").append(headset.getProductPrice()).append("</td>");
				sb.append("<td>").append(headset.getArrivedDateTime()).append("</td>");
				sb.append("</tr>");
			}
		}
			List<BackCoverForm> backcoverkList = stockDao.viewBackCoverData(productBrand, productModel);

			
			if (backcoverkList.isEmpty()) {
			} else {
				for (BackCoverForm backcover : backcoverkList) {
					sb.append("<tr>");
					sb.append("<td>").append(backcover.getProductBrand()).append("</td>");
					 sb.append("<td><a href='stockmodifyservlet?model=").append(backcover.getProductModel()).append("'>")
		              .append(backcover.getProductModel()).append("</a></td>");					sb.append("<td>").append(backcover.getProductPrice()).append("</td>");
					sb.append("<td>").append(backcover.getArrivedDateTime()).append("</td>");
					sb.append("</tr>");
				}
			}

		sb.append("</table>");
		pw.println(sb);
	}
}
