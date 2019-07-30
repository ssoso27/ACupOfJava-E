package study2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorld3 extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "jdbc:oracle:thin:@127.0.0.1/XE";
		String user = "HR";
		String pw = "hr";
		
		ArrayList<BangMyungVO> ls = new ArrayList<BangMyungVO>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url, user, pw);
			Statement stmt = conn.createStatement();
			
			String sql = "SELECT no, gul, the_time FROM bangmyung_t";
			ResultSet rs = stmt.executeQuery(sql);
			
			while ( rs.next() ) {
				BangMyungVO vo = new BangMyungVO();
				
				vo.setNo( rs.getInt("no") );
				vo.setGul( rs.getString("gul") );
				vo.setTheTime( rs.getString("the_time") );
				
				ls.add( vo );
			}
			rs.close();
			
			stmt.close();
			conn.close();
			
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println(" <body>");
		out.println("  <table border=\"1\">");
		out.println("<tr><td><font face='impact'>NO</font></td><td><font face='impact'>±Û</font></td><td><font face='impact'>½Ã°£</font></td></tr>");
		for ( BangMyungVO vo : ls ) {
			out.println("   <tr>");
			out.println("<td bgColor='#aabbcc'>" +  vo.getNo() +"</td>");
			out.println("<td bgColor='#ccddee'>" +  vo.getGul() +"</td>");
			out.println("<td bgColor='#bbccdd'>" +  vo.getTheTime() +"</td>");
			out.println("   </tr>");
		}
		out.println("  </table>");
		out.println(" </body>");
		out.println("</html>");
		out.close();
	}
	
}
