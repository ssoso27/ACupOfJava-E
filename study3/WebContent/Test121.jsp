<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="sso" %>

<%
List<String> rl = new ArrayList<String>();
rl.add("one");
rl.add("two");
rl.add("three");
rl.add("four");
rl.add("five");

request.setAttribute("rl", rl);
%>
<!DOCTYPE html>
<html>
<body>
	<table border="1" cellspacing="0">
		<sso:forEach var="vo" items="${ rl }">
			<tr>
				<td>${ vo }</td>
			</tr>
		</sso:forEach>
	</table>
</body>
</html>