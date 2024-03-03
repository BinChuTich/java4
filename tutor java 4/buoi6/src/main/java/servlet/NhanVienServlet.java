package servlet;

import entity.NhanVien;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import responsitory.NhanVienRespon;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "NhanVienServlet",value = {
        "/nhan-vien/hien-thi",
        "/nhan-vien/addNV",
        "/nhan-vien/detail",
        "/nhan-vien/delete",
})
public class NhanVienServlet extends HttpServlet {
    NhanVienRespon nvr=new NhanVienRespon();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri= req.getRequestURI();
        if(uri.contains("hien-thi")){
            req.setAttribute("LIST_NV",nvr.getList());
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        } else if(uri.contains("detail")) {
            String id=req.getParameter("id");
            req.setAttribute("NV",nvr.getOne(id));
            req.setAttribute("LIST_NV",nvr.getList());
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }else if(uri.contains("delete")) {
            String id=req.getParameter("id");
            NhanVien nv=nvr.getOne(id);
            nvr.deleteNV(nv);
            req.setAttribute("LIST_NV",nvr.getList());
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri= req.getRequestURI();
        if(uri.contains("addNV")){
            NhanVien nv=new NhanVien();
            try {
                BeanUtils.populate(nv,req.getParameterMap());
                nvr.addNV(nv);
                req.setAttribute("LIST_NV",nvr.getList());
                req.getRequestDispatcher("/index.jsp").forward(req,resp);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
