package mvc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bangmyung.*;

@RequestMapping("/apple_list.do")
public class CtrlList implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// request 贸府
		BangMyungDAO dao = new BangMyungDAO_OracleImpl();
		List<BangMyungVO> bangMyungs = dao.findAll();
		
		// 单捞磐 持扁
		request.setAttribute("lst", bangMyungs);
		
		// viewURI 府畔
		return "/apple_list.jsp";
	}
	
}
