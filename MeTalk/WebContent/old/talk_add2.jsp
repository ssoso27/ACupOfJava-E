<%@ page pageEncoding="EUC-KR"%>
<%@ page import="utils.Util"%>
<%@ page import="java.sql.*"%>

<%
	// 사용자 권한 판별
	String ctxPath = request.getContextPath();

	Cookie[] cks = request.getCookies();
	if (cks == null) {
		response.sendRedirect(ctxPath + "/talk_login.jsp");
		return;
	}

	int roomNo = -1;
	String level = null;

	for (Cookie ck : cks) {
		if (ck.getName().equals("roomNo")) {
			roomNo = Util.parseInt(ck.getValue());
		} else if (ck.getName().equals("level")) {
			level = ck.getValue();
		}
	}

	if (level == null || roomNo == -1 || (!level.equals("apple") && !level.equals("banana"))) {
		response.sendRedirect(ctxPath + "/talk_login.jsp");
		return;
	}
%>

<%
	// DB 연결
	Exception err = null;
	String content = Util.encodeUTF8(request.getParameter("content"));
	System.out.println(content);
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1/XE", "HR", "hr");

		String sql = "INSERT INTO talk_t VALUES (seq_talk.NEXTVAL, ?, ?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, roomNo);
		stmt.setString(2, content);
		stmt.executeUpdate();

		stmt.close();
		conn.close();
	} catch (Exception e) {
		err = e;
	}

	// 권한 별로 다른 redirect
	if (err != null) {
		response.sendRedirect(ctxPath + "/error.jsp");
	} else if ( level.equals("apple") ) {
		response.sendRedirect(ctxPath + "/talk_view_apple.jsp");
	} else if ( level.equals("banana") ) {
		response.sendRedirect(ctxPath + "/talk_view_banana.jsp");
	} else {
		response.sendRedirect(ctxPath + "/talk_login.jsp");
	}
%>