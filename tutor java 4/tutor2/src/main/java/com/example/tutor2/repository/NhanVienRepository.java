package com.example.tutor2.repository;

import com.example.tutor2.model.NhanVien;
import com.example.tutor2.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class NhanVienRepository {
//    public List<NhanVien> getAll() {
//        try (Session session = HibernateUtil.getFACTORY().openSession()) {
//            Query<NhanVien> query = session.createQuery("FROM NhanVien", NhanVien.class);
//            return query.list();
//        }
//    }
    ArrayList<NhanVien> list = new ArrayList<>();
    public ArrayList<NhanVien> getAll(){
        try(Session session= HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from NhanVien ");
            list = (ArrayList<NhanVien>) query.getResultList();
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public NhanVien getOne(String id){
        NhanVien nv = new NhanVien();
        try(Session session= HibernateUtil.getFACTORY().openSession()) {
            nv = session.get(NhanVien.class,id);
            return nv;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public void add(NhanVien nhanVien){
        Transaction transaction = null;
        try(Session session= HibernateUtil.getFACTORY().openSession()) {
            transaction =session.beginTransaction();
            session.saveOrUpdate(nhanVien);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public Boolean remove(String  nhanVien){
        Transaction transaction = null;
        try(Session session= HibernateUtil.getFACTORY().openSession()) {
            transaction =session.beginTransaction();
            session.delete(nhanVien);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
