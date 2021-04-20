<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Reading the three parameters values</h2>
<%= request.getParameter("param1") %></br>
<%= request.getParameter("param2") %></br>
<%= request.getParameter("param3") %>
</body>
</html>