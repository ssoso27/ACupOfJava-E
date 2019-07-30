package mycat;

import javax.servlet.http.*;
import java.io.IOException;
import javax.servlet.ServletException;
import java.io.PrintWriter;

public class Gugudan extends HttpServlet {

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		PrintWriter out = res.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<table border=\"1\" >");

		for (int i = 1; i <= 9; i++) {
			out.println("<tr>");
			for (int j = 1; j <=9 ; j++) {
				String bgColor = getRandRGB();
				out.println("<td bgColor='#" + bgColor + "'>"
						+ i + " x " + j + " = " + i*j
						+ "</td>");
			}
			out.println("</tr>");
		}

		out.println("</table>");
		out.println("</body>");
		out.println("</html>");		
		
		out.close();
	}
	
	private String getRandRGB() {
		String rgb = "";
		
		int rand = (int) (Math.random() * 100000000) % 16777216;
		rgb = Integer.toHexString(rand);
		
		System.out.println(rgb);
		return rgb;
	}
}
