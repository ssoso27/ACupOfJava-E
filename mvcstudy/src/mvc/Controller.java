package mvc;

import javax.servlet.http.*;

public interface Controller {
	// request �� ó���� ��, ViewURI�� ����.
	public String handleRequest ( HttpServletRequest request, HttpServletResponse response ) throws Exception ;
}
