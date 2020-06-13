package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Objects;

@WebServlet("/registration")
public class Registration extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean isMissingValue = false;

        Cookie[] cookies = request.getCookies();

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");

        for (Cookie c : cookies) {
            if ((firstName == null || Objects.equals(firstName, "") || Objects.equals(firstName, "알 수 없음")) && c.getName().equals("firstName")) {
                firstName = URLDecoder.decode(c.getValue(), "UTF-8");
            } else if ((lastName == null || Objects.equals(lastName, "") || Objects.equals(lastName, "알 수 없음")) && c.getName().equals("lastName")) {
                lastName = URLDecoder.decode(c.getValue(), "UTF-8");
            } else if ((email == null || Objects.equals(email, "") || Objects.equals(email, "알 수 없음")) && c.getName().equals("email")) {
                email = URLDecoder.decode(c.getValue(), "UTF-8");
            }
        }

        if (firstName == null || Objects.equals(firstName, "") || Objects.equals(firstName, "알 수 없음")) {
            firstName = "알 수 없음";
            isMissingValue = true;
        }
        if (lastName == null || Objects.equals(lastName, "") || Objects.equals(lastName, "알 수 없음")) {
            lastName = "알 수 없음";
            isMissingValue = true;
        }
        if (email == null || Objects.equals(email, "") || Objects.equals(email, "알 수 없음")) {
            email = "알 수 없음";
            isMissingValue = true;
        }

        firstName = URLEncoder.encode(firstName, "UTF-8");
        lastName = URLEncoder.encode(lastName, "UTF-8");
        email = URLEncoder.encode(email, "UTF-8");

        Cookie firstNameCookie = new Cookie("firstName", firstName);
        Cookie lastNameCookie = new Cookie("lastName", lastName);
        Cookie emailCookie = new Cookie("email", email);

        response.setContentType("text/html;charset=UTF-8");

        response.addCookie(firstNameCookie);
        response.addCookie(lastNameCookie);
        response.addCookie(emailCookie);

        if(isMissingValue) {
            response.sendRedirect("registration-form");
        }

        firstName = URLDecoder.decode(firstName, "UTF-8");
        lastName = URLDecoder.decode(lastName, "UTF-8");
        email = URLDecoder.decode(email, "UTF-8");

        PrintWriter out = response.getWriter();
        out.print("<html>");
        out.print("<head><title>Registration Form</title></head>");
        out.print("<body>");
        out.print("<h3>쿠키를 이용한 등록 (GET 요청 처리 결과)</h3>");
        out.print("First Name : " + firstName + "<br/>");
        out.print("Last NAme : " + lastName + "<br/>");
        out.print("Email Address : " + email + "<br/>");
        out.print("</body></html>");
        out.close();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean isMissingValue = false;

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");

        if (firstName == null || Objects.equals(firstName, "")) {
            firstName = "알 수 없음";
            isMissingValue = true;
        }
        if (lastName == null || Objects.equals(lastName, "")) {
            lastName = "알 수 없음";
            isMissingValue = true;
        }
        if (email == null || Objects.equals(email, "")) {
            email = "알 수 없음";
            isMissingValue = true;
        }

        firstName = URLEncoder.encode(firstName, "UTF-8");
        lastName = URLEncoder.encode(lastName, "UTF-8");
        email = URLEncoder.encode(email, "UTF-8");

        Cookie firstNameCookie = new Cookie("firstName", firstName);
        Cookie lastNameCookie = new Cookie("lastName", lastName);
        Cookie emailCookie = new Cookie("email", email);

        response.setContentType("text/html;charset=UTF-8");

        response.addCookie(firstNameCookie);
        response.addCookie(lastNameCookie);
        response.addCookie(emailCookie);

        if(isMissingValue) {
            response.sendRedirect("registration-form");
        }

        firstName = URLDecoder.decode(firstName, "UTF-8");
        lastName = URLDecoder.decode(lastName, "UTF-8");
        email = URLDecoder.decode(email, "UTF-8");

        PrintWriter out = response.getWriter();
        out.print("<html>");
        out.print("<head><title>Registration Form</title></head>");
        out.print("<body>");
        out.print("<h3>쿠키를 이용한 등록 (GET 요청 처리 결과)</h3>");
        out.print("First Name : " + firstName + "<br/>");
        out.print("Last NAme : " + lastName + "<br/>");
        out.print("Email Address : " + email + "<br/>");
        out.print("</body></html>");
        out.close();
    }
}
