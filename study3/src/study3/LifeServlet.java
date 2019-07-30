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
		/*	���� ������� �ٸ� ������ ���� �����ϴ���, this.toString() �� ����� �����ϴ�.
		 * 	-> ������ �ν��Ͻ��� ��� ����ǰ� �ִ�.
		 * 	-> �Ѳ����� ���� ���͵�, �޸𸮸� ���� �Ҹ��Ѵ�.
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
