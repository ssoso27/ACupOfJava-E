<%@ page pageEncoding="EUC-KR" %>
<%@ page import="utils.Util" %>
<%@ page import="dao.*" %>
<%@ page import="vo.*" %>

<%
	String ctxPath = request.getContextPath();
	int roomNo = Util.parseIntOr( request.getParameter("roomNo"), -1 );
	String password = request.getParameter("pwd");
	
	Exception err = null;
	String permission = null;
	
	try {
		TalkRoomDAO dao = new TalkRoomDAO_OracleImpl();
		permission = dao.findPermissionByRoomNoANDPassword(roomNo, password);

		session.setAttribute("roomNo", roomNo);
		session.setAttribute("permission", permission);
	} catch (Exception e) {
		err = e;
	}
	
	if (err != null) {
		Util.sendErr(pageContext, err);
	} else {
		switch( Util.nullToBlank(permission) ){
			case "apple":
				response.sendRedirect(ctxPath + "/view_apple.jsp");
				break;
			case "banana":
				response.sendRedirect(ctxPath + "/view_banana.jsp");
				break;
			case "orange":
				response.sendRedirect(ctxPath + "/view_orange.jsp");
				break;
			default:
				Util.redirectLogin(pageContext);
				break;
		}
	}
%>