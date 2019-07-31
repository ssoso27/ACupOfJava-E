<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="bangmyung.*"%>
<!DOCTYPE html>
<%
	Exception err = null;
	request.setCharacterEncoding("utf-8");
	String gul = request.getParameter("gul");
	System.out.println(gul);
	
	BangMyungVO pvo = new BangMyungVO();
	pvo.setGul( gul );
	
	BangMyungDAO dao = new BangMyungDAO_OracleImpl();
	try {
		dao.add( pvo );
	} catch (Exception e) {
		err = e;
	}
	
	if (err != null) {
		response.sendRedirect("/study3/error.jsp");
	} else {
		response.sendRedirect("/study3/bangmyung_list.jsp");
	}
%>
<html>
<body>
	hi
</body>
</html>