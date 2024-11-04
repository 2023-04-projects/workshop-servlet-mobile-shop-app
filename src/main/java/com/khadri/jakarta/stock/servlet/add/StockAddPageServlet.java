package com.khadri.jakarta.stock.servlet.add;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class StockAddPageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Entered StockAddPageServlet doGet(-,-)");

		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();

		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("<html>");
		stringBuffer.append("<head><title>Add Stock Details</title></head>");
		stringBuffer.append("<body>");
		stringBuffer.append("<script type='text/javascript'>");
		stringBuffer.append("function formValidation() {");
		stringBuffer.append("var selectBoxComponent = document.querySelector('#type');");
		stringBuffer.append("var selectedIndex = selectBoxComponent.selectedIndex;");
		stringBuffer.append("var productBrandComponent = document.getElementById('Product_brand');");
		stringBuffer.append("var productPriceComponent = document.getElementById('product_price');");
		stringBuffer.append("var productModelComponent = document.getElementById('product_model');");
		stringBuffer.append("var arriveddateComponent = document.getElementById('arrived_date_time');");
		stringBuffer.append("if (selectedIndex == 0) {");
		stringBuffer.append("alert('Please select type.');");
		stringBuffer.append("return false;");
		stringBuffer.append("} ");
		stringBuffer.append("if (productBrandComponent.value == '') {");
		stringBuffer.append("alert('Please enter product brand.');");
		stringBuffer.append("productBrandComponent.focus();");
		stringBuffer.append("return false;");
		stringBuffer.append("} ");
		stringBuffer.append("if (productModelComponent.value == '') {");
		stringBuffer.append("alert('Please enter product model.');");
		stringBuffer.append("productModelComponent.focus();");
		stringBuffer.append("return false;");
		stringBuffer.append("} ");
		stringBuffer.append("if (productPriceComponent.value == '') {");
		stringBuffer.append("alert('Please enter product price.');");
		stringBuffer.append("productPriceComponent.focus();");
		stringBuffer.append("return false;");
		stringBuffer.append("} ");
		stringBuffer.append("if (arriveddateComponent.value == '') {");
		stringBuffer.append("alert('Please enter arrived date time.');");
		stringBuffer.append("arriveddateComponent.focus();");
		stringBuffer.append("return false;");
		stringBuffer.append("}");
		stringBuffer.append("}");
		stringBuffer.append("</script>");
		stringBuffer.append("<form action='stockadd' method='post' onsubmit='return formValidation()'>");
		stringBuffer.append("<table>");
		stringBuffer.append("<thead><h2>Add Stock Details</h2></thead>");
		stringBuffer.append("<tbody>");
		stringBuffer.append("<tr><td><label>Type:</label><select name='type' id='type'>");
		stringBuffer.append("<option>--select--</option>");
		stringBuffer.append("<option>Mobile</option>");
		stringBuffer.append("<option>Charger</option>");
		stringBuffer.append("<option>PowerBank</option>");
		stringBuffer.append("<option>HeadSet</option>");
		stringBuffer.append("<option>BackCover</option>");
		stringBuffer.append("</select></td></tr>");
		stringBuffer.append(
				"<tr><td>Arrived Date/Time:<input type='datetime-local' name='arrived_date_time' id='arrived_date_time'></td></tr>");
		stringBuffer.append("<tr><td>Product Brand:<input type='text' name='Product_brand' id='Product_brand'></td></tr>");
		stringBuffer.append("<tr><td>Product Price:<input type='text' name='product_price' id='product_price'></td></tr>");
		stringBuffer.append("<tr><td>Product Model:<input type='text' name='product_model' id='product_model'></td></tr>");
		stringBuffer.append("<tr><td><input type='submit' value='AddStock'></td></tr>");
		stringBuffer.append("</tbody>");
		stringBuffer.append("</table>");
		stringBuffer.append("</form>");
		stringBuffer.append("</body>");
		stringBuffer.append("</html>");

		pw.println(stringBuffer.toString());

	}

}
