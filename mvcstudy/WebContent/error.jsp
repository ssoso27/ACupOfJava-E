<%@ page pageEncoding="EUC-KR"%>
<%
Exception err = (Exception) session.getAttribute("err");
StackTraceElement[] errs = err.getStackTrace();
session.removeAttribute("err");
%>
<!DOCTYPE html>
<html>
<body>
	<% for (StackTraceElement e: errs) { %>
		<%= e.toString() %>
	<% } %>
</body>
</html>