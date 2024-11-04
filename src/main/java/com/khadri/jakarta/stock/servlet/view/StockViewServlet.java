package com.khadri.jakarta.stock.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.khadri.jakarta.stock.dao.StockDao;
import com.khadri.jakarta.stock.form.BackCoverForm;
import com.khadri.jakarta.stock.form.ChargerForm;
import com.khadri.jakarta.stock.form.HeadSetForm;
import com.khadri.jakarta.stock.form.MobileForm;
import com.khadri.jakarta.stock.form.PowerBankForm;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class StockViewServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private StockDao stockDao;
	private List<MobileForm> listOfMobileForm;
	private List<ChargerForm> listOfChargerForm;
	private List<HeadSetForm> listOfHeadSetForm;
	private List<PowerBankForm> listOfPowerBankForm;
	private List<BackCoverForm> listOfBackCoverForm;

	public void init() throws ServletException {
		stockDao = new StockDao();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Entered into StockViewServlet doGet(-,-)");
		String type = req.getParameter("type");
		String product_brand = req.getParameter("product_brand");
		String product_model = req.getParameter("product_model");

		resp.setContentType("text/html");
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
		
		sb.append("<h2>Search Type</h2>");
		sb.append("<form action='StockViewServlet' method='get' onsubmit='return formValidation()'>");
		sb.append("<label>Type:</label>");
		sb.append("<select name='type' id='type'>");
		sb.append("<option value=''>--select--</option>");
		sb.append("<option value='Mobile'>Mobile</option>");
		sb.append("<option value='Charger'>Charger</option>");
		sb.append("<option value='PowerBank'>PowerBank</option>");
		sb.append("<option value='HeadSet'>HeadSet</option>");
		sb.append("<option value='BackCover'>BackCover</option>");
		sb.append("</select>");
		sb.append("<br/>");

		sb.append("Product Brand: <input type='text' name='product_brand' id ='product_brand'><br/>");
		sb.append("Product Model: <input type='text' name='product_model' id = 'product_model'><br/>");
		sb.append("<input type='submit' value='Search'>");
		sb.append("</form>");

		if (type != null && !type.isEmpty()) {
			switch (type) {
			case "Mobile":
				listOfMobileForm = stockDao.viewMobileData(product_brand, product_model);
				break;
			case "Charger":
				listOfChargerForm = stockDao.viewChargerData(product_brand, product_model);
				break;
			case "PowerBank":
				listOfPowerBankForm = stockDao.viewPowerBankData(product_brand, product_model);
				break;
			case "HeadSet":
				listOfHeadSetForm = stockDao.viewHeadSetData(product_brand, product_model);
				break;
			case "BackCover":
				listOfBackCoverForm = stockDao.viewBackCoverData(product_brand, product_model);
				break;
			default:
				listOfMobileForm = null;
			}

			if (listOfMobileForm != null && !listOfMobileForm.isEmpty()) {
				sb.append("<table border='1'>");
				sb.append("<thead>");
				sb.append(
						"<tr><th>Product Brand</th><th>Product Model</th><th>Product Price</th><th>ArrivedDateTime</th></tr>");
				sb.append("</thead>");
				sb.append("<tbody>");
				for (MobileForm eachProduct : listOfMobileForm) {
					sb.append("<tr>");
					sb.append("<td>").append(eachProduct.getProductBrand()).append("</td>");
					sb.append("<td>").append(eachProduct.getProductModel()).append("</td>");
					sb.append("<td>").append(eachProduct.getProductPrice()).append("</td>");
					sb.append("<td>").append(eachProduct.getArrivedDateTime()).append("</td>");

					sb.append("</tr>");
				}

			} else {
			}
		}

		if (listOfChargerForm != null && !listOfChargerForm.isEmpty()) {
			sb.append("<table border='1'>");
			sb.append("<thead>");
			sb.append(
					"<tr><th>Product Brand</th><th>Product Model</th><th>Product Price</th><th>ArrivedDateTime</th></tr>");
			sb.append("</thead>");
			sb.append("<tbody>");
			for (ChargerForm eachProduct : listOfChargerForm) {
				sb.append("<tr>");
				sb.append("<td>").append(eachProduct.getProductBrand()).append("</td>");
				sb.append("<td>").append(eachProduct.getProductModel()).append("</td>");
				sb.append("<td>").append(eachProduct.getProductPrice()).append("</td>");
				sb.append("<td>").append(eachProduct.getArrivedDateTime()).append("</td>");

				sb.append("</tr>");
			}

		} else {
		}

		if (listOfPowerBankForm != null && !listOfPowerBankForm.isEmpty()) {
			sb.append("<table border='1'>");
			sb.append("<thead>");
			sb.append(
					"<tr><th>Product Brand</th><th>Product Model</th><th>Product Price</th><th>ArrivedDateTime</th></tr>");
			sb.append("</thead>");
			sb.append("<tbody>");
			for (PowerBankForm eachProduct : listOfPowerBankForm) {
				sb.append("<tr>");
				sb.append("<td>").append(eachProduct.getProductBrand()).append("</td>");
				sb.append("<td>").append(eachProduct.getProductModel()).append("</td>");
				sb.append("<td>").append(eachProduct.getProductPrice()).append("</td>");
				sb.append("<td>").append(eachProduct.getArrivedDateTime()).append("</td>");

				sb.append("</tr>");
			}

		} else {
		}

		if (listOfHeadSetForm != null && !listOfHeadSetForm.isEmpty()) {
			sb.append("<table border='1'>");
			sb.append("<thead>");
			sb.append(
					"<tr><th>Product Brand</th><th>Product Model</th><th>Product Price</th><th>ArrivedDateTime</th></tr>");
			sb.append("</thead>");
			sb.append("<tbody>");
			for (HeadSetForm eachProduct : listOfHeadSetForm) {
				sb.append("<tr>");
				sb.append("<td>").append(eachProduct.getProductBrand()).append("</td>");
				sb.append("<td>").append(eachProduct.getProductModel()).append("</td>");
				sb.append("<td>").append(eachProduct.getProductPrice()).append("</td>");
				sb.append("<td>").append(eachProduct.getArrivedDateTime()).append("</td>");

				sb.append("</tr>");
			}
			sb.append("</tbody>");
			sb.append("</table>");
		} else {
		}

		if (listOfBackCoverForm != null && !listOfBackCoverForm.isEmpty()) {
			sb.append("<table border='1'>");
			sb.append("<thead>");
			sb.append(
					"<tr><th>Product Brand</th><th>Product Model</th><th>Product Price</th><th>ArrivedDateTime</th></tr>");
			sb.append("</thead>");
			sb.append("<tbody>");
			for (BackCoverForm eachProduct : listOfBackCoverForm) {
				sb.append("<tr>");
				sb.append("<td>").append(eachProduct.getProductBrand()).append("</td>");
				sb.append("<td>").append(eachProduct.getProductModel()).append("</td>");
				sb.append("<td>").append(eachProduct.getProductPrice()).append("</td>");
				sb.append("<td>").append(eachProduct.getArrivedDateTime()).append("</td>");

				sb.append("</tr>");
			}

		} else {
		}

		sb.append("</body>");
		sb.append("</html>");

		pw.println(sb.toString());
	}
}
