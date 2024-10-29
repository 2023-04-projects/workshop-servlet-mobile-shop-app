package com.khadri.stock.mobile.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.khadri.stock.mobile.form.MobileForm;
import com.khadri.stock.mobile.form.StockForm;

public class StockDao {
	Connection con;
	PreparedStatement pstmt;
	

	public StockForm selectStockTypeRecord(String type) {
		System.out.println("StockDao insertStock(-)");
		StockForm form = null;
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/2024_batch_mobile_shop", "root", "root");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM stock WHERE type = '" + type + "'");

			if (rs.next()) {
				form = new StockForm(result, rs.getString("type"), rs.getInt("qty"));
			}

		} catch (Exception e) {
			System.out.println("Exception Occured : " + e);
			e.printStackTrace();
		}
		return form;

	}

	public void updateStockQty(String type, int qty) throws Exception {
		con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/2024_batch_mobile_shop", "root", "root");

		PreparedStatement ps = con.prepareStatement("UPDATE stock SET qty = ? WHERE type = ?");
		ps.setInt(1, qty);
		ps.setString(2, type);
		ps.executeUpdate();
	}

	public void insertIntoStock(String type, int qty) throws Exception {
		con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/2024_batch_mobile_shop", "root", "root");

		PreparedStatement ps = con.prepareStatement("INSERT INTO stock (type, qty) VALUES (?, ?)");
		ps.setString(1, type);
		ps.setInt(2, qty);
		ps.executeUpdate();
	}

	
}
