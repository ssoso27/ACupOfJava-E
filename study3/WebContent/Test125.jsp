<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.List, bangmyung.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="sso" %>
<%!
	public void submit() {
		System.out.println("submit");
	}

%>
 <%  	
	// 1. 변수선언
	List<BangMyungVO> rl = null;
    Exception err = null;

    // 2. DB 연동
    BangMyungDAO dao = new BangMyungDAO_OracleImpl();
    
    try {
    	rl = dao.findAll();
    } catch (Exception e) { 
    	err = e; 
   	}
    
    // 3. 흐름 만들기
    if ( rl == null || err != null ) {
    	response.setCharacterEncoding("utf-8");
    	response.sendRedirect("/study3/error.jsp");
    } else { 
    	request.setAttribute("lst", rl);
    	RequestDispatcher rd = request.getRequestDispatcher("/Test125_1.jsp");
    	rd.forward(request, response);
    }
%>