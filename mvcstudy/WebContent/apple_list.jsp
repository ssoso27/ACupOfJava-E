<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="l" %>
<!DOCTYPE html>
<html>
<head>
	<title>APPLE_LIST.jsp</title>
</head>
<body>
<table>
	<l:forEach var="vo" items="${ lst }">
		<tr>
			<td>${ vo.no }</td>
			<td>${ vo.gul }</td>
			<td>${ vo.theTime }</td>
		</tr>
	</l:forEach>
</table>

<form method="POST" action="apple_add2.do">
	<input type="text" name="gul" size="55"/>
	<input type="submit"/>
</form>
</body>
</html>