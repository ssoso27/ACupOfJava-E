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
		
		// getInitParameter : web.xml에 설정된 내용을 읽어올 수 있는 방법을 제공한다.
		String val = config.getInitParameter("apple");
		System.out.println( val ); // ILikeApple
		
		// WEB-INF 폴더의 절대경로값을 얻어온다.
		// WEB-INF : 브라우저가 접근할 수 없음.
		/// FileInputStream 으로 파일을 읽어올 때, 절대경로를 사용한다.
		/// 그 경우에 getRealPath()를 사용한다.
		ServletContext application = config.getServletContext();
		String path = application.getRealPath("/WEB-INF/");
		System.out.println( path ); // C:\Users\sohi8\workspace\...\study3\WEB-INF\

	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service");
		
		// 컨텍스트 경로
		String l = request.getContextPath();
		System.out.println(l); //	/study3
		
		// request URI ( IP, port 제외 )
		String m = request.getRequestURI();
		System.out.println(m); //	/study3/config
		
		// 접속한 브라우저의 IP 주소값
		String n = request.getRemoteAddr();
		System.out.println(n); // 192.168.2.25
		
		// request Header 값
		String o = request.getHeader("User-Agent");
		System.out.println(o); // Mozilla/5.0 (Linux; Android 7.0; SAMSUNG SM-N920S Build/NRD90M) AppleWebKit/537.36 (KHTML, like Gecko) SamsungBrowser/9.4 Chrome/67.0.3396.87 Mobile Safari/537.36

	}

	@Override
	public void destroy() {
		System.out.println("destroy");
	}

}
