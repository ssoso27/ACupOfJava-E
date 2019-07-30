package study2;

import javax.servlet.http.*;
import java.io.IOException;
import javax.servlet.ServletException;

public class FormTestServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // request charset ����
        request.setCharacterEncoding("utf-8");
        
        // request.getParameter(name) : �ش� �Ķ���Ͱ� ������
		String gul = request.getParameter( "gul" );
		String love = request.getParameter( "love" );
		String hate = request.getParameter( "hate" );
		String method = request.getParameter( "method" );
		String password = request.getParameter( "pwd" );
		String content = request.getParameter( "content" );
		String animal = request.getParameter( "animal" );
		
		System.out.println("[gul] " + gul);
		System.out.println("[Love & Hate] " + love + " & " + hate);
		System.out.println("[method] " + method);
		System.out.println("[password] " + password);
		System.out.println("[content] " + content);
		System.out.println("[animal] " + animal);
		System.out.println("=======================================");
		
        // �ش� url�� �����̷�Ʈ
		response.sendRedirect("/study2/test_01.html");
	}
}
