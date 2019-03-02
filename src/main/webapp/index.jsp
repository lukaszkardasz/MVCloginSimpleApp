<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%--<%@taglib prefix="x" tagdir="folder z biblioteką tagów" %>--%>
<!doctype html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=yes, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Formularz logowania</title>
</head>
<body>
    <h4>
        Dzisiaj jest: <% out.println(java.time.LocalDate.now().toString());%>
    </h4>
    <h1><b>Panel logowania</b></h1>
    <h2>
        <%--znacznik wyrażeń--%>
        <form action="/loginUser" method="post">
            <input type="text" name="login" value="enter login">
            <input type="password" name="password">
            <input type="submit" value="Loguj">
        </form>
    </h2>
</body>
</html>
