package com.khadri.jakarta.stock.servlet.modify;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.khadri.jakarta.product.dao.ProductDao;
import com.khadri.jakarta.product.form.ProductForm;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class StockModifyPageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ProductDao productDao;

	@Override
	public void init() throws ServletException {
		productDao = new ProductDao(getServletContext());
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Entered into StockModifyPageServlet doGet(-,-)");

		List<ProductForm> listOfProducts = productDao.selectProductData();

		PrintWriter pw = resp.getWriter();
		StringBuffer sb = new StringBuffer();
		String type = req.getParameter("type");
		resp.setContentType("text/html");

		if (type == null || type.isEmpty()) {
			sb.append("<form action='stockmodifysearchpage' method='get'>");
			sb.append("<label>Type:</label>");
			sb.append("<select name='type' id='type'>");
			sb.append("<option value=''>--select--</option>");
			listOfProducts.stream().forEach(eachProduct -> {
				sb.append("<option value='" + eachProduct.getName() + "'>");
				sb.append(eachProduct.getName());
				sb.append("</option>");
			});
			sb.append("</select><br/>");

			sb.append("<label>Product Brand:</label><input type='text' name='product_brand'><br/>");
			sb.append("<label>Product Model:</label><input type='text' name='product_model'><br/>");
			sb.append("<input type='submit' value='search'>");
			sb.append("</form>");
			sb.append("</table>");
		}

		pw.println(sb);
	}
}
