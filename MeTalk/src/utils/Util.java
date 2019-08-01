package utils;

import java.io.IOException;

import javax.servlet.http.*;
import javax.servlet.jsp.PageContext;

public class Util {
	public static int parseIntOr(String str, int value) {
		if ( !(str == "" || str == null) ) {
			value = Integer.parseInt(str);
		}
		
		return value;
	}
	
	public static void sendErr(PageContext pageContext, Exception err) {
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();
		HttpSession session = pageContext.getSession();
		
		session.setAttribute("err", err);
		String ctxPath = request.getContextPath();
		try {
			response.sendRedirect(ctxPath + "/error.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void redirectLogin(PageContext pageContext) {
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();
		
		String ctxPath = request.getContextPath();
		try {
			response.sendRedirect(ctxPath + "/login.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String nullToBlank(String str) {
		if (str == null) str = "";
		return str;
	}
}
