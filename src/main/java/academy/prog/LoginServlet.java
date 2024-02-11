package academy.prog;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LoginServlet extends HttpServlet {
    static final String LOGIN = "admin";
    static final String PASS = "admin";
    static final String LOGIN2 = "user";
    static final String PASS2 = "user";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if ((LOGIN.equals(login) && PASS.equals(password)||(LOGIN2.equals(login) && PASS2.equals(password)))) {
            HttpSession session = request.getSession(true);
            session.setAttribute("user_login", login);
        }

        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String a = request.getParameter("a");
        HttpSession session = request.getSession(false);

        if ("exit".equals(a) && (session != null))
            session.removeAttribute("user_login");

        response.sendRedirect("login.jsp");
    }
}
