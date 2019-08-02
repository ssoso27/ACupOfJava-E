<%@ page pageEncoding="EUC-KR" %>
<%
int i = 0;

if ( i == 0 ) {
	request.setAttribute("¸Þ¼¼Áö", "cat");
	
	RequestDispatcher rd = request.getRequestDispatcher("/Test124_1.jsp");
	rd.forward( request, response );
}
%>