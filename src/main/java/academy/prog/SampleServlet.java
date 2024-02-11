package academy.prog;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SampleServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");

        Map<String, Integer> dataAdmin = new HashMap<>();
        dataAdmin.put("red", 0);
        dataAdmin.put("blue", 0);
        dataAdmin.put("coffee", 0);
        dataAdmin.put("tea", 0);

        Map<String, Integer> dataUser = new HashMap<>();
        dataUser.put("red", 0);
        dataUser.put("blue", 0);
        dataUser.put("coffee", 0);
        dataUser.put("tea", 0);

        Map<String, Map<String, Integer>> data = new HashMap<>();
        data.put("admin", dataAdmin);
        data.put("user", dataUser);

        HttpSession session = req.getSession(true);
        if (session.getAttribute("data") == null) {
            session.setAttribute("data", data);
        }

        resp.sendRedirect("quiz.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();

        Map<String, Map<String, Integer>> dataBase = (Map<String, Map<String, Integer>>) session.getAttribute("data");

        String login = (String) session.getAttribute("user_login");

        String q1 = req.getParameter("q1");
        String q2 = req.getParameter("q2");

        if (login != null && login.equals(LoginServlet.LOGIN)) {
            Map<String, Integer> answers = dataBase.get(login);
            answersCounter(answers, q1);
            answersCounter(answers, q2);
            dataBase.put(login, answers);
        }
        if (login != null && login.equals(LoginServlet.LOGIN2)) {
            Map<String, Integer> answers = dataBase.get(login);
            answersCounter(answers, q1);
            answersCounter(answers, q2);
            dataBase.put(login, answers);
        }
        session.setAttribute("data", dataBase);

        resp.sendRedirect("answers.jsp");
    }

    private void answersCounter(Map<String, Integer> answers, String key) {
        if (answers.containsKey(key)) {
            int temp = 0;
            answers.put(key, temp + 1);
        }
    }
}
