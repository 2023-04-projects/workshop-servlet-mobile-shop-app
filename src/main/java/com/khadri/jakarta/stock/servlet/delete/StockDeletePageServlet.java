package com.khadri.jakarta.stock.servlet.delete;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.khadri.jakarta.product.dao.ProductDao;
import com.khadri.jakarta.product.form.ProductForm;
import com.khadri.jakarta.stock.dao.StockDao;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class StockDeletePageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private StockDao stockDao;
	private ProductDao productDao;

	public void init() throws ServletException {
		ServletContext context = getServletContext();
		stockDao = new StockDao(context);
		productDao = new ProductDao(context);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Entered into StockDeletePageServlet doGet(-,-)");
		List<ProductForm> listOfProducts = productDao.selectProductData();
		String type = request.getParameter("type");
		String product_brand = request.getParameter("product_brand");
		String product_model = request.getParameter("product_model");

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		StringBuffer sb = new StringBuffer();

		if (type == null || type.isEmpty()) {
			sb.append("<form action='StockDeletePageServlet' method='get'>");
			sb.append("<label>Type:</label>");
			sb.append("<select name='type' id='type'>");
			sb.append("<option value=''>--select--</option>");
			listOfProducts.stream().forEach(eachProduct ->{
				sb.append("<option value='"+eachProduct.getName()+"'>"+eachProduct.getName()+"</option>");
			});
			sb.append("</select><br/>");
			sb.append("<label>Product Brand:</label><input type='text' name='product_brand' required><br/>");
			sb.append("<label>Product Model:</label><input type='text' name='product_model' required><br/>");
			sb.append("<input type='submit' value='Delete Mobile'>");
			sb.append("</form>");
		} else {

			boolean isDeleted = false;
			switch (type) {
			case "mobile":
				isDeleted = stockDao.deleteMobile(product_brand, product_model);
				break;
			case "charger":
				isDeleted = stockDao.deleteCharger(product_brand, product_model);
				break;
			case "powerbank":
				isDeleted = stockDao.deletePowerBank(product_brand, product_model);
				break;
			case "headset":
				isDeleted = stockDao.deleteHeadSet(product_brand, product_model);
				break;
			case "backcover":
				isDeleted = stockDao.deleteBackCover(product_brand, product_model);
				break;
			default:
				pw.println("Invalid product type selected.");
				break;
			}

			if (isDeleted) {
				pw.println(type + " entry deleted successfully.");
			} else {
				pw.println("Failed to delete " + type + " entry. Please check the details.");
			}
		}

		pw.println(sb.toString());
	}

}
