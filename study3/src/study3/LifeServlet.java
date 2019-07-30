package study3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeServlet extends HttpServlet {
	int i = 0;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*	많은 사람들이 다른 곳에서 각기 접속하더라도, this.toString() 의 결과는 동일하다.
		 * 	-> 동일한 인스턴스가 계속 재사용되고 있다.
		 * 	-> 한꺼번에 많이 들어와도, 메모리를 적게 소모한다.
		 */
		System.out.println( this.toString() );
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		
		synchronized ( this ){
			i = i+1;
			for (int j = 0; j < 100; j++ ){
				out.println( this.i );
			}
		}
		
		out.println("</body></html>");
		
		out.close();
	}

}
