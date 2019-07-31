package study3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// url-pattern : /study3/state?use=addCookie
public class StateServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String use = request.getParameter("use");
		
		if ( use.equals("addCookie") ) {
			System.out.println("add Cookie.");
			Cookie ck = new Cookie("name", "apple");
			response.addCookie( ck );
		} else if ( use.equals("readCookie") ) {
			Cookie[] cks = request.getCookies();
			System.out.println("cookie len : " + cks.length);
			
			if (cks != null) {
				for (Cookie ck: cks) {
					System.out.println( ck.getName() + ", " + ck.getValue() );
				}
				
			} else {
				System.out.println("cookie is null");
			}
		}
	}
	
}
