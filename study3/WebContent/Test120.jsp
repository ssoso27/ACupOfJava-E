<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR" isELIgnored="false"%>
<%-- tag ���̺귯���� ��������, prefix�� ���ϴ´�� ���� --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="sso" %>

<!DOCTYPE html>
<html>
<body>
	<%-- for �� --%>
	<sso:forEach var="i" begin="0" end="4">
		<%-- �ش� name �� �� ��� --%>
		<sso:out value="${ i }"/>
		
		<%-- ���ǹ� --%>
		<sso:choose>
			<%-- if �� --%>
			<sso:when test="${ (i%3) == 0 }">APPLE</sso:when>
			<sso:when test="${ (i%3) == 1 }">BANANA</sso:when>
			<%-- else �� --%>
			<sso:otherwise>ORANGE</sso:otherwise>
		</sso:choose>
	</sso:forEach>
</body>
</html>