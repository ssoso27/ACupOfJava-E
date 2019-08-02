package mvc;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DispatcherServlet extends HttpServlet {
	// url-pattern / controller ����
	private Map<String, Controller> map = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		map = new Hashtable<String, Controller>();
		
		String ctrlNames = config.getInitParameter("controllers");
		for (String ctrlName : ctrlNames.split(",")) {
			try {
				// �ش� �̸��� class�� ��������
				Class<?> cls = Class.forName( ctrlName.trim() );
				
				// requestMapping�� ������ url-pattern �� ��������
				RequestMapping requestMapping = cls.getAnnotation( RequestMapping.class );
				String url = requestMapping.value();
				
				// �ش� controller instance �޾ƿ���
				Controller controller = (Controller) cls.newInstance();
				
				// url-pattern / controller instance ����
				map.put(url, controller);
				
			} catch ( Exception e ) {
				
			}
		}
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ctxPath = request.getContextPath(); // /mvcstudy
		String uri = request.getRequestURI(); // /mvcstudy/happy.do
		// ctxPath �� ������ URI
		uri = uri.substring( ctxPath.length() ); // /happy.do
		
		// �ش� uri�� ���ε� controller ã��
		Controller ctrl = map.get( uri ); 
		
        if(ctrl == null){
            System.out.println("��� ���� ���� ��û�Դϴ�.");
            return;
        }
		
        // controller�� ����Ű�� viewURI �� �ް�, View�� �����
		try {
			String viewURI = ctrl.handleRequest(request, response);
			if ( viewURI == null ) {
				
			} else if ( viewURI.startsWith("redirect:") ) {
				response.sendRedirect( ctxPath + viewURI.substring(9));
			} else {
				RequestDispatcher rd = request.getRequestDispatcher( viewURI );
				rd.forward(request, response);
			}
		} catch ( Exception e ) {
			HttpSession session = request.getSession();
			session.setAttribute("err", e);
			
			response.sendRedirect( ctxPath + "/error.jsp" );
		}
	}
	
}
