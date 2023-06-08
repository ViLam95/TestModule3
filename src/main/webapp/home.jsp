<%--
  Created by IntelliJ IDEA.
  User: viquoclam
  Date: 08/06/2023
  Time: 09:40
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nhân viên</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <h1 style="text-align: center">List Employees</h1>
    <div class="row">
        <div class="col-lg-2">
            <a class="btn btn-primary" style="text-decoration: none; color: white" href="/employee?action=create">Create
                new employee</a>
        </div>
        <div class="col-lg-7">
            <a class="btn btn-primary" style="text-decoration: none; color: white" href="/department">Home Department</a>
        </div>
        <div class="col-lg-3">
            <form action="/employees?action=search" method="post">
                <input type="text" name="search">
                <button class="btn btn-info" type="submit">Search</button>
            </form>
        </div>
    </div>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>#</th>
            <th>Email</th>
            <th>Address</th>
            <th>PhoneNumber</th>
            <th>Salary</th>
            <th>Department</th>
            <th colspan="2" style="text-align: center">Action</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${employees}" var="e">
            <tr>
                <td>${e.id}</td>
                <td>${e.name}</td>
                <td>${e.email}</td>
                <td>${e.address}</td>
                <td>${e.phoneNumber}</td>
                <td>${e.deparment.name}</td>
                <td>
                    <a class="btn btn-warning" href="/employees?action=update&&id=${e.id}">Update</a>
                </td>
                <td>
                    <button class="btn btn-danger" onclick="deleteS(${e.id})">Delete</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
<script>
    function deleteS(id) {
        if (confirm("Are you sure?")) {
            window.location.href = `http://localhost:8080/employee?action=delete&&id=` + id
        }
    }
</script>
</body>
</html>
