<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%! // 멤버 공간

	// 불가능
	// out.println( config.toString() );

	int i = 0;	// 가능
	// i = i + 1; // 불가능

	// 가능
	public void print() { }
	
%>
<html>
<body>
<% // 로컬 공간
	// 가능 ( out, config 등은 JSP가 변환된 JSPServlet에 존재한다. )
	out.println( config.toString() );
	String l = request.getParameter("abcd");
	String m = config.getInitParameter("initparam");
%>
</body>
</html>