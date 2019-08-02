package mvc;

import javax.servlet.http.*;

public interface Controller {
	// request 를 처리한 후, ViewURI을 리턴.
	public String handleRequest ( HttpServletRequest request, HttpServletResponse response ) throws Exception ;
}
