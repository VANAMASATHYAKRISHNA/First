package showproducts;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Loginp extends HttpServlet {
	
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String la = request.getParameter("a");
		String lb = request.getParameter("b");
		
		try
		{
		DriverManager.registerDriver(new org.h2.Driver());
		Connection con;
		con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/sathkrh","sa","sa");
		PreparedStatement ps=con.prepareStatement("select * from PERSON where email=? and password=?");
		ps.setString(1,la);
		ps.setString(2,lb);
		ResultSet rs=ps.executeQuery();
		response.setContentType("text/html");
		HttpSession hsHttpSession=request.getSession();
		hsHttpSession.setAttribute("login","yes");
		
	    if(rs.next())
	    {
	    out.print("login success");
	    out.print("<a href='Viewpro'>showproducts</a>");
	    }
	    else
	    {
	    	
	        out.println("login failed");
	        RequestDispatcher rd1= request.getRequestDispatcher("showproducts.html");
	    	rd1.include(request,response);
	        
	    }
	    }
		catch(SQLException e)
		{
			System.out.println(e);
		}
		}
	}





