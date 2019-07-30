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

public class BangMyung2Add2 extends HttpServlet {
	@Override
	public void service(HttpServletRequest request, 
		HttpServletResponse response ) 
		throws ServletException, IOException 
	{
		String gul = request.getParameter("gul");
		
		BangMyungVO pvo = new BangMyungVO();
		pvo.setGul( gul );
		
		BangMyungDAO dao = new BangMyungDAO_OracleImpl();
		try {
			dao.add( pvo );
		} catch (Exception e) {
		
		}
		response.sendRedirect("/study2/bangmyung_list");
	}
}
