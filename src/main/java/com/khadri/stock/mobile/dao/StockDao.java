package com.khadri.stock.mobile.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.khadri.stock.mobile.form.StockForm;

public class StockDao {
	Connection con;
	PreparedStatement pstmt ;
	
	public StockForm getInsertStock(String type){
		System.out.println("StockDao insertStock(-)");
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			 DriverManager.getConnection("jdbc:MySQL://localhost:3306/2024_batch_mobile_shop",
					"root", "root");
		        Statement stmt = con.createStatement();
		        ResultSet rs=  stmt.executeQuery("SELECT * FROM stock WHERE type = '"+type+"'");
		        
		        rs.updateString(1,type );

		        if (rs.next()) {
		            return new StockForm(result, rs.getString("type"), rs.getInt("qty"));
		        }
		       
		}  catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
	}
		    public void updateStockQty(String type, int qty) throws Exception {
		        String sql = "UPDATE stock SET qty = ? WHERE type = ?";
		        PreparedStatement ps = con.prepareStatement(sql);
		        ps.setInt(1, qty);
		        ps.setString(2, type);
		        ps.executeUpdate();
		    }

		    public void insertIntoStock(String type, int qty) throws Exception {
		        String sql = "INSERT INTO stock (type, qty) VALUES (?, ?)";
		        PreparedStatement ps = con.prepareStatement(sql);
		        ps.setString(1, type);
		        ps.setInt(2, qty);
		        ps.executeUpdate();
		    }
		  
		    public void insertMobileTypeData() throws Exception {
		     //   Connection conn = DatabaseConnection.getConnection();
		        String sql = "INSERT INTO mobile (specific_fields) VALUES (values)";
		        PreparedStatement ps = con.prepareStatement(sql);
		        // set values for specific_fields
		        ps.executeUpdate();
		    }
	}
		
		
		
		
	//Class.forName("com.mysql.cj.jdbc.Driver");
	
	//pstmt = con.prepareStatement("insert into stock values(?,?,?,?,?)");
		
		
		
		
		
		
		
		
	