package coreservlets;

import java.io.*;
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

@WebServlet("/registration-display")
public class RegistrationDisplay extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	if (isEmpty(request.getParameter("lastname")) || isEmpty(request.getParameter("firstname"))
		|| isEmpty(request.getParameter("emailaddress"))) {
	    response.sendRedirect("registration-form?lastname=" + request.getParameter("lastname") + "&firstname="
		    + request.getParameter("firstname") + "&emailaddress=" + request.getParameter("emailaddress"));
	} else {
	    showRegistration(request, response);
	}
    }

    private void showRegistration(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	String title = "Reading Three Request Parameters";
	String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " + "Transitional//EN\">\n";
	out.println(docType + "<HTML>\n" + "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n"
		+ "<BODY BGCOLOR=\"#FDF5E6\">\n" + "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" + "<UL>\n"
		+ "  <LI><B>Last Name</B>: " + request.getParameter("lastname") + "\n" + "  <LI><B>First Name</B>: "
		+ request.getParameter("firstname") + "\n" + "  <LI><B>Email Address</B>: "
		+ request.getParameter("emailaddress") + "\n" + "</UL>\n" + "</BODY></HTML>");
    }

    private static boolean isEmpty(String input) {
	if (input.length() == 0) {
	    return true;
	} else {
	    return false;
	}
    }
}
