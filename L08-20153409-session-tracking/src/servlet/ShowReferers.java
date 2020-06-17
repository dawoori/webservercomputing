package servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/show-referers")
public class ShowReferers extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        ArrayList<String> referers = (ArrayList<String>) session.getAttribute("referers");

        String referer = request.getHeader("referer");
        if (referer == null) referer = "Unknown referer";

        if (referers == null) {
            referers = new ArrayList<>();
        }

        if (referers.indexOf(referer) == -1) referers.add(referer);

        session.setAttribute("referers", referers);

        PrintWriter out = response.getWriter();
        out.print("<html>");
        out.print("<head><title>Registration Form</title></head>");
        out.print("<body>");
        out.print("<h3>Referers</h3>");
        out.print("<ul>");

        for (String s : referers) {
            out.print("<li>referer: " + s + "</li><br/>");
        }

        out.print("</ul>");
        out.print("</body></html>");
        out.close();
    }
}
