package com.khadri.jakarta.stock.servlet.modify;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.khadri.jakarta.stock.dao.StockDao;
import com.khadri.jakarta.stock.form.ChargerForm;
import com.khadri.jakarta.stock.form.MobileForm;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class StockModifyPageServlet extends HttpServlet {

	private StockDao stockDao;

	public void init() throws ServletException {
		stockDao = new StockDao();
	}

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Entered into StockModifyPageServlet doGet(-,-)");
		PrintWriter pw = resp.getWriter();
		StringBuffer sb = new StringBuffer();
		String type = req.getParameter("type");
		resp.setContentType("text/html");

		if (type == null || type.isEmpty()) {
			sb.append("<form action='stockmodifysearchpage' method='get'>");
			sb.append("<label>Type:</label>");
			sb.append("<select name='type' id='type'>");
			sb.append("<option value=''>--select--</option>");
			sb.append("<option value='Mobile'>Mobile</option>");
			sb.append("<option value='Charger'>Charger</option>");
			sb.append("<option value='PowerBank'>PowerBank</option>");
			sb.append("<option value='HeadSet'>HeadSet</option>");
			sb.append("<option value='BackCover'>BackCover</option>");
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
	




