package com.khadri.jakarta.product.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.khadri.jakarta.product.dao.ProductDao;
import com.khadri.jakarta.product.form.ProductForm;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProductViewAllServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ProductDao dao;
	private List<ProductForm> listOfForms;

	public void init() throws ServletException {
		dao = new ProductDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("Entered into ProductViewProductServlet doGet(-,-)");

		String productId = req.getParameter("getId()");
		PrintWriter pw = resp.getWriter();

		StringBuffer sb = new StringBuffer();
		sb.append("<html><head><title>Product View</title>");
		sb.append("<script>");
		sb.append("function validateForm() {");
		sb.append("var productId = document.getElementById('productId').value;");
		sb.append("if(productId == '' || isNaN(productId)) {");
		sb.append("alert('Please enter a valid Product ID');");
		sb.append("return false;");
		sb.append("}");
		sb.append("return true;");
		sb.append("}");
		sb.append("</script>");
		sb.append("</head>");

		sb.append("<body>");
		sb.append("<form onsubmit='return validateForm()' method='get'>");
		sb.append("  <label for='productId'>Enter Product ID:</label>");
		sb.append("  <input type='text' id='productId' name='getId()'>");
		sb.append("  <input type='submit' value='View Product'>");
		sb.append("</form>");

		if (productId == null || productId.isEmpty()) {
			listOfForms = dao.selectProductData();
			sb.append("<table border='1'>");
			sb.append("<thead><tr><th>ProductId</th><th>ProductName</th></tr></thead>");
			sb.append("<tbody>");
			listOfForms.forEach(eachProduct -> {
				sb.append("<tr>");
				sb.append("<td>").append(eachProduct.getId()).append("</td>");
				sb.append("<td>").append(eachProduct.getName()).append("</td>");
				sb.append("</tr>");
			});
			sb.append("</tbody>");
			sb.append("</table>");
		} else {

		}

		sb.append("</body>");
		sb.append("</html>");
		pw.println(sb.toString());
	}
}
