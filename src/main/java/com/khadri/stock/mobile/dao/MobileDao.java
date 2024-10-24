package com.khadri.stock.mobile.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.khadri.stock.mobile.form.MobileForm;

public class MobileDao {
	Connection con;
	PreparedStatement pstmt = null;

	public int insertMobile(MobileForm form) {
		System.out.println("MobileDao insertMobile(-)");
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			pstmt = con.prepareStatement("insert into stock values(?,?,?,?,?)");

			pstmt.setInt(1, form.getMobileModelNo());
			pstmt.setString(2, form.getMobileName());
			pstmt.setString(3, form.getMobileBrand());
			pstmt.setDouble(4, form.getMobileCost());
			pstmt.setInt(5, form.getMobileQuantity());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Exception occured" + e.getMessage());
		}
		return result;
	}
}
