<%@ page import="java.util.Map" %>
<%@ page import="academy.prog.LoginServlet" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Answers</title>
</head>
<%Map<String, Map<String, Integer>> data = (Map<String, Map<String, Integer>>) session.getAttribute("data");%>
<body>
<div class="line">
    <%if (session.getAttribute("user_login").equals("admin")) {%>
        <%for (String key : data.get(session.getAttribute("user_login")).keySet()) {%>
            <p><%=key + " = " + data.get(session.getAttribute("user_login")).get(key)%></p>
        <%}%>
    <%}%>
    <%if (session.getAttribute("user_login").equals("user")) {%>
        <%for (String key : data.get(session.getAttribute("user_login")).keySet()) {%>
            <p><%=key + " = " + data.get(session.getAttribute("user_login")).get(key)%></p>
        <%}%>
    <%}%>
</div>
<br>Click this link to <a href="generalAnswers.jsp">check general answers</a>
<br>Click this link to <a href="/sample">go to the quiz again</a>
<br>Click this link to <a href="/login?a=exit">logout</a>
</body>
</html>
