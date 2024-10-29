package com.khadri.stock.mobile.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.khadri.stock.mobile.form.MobileForm;

public class MobileDao {
	MobileForm mobileForm;
	Connection con;
	 public void insertMobile(MobileForm mobileForm) throws SQLException {
		 
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		 
			con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/2024_batch_mobile_shop", "root", "root");
			
	             PreparedStatement statement = con.prepareStatement("INSERT INTO mobile (productBrand, productPrice, productModel, arrivedDateTime) VALUES (?, ?, ?,?)"); 
	            statement.setString(1, mobileForm.getProductBrand());
	            statement.setDouble(2, mobileForm.getProductprice());
	            statement.setString(3, mobileForm.getProductModel());
	            statement.setDate(4, mobileForm.getArrivedDateTime());

	            statement.executeUpdate();
		 }
	            catch (ClassNotFoundException e) {
	            	System.out.println("ClassNotFoundException "+e);
	    			e.printStackTrace();
	    		}
	        
	    }

}
