package com.khadri.stock.mobile.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.khadri.stock.mobile.form.HeadSetForm;

public class HeadSetDao {
	HeadSetForm headSetForm;
	Connection con;

	public void insertHeadSet(HeadSetForm headSetForm) throws SQLException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/2024_batch_mobile_shop", "root", "root");

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

}
