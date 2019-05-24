

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;


public class login extends HttpServlet {
	
    
	/* private ServletRequest request; */
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
    if(rs.next())
    {
    out.println("login success");
    }
    else
    {
        out.println("login failed");
    }
    }
	catch(SQLException e)
	{
		System.out.println(e);
	}
	}
}



