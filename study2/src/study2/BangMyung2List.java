package study2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//	/bangmyung_list 로 요청이 들어오면 보여지게 세팅해 보자.
public class BangMyung2List extends HttpServlet 
{
	@Override
	public void service(HttpServletRequest request, 
		HttpServletResponse response) 
		throws ServletException, IOException 
	{
		System.out.println("BangMyung2List");
		
		BangMyungDAO dao = new BangMyungDAO_OracleImpl();
		List<BangMyungVO> ls = null;
		try {
			ls = dao.findAll();
		} catch (Exception e) {

		}
		
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<body>");		
		
		out.println("		<table border=\"0\" cellspacing='2' cellpadding='8'>");
		out.println("<tr><td width='80'></td><td width='320'></td><td width='160'></td></tr>");
		
		int i = 0;
		for( BangMyungVO vo : ls ) {
			String color = ( ( ++i % 2 ) == 0 ) ? "#aabbcc" : "#ccddee"; 
			out.println("		<tr bgColor='"+ color +"'>");
			out.println("			<td>");
			out.println( vo.getNo() );		
			out.println("			</td><td>");			
			out.println( vo.getGul() );
			out.println("			</td><td>");			
			out.println( vo.getTheTime() );
			out.println("			</td>");			
			out.println("		</tr>");
		}
		out.println("		</table>");
/*
		<form method=\"POST\" action=\"bangmyung_add2\">
			<input type=\"text\" size=\"50\"/>
			<input type=\"submit\"/>
		</form>
*/
		out.println("<br/><br/>");
		out.println("<form method=\"POST\" action=\"bangmyung_add2\">");
		out.println("	<input type=\"text\" name=\"gul\" size=\"50\"/>");
		out.println("	<input type=\"submit\"/>");
		out.println("</form>");
		
		out.println("	</body>");		
		out.println("</html>");		
		out.close();
	}
}
