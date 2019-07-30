package study2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormTestServlet extends HttpServlet {
	@Override
	public void service(HttpServletRequest request, 
		HttpServletResponse response) 
		throws ServletException, IOException 
	{
		System.out.println("FormTestServlet");
		
		/*	request : 요청과 관련되어진 함수 모음.
		 * 	response : 응답과 관련되어진 함수가 모여있다.

			sendRedirect - 브라우저에게 해당 경로로 요청할 것을 지시한다.
			getParameter - 요청시에 곁다리(?) 로 들어온 정보를 추출한다.
		 */
		String gul = request.getParameter("gul");
		System.out.println( "gul : " + gul );
		
		String abcd = request.getParameter("abcd");
		String xyzz = request.getParameter("xyzz");
		System.out.println( "abcd : " + abcd );
		System.out.println( "xyzz : " + xyzz );
		
		String method = request.getParameter("method");
		System.out.println( "method : " + method );

		String pwd = request.getParameter("pwd");
		System.out.println( "pwd : " + pwd );

		String content = request.getParameter("content");
		System.out.println( "content : " + content );

		String fruit = request.getParameter("fruit");
		System.out.println( "fruit : " + fruit );
		
		response.sendRedirect("/study2/test_02.html");
	}
}






