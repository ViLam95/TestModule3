<%--
  Created by IntelliJ IDEA.
  User: viquoclam
  Date: 08/06/2023
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
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
     <input type="text" name="name" value="${employee.name}">
     <p>Email</p>
     <input type="text" name="email" value="${employee.email}">
     <p>Address</p>
     <input type="text" name="address" value="${employee.address}">
     <p>Phone number</p>
     <input type="text" name="phone" value="${employee.phone}">
     <p>Salary</p>
     <input type="text" name="salary" value="${employee.salary}">
     <p>Department</p>
     <select name="departmentId">
         <option>Open this select menu</option>
         <c:forEach items="${departmentList}" var="d">
             <option value="${d.id}">${d.name}</option>
         </c:forEach>
     </select><br>
     <button class="btn btn-info" type="submit">Submit</button>
 </form>

</body>
</html>
