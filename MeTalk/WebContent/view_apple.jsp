<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR"%>
<%@ page import="dao.*" %>
<%@ page import="vo.*" %>
<%@ page import="utils.Util" %>
<%@ page import="java.util.*" %>

<%
int roomNo = (Integer)session.getAttribute("roomNo");
String permission = (String) session.getAttribute("permission");

Exception err = null;
List<TalkVO> talks = null;

try {
	TalkDAO dao = new TalkDAO_OracleImpl();
	talks = dao.findByRoomNo(roomNo);
} catch (Exception e) {
	err = e;
}

if (err != null) Util.sendErr(pageContext, err);
%>

<!DOCTYPE>
<html>
<head>
	<title><%= roomNo %>�� ä�ù�</title>
</head>
<body>
	<h1><%= roomNo %>�� ä�ù� ( ���� : <%= permission %> )</h1>
	<table border="1">
		<tr>
			<td width="80" align="center">��ȣ</td>
			<td width="240" align="center">����</td>
		</tr>
	<% for (TalkVO talk : talks) { %>
		<tr>
			<td align="center"><%= talk.getTalkNo() %></td>
			<td><%= talk.getContent() %></td>
		</tr>
	<% } %>
	</table>
</body>
</html>