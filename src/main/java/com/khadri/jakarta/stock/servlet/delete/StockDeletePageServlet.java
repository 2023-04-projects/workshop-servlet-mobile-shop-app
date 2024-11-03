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

    @Override
    public void init() throws ServletException {
        stockDao = new StockDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String type = request.getParameter("type");
        String product_brand = request.getParameter("product_brand"); // Correct parameter name
        String product_model = request.getParameter("product_model"); // Correct parameter name

        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        
        StringBuffer sb = new StringBuffer();

        if (type == null || type.isEmpty()) {
            // If 'type' is not provided, show the form to enter details
            sb.append("<form action='StockDeletePageServlet' method='get'>");
            sb.append("<label>Type:</label>");
            sb.append("<select name='type' id='type'>");
            sb.append("<option value=''>--select--</option>");
            sb.append("<option value='Mobile'>Mobile</option>");
            sb.append("<option value='Charger'>Charger</option>");
            sb.append("<option value='PowerBank'>PowerBank</option>");
            sb.append("<option value='HeadSet'>HeadSet</option>");
            sb.append("<option value='BackCover'>BackCover</option>");
            sb.append("</select><br/>");
            sb.append("<label>Product Brand:</label><input type='text' name='product_brand' required><br/>");
            sb.append("<label>Product Model:</label><input type='text' name='product_model' required><br/>");
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

         // Display the form if no type is provided or after deletion attempt
         pw.println(sb.toString());
        }
//            // If type is provided, attempt to delete the mobile entry
//            boolean isMobileDeleted = stockDao.deleteMobile(product_brand, product_model);
//            boolean isChargerDeleted = stockDao.deleteCharger(product_brand, product_model);
//          //  boolean isDeleted = stockDao.deleteMobile(product_brand, product_model);
//           // boolean isDeleted = stockDao.deleteMobile(product_brand, product_model);
//          //  boolean isDeleted = stockDao.deleteMobile(product_brand, product_model);
//
//            if (isDeleted) {
//                pw.println("entry deleted successfully.");
//            } else {
//                pw.println("Failed to delete  entry. Please check the details.");
//            }
//        }
//
//        // Display the form if no type is provided or after deletion attempt
//        pw.println(sb.toString());
    
}
