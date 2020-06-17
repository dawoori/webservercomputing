package servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/repeat-visitor")
public class RepeatVisitor extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();

        if (session.getAttribute("isRepeatVisitor") == null) {
            session.setAttribute("isRepeatVisitor", "true");
            out.print("Welcome Abroad");
        } else {
            out.print("Welcome Back");
        }

        out.close();
    }

}