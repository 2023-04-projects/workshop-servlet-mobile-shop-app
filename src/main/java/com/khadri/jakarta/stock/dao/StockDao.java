package com.khadri.jakarta.stock.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.khadri.jakarta.stock.form.BackCoverForm;
import com.khadri.jakarta.stock.form.ChargerForm;
import com.khadri.jakarta.stock.form.HeadSetForm;
import com.khadri.jakarta.stock.form.MobileForm;
import com.khadri.jakarta.stock.form.PowerBankForm;
import com.khadri.jakarta.stock.form.StockForm;

public class StockDao {
	Connection con;
	PreparedStatement pstmt;
	MobileForm mobileForm;
	ChargerForm chargerForm;
	PowerBankForm powerBankForm;
	HeadSetForm headSetForm;
	BackCoverForm backCoverForm;

	// StockProductForm stockProductForm = new StockProductForm();

	public StockForm selectStockTypeRecord(String type) {
		System.out.println("StockDao insertStock(-)");
		StockForm form = null;
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/2024_batch_workshop_servlet_mobile_shop_app",
					"root", "root");
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
		con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/2024_batch_workshop_servlet_mobile_shop_app",
				"root", "root");

		PreparedStatement ps = con.prepareStatement("UPDATE stock SET qty = ? WHERE type = ?");
		ps.setInt(1, qty);
		ps.setString(2, type);
		ps.executeUpdate();
	}

	public void insertIntoStock(String type, int qty) throws Exception {
		con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/2024_batch_workshop_servlet_mobile_shop_app",
				"root", "root");

		PreparedStatement ps = con.prepareStatement("INSERT INTO stock (type, qty) VALUES (?, ?)");
		ps.setString(1, type);
		ps.setInt(2, qty);
		ps.executeUpdate();
	}

	public void insertMobile(MobileForm mobileForm) throws SQLException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/2024_batch_workshop_servlet_mobile_shop_app",
					"root", "root");

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

			con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/2024_batch_workshop_servlet_mobile_shop_app",
					"root", "root");

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

			con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/2024_batch_workshop_servlet_mobile_shop_app",
					"root", "root");

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

			con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/2024_batch_workshop_servlet_mobile_shop_app",
					"root", "root");

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

			con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/2024_batch_workshop_servlet_mobile_shop_app",
					"root", "root");

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

	public List<ChargerForm> viewChargerData(String product_brand, String product_model) {
		System.out.println("stockDao viewChargerData(-)");
		List<ChargerForm> listOfData = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:MySQL://localhost:3306/2024_batch_workshop_servlet_mobile_shop_app", "root", "root");

			PreparedStatement pstmt = con
					.prepareStatement("SELECT * FROM charger WHERE product_brand = ? AND product_model = ?");

			// Set parameters
			pstmt.setString(1, product_brand);
			pstmt.setString(2, product_model);

			// Execute the query
			ResultSet resultSet = pstmt.executeQuery();
			System.out.println("Executing viewChargerData query");

			// Process the result
			while (resultSet.next()) {
				// Use the constructor to create a new MobileForm instance
				mobileForm = new MobileForm(resultSet.getString("product_brand"), resultSet.getDouble("product_price"),
						resultSet.getString("product_model"), resultSet.getDate("arrived_date_time"));

				listOfData.add(chargerForm); // Add the populated mobileForm to the list
			}

		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: " + e);
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQLException: " + e);
			e.printStackTrace();
		}

		return listOfData;
	}

	public List<HeadSetForm> viewHeadSetData(String product_brand, String product_model) {
		System.out.println("stockDao viewHeadSetData(-)");
		List<HeadSetForm> listOfData = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:MySQL://localhost:3306/2024_batch_workshop_servlet_mobile_shop_app", "root", "root");

			PreparedStatement pstmt = con
					.prepareStatement("SELECT * FROM headSet WHERE product_brand = ? AND product_model = ?");

			// Set parameters
			pstmt.setString(1, product_brand);
			pstmt.setString(2, product_model);

			// Execute the query
			ResultSet resultSet = pstmt.executeQuery();
			System.out.println("Executing viewHeadSet query");

			// Process the result
			while (resultSet.next()) {
				// Use the constructor to create a new MobileForm instance
				HeadSetForm headSetForm = new HeadSetForm(resultSet.getString("product_brand"),
						resultSet.getDouble("product_price"), resultSet.getString("product_model"),
						resultSet.getDate("arrived_date_time"));

				listOfData.add(headSetForm); // Add the populated mobileForm to the list
			}

		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: " + e);
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQLException: " + e);
			e.printStackTrace();
		}

		return listOfData;
	}

	public List<PowerBankForm> viewPowerBankData(String product_brand, String product_model) {
		System.out.println("stockDao viewPowerBankData(-)");
		List<PowerBankForm> listOfData = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:MySQL://localhost:3306/2024_batch_workshop_servlet_mobile_shop_app", "root", "root");

			PreparedStatement pstmt = con
					.prepareStatement("SELECT * FROM powerBank WHERE product_brand = ? AND product_model = ?");

			// Set parameters
			pstmt.setString(1, product_brand);
			pstmt.setString(2, product_model);

			// Execute the query
			ResultSet resultSet = pstmt.executeQuery();
			System.out.println("Executing viewPowerBankData query");

			// Process the result
			while (resultSet.next()) {
				// Use the constructor to create a new MobileForm instance
				PowerBankForm powerBankForm = new PowerBankForm(resultSet.getString("product_brand"),
						resultSet.getDouble("product_price"), resultSet.getString("product_model"),
						resultSet.getDate("arrived_date_time"));

				listOfData.add(powerBankForm); // Add the populated mobileForm to the list
			}

		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: " + e);
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQLException: " + e);
			e.printStackTrace();
		}

		return listOfData;
	}

	public List<BackCoverForm> viewBackCoverData(String product_brand, String product_model) {
		System.out.println("stockDao viewBackCoverData(-)");
		List<BackCoverForm> listOfData = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:MySQL://localhost:3306/2024_batch_workshop_servlet_mobile_shop_app", "root", "root");

			PreparedStatement pstmt = con
					.prepareStatement("SELECT * FROM backCover WHERE product_brand = ? AND product_model = ?");

			// Set parameters
			pstmt.setString(1, product_brand);
			pstmt.setString(2, product_model);

			// Execute the query
			ResultSet resultSet = pstmt.executeQuery();
			System.out.println("Executing viewBackCoverData query");

			// Process the result
			while (resultSet.next()) {
				// Use the constructor to create a new MobileForm instance
				BackCoverForm backCoverForm = new BackCoverForm(resultSet.getString("product_brand"),
						resultSet.getDouble("product_price"), resultSet.getString("product_model"),
						resultSet.getDate("arrived_date_time"));

				listOfData.add(backCoverForm); // Add the populated mobileForm to the list
			}

		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: " + e);
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQLException: " + e);
			e.printStackTrace();
		}

		return listOfData;
	}

	public List<MobileForm> viewMobileData(String product_brand, String product_model) {
		System.out.println("stockDao viewMobileData(-)");
		List<MobileForm> listOfData = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:MySQL://localhost:3306/2024_batch_workshop_servlet_mobile_shop_app", "root", "root");

			PreparedStatement pstmt = con
					.prepareStatement("SELECT * FROM mobile WHERE product_brand = ? AND product_model = ?");

			// Set parameters
			pstmt.setString(1, product_brand);
			pstmt.setString(2, product_model);

			// Execute the query
			ResultSet resultSet = pstmt.executeQuery();
			System.out.println("Executing viewMobileData query");

			// Process the result
			while (resultSet.next()) {
				// Use the constructor to create a new MobileForm instance
				MobileForm mobileForm = new MobileForm(resultSet.getString("product_brand"),
						resultSet.getDouble("product_price"), resultSet.getString("product_model"),
						resultSet.getDate("arrived_date_time"));

				listOfData.add(mobileForm); // Add the populated mobileForm to the list
			}

		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: " + e);
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQLException: " + e);
			e.printStackTrace();
		}

		return listOfData;
	}

	public boolean deleteMobile(String product_brand, String product_model) {

		boolean deleted = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(
					"jdbc:MySQL://localhost:3306/2024_batch_workshop_servlet_mobile_shop_app", "root", "root");

			PreparedStatement pstmt = con
					.prepareStatement("DELETE FROM mobile WHERE  product_brand = ? AND product_model = ?");
			pstmt.setString(1, product_brand);
			pstmt.setString(2, product_model);

			int rowsAffected = pstmt.executeUpdate();
			deleted = rowsAffected > 0; // If rowsAffected is more than 0, deletion was successful
		} catch (SQLException e) {
			System.out.println("SQLException occured:" + e);
			e.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			System.out.println("ClassNotFoundException occured:" + cnfe);
			cnfe.printStackTrace();
		}

		return deleted;

	}

	public boolean deleteCharger(String product_brand, String product_model) {

		boolean deleted = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(
					"jdbc:MySQL://localhost:3306/2024_batch_workshop_servlet_mobile_shop_app", "root", "root");

			PreparedStatement pstmt = con
					.prepareStatement("DELETE FROM charger WHERE  product_brand = ? AND product_model = ?");
			pstmt.setString(1, product_brand);
			pstmt.setString(2, product_model);

			int rowsAffected = pstmt.executeUpdate();
			deleted = rowsAffected > 0; // If rowsAffected is more than 0, deletion was successful
		} catch (SQLException e) {
			System.out.println("SQLException occured:" + e);
			e.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			System.out.println("ClassNotFoundException occured:" + cnfe);
			cnfe.printStackTrace();
		}

		return deleted;

	}

	public boolean deletePowerBank(String product_brand, String product_model) {

		boolean deleted = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(
					"jdbc:MySQL://localhost:3306/2024_batch_workshop_servlet_mobile_shop_app", "root", "root");

			PreparedStatement pstmt = con
					.prepareStatement("DELETE FROM powerbank WHERE  product_brand = ? AND product_model = ?");
			pstmt.setString(1, product_brand);
			pstmt.setString(2, product_model);

			int rowsAffected = pstmt.executeUpdate();
			deleted = rowsAffected > 0; // If rowsAffected is more than 0, deletion was successful
		} catch (SQLException e) {
			System.out.println("SQLException occured:" + e);
			e.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			System.out.println("ClassNotFoundException occured:" + cnfe);
			cnfe.printStackTrace();
		}

		return deleted;

	}

	public boolean deleteHeadSet(String product_brand, String product_model) {

		boolean deleted = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(
					"jdbc:MySQL://localhost:3306/2024_batch_workshop_servlet_mobile_shop_app", "root", "root");

			PreparedStatement pstmt = con
					.prepareStatement("DELETE FROM headset WHERE  product_brand = ? AND product_model = ?");
			pstmt.setString(1, product_brand);
			pstmt.setString(2, product_model);

			int rowsAffected = pstmt.executeUpdate();
			deleted = rowsAffected > 0; // If rowsAffected is more than 0, deletion was successful
		} catch (SQLException e) {
			System.out.println("SQLException occured:" + e);
			e.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			System.out.println("ClassNotFoundException occured:" + cnfe);
			cnfe.printStackTrace();
		}

		return deleted;

	}

	public boolean deleteBackCover(String product_brand, String product_model) {

		boolean deleted = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(
					"jdbc:MySQL://localhost:3306/2024_batch_workshop_servlet_mobile_shop_app", "root", "root");

			PreparedStatement pstmt = con
					.prepareStatement("DELETE FROM backcover WHERE  product_brand = ? AND product_model = ?");
			pstmt.setString(1, product_brand);
			pstmt.setString(2, product_model);

			int rowsAffected = pstmt.executeUpdate();
			deleted = rowsAffected > 0; // If rowsAffected is more than 0, deletion was successful
		} catch (SQLException e) {
			System.out.println("SQLException occured:" + e);
			e.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			System.out.println("ClassNotFoundException occured:" + cnfe);
			cnfe.printStackTrace();
		}

		return deleted;

	}
}
