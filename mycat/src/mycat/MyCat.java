package mycat;

import javax.servlet.http.*;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.DriverManager;

public class MyCat extends HttpServlet {
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		String url = "jdbc:oracle:thin:@127.0.0.1/XE";
		String user = "HR";
		String pw = "hr";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT no, gul, the_time FROM bangmyung_t";
		ArrayList<BangMyungVO> ls = new ArrayList<BangMyungVO>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pw);
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while ( rs.next() ) {
				BangMyungVO vo = new BangMyungVO();
				
				vo.setNo( rs.getInt("no") );
				vo.setGul( rs.getString("gul") );
				vo.setTheTime( rs.getString("the_time") );
				
				ls.add(vo);
			}
			
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<table border=\"1\">");
		out.println("<tr>"
				+ "<td>No</td>"
				+ "<td>글</td>"
				+ "<td>작성시간</td>"
				+ "</tr>");
		for(BangMyungVO vo: ls) {
			out.println("<tr>"
					+ "<td>" + vo.getNo() +"</td>"
					+ "<td>" + vo.getGul() + "</td>"
					+ "<td>" + vo.getTheTime() + "</td>"
					+ "</tr>");
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}
}
