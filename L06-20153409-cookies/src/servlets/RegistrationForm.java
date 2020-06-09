package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registration")
public class RegistrationForm extends HttpServlet {
    
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
	res.setContentType("text/html;charset=UTF-8");
	PrintWriter out = res.getWriter();
	out.print("<html>");
	out.print("<head><title>Registration Form</title></head>");
	out.print("<body>");
	out.print("<h3>µî·Ï Æû</h3>");
	out.print("Request Scheme : " + req.getScheme() + "<br/>");
	out.print("Server Name : " + req.getServerName() + "<br/>");
	out.print("Server Address : " + req.getLocalAddr() + "<br/>");
	out.print("</body></html>");
	out.close();
    }

}
