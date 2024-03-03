package com.example.tutor2.servlet;

import com.example.tutor2.model.NhanVien;
import com.example.tutor2.service.NhanVienService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "NhanVienServlet", value = {
        "/nhan-vien/hien-thi",
        "/nhan-vien/add",
        "/nhan-vien/detail",
        "/nhan-vien/delete"

})
public class NhanVienServlet extends HttpServlet {
    NhanVienService nhanVienService = new NhanVienService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("/hien-thi")){
            List<NhanVien> nhanViens = nhanVienService.getList();
            request.setAttribute("nhanViens", nhanViens);
            request.getRequestDispatcher("/viewnhanvien.jsp").forward(request,response);
        }else if(uri.contains("/delete")){
            String id = request.getParameter("id");
            nhanVienService.delete(id);
            response.sendRedirect("/nhan-vien/hien-thi");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("/add")){
            NhanVien nhanVien = new NhanVien();
//            try {
//                BeanUtils.populate(nhanVien, request.getParameterMap());
//                nhanVienService.add(nhanVien);
//                request.setAttribute("nhanViens", nhanVienService.getList());
//                request.getRequestDispatcher("/viewnhanvien.jsp").forward(request,response);
//
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
            nhanVien.setMa(request.getParameter("ma"));
            nhanVien.setTen(request.getParameter("ten"));
            nhanVien.setGioiTinh(request.getParameter("gioiTinh"));
            nhanVien.setDiaChi(request.getParameter("diaChi"));
            nhanVienService.add(nhanVien);
            response.sendRedirect("/nhan-vien/hien-thi");
        }
    }
}
