

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Register extends HttpServlet
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,  IOException  {
		
String ra = request.getParameter("a");
String rb = request.getParameter("b");
String rc = request.getParameter("c");
String rd = request.getParameter("d");
PrintWriter pw=response.getWriter();
pw.print("user name"+ra);
pw.print("password"+rb);
pw.print("email"+rc);
pw.print("mobile number"+rd);
try
{
DriverManager.registerDriver(new org.h2.Driver());
Connection con;
con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/sathkrh","sa","sa");
Statement Statement=con.createStatement();
Statement.executeUpdate("insert into person values('"+ra+"','"+rb+"','"+rc+"','"+rd+"')");
}
catch(SQLException e)
{
	System.out.println(e);
}
}
}








