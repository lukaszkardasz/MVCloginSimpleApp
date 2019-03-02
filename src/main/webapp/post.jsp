<%--
  Created by IntelliJ IDEA.
  User: n2god
  Date: 2019-03-02
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<html>
<head>
    <title>
        <%--po przekazaniu sterowania z servletu idziemy tutaj--%>
        ${requestScope.get("post").title}
    </title>
</head>
<body>
<div>
    <font color="#808080">
        <p2>${requestScope.get("post").createdDate}</p2>
    </font>
    </br>
    <b>
    <p0> ${requestScope.get("post").title} </p0>
    </b>
    </br>
    <i>
        <p3>${requestScope.get("post").author}</p3>
    </i>
    </br>
    </br>
    </br>
    <p4>${requestScope.get("post").text}</p4>
    </br>
</div>
</body>
</html>
