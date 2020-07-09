package com.lab.report.digitization;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.lab.report.digitization.helper.DatabaseHelper;
import com.mysql.jdbc.Connection;

public class RegisterUser extends HttpServlet {

	/**
	 * HttpServlet serial version UID
	 */
	private static final long serialVersionUID = 198789897987987L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		PrintWriter pw = response.getWriter();
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String uname = request.getParameter("uname");
		String psw = request.getParameter("psw");
		String email = request.getParameter("email");
		String age = request.getParameter("age");
		String phone = request.getParameter("phone");
		DatabaseHelper dbHelper = new DatabaseHelper();
		if (StringUtils.isEmpty(uname) && StringUtils.isEmpty(psw)) {
			pw.write(dbHelper.getFailureResponse());
			return;
		} else {
			boolean isRegistered = registerInDatabase(firstname, lastname, uname, psw, email, age, phone);
			if (isRegistered) {
				String loginSuccessResponse = dbHelper.doLogin(uname, psw);
				if (loginSuccessResponse.contains("Login Success")) {
					pw.write(loginSuccessResponse);
				} else {				
					pw.write(dbHelper.getFailureResponse());
				}
			} else {			
				pw.write(dbHelper.getFailureResponse());
			}
		}
	}

	private boolean registerInDatabase(String firstname, String lastname, String uname, String psw, String email,
			String age, String phone) {

		try {
			MySQLConnection mySQL = new MySQLConnection();
			Connection con = mySQL.doConnection();

			String cusomterLogin = "INSERT INTO customer_login (uname,password, token) VALUES (?,?,'');";
			PreparedStatement cusomterLoginPS = con.prepareStatement(cusomterLogin);
			cusomterLoginPS.setString(1, uname);
			cusomterLoginPS.setString(2, psw);
			// execute the java prepared statement
			cusomterLoginPS.executeUpdate();

			String query = "INSERT INTO customer_profile (uname, firstname, lastname, email, age, phone) VALUES (?,?,?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, uname);
			preparedStmt.setString(2, firstname);
			preparedStmt.setString(3, lastname);
			preparedStmt.setString(4, email);
			preparedStmt.setInt(5, Integer.parseInt(age));
			preparedStmt.setLong(6, Long.parseLong(phone));
			// execute the java prepared statement
			preparedStmt.executeUpdate();

			con.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

}
