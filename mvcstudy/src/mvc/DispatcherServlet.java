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
	// url-pattern / controller 매핑
	private Map<String, Controller> map = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		map = new Hashtable<String, Controller>();
		
		String ctrlNames = config.getInitParameter("controllers");
		for (String ctrlName : ctrlNames.split(",")) {
			try {
				// 해당 이름의 class를 가져오고
				Class<?> cls = Class.forName( ctrlName.trim() );
				
				// requestMapping에 지정된 url-pattern 을 가져오고
				RequestMapping requestMapping = cls.getAnnotation( RequestMapping.class );
				String url = requestMapping.value();
				
				// 해당 controller instance 받아오고
				Controller controller = (Controller) cls.newInstance();
				
				// url-pattern / controller instance 매핑
				map.put(url, controller);
				
			} catch ( Exception e ) {
				
			}
		}
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ctxPath = request.getContextPath(); // /mvcstudy
		String uri = request.getRequestURI(); // /mvcstudy/happy.do
		// ctxPath 를 제외한 URI
		uri = uri.substring( ctxPath.length() ); // /happy.do
		
		// 해당 uri에 매핑된 controller 찾기
		Controller ctrl = map.get( uri ); 
		
        if(ctrl == null){
            System.out.println("등록 되지 않은 요청입니다.");
            return;
        }
		
        // controller가 가리키는 viewURI 를 받고, View를 띄워줌
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
