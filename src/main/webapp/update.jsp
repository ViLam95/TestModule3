<%--
  Created by IntelliJ IDEA.
  User: viquoclam
  Date: 08/06/2023
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<h1>Update employee</h1>
<form method="post">
    <p>Name</p>
    <input type="text" name="name" value="${employee.name}">
    <p>Email</p>
    <input type="text" name="email" value="${employee.email}">
    <p>Address</p>
    <input type="text" name="address" value="${employee.address}">
    <p>Phone number</p>
    <input type="text" name="phone" value="${employee.phoneNumber}">
    <p>Salary</p>
    <input type="text" name="salary" value="${employee.salary}">
    <p>Department</p>
    <select name="departmentId">
        <c:forEach items="${departments}" var="d">
            <option value="${d.id}">${d.name}</option>
        </c:forEach>
    </select>
    <br>
    <button class="btn btn-info" type="submit">Submit</button>
</form>
</body>
</html>
