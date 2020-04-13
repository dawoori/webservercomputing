package basics.L03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/2")
public class Table extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print("<table border=1>");
		for(int i = 1; i < 11; i++) {
			out.print("<th>Column " + i + "</th>");
		}
		for(int i = 1; i < 26; i++) {
			out.print("<tr>");
			for(int j = 1; j < 11; j++) {
				out.printf("<th>Row %d, Col %d</th>", i, j);
			}
			out.print("</tr>");
			
		}
		
		out.print("</table>");
		
		out.close();
	}
}
