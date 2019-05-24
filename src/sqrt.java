

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class sqrt extends HttpServlet {
	
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		String n= request.getParameter("h");
    		int a=Integer.parseInt(n);
           PrintWriter pw = response.getWriter();
    		pw.println("square root is" +(a*a));
        
    }

	
}
