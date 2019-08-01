<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR"%>
<% 
String ctxPath = request.getContextPath();
request.setAttribute("ctxPath", ctxPath);
%>
<!DOCTYPE html>
<html>
<head>
<title>로그인 페이지</title>
</head>
<body>

<form method="POST" action="${ ctxPath }/login2.jsp">
	roomNo : <input type="text" name="roomNo" size="4"/> <br>
	Password : <input type="password" name="pwd" size="8"/> <br>
	<input type="submit"/>
</form>

</body>
</html>