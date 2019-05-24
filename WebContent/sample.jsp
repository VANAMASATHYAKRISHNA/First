<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>sample program</title>
</head>
<body>
<form action="sample.jsp">
Enter Number<input type="number"name="a"/>
<input type="submit"value="click">
</form>
<% try
{  int i=Integer.parseInt(request.getParameter("a"));
out.print("square of a number="+i*i);
}
catch(NumberFormatException e)
{
System.out.println(e);
}
%>
</body>
</html>