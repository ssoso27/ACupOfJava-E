<%@ page pageEncoding="utf-8" %>
<%
int roomNo = (Integer) session.getAttribute("roomNo");
String content = (String) session.getAttribute("content");
%>

<%=roomNo%> <%=content%>