<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="EUC-KR"%>

<%
String pw = request.getParameter("pw");

if ( pw != null && pw.equals("1234") ) {
	String[] ls = {"���", "��", "��", "�丶��"};
	String nl = "\r\n"; // �ٹٲ� ǥ��

	for (String l : ls) {
		%> <%= l %><%= nl %> <%
	}
} else {
	%> <%= "��ȣ Ʋ��" %> <%
}
%>