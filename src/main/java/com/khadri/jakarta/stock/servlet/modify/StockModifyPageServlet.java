package com.khadri.jakarta.stock.servlet.modify;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class StockModifyPageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Entered into StockModifyPageServlet doGet(-,-)");

		resp.setContentType("text/html");

		String type = req.getParameter("type");

		PrintWriter pw = resp.getWriter();
		StringBuffer sb = new StringBuffer();

		sb.append("<html>");
		sb.append("<head><title>Add Stock Details</title></head>");
		sb.append("<body>");
		sb.append("<script type='text/javascript'>");
		sb.append("function formValidation() {");
		sb.append("var selectBoxComponent = document.querySelector('#type');");
		sb.append("var selectedIndex = selectBoxComponent.selectedIndex;");
		sb.append("var productBrandComponent = document.getElementById('product_brand');");
		sb.append("var productModelComponent = document.getElementById('product_model');");
		sb.append("if (selectedIndex == 0) {");
		sb.append("alert('Please select type ..!');");
		sb.append("return false;");
		sb.append("} ");
		sb.append("if(productBrandComponent.value == '') {");
		sb.append("alert('Please enter a product brand ..!');");
		sb.append("productBrandComponent.focus();");
		sb.append("return false;");
		sb.append("} ");
		sb.append("if (productModelComponent.value == '') {");
		sb.append("alert('Please enter product model.');");
		sb.append("productModelComponent.focus();");
		sb.append("return false;");
		sb.append("} ");
		sb.append("}");
		sb.append("</script>");
		if (type == null || type.isEmpty()) {
			sb.append("<form action='stockmodifysearchpage' method='get' onsubmit='return formValidation()'>");
			sb.append("<label>Type:</label>");
			sb.append("<select name='type' id='type'>");
			sb.append("<option value=''>--select--</option>");
			sb.append("<option value='Mobile'>Mobile</option>");
			sb.append("<option value='Charger'>Charger</option>");
			sb.append("<option value='PowerBank'>PowerBank</option>");
			sb.append("<option value='HeadSet'>HeadSet</option>");
			sb.append("<option value='BackCover'>BackCover</option>");
			sb.append("</select><br/>");

			sb.append("<label>Product Brand:</label><input type='text' name='product_brand' id ='product_brand'><br/>");
			sb.append(
					"<label>Product Model:</label><input type='text' name='product_model' id = 'product_model'><br/>");
			sb.append("<input type='submit' value='search'>");
			sb.append("</form>");
			sb.append("</table>");
			sb.append("</body>");
			sb.append("</html>");
		}

		pw.println(sb);
	}
}
