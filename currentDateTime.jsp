<%@ page import = "java.util.*"  %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% response.setIntHeader("Refresh", 4);

Date da = new Date();
String currentdatetime = da.toString();
out.println(currentdatetime); %>
</body>
</html>