package com.khadri.jakarta.product.servlet.modify;

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

public class ProductModifySearchPageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ProductDao dao;

	private List<ProductForm> listOfForms;

	@Override
	public void init() throws ServletException {
		ServletContext context = getServletContext();
		dao = new ProductDao(context);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Entered into ProductModifySearchPageServlet dopost(-,-)");

		String productId = req.getParameter("Id");
		PrintWriter pw = resp.getWriter();
		StringBuffer sb = new StringBuffer();

		sb.append("<html>");
		sb.append("<head>");
		sb.append("<link rel='stylesheet' type='text/css' href='styles.css'/>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<form action = 'productmodifysearchpage' method = 'get'");
		sb.append("<table border='1'>");
		sb.append("<tbody>");
		sb.append("<tr><td>ProductId :<input type= 'text' name ='Id'><td/></tr>");
		sb.append("<tr><td><input type='submit' value='Product Modify Search'></td></tr>");
		sb.append("</tbody>");
		sb.append("</table>");
		sb.append("<table border='1'>");
		sb.append("<tr>");
		sb.append("<th>ProductId</th>");
		sb.append("<th>ProductName</th>");
		sb.append("</tr>");

		if (productId != null) {
			listOfForms = dao.viewProductData(productId);
			
			if(!listOfForms.isEmpty()) {
				listOfForms.stream().forEach(eachProduct -> {
					sb.append("<tr>");
					sb.append("<td><a href='productmodifypage?ID=" + eachProduct.getId() + "&Name=" + eachProduct.getName()
					+ "' target='bottom_right'> " + eachProduct.getId() + "</a></td>");
					sb.append("<td>" + eachProduct.getName() + "</td>");
					sb.append("</tr>");
				});
			}else {
				sb.append("<tr>");
				sb.append("<td colspan='2' id='nrf'>No Records Found</td>");
				sb.append("</tr>");
			}
			sb.append("</table>");

		}

		pw.println(sb);
		sb.append("</body>");
		sb.append("</html>");
	}
}
