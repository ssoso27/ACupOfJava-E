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
		// fileup ���丮�� ������ ���� �ľ��Ѵ�.
		String path = application.getRealPath("/WEB-INF/fileup");
		
		// cos.jar ���� �����Ǵ� Ŭ����
		MultipartRequest mpr = new MultipartRequest( 
				request // request
				, path // ���� �ٿ�ε� ��ġ ������
				, 1024*1024*20 // maxSize
				, "UTF-8" // ���ڵ�
				, new DefaultFileRenamePolicy() // ���ϸ� ��ĥ ���, rename ��Ģ
				);
		
		// origin file name
		String ofn = mpr.getOriginalFileName("apple");
        
		// ���� ����� file name
		String fsn = mpr.getFilesystemName("apple");
		
        System.out.println(ofn);
        System.out.println(fsn);
        
		return null;
	}
}
