
package com.poly.it17326.group3.repository;

import com.poly.it17326.group3.config.HibernateConfig;
import com.poly.it17326.group3.domainmodels.GiaoHang;
import com.poly.it17326.group3.domainmodels.KhuyenMai;
import com.poly.it17326.group3.response.GiaoHangResponse;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


public class GiaoHangRepository {
    private Session session = HibernateConfig.getFACTORY().openSession();
    
    private String fromTable = "FROM GiaoHang";//hsl
    
    public List<GiaoHangResponse> getAll(){
        Query query = session.createQuery(fromTable, GiaoHang.class);
        return  query.getResultList(); 
    }
    
    public Boolean save(GiaoHang gh) {
        Transaction transaction = null;
        try ( Session ss = HibernateConfig.getFACTORY().openSession()) {
            transaction=ss.beginTransaction();
            ss.save(gh);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
     public Boolean update(GiaoHang gh){
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.saveOrUpdate(gh);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public Boolean delete(GiaoHang gh) {
        Transaction transaction = null;
        try ( Session ss = HibernateConfig.getFACTORY().openSession()) {
            transaction= ss.beginTransaction();
            ss.delete(gh);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
}
