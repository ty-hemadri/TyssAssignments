<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Background color</title>
</head>
<% String backcolor= request.getParameter("color");
  if(backcolor==null || (backcolor.equals("")))
  {
	  backcolor="white";
  }
%>

<body bgcolor="<%= backcolor %>">
<form action="">
<h2>Changing the Background color</h2>
<input type="text" name ="color"></br>
<input type="submit"  value="try this color">
</form>
</body>
</html>