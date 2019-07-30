package study2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.sql.SQLException;

// DB에 방명록 insert
public class BangMyungAdd2 extends HttpServlet {
	String url = "jdbc:oracle:thin:@127.0.0.1:1521/XE";
	String user = "HR";
	String pw = "hr";
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		Connection conn = null;
		Statement stmt = null;
		
		String gul = request.getParameter( "gul" );
		String sql = "INSERT INTO bangmyung_t VALUES ( seq_bangmyung.NEXTVAL, '" + gul  +"', SYSDATE) ";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pw);
			stmt = conn.createStatement();
			
			stmt.executeUpdate(sql);	

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		response.sendRedirect("/study2/bangmyung_list");
	}
}
