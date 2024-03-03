<%--
  Created by IntelliJ IDEA.
  User: Thuan
  Date: 11/30/2023
  Time: 3:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<form action="/nhan-vien/add" method="post">
    <div class="mb-3">
        <label class="form-label">ID</label>
        <input type="text" class="form-control" name="id">
    </div>
    <div class="mb-3">
        <label class="form-label">ma</label>
        <input type="text" class="form-control" name="ma">
    </div>
    <div class="mb-3">
        <label class="form-label">Ten</label>
        <input type="text" class="form-control" name="ten" >
    </div>
    <div class="mb-3">
        <label class="form-label">Giới tính</label>
        <br>
        <input type="radio" id="contactChoice1" name="gioiTinh" value="Nam"/>
        <label for="contactChoice1">Nam</label>

        <input type="radio" id="contactChoice2" name="gioiTinh" value="Nu"/>
        <label for="contactChoice2">Nu</label>
    </div>
    <div class="mb-3">
        <label class="form-label">Địa chỉ</label>
        <input type="text" class="form-control" name="diaChi" >
    </div>

    <button type="submit">Add</button>
</form>
<table class="table">
    <tr>
        <th>id</th>
        <th>mã</th>
        <th>tên</th>
        <th>gioi tính</th>
        <th>địa chỉ</th>
        <th colspan="3">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${nhanViens}" var="nv">
        <tr>
            <td>${nv.id}</td>
            <td>${nv.ma}</td>
            <td>${nv.ten}</td>
            <td>${nv.gioiTinh}</td>
            <td>${nv.diaChi}</td>
            <td>
                <button><a href="#">Delete</a></button>
                <button><a href="#">Detail</a></button>
                <button><a href="#">Update</a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
