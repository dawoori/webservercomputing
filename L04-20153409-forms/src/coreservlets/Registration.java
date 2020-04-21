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

@WebServlet("/registration")
public class Registration extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	String title = "Reading Three Request Parameters";
	String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " + "Transitional//EN\">\n";
	out.println(docType + "<HTML>\n" + "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n"
		+ "<BODY BGCOLOR=\"#FDF5E6\">\n" + "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" + "<UL>\n"
		+ "  <LI><B>Last Name</B>: " + nullCheck(request, "lastname") + "\n" + "  <LI><B>First Name</B>: "
		+ nullCheck(request, "firstname") + "\n" + "  <LI><B>Email Address</B>: "
		+ nullCheck(request, "emailaddress") + "\n" + "</UL>\n" + "</BODY></HTML>");
    }

    private static String nullCheck(HttpServletRequest request, String parameter) {
	String paramValue = request.getParameter(parameter);
	if (isEmpty(paramValue)) {
	    return "Empty parameters have been submitted.";
	} else {
	    return paramValue;
	}
    }

    private static boolean isEmpty(String input) {
	if (input.length() == 0) {
	    return true;
	} else {
	    return false;
	}
    }
}
