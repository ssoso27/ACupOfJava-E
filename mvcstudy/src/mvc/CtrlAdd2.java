package mvc;

import utils.Util;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bangmyung.*;

@RequestMapping("/apple_add2.do")
public class CtrlAdd2 implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String gul = Util.encodeUTF8( request.getParameter("gul") );
		BangMyungVO vo = new BangMyungVO();
		vo.setGul(gul);
		
		BangMyungDAO dao = new BangMyungDAO_OracleImpl();
		dao.add(vo);
		
		return "redirect:/apple_list.do";
	}
	
}
