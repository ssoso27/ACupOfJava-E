<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="EUC-KR"%>

<%
String pw = request.getParameter("pw");

if ( pw != null && pw.equals("1234") ) {
	String[] ls = {"사과", "귤", "배", "토마토"};
	String nl = "\r\n"; // 줄바꿈 표시

	for (String l : ls) {
		%> <%= l %><%= nl %> <%
	}
} else {
	%> <%= "암호 틀림" %> <%
}
%>