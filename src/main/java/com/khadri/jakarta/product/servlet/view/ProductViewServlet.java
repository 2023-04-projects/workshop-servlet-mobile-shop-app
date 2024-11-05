package com.khadri.jakarta.product.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.khadri.jakarta.product.dao.ProductDao;
import com.khadri.jakarta.product.form.ProductForm;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProductViewServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ProductDao dao;
	private List<ProductForm> listOfForms;

	@Override
	public void init() throws ServletException {
		ServletContext context = getServletContext();
		dao = new ProductDao(context);	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("Entered into ProductViewProductServlet dopost(-,-)");
		String productId = req.getParameter("Id");
		PrintWriter pw = resp.getWriter();
		if (productId == null || productId.isEmpty()) {
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
			
			sb.append("<body><table><thead><h2>Search Product</h2></thead>");
			sb.append("<form action = 'productview' method = 'get' onsubmit ='validateForm()' ");
			sb.append("<tbody><tr><td>ProductId :<input type= 'text' name ='Id' id= 'productId'><td/></tr>");
			sb.append("<tr><td><input type='submit' value='search'></td></tr>");

			pw.println(sb);

		} else {
			StringBuffer sb = new StringBuffer();
			listOfForms = dao.viewProductData(productId);
			sb.append("<html><body><table><thead><h2>Search Product</h2></thead>");
			sb.append("<form action = 'productview' method = 'get'");
			sb.append("<tbody><tr><td>ProductId :<input type= 'text' name ='Id'><td/></tr>");
			sb.append("<tr><td><input type='submit' value='search'></td></tr>");

			sb.append("<table border='1'>");
			sb.append("<thead>");
			sb.append("<tr>");
			sb.append("<th>ProductId</th>");
			sb.append("<th>ProductName</th>");
			sb.append("</tr>");
			sb.append("</thead>");
			sb.append("<tbody>");
			listOfForms.stream().forEach(eachProduct -> {
				sb.append("<tr>");
				sb.append("<td>" + eachProduct.getId() + "</td>");
				sb.append("<td>" + eachProduct.getName() + "</td>");
				sb.append("</tr>");
			});
			sb.append("</tbody>");
			sb.append("</table>");
			pw.println(sb);
		}
	}
}
