package com.example.tutorjava.servlet;

import com.example.tutorjava.entity.NhanVien;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "NhanVienServlet", value = {
        "/nhan-vien/hien-thi-tat-ca",


})
public class NhanVienServlet extends HttpServlet {
    ArrayList<NhanVien> nhanVienArrayList = new ArrayList<>();

    ArrayList<String> listComBoBox = new ArrayList<>();

    public NhanVienServlet() {
        nhanVienArrayList.add(new NhanVien(1, "NV001", "Nguyễn Quoc Anh", 2000, "Nam", "Quản Lý"));
        nhanVienArrayList.add(new NhanVien(2, "NV002", "Nguyễn Quoc Anh", 2000, "Nữ", "Quản Lý"));
        nhanVienArrayList.add(new NhanVien(3, "NV003", "Nguyễn Quoc Anh", 2000, "Nam", "Quản Lý"));
        nhanVienArrayList.add(new NhanVien(4, "NV004", "Nguyễn Quoc Anh", 2000, "Nữ", "Quản Lý"));

        listComBoBox.add("Quản Lý");
        listComBoBox.add("Nhân Viên");
        listComBoBox.add("Trưởng Phòng");
        listComBoBox.add("Kế Toán");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("/hien-thi-tat-ca")){
            request.setAttribute("nhanVienArrayList", nhanVienArrayList);
            request.setAttribute("listComBoBox", listComBoBox);
            request.getRequestDispatcher("/hien-thi-nhan-vien.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
