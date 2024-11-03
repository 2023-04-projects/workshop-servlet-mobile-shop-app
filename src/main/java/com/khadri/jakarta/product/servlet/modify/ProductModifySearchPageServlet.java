package com.khadri.jakarta.product.servlet.modify;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.khadri.jakarta.product.dao.ProductDao;
import com.khadri.jakarta.product.form.ProductForm;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProductModifySearchPageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ProductDao dao;

	private List<ProductForm> listOfForms;

	@Override
	public void init() throws ServletException {
		dao = new ProductDao();
		listOfForms = new ArrayList<>();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Entered into ProductModifySearchPageServlet dopost(-,-)");

		String productId = req.getParameter("Id");
		PrintWriter pw = resp.getWriter();
		StringBuffer sb = new StringBuffer();

		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>Modify Product Details</title>");
		sb.append("<script type='text/javascript'>");
		sb.append("function validateForm() {");
		sb.append("var id = document.getElementById('productId').value;");
		sb.append("if (id == '') {");
		sb.append("alert('Please enter a Product ID ..!');");
		sb.append("return false;");
		sb.append("}");
		sb.append("if(isNaN(productIdComponent)) { ");
		sb.append("alert('Product Id Must be a number')");
		sb.append("productIdComponent.focus();");
		sb.append("return false");
		sb.append("}");
		sb.append("return true;");
		sb.append("}");
		sb.append("</script>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<thead><h2>Search Product</h2></thead>");

		if (productId == null || productId.isEmpty()) {
			sb.append("<form action = 'productmodifysearchpage' method = 'get' onsubmit ='validateForm()' ");
			sb.append("<table border='1'>");
			sb.append("<tbody>");
			sb.append("<tr><td>ProductId :<input type= 'text' name ='Id' id = 'productId'><td/></tr>");
			sb.append("<tr><td><input type='submit' value='search'></td></tr>");
			sb.append("</tbody>");
			sb.append("</table>");
			sb.append("<table border='1'>");
			sb.append("<tr>");
			sb.append("<th>ProductId</th>"); 
			sb.append("<th>ProductName</th>");
			sb.append("</tr>");
			sb.append("</table>");

			sb.append("</form>");
			pw.println(sb);

		} else {
			listOfForms = dao.viewProductData(productId);
			sb.append("<table border='1'>");
			sb.append("<tbody>");
			sb.append("<tr><td>ProductId :<input type= 'text' name ='Id'><td/></tr>");
			sb.append("<tr><td><input type='submit' value='search'></td></tr>");
			sb.append("</tbody>");
			sb.append("</table>");

			sb.append("<table border='1'>");
			sb.append("<tr>");
			sb.append("<th>ProductId</th>");
			sb.append("<th>ProductName</th>");
			sb.append("</tr>");
			listOfForms.stream().forEach(eachProduct -> {
				sb.append("<tr>");
				sb.append("<td><a href='productmodifypage?ID=" + eachProduct.getId() + "&Name=" + eachProduct.getName()
						+ "' target='bottom_right'> " + eachProduct.getId() + "</a></td>");
				sb.append("<td>" + eachProduct.getName() + "</td>");
				sb.append("</tr>");
			});
			sb.append("</table>");

			pw.println(sb);
		}

		sb.append("</body>");
		sb.append("</html>");
	}
}
