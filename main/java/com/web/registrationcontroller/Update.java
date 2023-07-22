package com.web.registrationcontroller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
		 protected void doPost(HttpServletRequest request, HttpServletResponse response)
		            throws ServletException, IOException {

		        String uname = request.getParameter("name");
		        String uemail = request.getParameter("email");
		        String upwd = request.getParameter("pass");
		        String oupwd = PasswordEncoder.encodePassword(upwd);
		        String umobile = request.getParameter("contact");
		        RequestDispatcher dispatcher = null;
		        Connection con = null;

		        try {
	                Class.forName("com.mysql.cj.jdbc.Driver");
	                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?useSSL=false", "root", "Asdf54321@");
	                PreparedStatement pst = con.prepareStatement("UPDATE users SET uname=?,upwd=?, uemail=?, umobile=? WHERE uemail=?");
	                pst.setString(1, uname);
	                pst.setString(2, oupwd);
	                pst.setString(3, uemail);
	                pst.setString(4, umobile);

	                int rowCount = pst.executeUpdate();

	                if (rowCount > 0) {
	                    request.setAttribute("status", "success");
	                } else {
	                    request.setAttribute("status", "failed");
	                }

	            } catch (Exception e) {
	                e.printStackTrace();
	                request.setAttribute("status", "failed");
	            } finally {
	                try {
	                    if (con != null) {
	                        con.close();
	                    }
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	        

	        dispatcher = request.getRequestDispatcher("registration.jsp");
	        dispatcher.forward(request, response);
		
		
	}

}
