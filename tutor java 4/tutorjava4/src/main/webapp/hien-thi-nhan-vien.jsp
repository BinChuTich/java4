<%--
  Created by IntelliJ IDEA.
  User: Thuan
  Date: 11/24/2023
  Time: 8:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
            integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
            integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
            crossorigin="anonymous"></script>
    <title>Title</title>
</head>
<body>
<form>
    <div class="row mb-3">
        <label class="col-sm-2 col-form-label">id</label>
        <div class="col-sm-10">
            <input type="text" class="form-control">
        </div>
    </div>
    <div class="row mb-3">
        <label class="col-sm-2 col-form-label">Mã Nhân Viên</label>
        <div class="col-sm-10">
            <input type="text" class="form-control">
        </div>
    </div>
    <div class="row mb-3">
        <label class="col-sm-2 col-form-label">Họ Tên</label>
        <div class="col-sm-10">
            <input type="text" class="form-control">
        </div>
    </div>
    <fieldset class="row mb-3">
        <legend class="col-form-label col-sm-2 pt-0">gioi tinh</legend>
        <div class="col-sm-10">
            <div class="form-check">
                <input class="form-check-input" type="radio" name="gioiTinh" value="Nam" checked>
                <label class="form-check-label">
                    Nam
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="gioiTinh"  value="Nữ">
                <label class="form-check-label" >
                    Nữ
                </label>
            </div>
        </div>
    </fieldset>
    <div class="row mb-3">
        <label class="form-label">Chức Vụ</label>
        <select class="form-select" name="chucVu">
            <c:forEach var="i" items="${listComBoBox}">
                <option value="${i.id}"></option>
            </c:forEach>
        </select>
    </div>
    <button type="submit" class="btn btn-primary">Sign in</button>
</form>
<table class="table">
    <thead>
    <tr>
        <td>STT</td>
        <td>ID</td>
        <td>Mã Nhân Viên</td>
        <td>Họ Tên</td>
        <td>Giới tính</td>
        <td>Chức vụ</td>
        <td>Năm Sinh</td>
        <td>Action</td>
    </tr>
    </thead>
    <tbody>
        <c:forEach items="${nhanVienArrayList}" var="i" varStatus="nhanVien1">
            <tr>
                <td>${nhanVien1.index}</td>
                <td>${i.id}</td>
                <td>${i.maNV}</td>
                <td>${i.tenNV}</td>
                <td>${i.gioiTinh}</td>
                <td>${i.chucVu}</td>
                <td>${i.namSinh}</td>
                <td>
                    <a href="" class="btn btn-primary">Detail</a>
                    <a href="" class="btn btn-primary">Edit</a>
                    <a href="" class="btn btn-primary">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
