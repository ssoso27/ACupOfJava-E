<%@ page language="java" contentType="text/plain; charset=utf-8"
    pageEncoding="utf-8"%>

<%
String email = request.getParameter("email");
String passwd = request.getParameter("passwd");

String sql = "INSERT INTO tempt VALUES ('"+email+"', '" + passwd + "')";
String code = ( email.equals("apple") && passwd.equals("1234") ) ? "OK" : "FAIL";
%>
{ code: '<%= code %>', result: [] }