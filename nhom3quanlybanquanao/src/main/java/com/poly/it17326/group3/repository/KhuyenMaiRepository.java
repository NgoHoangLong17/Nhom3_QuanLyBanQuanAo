/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.repository;

import com.poly.it17326.group3.config.HibernateConfig;
import com.poly.it17326.group3.domainmodels.KhuyenMai;
import com.poly.it17326.group3.response.KhuyenMaiReponse;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author longnh203
 */
public class KhuyenMaiRepository {

    public List<KhuyenMai> getAll() {
        Session ses = HibernateConfig.getFACTORY().openSession();
        String HQL = "from KhuyenMai";
        Query q = ses.createQuery(HQL);
        return q.getResultList();
    }

    public Boolean save(KhuyenMai km) {
        Transaction transaction = null;
        try ( Session ss = HibernateConfig.getFACTORY().openSession()) {
            transaction=ss.beginTransaction();
            ss.save(km);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
     public Boolean update(KhuyenMai khuyenMai){
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.saveOrUpdate(khuyenMai);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public Boolean delete(KhuyenMai km) {
        Transaction transaction = null;
        try ( Session ss = HibernateConfig.getFACTORY().openSession()) {
            transaction= ss.beginTransaction();
            ss.delete(km);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public List<KhuyenMai> tim(String Ten) { // timf theo ngay

        try ( Session session = HibernateConfig.getFACTORY().openSession();) {
            String sql = "from KhuyenMai where Ten = :Ten";                 
            javax.persistence.Query query = session.createQuery(sql);
            query.setParameter("Ten", Ten);           
            List<KhuyenMai> listkm = (List<KhuyenMai>) query.getResultList();

            session.close();
            return listkm;
        }

    }


    

}
