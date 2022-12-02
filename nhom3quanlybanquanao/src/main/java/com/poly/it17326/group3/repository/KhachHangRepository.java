/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.repository;

import com.poly.it17326.group3.config.HibernateConfig;
import com.poly.it17326.group3.domainmodels.KhachHang;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author doand
 */
public class KhachHangRepository {

    private Session session = HibernateConfig.getFACTORY().openSession();
    private String fromTable = "From KhachHang";

    public List<KhachHang> getAll() {
        Query query = session.createQuery(fromTable);
        return query.getResultList();
    }

    public KhachHang getOne(int id) {
        String sql = fromTable + "Where id = :id";
        Query query = session.createQuery(sql, KhachHang.class);
        query.setParameter("id", id);
        return (KhachHang) query.getSingleResult();
    }

    public Boolean add(KhachHang KhachHang) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession();) {

            transaction = session.beginTransaction();
            session.save(KhachHang);
            transaction.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean update(KhachHang KhachHang) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession();) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("UPDATE  KhachHang\n"
                    + "SET   Ten = :ten" + " Where id = :id");
            query.setParameter("ten",KhachHang.getTen());
            query.setParameter("id",KhachHang.getId());
            query.executeUpdate();
            transaction.commit();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
     
    }

    public Boolean Delete(KhachHang KhachHang) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession();) {
            transaction = session.beginTransaction();
            session.delete(KhachHang);
            transaction.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        List<KhachHang> list = new KhachHangRepository().getAll();
        for (KhachHang KhachHang : list) {
            System.out.println(KhachHang.toString());
        }
    }
}
