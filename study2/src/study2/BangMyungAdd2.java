package study2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BangMyungAdd2 extends HttpServlet {
	@Override
	public void service(HttpServletRequest request, 
		HttpServletResponse response ) 
		throws ServletException, IOException 
	{
		String gul = request.getParameter("gul");
		
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@127.0.0.1:1521/XE","HR","HR");
			stmt = conn.createStatement();
			
			String sql = "insert into bangmyung_t values "+
					"( seq_bangmyung.nextval , '"+ gul +"', sysdate )";
			stmt.executeUpdate( sql );
		}
		catch( Exception e ) {
			e.printStackTrace();
		}
		finally {
			try{
				if( stmt != null ) stmt.close();
				if( conn != null ) conn.close();
			}
			catch( SQLException e ){}
		}

		response.sendRedirect("/study2/bangmyung_list");
	}
}
