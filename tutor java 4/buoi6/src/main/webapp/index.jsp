<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

    <title>JSP - Hello World</title>
</head>
<body>
<h1 class="text-center">Quản Lý Nhân Viên</h1>
<br/>
<div class="container">
    <form action="/nhan-vien/addNV" method="post">
        <div class="form-group">
            <h3>Mã</h3>
            <input type="text" name="ma" class="form-control" value="${NV.ma}">
            <p style="color: red">${Loi_Ma}</p>
        </div>
        <div class="form-group">
            <h3>Tên</h3>
            <input type="text" name="ten" class="form-control" value="${NV.ten}" >
            <p style="color: red">${Loi_Ten}</p>
        </div>
        <div class="form-group">
            <h3>Giới tính</h3>
            <label class="checkbox-inline"><input type="radio" name="gioiTinh" value="Nam" class="form-control" <c:if test="${NV.gioiTinh=='Nam'}">checked</c:if>>Nam</label>
            <label class="checkbox-inline"><input type="radio" name="gioiTinh" value="Nữ" class="form-control" <c:if test="${NV.gioiTinh=='Nữ'}">checked</c:if>>Nữ</label>
        </div>
        <div class="form-group">
            <h3>Địa chỉ</h3>
            <input type="text" name="diaChi" class="form-control" value="${NV.diaChi}">
            <p style="color: red">${Loi_DiaChi}</p>
        </div>
        <button class="btn btn-primary" style="margin-top: 10px;" >Thêm</button>
    </form>
</div>
<div class="container mt-5">
    <table class="table table-striped">
        <thead>
        <tr>
            <th class="col">#</th>
            <th class="col">Mã</th>
            <th class="col">Tên</th>
            <th class="col">Giới Tính</th>
            <th class="col">Địa Chỉ</th>
            <th class="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="nv" items="${LIST_NV}" varStatus="stt">
            <tr>
                <td>${stt.index+1}</td>
                <td>${nv.ma}</td>
                <td>${nv.ten}</td>
                <td>${nv.gioiTinh}</td>
                <td>${nv.diaChi}</td>
                <td>
                    <a href="/nhan-vien/detail?id=${nv.id}" class="btn btn-success">Detail</a>
                    <a href="/nhan-vien/delete?id=${nv.id}" class="btn btn-danger" onclick="return confirm('Bạn có muốn xóa nhân viên này không?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>