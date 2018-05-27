<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/28
  Time: 0:00
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>Employee</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" >
</head>
<body>
<div class="employeeForm">
    <h1>Add New Employee</h1>
    <form method="POST" name="employeeForm" >
        <input type="text" name="id"  placeholder="请输入员工编号"><br><br>
        <input type="text" name="name" placeholder="请输入员工姓名"><br><br>
        <input type="text" name="age" placeholder="请输入员工年龄"><br><br>
        <input type="radio" value="男" name="gender">男
        <input type="radio" value="女" name="gender">女<Br /><br>
        <input type="submit" value="Add" />
    </form>
</div>
<div class="listTitle">
    <h1>Recent Employees</h1>
  <%--  <ul class="employeeList">
        <c:forEach items="${employeeList}" var="employee" >
            <li id="employee_<c:out value="employee.id"/>">
                <div>
                    <span class="spittleTime"><c:out value="${employee.id}" /></span>
                    <span class="spittleLocation">(<c:out value="${employee.name}" /><c:out value="${employee.age}" />, <c:out value="${employee.gender}" />)</span>
                </div>
            </li>
        </c:forEach>
    </ul>--%>


    <div class="row margin-top-20">
        <table id="customers">
            <thead>
            <tr class = "head">
                <th>编号</th>
                <th>姓名</th>
                <th>年龄</th>
                <th>性别</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
            <c:forEach items="${employeeList}" var="employee" varStatus="loop">
                <tr <c:if test="${employee.id %2==0}">class="alt" </c:if>>
                    <td><c:out value="${employee.id}" /></td>
                    <td><c:out value="${employee.name}" /></td>
                    <td><c:out value="${employee.age}" /></td>
                    <td><c:out value="${employee.gender}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <c:if test="${fn:length(employeeList) gt 20}">
        <hr />
        <s:url value="/employees?count=${nextCount}" var="more_url" />
        <a href="${more_url}">Show more</a>
    </c:if>

</div>
</body>
</html>
