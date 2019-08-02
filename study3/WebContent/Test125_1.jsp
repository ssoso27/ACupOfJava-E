<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="sso" %>
<!DOCTYPE>
<html>
<body>
<table border='1'>
	<tr>
		<td>No</td>
		<td>글</td>
		<td>작성시간</td>
	</tr>
	
	<sso:forEach varStatus="vs" var="vo" items="${ lst }">
		<tr bgColor="${ (vs.count % 2 != 0)?'#aabbcc':'#bbccdd' }">
			<td>${ vs.count }</td>
			<td>${ vo.no }</td>
			<td>${ vo.gul }</td>
			<td>${ vo.theTime }</td>
		</tr>
	</sso:forEach>
</table>
<form method="POST" action="bangmyung_add.jsp">
	<input type="text" name="gul" size="50"/>
	<input type="submit"/>
</form>
</body>
</html>