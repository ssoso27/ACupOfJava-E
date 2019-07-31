<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%!
	String getColor() {
		char[] chs = "0123456789abcdef".toCharArray();
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < 6; i++) {
			int idx = (int) (Math.random() * 16);
			sb.append(chs[idx]);
		}
		
		return sb.toString();
	}
%>
<html>
<body>
<table>
	<% for (int i = 1; i <= 9; i++) { %>
	<tr>
		<% for (int j = 1; j <= 9; j++) { %>
			<td bgColor='#<%= getColor() %>'> <%= i %> * <%= j %> = <%= i*j %> </td>
		<% } %>
	</tr>
	<% } %>
</table>
</body>
</html>