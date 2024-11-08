package com.khadri.jakarta.stock.servlet.delete;

import java.io.IOException;
import java.io.PrintWriter;

import com.khadri.jakarta.stock.dao.StockDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class StockDeletePageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private StockDao stockDao;

	public void init() throws ServletException {
		stockDao = new StockDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("type");
		String product_brand = request.getParameter("product_brand");
		String product_model = request.getParameter("product_model");

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

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
			sb.append("<form action='StockDeletePageServlet' method='get' onsubmit = 'formValidation()'>");
			sb.append("<label>Type:</label>");
			sb.append("<select name='type' id='type'>");
			sb.append("<option value=''>--select--</option>");
			sb.append("<option value='Mobile'>Mobile</option>");
			sb.append("<option value='Charger'>Charger</option>");
			sb.append("<option value='PowerBank'>PowerBank</option>");
			sb.append("<option value='HeadSet'>HeadSet</option>");
			sb.append("<option value='BackCover'>BackCover</option>");
			sb.append("</select><br/>");
			sb.append("<label>Product Brand:</label><input type='text' name='product_brand' id='product_brand' required><br/>");
			sb.append("<label>Product Model:</label><input type='text' name='product_model' id ='product_model' required><br/>");
			sb.append("<input type='submit' value='Delete Mobile'>");
			sb.append("</form>");
		} else {

			boolean isDeleted = false;
			switch (type) {
			case "Mobile":
				isDeleted = stockDao.deleteMobile(product_brand, product_model);
				break;
			case "Charger":
				isDeleted = stockDao.deleteCharger(product_brand, product_model);
				break;
			case "PowerBank":
				isDeleted = stockDao.deletePowerBank(product_brand, product_model);
				break;
			case "HeadSet":
				isDeleted = stockDao.deleteHeadSet(product_brand, product_model);
				break;
			case "BackCover":
				isDeleted = stockDao.deleteBackCover(product_brand, product_model);
				break;
			default:
				pw.println("Invalid product type selected.");
				break;
			}

			if (isDeleted) {
				pw.println(type + " entry deleted successfully.");
			} else {
				pw.println("Failed to delete " + type + " entry. Please check the details.");
			}
		}

		pw.println(sb.toString());
	}

}
