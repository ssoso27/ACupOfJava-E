package main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BangMyungAdd2 extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BangMyungDAO dao = new BangMyungDAO_OracleImpl();
		BangMyungVO vo = new BangMyungVO();
		
		request.setCharacterEncoding("utf-8");
		vo.setGul( request.getParameter("gul") );
		
		try {
			dao.add(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("/study2/list");
	}
	
}
