package com.lab.report.digitization;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.lab.report.digitization.helper.DatabaseHelper;

public class CustomerLogin extends HttpServlet {

	/**
	 * HttpServlet serial version UID
	 */
	private static final long serialVersionUID = 198789897987987L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {			
		DatabaseHelper dbHelper = new DatabaseHelper();
		PrintWriter pw = response.getWriter();
		String uname = request.getParameter("uname");
		String psw = request.getParameter("psw");		
		if (StringUtils.isEmpty(uname) || StringUtils.isEmpty(psw)) {						
			pw.write(dbHelper.getFailureResponse());
			return;
		} else { 
			String loginSuccessResponse = dbHelper.doLogin(uname, psw); 
			if(loginSuccessResponse.contains("Login Success")) {
			     pw.write(loginSuccessResponse);
			} else {			
				pw.write(dbHelper.getFailureResponse());
			}
		}
	}
}
