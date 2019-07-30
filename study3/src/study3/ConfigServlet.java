package study3;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfigServlet extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init");
		
		// getInitParameter : web.xml�� ������ ������ �о�� �� �ִ� ����� �����Ѵ�.
		String val = config.getInitParameter("apple");
		System.out.println( val ); // ILikeApple
		
		// WEB-INF ������ �����ΰ��� ���´�.
		// WEB-INF : �������� ������ �� ����.
		/// FileInputStream ���� ������ �о�� ��, �����θ� ����Ѵ�.
		/// �� ��쿡 getRealPath()�� ����Ѵ�.
		ServletContext application = config.getServletContext();
		String path = application.getRealPath("/WEB-INF/");
		System.out.println( path ); // C:\Users\sohi8\workspace\...\study3\WEB-INF\

	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service");
		
		// ���ؽ�Ʈ ���
		String l = request.getContextPath();
		System.out.println(l); //	/study3
		
		// request URI ( IP, port ���� )
		String m = request.getRequestURI();
		System.out.println(m); //	/study3/config
		
		// ������ �������� IP �ּҰ�
		String n = request.getRemoteAddr();
		System.out.println(n); // 192.168.2.25
		
		// request Header ��
		String o = request.getHeader("User-Agent");
		System.out.println(o); // Mozilla/5.0 (Linux; Android 7.0; SAMSUNG SM-N920S Build/NRD90M) AppleWebKit/537.36 (KHTML, like Gecko) SamsungBrowser/9.4 Chrome/67.0.3396.87 Mobile Safari/537.36

	}

	@Override
	public void destroy() {
		System.out.println("destroy");
	}

}
