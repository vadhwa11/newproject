package com.loghub.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnectionUtil {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

//con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ilms", "ilms");
			con = DriverManager.getConnection("jdbc:oracle:thin:@10.0.144.62:1521:xe","ilms", "ilms");
			//con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ilms", "ilms");
			//con = DriverManager.getConnection("jdbc:oracle:thin:@10.0.144.223:1521:idroradb","ilms", "ilms");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;
	}

}
