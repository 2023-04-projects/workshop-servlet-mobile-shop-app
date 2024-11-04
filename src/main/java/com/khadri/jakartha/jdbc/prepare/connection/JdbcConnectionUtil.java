package com.khadri.jakartha.jdbc.prepare.connection;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import jakarta.servlet.http.HttpServletRequest;

public class JdbcConnectionUtil {

	private static Connection con;

	public static Connection getConnection(HttpServletRequest req) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Properties properties = new Properties();
			//properties.load(new FileReader(new File("db.properties")));

			String url = properties.getProperty("URL");
			String user = properties.getProperty("USER");
			String password = properties.getProperty("PASSWORD");

			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException cnfe) {
			System.out.println("ClassNotFoundException " + cnfe);
		} catch (FileNotFoundException fnfe) {
			System.out.println("FileNotFoundException " + fnfe);

		} catch (IOException ioe) {
			System.out.println("IOException " + ioe);

		} catch (SQLException sqle) {
			System.out.println("SQLException " + sqle);
		}
		return con;
	}

	public static void closeResources() {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("SQLException" + e);
		}
	}
}
