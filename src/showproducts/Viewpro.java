package showproducts;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Viewpro extends HttpServlet {
	
       
   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try
		{
		DriverManager.registerDriver(new org.h2.Driver());
		Connection con;
		con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/sathkrh","sa","sa");
		Statement statement=con.createStatement();
		ResultSet rs= statement.executeQuery("SELECT * FROM PRODUCT ");
		HttpSession hsHttpSession=request.getSession();
		String checklogin=(String)hsHttpSession.getAttribute("login");
		
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		if(checklogin==null)
		{
			pw.print("not autheriozed");
		}
		else if(checklogin.equals("yes"))
		{
		while(rs.next())
		{
		pw.println(rs.getInt(1)+"<br>");
		pw.println(rs.getString(2)+"<br>");
		pw.println(rs.getInt(3)+"<br>");
		}
		}
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		}
	}



