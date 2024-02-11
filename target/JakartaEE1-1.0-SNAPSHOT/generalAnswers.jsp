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

    <%for (String user : data.keySet()) {%>
    <p><%=user%>
    </p>
    <%for (String key : data.get(user).keySet()) {%>
    <p><%=key + " = " + data.get(user).get(key)%>
    </p>
    <%}%>
    <%}%>
</div>
<br>Click this link to <a href="/sample">go to the quiz again</a>
<br>Click this link to <a href="/login?a=exit">logout</a>
</body>
</html>
