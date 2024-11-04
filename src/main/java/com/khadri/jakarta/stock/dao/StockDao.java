package com.khadri.jakarta.stock.dao;

import java.sql.Connection;
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
import com.khadri.jakartha.jdbc.prepare.connection.JdbcConnectionUtil;

import jakarta.servlet.http.HttpServletRequest;

public class StockDao {
	Connection con;
	PreparedStatement pstmt;
	MobileForm mobileForm;
	ChargerForm chargerForm;
	PowerBankForm powerbankForm;
	HeadSetForm headsetForm;
	BackCoverForm backcoverForm;

	public StockForm selectStockTypeRecord(String type, HttpServletRequest req) {
		System.out.println("StockDao insertStock(-)");
		StockForm form = null;
		int result = 0;
		try {
			con = JdbcConnectionUtil.getConnection();

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

	public void updateStockQty(String type, int qty) {

		PreparedStatement ps;
		try {
			con = JdbcConnectionUtil.getConnection();
			ps = con.prepareStatement("UPDATE stock SET qty = ? WHERE type = ?");
			ps.setInt(1, qty);
			ps.setString(2, type);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQLException:" + e);
			e.printStackTrace();
		}
	}

	public void insertIntoStock(String type, int qty) {

		PreparedStatement ps;
		try {
			con = JdbcConnectionUtil.getConnection();

			ps = con.prepareStatement("INSERT INTO stock (type, qty) VALUES (?, ?)");
			ps.setString(1, type);
			ps.setInt(2, qty);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQLException:" + e);
			e.printStackTrace();
		}
	}

	public void insertMobile(MobileForm mobileForm) {

		try {
			con = JdbcConnectionUtil.getConnection();

			PreparedStatement statement = con.prepareStatement(
					"INSERT INTO mobile (Product_brand, product_price, product_model, arrived_date_time) VALUES (?, ?, ?,?)");
			statement.setString(1, mobileForm.getProductBrand());
			statement.setDouble(2, mobileForm.getProductPrice());
			statement.setString(3, mobileForm.getProductModel());
			statement.setDate(4, mobileForm.getArrivedDateTime());

			statement.executeUpdate();

		} catch (SQLException sqle) {
			System.out.println("SqlException " + sqle);
			sqle.printStackTrace();
		}
	}

	public void insertCharger(ChargerForm chargerForm) {
		try {
			con = JdbcConnectionUtil.getConnection();

			PreparedStatement statement = con.prepareStatement(
					"INSERT INTO charger(Product_brand, product_price, product_model, arrived_date_time) VALUES (?, ?, ?,?)");
			statement.setString(1, chargerForm.getProductBrand());
			statement.setDouble(2, chargerForm.getProductPrice());
			statement.setString(3, chargerForm.getProductModel());
			statement.setDate(4, chargerForm.getArrivedDateTime());

			statement.executeUpdate();
		} catch (SQLException sqle) {
			System.out.println("SqlException " + sqle);
			sqle.printStackTrace();
		}
	}

	public void insertHeadSet(HeadSetForm headSetForm) {

		try {
			con = JdbcConnectionUtil.getConnection();

			PreparedStatement statement = con.prepareStatement(
					"INSERT INTO headset (Product_brand, product_price, product_model, arrived_date_time) VALUES (?, ?, ?,?)");
			statement.setString(1, headSetForm.getProductBrand());
			statement.setDouble(2, headSetForm.getProductPrice());
			statement.setString(3, headSetForm.getProductModel());
			statement.setDate(4, headSetForm.getArrivedDateTime());

			statement.executeUpdate();
		} catch (SQLException sqle) {
			System.out.println("SqlException " + sqle);
			sqle.printStackTrace();
		}
	}

	public void insertPowerBank(PowerBankForm powerBankForm) {

		try {
			con = JdbcConnectionUtil.getConnection();

			PreparedStatement statement = con.prepareStatement(
					"INSERT INTO powerbank (Product_brand, product_price, product_model, arrived_date_time) VALUES (?, ?, ?,?)");
			statement.setString(1, powerBankForm.getProductBrand());
			statement.setDouble(2, powerBankForm.getProductPrice());
			statement.setString(3, powerBankForm.getProductModel());
			statement.setDate(4, powerBankForm.getArrivedDateTime());

			statement.executeUpdate();
		} catch (SQLException sqle) {
			System.out.println("SqlException " + sqle);
			sqle.printStackTrace();
		}
	}

	public void insertBackCover(BackCoverForm backCoverForm) {

		try {
			con = JdbcConnectionUtil.getConnection();

			PreparedStatement statement = con.prepareStatement(
					"INSERT INTO backcover (Product_brand, product_price, product_model, arrived_date_time) VALUES (?, ?, ?,?)");
			statement.setString(1, backCoverForm.getProductBrand());
			statement.setDouble(2, backCoverForm.getProductPrice());
			statement.setString(3, backCoverForm.getProductModel());
			statement.setDate(4, backCoverForm.getArrivedDateTime());

			statement.executeUpdate();
		} catch (SQLException sqle) {
			System.out.println("SqlException " + sqle);
			sqle.printStackTrace();
		}
	}

	public List<MobileForm> viewMobileData(String product_brand, String product_model) {
		System.out.println("stockDao viewMobileData(-)");
		List<MobileForm> listOfData = new ArrayList<>();
		try {
			con = JdbcConnectionUtil.getConnection();

			PreparedStatement pstmt = con

					.prepareStatement("SELECT * FROM mobile WHERE product_brand = ? AND product_model = ?");

			pstmt.setString(1, product_brand);
			pstmt.setString(2, product_model);

			ResultSet resultSet = pstmt.executeQuery();
			System.out.println("Executing viewMobileData query");

			while (resultSet.next()) {
				MobileForm mobileForm = new MobileForm(resultSet.getString("product_brand"),
						resultSet.getDouble("product_price"), resultSet.getString("product_model"),
						resultSet.getDate("arrived_date_time"));

				listOfData.add(mobileForm);
			}

		} catch (SQLException e) {
			System.out.println("SQLException: " + e);
			e.printStackTrace();
		}

		return listOfData;
	}

	public List<ChargerForm> viewChargerData(String product_brand, String product_model) {
		System.out.println("stockDao viewChargerData(-)");
		List<ChargerForm> listOfData = new ArrayList<>();
		try {
			con = JdbcConnectionUtil.getConnection();

			PreparedStatement pstmt = con

					.prepareStatement("SELECT * FROM charger WHERE product_brand = ? AND product_model = ?");

			pstmt.setString(1, product_brand);
			pstmt.setString(2, product_model);
			ResultSet resultSet = pstmt.executeQuery();
			System.out.println("Executing viewChargerData query");

			while (resultSet.next()) {
				ChargerForm chargerForm = new ChargerForm(resultSet.getString("product_brand"),
						resultSet.getDouble("product_price"), resultSet.getString("product_model"),
						resultSet.getDate("arrived_date_time"));

				listOfData.add(chargerForm);
			}

		} catch (SQLException sqle) {
			System.out.println("SQLException: " + sqle);
			sqle.printStackTrace();
		}

		return listOfData;
	}

	public List<PowerBankForm> viewPowerBankData(String product_brand, String product_model) {
		System.out.println("stockDao viewPowerBankData(-)");
		List<PowerBankForm> listOfData = new ArrayList<>();
		try {
			con = JdbcConnectionUtil.getConnection();

			PreparedStatement pstmt = con

					.prepareStatement("SELECT * FROM powerbank WHERE product_brand = ? AND product_model = ?");

			pstmt.setString(1, product_brand);
			pstmt.setString(2, product_model);
			ResultSet resultSet = pstmt.executeQuery();
			System.out.println("Executing viewPowerBankData query");

			while (resultSet.next()) {
				PowerBankForm powerbankForm = new PowerBankForm(resultSet.getString("product_brand"),
						resultSet.getDouble("product_price"), resultSet.getString("product_model"),
						resultSet.getDate("arrived_date_time"));

				listOfData.add(powerbankForm);
			}

		} catch (SQLException e) {
			System.out.println("SQLException: " + e);
			e.printStackTrace();
		}

		return listOfData;
	}

	public List<HeadSetForm> viewHeadSetData(String product_brand, String product_model) {
		System.out.println("stockDao viewPowerBankData(-)");
		List<HeadSetForm> listOfData = new ArrayList<>();
		try {
			con = JdbcConnectionUtil.getConnection();

			PreparedStatement pstmt = con
					.prepareStatement("SELECT * FROM headset WHERE product_brand = ? AND product_model = ?");

			pstmt.setString(1, product_brand);
			pstmt.setString(2, product_model);
			ResultSet resultSet = pstmt.executeQuery();
			System.out.println("Executing viewHeadSetData query");

			while (resultSet.next()) {
				HeadSetForm headsetForm = new HeadSetForm(resultSet.getString("product_brand"),
						resultSet.getDouble("product_price"), resultSet.getString("product_model"),
						resultSet.getDate("arrived_date_time"));

				listOfData.add(headsetForm);
			}

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
			con = JdbcConnectionUtil.getConnection();

			PreparedStatement pstmt = con

					.prepareStatement("SELECT * FROM backcover WHERE product_brand = ? AND product_model = ?");

			pstmt.setString(1, product_brand);
			pstmt.setString(2, product_model);
			ResultSet resultSet = pstmt.executeQuery();
			System.out.println("Executing viewHeadSetData query");

			while (resultSet.next()) {
				BackCoverForm backcoverForm = new BackCoverForm(resultSet.getString("product_brand"),
						resultSet.getDouble("product_price"), resultSet.getString("product_model"),
						resultSet.getDate("arrived_date_time"));

				listOfData.add(backcoverForm);
			}

		} catch (SQLException e) {
			System.out.println("SQLException: " + e);
			e.printStackTrace();
		}

		return listOfData;
	}

	public boolean deleteMobile(String product_brand, String product_model) {

		boolean deleted = false;
		try {
			con = JdbcConnectionUtil.getConnection();

			PreparedStatement pstmt = con
					.prepareStatement("DELETE FROM mobile WHERE  product_brand = ? AND product_model = ?");
			pstmt.setString(1, product_brand);
			pstmt.setString(2, product_model);

			int rowsAffected = pstmt.executeUpdate();
			deleted = rowsAffected > 0;
		} catch (SQLException e) {
			System.out.println("SQLException occured:" + e);
			e.printStackTrace();
		}

		return deleted;

	}

	public boolean deleteCharger(String product_brand, String product_model) {

		boolean deleted = false;
		try {
			con = JdbcConnectionUtil.getConnection();

			PreparedStatement pstmt = con
					.prepareStatement("DELETE FROM charger WHERE  product_brand = ? AND product_model = ?");
			pstmt.setString(1, product_brand);
			pstmt.setString(2, product_model);

			int rowsAffected = pstmt.executeUpdate();
			deleted = rowsAffected > 0;
		} catch (SQLException e) {
			System.out.println("SQLException occured:" + e);
			e.printStackTrace();
		}

		return deleted;

	}

	public boolean deletePowerBank(String product_brand, String product_model) {

		boolean deleted = false;
		try {
			con = JdbcConnectionUtil.getConnection();

			PreparedStatement pstmt = con
					.prepareStatement("DELETE FROM powerbank WHERE  product_brand = ? AND product_model = ?");
			pstmt.setString(1, product_brand);
			pstmt.setString(2, product_model);

			int rowsAffected = pstmt.executeUpdate();
			deleted = rowsAffected > 0;
		} catch (SQLException e) {
			System.out.println("SQLException occured:" + e);
			e.printStackTrace();
		}

		return deleted;

	}

	public boolean deleteHeadSet(String product_brand, String product_model) {

		boolean deleted = false;
		try {
			con = JdbcConnectionUtil.getConnection();

			PreparedStatement pstmt = con
					.prepareStatement("DELETE FROM headset WHERE  product_brand = ? AND product_model = ?");
			pstmt.setString(1, product_brand);
			pstmt.setString(2, product_model);

			int rowsAffected = pstmt.executeUpdate();
			deleted = rowsAffected > 0;
		} catch (SQLException e) {
			System.out.println("SQLException occured:" + e);
			e.printStackTrace();
		}
		return deleted;

	}

	public boolean deleteBackCover(String product_brand, String product_model) {

		boolean deleted = false;
		try {
			con = JdbcConnectionUtil.getConnection();

			PreparedStatement pstmt = con
					.prepareStatement("DELETE FROM backcover WHERE  product_brand = ? AND product_model = ?");
			pstmt.setString(1, product_brand);
			pstmt.setString(2, product_model);

			int rowsAffected = pstmt.executeUpdate();
			deleted = rowsAffected > 0;
		} catch (SQLException e) {
			System.out.println("SQLException occured:" + e);
			e.printStackTrace();
		}

		return deleted;

	}

	public void updateMobilePrice(Double productPrice, String productModel) {

		PreparedStatement ps;
		try {
			con = JdbcConnectionUtil.getConnection();

			ps = con.prepareStatement("UPDATE mobile SET product_price = ? WHERE product_model = ?");
			ps.setDouble(1, productPrice);
			ps.setString(2, productModel);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQLException:" + e);
			e.printStackTrace();
		}
	}

	public void updateChargerPrice(Double productPrice, String productModel) {

		PreparedStatement ps;
		try {
			con = JdbcConnectionUtil.getConnection();

			ps = con.prepareStatement("UPDATE charger SET product_price = ? WHERE product_model = ?");
			ps.setDouble(1, productPrice);
			ps.setString(2, productModel);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQLException:" + e);

			e.printStackTrace();
		}
	}

	public void updatePowerBankPrice(Double productPrice, String productModel) {

		PreparedStatement ps;
		try {
			con = JdbcConnectionUtil.getConnection();

			ps = con.prepareStatement("UPDATE powerbank SET product_price = ? WHERE product_model = ?");
			ps.setDouble(1, productPrice);
			ps.setString(2, productModel);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQLException:" + e);

			e.printStackTrace();
		}
	}

	public void updateHeadSetPrice(Double productPrice, String productModel) {

		PreparedStatement ps;
		try {
			con = JdbcConnectionUtil.getConnection();

			ps = con.prepareStatement("UPDATE headset SET product_price = ? WHERE product_model = ?");
			ps.setDouble(1, productPrice);
			ps.setString(2, productModel);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQLException:" + e);

			e.printStackTrace();
		}
	}

	public void updateBackCoverPrice(Double productPrice, String productModel) {

		PreparedStatement ps;
		try {
			con = JdbcConnectionUtil.getConnection();

			ps = con.prepareStatement("UPDATE backcover SET product_price = ? WHERE product_model = ?");
			ps.setDouble(1, productPrice);
			ps.setString(2, productModel);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQLException:" + e);

			e.printStackTrace();
		}
	}

	public List<MobileForm> viewAllMobileData() {
		System.out.println("stockDao ViewAllMobileData(-)");
		List<MobileForm> listOfData = new ArrayList<>();
		try {
			con = JdbcConnectionUtil.getConnection();

			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM mobile  ");
			ResultSet resultSet = pstmt.executeQuery();
			System.out.println("Executing ViewAllMobileData ");

			while (resultSet.next()) {
				MobileForm mobileForm = new MobileForm(resultSet.getString("product_brand"),
						resultSet.getDouble("product_price"), resultSet.getString("product_model"),
						resultSet.getDate("arrived_date_time"));

				listOfData.add(mobileForm);
			}

		} catch (SQLException e) {
			System.out.println("SQLException: " + e);
			e.printStackTrace();
		}

		return listOfData;
	}

	public List<ChargerForm> viewAllChargerData() {
		System.out.println("stockDao ViewAllChargerData(-)");
		List<ChargerForm> listOfData = new ArrayList<>();
		try {
			con = JdbcConnectionUtil.getConnection();

			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM charger ");

			ResultSet resultSet = pstmt.executeQuery();
			System.out.println("Executing ViewAllChargerData query");

			while (resultSet.next()) {
				ChargerForm chargerForm = new ChargerForm(resultSet.getString("product_brand"),
						resultSet.getDouble("product_price"), resultSet.getString("product_model"),
						resultSet.getDate("arrived_date_time"));

				listOfData.add(chargerForm);
			}

		} catch (SQLException e) {
			System.out.println("SQLException: " + e);
			e.printStackTrace();
		}

		return listOfData;
	}

	public List<PowerBankForm> viewAllPowerBankData() {
		System.out.println("stockDao ViewAllPowerBankData(-)");
		List<PowerBankForm> listOfData = new ArrayList<>();
		try {
			con = JdbcConnectionUtil.getConnection();

			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM powerbank ");

			ResultSet resultSet = pstmt.executeQuery();
			System.out.println("Executing viewPowerBankData query");

			while (resultSet.next()) {
				PowerBankForm powerbankForm = new PowerBankForm(resultSet.getString("product_brand"),
						resultSet.getDouble("product_price"), resultSet.getString("product_model"),
						resultSet.getDate("arrived_date_time"));

				listOfData.add(powerbankForm);
			}

		} catch (SQLException e) {
			System.out.println("SQLException: " + e);
			e.printStackTrace();
		}

		return listOfData;
	}

	public List<HeadSetForm> viewAllHeadSetData() {
		System.out.println("stockDao viewPowerBankData(-)");
		List<HeadSetForm> listOfData = new ArrayList<>();
		try {
			con = JdbcConnectionUtil.getConnection();

			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM headset ");

			ResultSet resultSet = pstmt.executeQuery();
			System.out.println("Executing viewHeadSetData query");

			while (resultSet.next()) {
				HeadSetForm headsetForm = new HeadSetForm(resultSet.getString("product_brand"),
						resultSet.getDouble("product_price"), resultSet.getString("product_model"),
						resultSet.getDate("arrived_date_time"));

				listOfData.add(headsetForm);
			}

		} catch (SQLException e) {
			System.out.println("SQLException: " + e);
			e.printStackTrace();
		}

		return listOfData;
	}

	public List<BackCoverForm> viewAllBackCoverData() {
		System.out.println("stockDao ViewAllBackCoverData(-)");
		List<BackCoverForm> listOfData = new ArrayList<>();
		try {
			con = JdbcConnectionUtil.getConnection();

			PreparedStatement pstmt = con
					.prepareStatement("SELECT * FROM backcover WHERE product_brand = ? AND product_model = ?");

			ResultSet resultSet = pstmt.executeQuery();
			System.out.println("Executing viewHeadSetData query");

			while (resultSet.next()) {
				BackCoverForm backcoverForm = new BackCoverForm(resultSet.getString("product_brand"),
						resultSet.getDouble("product_price"), resultSet.getString("product_model"),
						resultSet.getDate("arrived_date_time"));

				listOfData.add(backcoverForm);
			}

		} catch (SQLException e) {
			System.out.println("SQLException: " + e);
			e.printStackTrace();
		}

		return listOfData;
	}
}
