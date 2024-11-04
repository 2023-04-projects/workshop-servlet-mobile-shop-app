package com.khadri.jakarta.product.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.khadri.jakarta.product.form.ProductForm;

import jakarta.servlet.ServletContext;

public class ProductDao {
    private String jdbcUrl;
    private String jdbcUser;
    private String jdbcPassword;
    
    public ProductDao(ServletContext context) {
        this.jdbcUrl = context.getInitParameter("jdbcUrl");
        this.jdbcUser = context.getInitParameter("jdbcUser");
        this.jdbcPassword = context.getInitParameter("jdbcPassword");
    }

    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
    }

    public int insertMobileData(ProductForm form) {
        System.out.println("ProductDao insertMovieData(-)");
        int result = 0;
        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement("INSERT INTO product(Name) VALUES(?)")) {
             
            pstmt.setString(1, form.getName());
            result = pstmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
        return result;
    }

    public List<ProductForm> viewProductData(String productId) {
        System.out.println("ProductDao viewProductData(-)");
        List<ProductForm> listOfData = new ArrayList<>();
        
        try (Connection con = getConnection();
             Statement stmt = con.createStatement();
             ResultSet resultSet = stmt.executeQuery("SELECT * FROM product WHERE Id='" + productId + "'")) {
            
            if (resultSet.next()) {
                ProductForm form = new ProductForm();
                form.setId(resultSet.getInt(1));
                form.setName(resultSet.getString(2));
                listOfData.add(form);
            }

        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
        return listOfData;
    }

    public List<ProductForm> selectProductData() {
        System.out.println("ProductDao selectProductData(-)");
        List<ProductForm> listOfData = new ArrayList<>();
        
        try (Connection con = getConnection();
             Statement stmt = con.createStatement();
             ResultSet resultSet = stmt.executeQuery("SELECT * FROM product")) {
            
            while (resultSet.next()) {
                ProductForm form = new ProductForm();
                form.setId(resultSet.getInt(1));
                form.setName(resultSet.getString(2));
                listOfData.add(form);
            }

        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
        return listOfData;
    }

    public int updateProduct(ProductForm form) {
        System.out.println("ProductDao updateProduct(-)");
        int result = 0;
        
        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement("UPDATE product SET Name=? WHERE ID=?")) {
            
            pstmt.setString(1, form.getName());
            pstmt.setInt(2, form.getId());

            result = pstmt.executeUpdate();
            System.out.println(result + " record(s) modified successfully!");

        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
        return result;
    }
}
