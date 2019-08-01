<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.List, bangmyung.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="sso" %>
<%!
	public void submit() {
		System.out.println("submit");
	}

%>
 <%  	
	// 1. 변수선언
	List<BangMyungVO> rl = null;
    Exception err = null;

    // 2. DB 연동
    BangMyungDAO dao = new BangMyungDAO_OracleImpl();
    
    try {
    	rl = dao.findAll();
    } catch (Exception e) { 
    	err = e; 
   	}
    
    // 3. 흐름 만들기
    if ( rl == null || err != null ) {
    	response.setCharacterEncoding("utf-8");
    	response.sendRedirect("/study3/error.jsp");
    } else { 
    	request.setAttribute("lst", rl);
%>
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
<% } %>
</body>
</html>