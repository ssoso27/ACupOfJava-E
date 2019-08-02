package main;

import java.io.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

// url-pattern : /fileup
public class FileUpServlet extends HttpServlet {
	
	private ServletContext application = null;
	

	@Override
	public void init(ServletConfig config) throws ServletException {
			this.application = config.getServletContext();
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = process2( request );
	}
	
	public String process(HttpServletRequest request) throws IOException {
		byte[] buf = new byte[1024];
		int len = 0;
		
		StringBuffer sb = new StringBuffer();
		
		// fromClient
		InputStream in = request.getInputStream();
		while( (len = in.read(buf) ) != -1 ) {
			sb.append( new String(buf, 0, len) );
		}
		in.close();

		return sb.toString();
	}
	
	public String process2(HttpServletRequest request) throws IOException {
		// fileup 디렉토리의 절대경로 값을 파악한다.
		String path = application.getRealPath("/WEB-INF/fileup");
		
		// cos.jar 에서 제공되는 클래스
		MultipartRequest mpr = new MultipartRequest( 
				request // request
				, path // 파일 다운로드 위치 절대경로
				, 1024*1024*20 // maxSize
				, "UTF-8" // 인코딩
				, new DefaultFileRenamePolicy() // 파일명 겹칠 경우, rename 규칙
				);
		
		// origin file name
		String ofn = mpr.getOriginalFileName("apple");
        
		// 실제 저장된 file name
		String fsn = mpr.getFilesystemName("apple");
		
        System.out.println(ofn);
        System.out.println(fsn);
        
		return null;
	}
}
