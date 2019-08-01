<%@ page import="vo.TalkVO" %>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="utils.Util" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR"%>
<% // ����� ���� �Ǻ�
String ctxPath = request.getContextPath();

Cookie[] cks = request.getCookies();
if ( cks == null ) {
	response.sendRedirect( ctxPath + "/talk_login.jsp" );
	return;
}

int roomNo = -1;
String level = null;

for (Cookie ck : cks) {
	if ( ck.getName().equals("roomNo") ) {
		roomNo = Util.parseInt( ck.getValue() );
	} else if ( ck.getName().equals("level") ) {
		level = ck.getValue();
	}
}

if ( level == null || !level.equals("apple") ) {
	response.sendRedirect( ctxPath + "/talk_login.jsp" );
	return;
}
%>

<% // ä�ø�� �޾ƿ���
List<TalkVO> rl = new ArrayList<TalkVO>();
Exception err = null;

try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection(
			"jdbc:oracle:thin:@127.0.0.1/XE", "HR", "hr" );
	
	String sql = "SELECT * FROM talk_t WHERE room_no=? ORDER BY talk_no";
	PreparedStatement stmt = conn.prepareStatement(sql);
	stmt.setInt(1, roomNo);
	
	ResultSet rs = stmt.executeQuery();
	while( rs.next() ) {
		TalkVO vo = new TalkVO();
		vo.setTalkNo( rs.getInt("talk_no") );
		vo.setRoomNo( rs.getInt("room_no") );
		vo.setContent( rs.getString("content") );
		
		rl.add( vo );
	}
	
	rs.close();
	stmt.close();
	conn.close();
} catch (Exception e) { err = e; }

if ( err != null ) {
	response.sendRedirect( ctxPath + "/error.jsp" );
}
%>
<!DOCTYPE html>
<html>
<body>
<h1><%= roomNo %>�� ä�ù� (level : <%= level %>)</h1>
<table border="1">
	<tr>
		<td width="80" align="center">��ȣ</td>
		<td width="420" align="center">����</td>
		<td width="80"></td>
	</tr>
	<% for (TalkVO vo: rl) { %>
		<tr>
			<td align="center"><%= vo.getTalkNo() %></td>
			<td><%= vo.getContent() %></td>
			<td align="center"><a href="talk_delete2.jsp?talk_no=<%= vo.getTalkNo() %>">����</a></td>
		</tr>
	<% } %>
</table>
<br>
<form method="POST" action="talk_add2.jsp">
	<textarea rows="3" cols="60" name="content"></textarea>
	<input type="submit" value="�Է�"/>
</form>

</body>
</html>