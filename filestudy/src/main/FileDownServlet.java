package main;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import java.io.*;

public class FileDownServlet extends HttpServlet {
    @Override
    public void service (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
    	// �ٿ�ε� ��� ���ϸ�
    	String fsn = request.getParameter("fsn"); 
    	String ofn = request.getParameter("ofn");
    	
    	if (ofn == null) ofn = fsn;

        // ���� ���� ������
        String path = request.getServletContext().getRealPath("/WEB-INF/fileup"); 
        
        // ������ �������� type ��� ( MIME TYPE )
        response.setContentType("application/octet-steam");
        // �ٿ� �����鼭 ����Ǵ� ���� �̸� ����
        response.setHeader("content-disposition", "attchment;filename=" + encodeUTF8(ofn) );
        
        // ���� ���� (server -> client)
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