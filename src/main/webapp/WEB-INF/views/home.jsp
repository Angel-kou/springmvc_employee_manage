<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/27
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Spitter</title>
    <link rel="stylesheet"
          type="text/css"
          href="<c:url value="/resources/style.css" />" >
</head>
<body>
<h1>Welcome to browse Employee</h1>

<a href="<c:url value="/employees" />">Employees</a>
</body>
</html>

