package coreservlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/three-params-filtered")
public class ThreeParamsFiltered extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	String title = "Reading Three Request Parameters";
	String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " + "Transitional//EN\">\n";
	out.println(docType + "<HTML>\n" + "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n"
		+ "<BODY BGCOLOR=\"#FDF5E6\">\n" + "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" + "<UL>\n"
		+ "  <LI><B>param1</B>: " + getCode(request, "param1") + "\n" + "  <LI><B>param2</B>: "
		+ getCode(request, "param2") + "\n" + "  <LI><B>param3</B>: " + getCode(request, "param3") + "\n"
		+ "</UL>\n" + "</BODY></HTML>");
    }

    protected String getCode(HttpServletRequest request, String parameter) {
	return filter(request.getParameter(parameter));
    }

    public static String filter(String input) {
	if (!hasSpecialChars(input)) {
	    return (input);
	}
	StringBuilder filtered = new StringBuilder(input.length());
	char c;
	for (int i = 0; i < input.length(); i++) {
	    c = input.charAt(i);
	    switch (c) {
	    case '<':
		filtered.append("&lt;");
		break;
	    case '>':
		filtered.append("&gt;");
		break;
	    case '"':
		filtered.append("&quot;");
		break;
	    case '&':
		filtered.append("&amp;");
		break;
	    default:
		filtered.append(c);
	    }
	}
	return (filtered.toString());
    }

    private static boolean hasSpecialChars(String input) {
	boolean flag = false;
	if ((input != null) && (input.length() > 0)) {
	    char c;
	    for (int i = 0; i < input.length(); i++) {
		c = input.charAt(i);
		switch (c) {
		case '<':
		    flag = true;
		    break;
		case '>':
		    flag = true;
		    break;
		case '"':
		    flag = true;
		    break;
		case '&':
		    flag = true;
		    break;
		}
	    }
	}
	return (flag);
    }
}
