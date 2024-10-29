package com.khadri.stock.mobile.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.khadri.stock.mobile.form.PowerBankForm;

public class PowerBankDao {
	PowerBankForm powerBankForm;
	Connection con;

	public void insertPowerBank(PowerBankForm powerBankForm) throws SQLException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/2024_batch_mobile_shop", "root", "root");

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

}
