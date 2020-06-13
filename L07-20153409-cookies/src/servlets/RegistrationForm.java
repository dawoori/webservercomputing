package servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

@WebServlet("/registration-form")
public class RegistrationForm extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        Cookie[] cookies = request.getCookies();
        boolean newUser = true;

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("newUser") && c.getValue().equals("no")) {
                    newUser = false;
                    break;
                }
            }
        }

        Cookie newUserCookie = new Cookie("newUser", "no");
        newUserCookie.setMaxAge(60*60*24);
        response.addCookie(newUserCookie);

        String firstName = "";
        String lastName = "";
        String email = "";

        if (!newUser) {
            for (Cookie c : cookies) {
                if (c.getName().equals("firstName")) {
                    firstName = URLDecoder.decode(c.getValue(), "UTF-8");
                } else if (c.getName().equals("lastName")) {
                    lastName = URLDecoder.decode(c.getValue(), "UTF-8");
                } else if (c.getName().equals("email")) {
                    email = URLDecoder.decode(c.getValue(), "UTF-8");
                }
            }
        }

        PrintWriter out = response.getWriter();

        out.print("<html>");
        out.print("<head><title>Registration Form</title></head>");
        out.print("<body>");
        out.print("<h3>등록 폼 (GET 요청)</h3>");
        out.print("<form action=\"registration\" method=\"GET\">");
        out.print("First Name : <input type=\"text\" name=\"firstName\" value=\"" + firstName + "\"/><br/>");
        out.print("Last Name : <input type=\"text\" name=\"lastName\" value=\"" + lastName + "\"/><br/>");
        out.print("Email address : <input type=\"text\" name=\"email\" value=\"" + email + "\"/><br/>");
        out.print("<input type=\"submit\" value=\"전송\"/>");
        out.print("<input type=\"reset\" value=\"지우기\"/>");
        out.print("</form>");
        out.print("</body></html>");
        out.close();
    }
}
