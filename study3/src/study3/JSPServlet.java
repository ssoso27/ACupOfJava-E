package study3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

public class JSPServlet extends HttpServlet {
	
	private ServletContext application = null;
	private ServletConfig config = null;
	
	/*
	 * <%! ... %> 은 여기로 온다.
	 */
	int i = 0; // <%! int i = 0; %>
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		this.application = config.getServletContext();
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		response.setContentType("test/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// ------------------------------------------------
		/* <% ... %> 은 여기로 온다.
		 * <%= ... %> 은 out.println( ... ) 으로 변환된다.
		 */
		// ------------------------------------------------
		int j = 0; // <% int j = 0; %>
		out.println(i++); // <%= i++ %>
		out.println(j++); // <%= j++ %>
		
		out.flush();
		out.close();
	}
}
