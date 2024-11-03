package com.khdari.jakarta.product.servlet.delete;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProductDeletePageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Entered into DeletePageServlet doGet(-,-)");
		PrintWriter pw = resp.getWriter();
		String productId = req.getParameter("ID");
		String productName = req.getParameter("NAME");

		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<body>");
		sb.append("<form action = 'productdelete' method = 'post'>");
		sb.append("<table>");
		sb.append("<tbody>");
		sb.append("<tr><td>ProductId :<input type='text' name='ID' value='" + productId + "' readonly></td></tr>");
		sb.append("<tr><td>Product Name :<input type='text' name='Name' value='" + productName + "'></td></tr>");
		sb.append("<tr><td><input type='submit' value = 'delete'></td></tr>");
		sb.append("</tbody>");
		sb.append("</table>");
		sb.append("</form>");
		sb.append("</body>");
		sb.append("</html>");

		pw.println(sb);

	}

}
