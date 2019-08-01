<%@ page pageEncoding="EUC-KR" %>
<%@ page import="utils.Util" %>
<%@ page import="java.sql.*" %>

<% // 삭제 권한 검사
String ctxPath = request.getContextPath();

//삭제 권한자: 해당 room 의 apple 권한자
int talkNo = Util.parseInt( request.getParameter("talk_no") );
int roomNo = -1;
String level = null;

Cookie[] cks = request.getCookies();
if ( cks == null ) {
	response.sendRedirect(ctxPath + "/talk_login.jsp");
}

for (Cookie ck: cks) {
	if ( ck.getName().equals("roomNo") ) roomNo = Util.parseInt( ck.getValue() );
	else if ( ck.getName().equals("level") ) level = ck.getValue();
}

if ( roomNo == -1 || level == null || !level.equals("apple") ) {
	response.sendRedirect(ctxPath + "/talk_login.jsp");
}

%>

<% // DB 연결
Exception err = null;

try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection(
			"jdbc:oracle:thin:@127.0.0.1/XE", "HR", "hr" );
	
	String sql = "DELETE FROM talk_t WHERE room_no=? AND talk_no=?";
	PreparedStatement stmt = conn.prepareStatement(sql);
	stmt.setInt(1, roomNo);
	stmt.setInt(2, talkNo);
	
	stmt.executeUpdate();

	stmt.close();
	conn.close();
} catch ( Exception e ) {
	err = e;
}

if (err != null) {
	response.sendRedirect(ctxPath + "/error.jsp");
} else {
	response.sendRedirect(ctxPath + "/talk_view_apple.jsp");
}
%>