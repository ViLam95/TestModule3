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
    <title>Create</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</head>
<body>
 <h1>Add new employee</h1>
 <form method="post">
     <p>Name</p>
     <input placeholder="Enter name" type="text" name="name" value="${employee.name}">
     <p>Email</p>
     <input placeholder="Enter email"type="text" name="email" value="${employee.email}">
     <p>Address</p>
     <input placeholder="Enter address" type="text" name="address" value="${employee.address}">
     <p>Phone number</p>
     <input placeholder="Enter phone number" type="text" name="phone" value="${employee.phoneNumber}">
     <p>Salary</p>
     <input placeholder="Enter salary" type="text" name="salary" value="${employee.salary}">
     <p>Department</p>
     <select name="id_department">
         <option>Open this select menu</option>
         <c:forEach items="${departments}" var="d">
             <option value="${d.id}">${d.name}</option>
         </c:forEach>
     </select><br>
     <button class="btn btn-info" type="submit">Create</button>
 </form>

</body>
</html>
