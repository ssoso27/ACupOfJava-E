package main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class BangMyungList extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BangMyungDAO dao = new BangMyungDAO_OracleImpl();
		List<BangMyungVO> ls = new ArrayList<BangMyungVO>();
		
		try {
			ls = dao.findAll();
		} catch (Exception e) {
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
		out.println("<br><br>");

		out.println("<form method='POST' action='add'>");
		out.println("<input type='text' size='50' name='gul' />");
		out.println("<input type='submit'/>");
		out.println("</form>");
		
		out.println(" </body>");
		out.println("</html>");
		
		out.close();
	}
	
}
