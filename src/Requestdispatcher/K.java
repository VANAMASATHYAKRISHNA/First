package Requestdispatcher;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class K extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object object;
		object=request.getAttribute("n");
		int y=(Integer)object;
		PrintWriter pw=response.getWriter();
		pw.print("y="+y);
		System.out.println("y"+y);
		
		
	}


	

}
