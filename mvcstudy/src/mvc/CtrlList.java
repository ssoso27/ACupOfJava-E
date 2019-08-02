package mvc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bangmyung.*;

@RequestMapping("/apple_list.do")
public class CtrlList implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// request ó��
		BangMyungDAO dao = new BangMyungDAO_OracleImpl();
		List<BangMyungVO> bangMyungs = dao.findAll();
		
		// ������ �ֱ�
		request.setAttribute("lst", bangMyungs);
		
		// viewURI ����
		return "/apple_list.jsp";
	}
	
}
