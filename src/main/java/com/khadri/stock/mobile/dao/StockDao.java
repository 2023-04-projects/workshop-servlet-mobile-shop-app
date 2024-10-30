package com.khadri.stock.mobile.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.khadri.stock.mobile.form.BackCoverForm;
import com.khadri.stock.mobile.form.ChargerForm;
import com.khadri.stock.mobile.form.HeadSetForm;
import com.khadri.stock.mobile.form.MobileForm;
import com.khadri.stock.mobile.form.PowerBankForm;
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
			con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/2024_batch_mobile_app", "root", "root");
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
		con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/2024_batch_mobile_app", "root", "root");

		PreparedStatement ps = con.prepareStatement("UPDATE stock SET qty = ? WHERE type = ?");
		ps.setInt(1, qty);
		ps.setString(2, type);
		ps.executeUpdate();
	}

	public void insertIntoStock(String type, int qty) throws Exception {
		con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/2024_batch_mobile_app", "root", "root");

		PreparedStatement ps = con.prepareStatement("INSERT INTO stock (type, qty) VALUES (?, ?)");
		ps.setString(1, type);
		ps.setInt(2, qty);
		ps.executeUpdate();
	}
	public void insertMobile(MobileForm mobileForm) throws SQLException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/2024_batch_mobile_app", "root", "root");

			PreparedStatement statement = con.prepareStatement(
					"INSERT INTO mobile (Product_brand, product_price, product_model, arrived_date_time) VALUES (?, ?, ?,?)");
			statement.setString(1, mobileForm.getProductBrand());
			statement.setDouble(2, mobileForm.getProductPrice());
			statement.setString(3, mobileForm.getProductModel());
			statement.setDate(4, mobileForm.getArrivedDateTime());

			statement.executeUpdate();
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException " + e);
			e.printStackTrace();
		}
	}
		public void insertCharger(ChargerForm chargerForm) throws SQLException {

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");

				con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/2024_batch_mobile_app", "root", "root");

				PreparedStatement statement = con.prepareStatement(
						"INSERT INTO charger(Product_brand, product_price, product_model, arrived_date_time) VALUES (?, ?, ?,?)");
				statement.setString(1, chargerForm.getProductBrand());
				statement.setDouble(2, chargerForm.getProductPrice());
				statement.setString(3, chargerForm.getProductModel());
				statement.setDate(4, chargerForm.getArrivedDateTime());

				statement.executeUpdate();
			} catch (ClassNotFoundException e) {
				System.out.println("ClassNotFoundException " + e);
				e.printStackTrace();
			}

		}
		public void insertHeadSet(HeadSetForm headSetForm) throws SQLException {

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");

				con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/2024_batch_mobile_app", "root", "root");

				PreparedStatement statement = con.prepareStatement(
						"INSERT INTO headset (Product_brand, product_price, product_model, arrived_date_time) VALUES (?, ?, ?,?)");
				statement.setString(1, headSetForm.getProductBrand());
				statement.setDouble(2, headSetForm.getProductPrice());
				statement.setString(3, headSetForm.getProductModel());
				statement.setDate(4, headSetForm.getArrivedDateTime());

				statement.executeUpdate();
			} catch (ClassNotFoundException e) {
				System.out.println("ClassNotFoundException " + e);
				e.printStackTrace();
			}
		}
		
		public void insertPowerBank(PowerBankForm powerBankForm) throws SQLException {

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");

				con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/2024_batch_mobile_app", "root", "root");

				PreparedStatement statement = con.prepareStatement(
						"INSERT INTO powerbank (Product_brand, product_price, product_model, arrived_date_time) VALUES (?, ?, ?,?)");
				statement.setString(1, powerBankForm.getProductBrand());
				statement.setDouble(2, powerBankForm.getProductPrice());
				statement.setString(3, powerBankForm.getProductModel());
				statement.setDate(4, powerBankForm.getArrivedDateTime());

				statement.executeUpdate();
			} catch (ClassNotFoundException e) {
				System.out.println("ClassNotFoundException " + e);
				e.printStackTrace();
			}
		}
		
		public void insertBackCover(BackCoverForm backCoverForm) throws SQLException {

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");

				con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/2024_batch_mobile_app", "root", "root");

				PreparedStatement statement = con.prepareStatement(
						"INSERT INTO backcover (Product_brand, product_price, product_model, arrived_date_time) VALUES (?, ?, ?,?)");
				statement.setString(1, backCoverForm.getProductBrand());
				statement.setDouble(2, backCoverForm.getProductPrice());
				statement.setString(3, backCoverForm.getProductModel());
				statement.setDate(4, backCoverForm.getArrivedDateTime());

				statement.executeUpdate();
			} catch (ClassNotFoundException e) {
				System.out.println("ClassNotFoundException " + e);
				e.printStackTrace();
			}
		}
	}


