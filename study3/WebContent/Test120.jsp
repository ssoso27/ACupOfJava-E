<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR" isELIgnored="false"%>
<%-- tag 라이브러리를 가져오고, prefix를 원하는대로 지정 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="sso" %>

<!DOCTYPE html>
<html>
<body>
	<%-- for 문 --%>
	<sso:forEach var="i" begin="0" end="4">
		<%-- 해당 name 의 값 출력 --%>
		<sso:out value="${ i }"/>
		
		<%-- 조건문 --%>
		<sso:choose>
			<%-- if 문 --%>
			<sso:when test="${ (i%3) == 0 }">APPLE</sso:when>
			<sso:when test="${ (i%3) == 1 }">BANANA</sso:when>
			<%-- else 문 --%>
			<sso:otherwise>ORANGE</sso:otherwise>
		</sso:choose>
	</sso:forEach>
</body>
</html>