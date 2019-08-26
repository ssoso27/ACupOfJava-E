<%@ page language="java" contentType="text/plain; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String email = request.getParameter("email");

	String code = "FAIL";
	if ( email.equals("ssoso27@gmail.com") ) {
		code = "OK";
	}
%>
{
	code: '<%= code %>',
	result: ['cat', 'hamster', 'dog']
}