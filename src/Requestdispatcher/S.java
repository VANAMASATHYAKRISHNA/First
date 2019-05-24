package Requestdispatcher;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class S extends HttpServlet {
	
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int x=10;
		RequestDispatcher rd1;
		rd1=request.getRequestDispatcher("k");
		request.setAttribute("n",x);
		rd1.forward(request,response);
		
	}
}

	