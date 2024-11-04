package com.khadri.jakarta.product.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.khadri.jakarta.product.form.ProductForm;

public class ProductDao {
	public int insertMobileData(ProductForm form) {
		System.out.println("ProductDao insertMovieData(-)");
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(

					"jdbc:MySQL://localhost:3306/2024_batch_workshop_servlet_mobile_shop_app", "root", "root");

			PreparedStatement pstmt = con.prepareStatement("insert into product(productName) values(?)");
			pstmt.setString(1, form.getName());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("Exception occured" + e.getMessage());
		}
		return result;
	}

	public List<ProductForm> viewProductData(String productId) {
		ProductForm form = new ProductForm();

		System.out.println("productDao ViewProductData(-)");
		List<ProductForm> listOfData = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(
					"jdbc:MySQL://localhost:3306/2024_batch_servlet_mobile_shop_app", "root", "Salman@23");

			Statement stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery("select * from product where Id='" + productId + "'");
			System.out.println("view");
			while (resultSet.next()) {
				form.setId(resultSet.getInt(1));
				form.setName(resultSet.getString(2));
			}
			listOfData.add(form);

		} catch (Exception e) {
			System.out.println("Exception occured" + e.getMessage());
		}
		return listOfData;

	}

	public List<ProductForm> selectProductData() {

		System.out.println("ProductDao selectproduct(-)");
		List<ProductForm> listOfData = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(
					"jdbc:MySQL://localhost:3306/2024_batch_servlet_mobile_shop_app", "root", "Salman@23");

			Statement stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery("select * from product");

			while (resultSet.next()) {
				ProductForm form = new ProductForm();
				form.setId(resultSet.getInt(1));
				form.setName(resultSet.getString(2));
				listOfData.add(form);
			}

		} catch (Exception e) {
			System.out.println("Exception occured" + e.getMessage());
		}
		return listOfData;

	}

	public int updateProduct(ProductForm form) {
		System.out.println("ProductDao updateProduct(-)");
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(
					"jdbc:MySQL://localhost:3306/2024_batch_servlet_mobile_shop_app", "root", "Salman@23");

			PreparedStatement pstmt = con.prepareStatement("update product set Name=? where ID=?");
			pstmt.setString(1, form.getName());
			pstmt.setInt(2, form.getId());

			result = pstmt.executeUpdate();
			System.out.println(result + "modified sucessfully!!!");

		} catch (Exception e) {
			System.out.println("Exception occured" + e.getMessage());
		}
		return result;

	}

	public int deleteProductData(ProductForm form) {
		int result = 0;
		System.out.println("productDao DeleteProductData(-)");
		List<ProductForm> listOfData = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(
					"jdbc:MySQL://localhost:3306/2024_batch_servlet_mobile_shop_app", "root", "Salman@23");

			Statement stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery("delete from product where Id=?");
			while (resultSet.next()) {
				form.setId(resultSet.getInt(1));
				form.setName(resultSet.getString(2));
			}
			listOfData.add(form);

		} catch (Exception e) {
			System.out.println("Exception occured" + e.getMessage());
		}
		return result;

	}

}
