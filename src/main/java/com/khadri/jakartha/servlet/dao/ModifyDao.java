package com.khadri.jakartha.servlet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.khadri.jakartha.servlet.modify.form.ModifyForm;

public class ModifyDao {
	public int updateMovie(ModifyForm form) {
		System.out.println("MobileDao updateMobile(-)");
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(
					"jdbc:MySQL://localhost:3306/2024_batch_servlet_mobile_shop_app", "root", "Wellcome@123");

			PreparedStatement pstmt = con.prepareStatement(
					"update mobile set mobile_name = ?, mobile_brand = ?, mobile_cost = ?, mobile_qty =?  where mobile_model_no = ?");
			pstmt.setString(1, form.getMobileName());
			pstmt.setString(2, form.getMobileBrand());
			pstmt.setDouble(3, form.getMobileCost());
			pstmt.setInt(4, form.getMobileQuantity());
			pstmt.setString(5, form.getMobileModelNumber());
			result = pstmt.executeUpdate();
			System.out.println(result + "modified sucessfully!!!");

		} catch (Exception e) {
			System.out.println("Exception occured" + e.getMessage());
		}
		return result;

	}

}
