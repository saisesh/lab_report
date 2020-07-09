package com.lab.report.digitization;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;
import com.lab.report.digitization.helper.DatabaseHelper;
import com.mysql.jdbc.Connection;

public class ProfileServlet extends HttpServlet {

	/**
	 * HttpServlet serial version UID
	 */
	private static final long serialVersionUID = 198789897987987L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		PrintWriter pw = response.getWriter();
		String accessToken = request.getParameter("accessToken");
		DatabaseHelper dbHelper = new DatabaseHelper();
		if (StringUtils.isEmpty(accessToken)) {
			pw.write(dbHelper.getFailureResponse());
			return;
		} else {
			String profileData = getProfileData(accessToken);
			if (StringUtils.isNotBlank(profileData)) {
					pw.write(profileData);	
			} else {			
				pw.write(dbHelper.getFailureResponse());
			}
		}
	}

	private String getProfileData(String accessToken) {

		try {
			MySQLConnection mySQL = new MySQLConnection();
			Connection con = mySQL.doConnection();

			String profileQuery = "SELECT *FROM customer_profile LEFT JOIN customer_login\r\n" + 
					"ON customer_profile.uname = customer_login.uname \r\n" + 
					"where customer_login.token=?";
			PreparedStatement profileQueryPS = con.prepareStatement(profileQuery);
			profileQueryPS.setString(1, accessToken);		
			// execute the java prepared statement
			ResultSet result = profileQueryPS.executeQuery();
			result.first();
			Map<String, String> userDetailsMap = new HashMap<String, String>();
			userDetailsMap.put("username", result.getString(1));
			userDetailsMap.put("firstname", result.getString(2));
			userDetailsMap.put("lastname", result.getString(3));
			userDetailsMap.put("email", result.getString(4));
			userDetailsMap.put("age", result.getString(5));
			userDetailsMap.put("phone", result.getString(6));
			userDetailsMap.put("status", "200");
			con.close();
			Gson gson = new Gson();					
			return gson.toJson(userDetailsMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";

	}

}
