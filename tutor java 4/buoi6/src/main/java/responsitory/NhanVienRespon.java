package responsitory;

import com.example.buoi6.util.HibernateUtil;
import entity.NhanVien;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class NhanVienRespon {
    ArrayList<NhanVien> list=new ArrayList<>();

    public ArrayList<NhanVien> getList() {
        try(Session session= HibernateUtil.getFACTORY().openSession()){
            Query query=session.createQuery("FROM NhanVien ");
            list= (ArrayList<NhanVien>) query.getResultList();
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public NhanVien getOne(String id){
        NhanVien nv=new NhanVien();
        try(Session session= HibernateUtil.getFACTORY().openSession()){
            nv=session.get(NhanVien.class,id);
            return nv;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public void addNV(NhanVien nv){
        Transaction transaction=null;
        try(Session session= HibernateUtil.getFACTORY().openSession()){
            transaction= session.beginTransaction();
            session.save(nv);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
    }
    public void deleteNV(NhanVien nv){
        Transaction transaction=null;
        try(Session session= HibernateUtil.getFACTORY().openSession()){
            transaction= session.beginTransaction();
            session.delete(nv);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
    }
}
