package servlet;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet("/registration-with-session")
public class RegistrationWithSession extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String emailAddress = request.getParameter("emailAddress");

        HttpSession session = request.getSession();

        String firstNameTemp, lastNameTemp, emailAddressTemp;

        firstNameTemp = (String) session.getAttribute("firstName");
        lastNameTemp = (String) session.getAttribute("lastName");
        emailAddressTemp = (String) session.getAttribute("emailAddress");
        if (firstNameTemp == null) {
            firstNameTemp = "Unknown";
        }
        if (lastNameTemp == null) {
            lastNameTemp = "Unknown";
        }
        if (emailAddressTemp == null) {
            emailAddressTemp = "Unknown";
        }

        if (firstName == null || Objects.equals(firstName, "")) {
            firstName = firstNameTemp;
        }
        if (lastName == null || Objects.equals(lastName, "")) {
            lastName = lastNameTemp;
        }
        if (emailAddress == null || Objects.equals(emailAddress, "")) {
            emailAddress = emailAddressTemp;
        }

        session.setAttribute("firstName", firstName);
        session.setAttribute("lastName", lastName);
        session.setAttribute("emailAddress", emailAddress);

        out.print("<html>");
        out.print("<head><title>Registration Form</title></head>");
        out.print("<body>");
        out.print("<h3>세션을 이용한 등록 (GET 요청 처리 결과)</h3>");
        out.print("First Name : " + firstName + "<br/>");
        out.print("Last NAme : " + lastName + "<br/>");
        out.print("Email Address : " + emailAddress + "<br/>");
        out.print("</body></html>");
        out.close();
    }
}
