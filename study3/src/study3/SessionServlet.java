package study3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// url-pattern : /study3/session
public class SessionServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		System.out.println( session.isNew() ); // 처음만 true, 이후에는 false
		
		session.setAttribute("apple", "MYObject!!");
		Object value = session.getAttribute("apple");
		System.out.println( value.toString() );
	}
	
}
