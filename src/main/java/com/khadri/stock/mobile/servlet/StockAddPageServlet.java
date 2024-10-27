package com.khadri.stock.mobile.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import com.khadri.stock.mobile.dao.StockDao;
import com.khadri.stock.mobile.form.MobileForm;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class StockAddPageServlet extends HttpServlet {
			
	private static final long serialVersionUID = 1L;
	private StockDao dao;
	PrintWriter pw;
	MobileForm form;

	public void init() throws ServletException {
		dao = new StockDao();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Entered StockAddServlet doGet(-,-)");

		List<String> stockTypes = Arrays.asList("Mobile", "Charger", "PowerBank", "HeadSet", "BackCover");

		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();

		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("<html>");
		stringBuffer.append("<head><title>Add Stock Details</title></head>");
		stringBuffer.append("<body>");
		stringBuffer.append("<form action='stockadd' method='post'>");
		stringBuffer.append("<table>");
		stringBuffer.append("<thead><h2>Add Stock Details</h2></thead>");
		stringBuffer.append("<tbody>");
		stringBuffer.append("<tr><td><label>Type:</label><select name='type'>");
		stringBuffer.append("<option>--select--</option>");
		stockTypes.forEach(type -> stringBuffer.append("<option>" + type + "</option>"));
		stringBuffer.append("</select></td></tr>");

		stringBuffer.append("<tr><td>Arrived Date/Time:<input type='datetime-local' name='arrived_date_time'></td></tr>");

		stringBuffer.append("<tr><td>Product Brand:<input type='text' name='Product_brand'></td></tr>");

		stringBuffer.append("<tr><td>Product Price:<input type='text' name='product_price'></td></tr>");

		stringBuffer.append("<tr><td>Product Model:<input type='text' name='product_model'></td></tr>");

		stringBuffer.append("<tr><td><input type='submit' value='AddStock'></td></tr>");

		stringBuffer.append("</tbody>");
		stringBuffer.append("</table>");
		stringBuffer.append("</form>");
		stringBuffer.append("</body>");
		stringBuffer.append("</html>");

		pw.println(stringBuffer.toString());
	}
	
			
			
}		
			
			
			
			
			
			
			
			
			
			
			

		


		
		
		
		
		
		
		
		
		
		
		
		
