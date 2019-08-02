package main;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import java.io.*;

public class FileDownServlet extends HttpServlet {
    @Override
    public void service (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
    	// 다운로드 대상 파일명
    	String fsn = request.getParameter("fsn"); 
    	String ofn = request.getParameter("ofn");
    	
    	if (ofn == null) ofn = fsn;

        // 파일 폴더 절대경로
        String path = request.getServletContext().getRealPath("/WEB-INF/fileup"); 
        
        // 전송할 데이터의 type 명시 ( MIME TYPE )
        response.setContentType("application/octet-steam");
        // 다운 받으면서 저장되는 파일 이름 지정
        response.setHeader("content-disposition", "attchment;filename=" + encodeUTF8(ofn) );
        
        // 파일 전송 (server -> client)
        InputStream in = new FileInputStream( path + "\\" + fsn );
        OutputStream out = response.getOutputStream();
        
        byte[] buf = new byte[1024*4];
        int len = 0;
        
        while ( (len = in.read(buf)) != -1) {
        	out.write(buf, 0, len);
        	out.flush();
        }
        
        out.close();
        in.close();
    }
    
    public static String encodeUTF8( String str ) {
		if (str == null || str == "") {
			return str;
		}
		
		try {
			byte[] bs = str.getBytes("8859_1");
			str = new String( bs, "UTF-8" );
		} catch ( Exception e ) {}
		
		return str;
	}
}