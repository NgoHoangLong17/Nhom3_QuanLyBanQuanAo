/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.repository;

import com.poly.it17326.group3.config.HibernateConfig;
import com.poly.it17326.group3.domainmodels.NSX;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author ADMIN
 */
public class NSXRepositpry {

      private Session session = HibernateConfig.getFACTORY().openSession();
    
    private String fromTable = "FROM NSX"; // HQL
    
    public List<NSX>getAll(){
        javax.persistence.Query query = session.createQuery(fromTable, NSX.class);
        return query.getResultList();
    }
    public NSX getOne(Integer  ID){
        String sql = fromTable + " WHERE ID =:ID ";
        javax.persistence.Query query = session.createQuery(sql, NSX.class);
        query.setParameter("ID", ID);
        return (NSX) query.getSingleResult();
    }
    
    public Boolean add(NSX nsx){
        Transaction transaction = null;
        try(Session session = HibernateConfig.getFACTORY().openSession()){
        transaction = session.beginTransaction();
        session.save(nsx);
        transaction.commit();
        return true;
        }catch(Exception e){
        e.printStackTrace(System.out);
        }
        return null;
    }
    public Boolean update(NSX nsx){
        Transaction transaction = null;
        try(Session session = HibernateConfig.getFACTORY().openSession()){
        transaction = session.beginTransaction();
        session.saveOrUpdate(nsx);
        transaction.commit();
        return true;
        }catch(Exception e){
        e.printStackTrace(System.out);
        }
        return null;
    }
    public Boolean delete(NSX nsx){
        Transaction transaction = null;
        try(Session session = HibernateConfig.getFACTORY().openSession()){
        transaction = session.beginTransaction();
        session.delete(nsx);
        transaction.commit();
        return true;
        }catch(Exception e){
        e.printStackTrace(System.out);
        }
        return null;
    }
    
    public static void main(String[] args) {
        List<NSX> nsxs = new NSXRepositpry().getAll();
        for (NSX nsx :nsxs){
            System.out.println(nsx.toString());
        }
    }
}
