package com.lab.report.digitization;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class MySQLConnection {
	public Connection doConnection() {
		Connection con = null;		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection)DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/lab_report_digitization", "root",
					"LenovoT460S");		
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
}