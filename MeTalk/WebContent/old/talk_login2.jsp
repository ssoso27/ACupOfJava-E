<%-- talk_login2.jsp --%>
<%@page import="utils.Util" %>
<%@page import="java.sql.*" %>
<%@page import="vo.TalkRoomVO" %>
<%@page pageEncoding="EUC-KR" %>

<%
String ctxPath = request.getContextPath();

int roomNo = Util.parseInt( request.getParameter("roomNo") );
String pwd = request.getParameter("pwd");

if ( roomNo == -1 || pwd == null || pwd.equals("") ) {
	response.sendRedirect( ctxPath + "/talk_login.jsp");
	return; // redirect �Ǿ����� �ǹ� x
}

%>


<% 
Exception err = null;
TalkRoomVO vo = null;

try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection(
			"jdbc:oracle:thin:@127.0.0.1:1521/XE",
			"HR", "hr" );

	String sql = "SELECT * FROM talk_room_t WHERE room_no=?";
	PreparedStatement stmt = conn.prepareStatement(sql);
	stmt.setInt(1, roomNo);
	
	ResultSet rs = stmt.executeQuery();
	if ( rs.next() ) {
		vo = new TalkRoomVO();
		
		vo.setRoomNo( rs.getInt("room_no") );
		vo.setApple( rs.getString("apple") );
		vo.setBanana( rs.getString("banana") );
		vo.setOrange( rs.getString("orange") );
		
		System.out.println(vo.toString());
	}
	
	rs.close();
	stmt.close();
	conn.close();
} catch (Exception e) {
	err = e;
	e.printStackTrace();
}
%>

<%
if ( vo == null ){ // �ش� ���� ����
	response.sendRedirect( ctxPath + "/talk_login.jsp" );
} else if ( vo.getApple().equals( pwd ) ) { // �ش� ���� apple pwd �Է����� ��
	Cookie ck = new Cookie("level", "apple");
	response.addCookie(ck);
	
	Cookie ck2 = new Cookie("roomNo", String.valueOf(roomNo) );
	response.addCookie(ck2);
	
	response.sendRedirect( ctxPath + "/talk_view_apple.jsp" );
} else if ( vo.getBanana().equals( pwd ) ) { // �ش� ���� banana pwd �Է����� ��
	Cookie ck = new Cookie("level", "banana");
	response.addCookie(ck);
	
	Cookie ck2 = new Cookie("roomNo", String.valueOf(roomNo) );
	response.addCookie(ck2);

	response.sendRedirect( ctxPath + "/talk_view_banana.jsp" );
} else if ( vo.getOrange().equals( pwd ) ) { // �ش� ���� orange pwd �Է����� ��
	Cookie ck = new Cookie("level", "orange");
	response.addCookie(ck);
	
	Cookie ck2 = new Cookie("roomNo", String.valueOf(roomNo) );
	response.addCookie(ck2);

	response.sendRedirect( ctxPath + "/talk_view_orange.jsp" );
} else { // �˸��� pwd �� �ƴ�
	response.sendRedirect( ctxPath + "/talk_login.jsp" );
}
%>
