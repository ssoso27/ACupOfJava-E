<%@ page pageEncoding="EUC-KR" %>
<%@ page import="utils.Util" %>
<%@ page import="dao.*" %>
<%@ page import="vo.*" %>

<%
	Integer roomNo = Util.parseIntOr( request.getParameter("roomNo"), -1 );
	String password = request.getParameter("pwd");
	
	Exception err = null;
	String permission = null;
	
	try {
		TalkRoomDAO dao = new TalkRoomDAO_OracleImpl();
		permission = dao.findPermissionByRoomNoANDPassword(roomNo, password);
		System.out.println(permission);
	} catch (Exception e) {
		err = e;
	}
	
	if (err != null) {
		Util.sendErr(pageContext, err);
	} else {
		switch( Util.nullToBlank(permission) ){
			case "apple":
				break;
			case "banana":
				break;
			case "orange":
				break;
			default:
				break;
		}
	}
%>