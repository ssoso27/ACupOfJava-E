<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%! // ��� ����

	// �Ұ���
	// out.println( config.toString() );

	int i = 0;	// ����
	// i = i + 1; // �Ұ���

	// ����
	public void print() { }
	
%>
<html>
<body>
<% // ���� ����
	// ���� ( out, config ���� JSP�� ��ȯ�� JSPServlet�� �����Ѵ�. )
	out.println( config.toString() );
	String l = request.getParameter("abcd");
	String m = config.getInitParameter("initparam");
%>
</body>
</html>