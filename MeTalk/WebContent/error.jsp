<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%
	Exception err = (Exception) session.getAttribute("err");
	session.removeAttribute("err");
%>
<html>
<head>
<title>ERROR</title>
</head>
<body>
	<%= err %><br>
	<% for (StackTraceElement trace : err.getStackTrace()) { %>
		<%= trace.toString() %><br>
	<% } %>
</body>
</html>