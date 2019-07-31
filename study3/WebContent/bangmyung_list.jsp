<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.List, bangmyung.*" %>
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
    } catch (Exception e) { err = e; }
    
    // 3. 흐름 만들기
    if ( rl == null || err != null ) {
    	response.sendRedirect("/study3/error.jsp");
    } else { 
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
	<% for (BangMyungVO vo : rl) { %>
	<tr>
		<td><%= vo.getNo() %></td>
		<td><%= vo.getGul() %></td>
		<td><%= vo.getTheTime() %></td>
	</tr>
	<% } %>
</table>
<form method="POST" action="bangmyung_add.jsp">
	<input type="text" name="gul" size="50"/>
	<input type="submit"/>
</form>
<% } %>
</body>
</html>