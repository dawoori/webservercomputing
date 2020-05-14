package coreservlets;

import java.io.*;
import java.util.Objects;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * Servlet that prints out the param1, param2, and param3 request parameters.
 * Does not filter out HTML tags.
 * <p>
 * From <a href="http://courses.coreservlets.com/Course-Materials/">the
 * coreservlets.com tutorials on servlets, JSP, Struts, JSF, Ajax, GWT, and
 * Java</a>.
 */

@WebServlet("/registration-form")
public class RedirectRegistration extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	String title = "Registration Form";
	String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " + "Transitional//EN\">\n";
	out.println(
		docType + "<HTML>\n" + "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" + "<BODY BGCOLOR=\"#FDF5E6\">\n"
			+ "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" + "<FORM ACTION=\"registration-display\">");
	if (request.getParameter("lastname") != null && isEmpty(request.getParameter("lastname"))) {
	    out.println("<B>Required Field!!</B>");
	}
	out.println("Last Name:  <INPUT TYPE=\"TEXT\" NAME=\"lastname\" VALUE=\""
		+ Objects.toString(request.getParameter("lastname"), "") + "\"><BR>");
	if (request.getParameter("firstname") != null && isEmpty(request.getParameter("firstname"))) {
	    out.println("<B>Required Field!!</B>");
	}
	out.println("First Name: <INPUT TYPE=\"TEXT\" NAME=\"firstname\"VALUE=\""
		+ Objects.toString(request.getParameter("firstname"), "") + "\"><BR>");
	if (request.getParameter("emailaddress") != null && isEmpty(request.getParameter("emailaddress"))) {
	    out.println("<B>Required Field!!</B>");
	}
	out.println("Email address:  <INPUT TYPE=\"TEXT\" NAME=\"emailaddress\" VALUE=\""
		+ Objects.toString(request.getParameter("emailaddress"), "") + "\"><BR>");
	out.println("<CENTER><INPUT TYPE=\"SUBMIT\"></CENTER>" + "</FORM>" + "</BODY></HTML>");
    }

    private static boolean isEmpty(String input) {
	if (input.length() == 0) {
	    return true;
	} else {
	    return false;
	}
    }
}
