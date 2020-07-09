package com.lab.report.digitization.helper;

import java.security.SecureRandom;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import com.google.gson.Gson;
import com.lab.report.digitization.MySQLConnection;
import com.lab.report.digitization.utils.RandomString;
import com.mysql.jdbc.Connection;

public class DatabaseHelper {
	/**
	 * 
	 * @return
	 */
	public String getFailureResponse() {
		HashMap<String, String> responseObj = new HashMap<String, String>();		
		responseObj.put("status", "401");		
		responseObj.put("token", "");
		Gson gson = new Gson();
		return gson.toJson(responseObj);
	}

	/**
	 * 
	 * @return
	 */
	public String doLogin(String uname, String psw) {	
		try {
			MySQLConnection mySQL = new MySQLConnection();
			Connection con = mySQL.doConnection();
			// here lab_report_digitization is database name, root is user name and password
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from customer_login where uname='" + uname + "'");
			rs.first();			
			String passwordFromDB = rs.getString(2);	 	
			if(psw.equals(passwordFromDB)) { 
				String token =  generateToken();				
				updateTokenInDB(con, uname, token); 
				return getSuccessResponse(token);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getFailureResponse();
	}
	
	public void updateTokenInDB(Connection con, String uname, String token) throws SQLException {
		// create the java my sql update prepared statement
	      String query = "update customer_login set token = ? where uname = ?";
	      PreparedStatement preparedStmt = con.prepareStatement(query);
	      preparedStmt.setString   (1, token);
	      preparedStmt.setString(2, uname);
	      // execute the java prepared statement
	      preparedStmt.executeUpdate();
	}

	public String generateToken() {
		String easy = RandomString.digits + "ACEFGHJKLMNPQRUVWXYabcdefhijkprstuvwx";
		RandomString tickets = new RandomString(23, new SecureRandom(), easy);
		return tickets.nextString();
	}

	/**
	 * 
	 * @return
	 */
	public String getSuccessResponse(String token) {
		Gson gson = new Gson();
		HashMap<String, String> responseObj = new HashMap<String, String>();		
		responseObj.put("status", "200");
		responseObj.put("message", "Login Success");
		responseObj.put("token", token);
		return gson.toJson(responseObj);
	}
}
