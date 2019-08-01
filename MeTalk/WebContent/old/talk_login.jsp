<%-- talk_login.jsp --%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>talk_login.jsp</title>
</head>
<body>

<form method="POST" action="talk_login2.jsp">
	roomNo : <input type="text" name="roomNo" size="4"/> <br>
	Password : <input type="password" name="pwd" size="8"/> <br>
	<input type="submit"/>
</form>

</body>
</html>