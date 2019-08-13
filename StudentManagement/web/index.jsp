<%--
  Created by IntelliJ IDEA.
  User: handsomestar
  Date: 2019/8/10
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    request.getRequestDispatcher("indexServlet.do").forward(request,response);
  %>

  </body>
</html>
