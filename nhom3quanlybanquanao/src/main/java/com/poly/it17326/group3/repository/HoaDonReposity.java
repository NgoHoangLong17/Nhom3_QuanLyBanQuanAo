/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.repository;

import com.poly.it17326.group3.config.HibernateConfig;
import com.poly.it17326.group3.domainmodels.DongSp;
import com.poly.it17326.group3.domainmodels.HoaDon;
import com.poly.it17326.group3.domainmodels.SanPham;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author doand
 */
public class HoaDonReposity {

    private Session session = HibernateConfig.getFACTORY().openSession();

    private String fromTable = "FROM HoaDon";

    public ArrayList<HoaDon> getAll() {
        Query query = session.createQuery(fromTable, HoaDon.class);
        return (ArrayList<HoaDon>) query.getResultList();
    }

//    public Boolean add(HoaDon hoaDon) {
//        Transaction transaction = null;
//        try ( Session session = HibernateConfig.getFACTORY().openSession();) {
//
//            transaction = session.beginTransaction();
//            javax.persistence.Query query = session.createQuery("INSERT INTO HOADON\n"
//                    + "( NGAYTAO, IDNHANVIEN, TENKHACHHANG)\n"
//                    + "VALUES    (NGAYTAO :nt ,IDNHANVIEN: idnv,TENKHACHHANG: ten)");
//            query.setParameter("nt", new java.util.Date().getTime());
//            query.setParameter("idnv", hoaDon.getNhanVien().getId());
//            query.setParameter("ten", hoaDon.getTenKhachHang());
//            
//            transaction.commit();
//            return true;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
     public Boolean add(HoaDon hoaDon){
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.save(hoaDon);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
//    public Boolean add(HoaDon hoaDon) {
//        Transaction transaction = null;
//        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
//            // start a transaction
//            transaction = session.beginTransaction();
//            String hql = "INSERT INTO Student (firstName, lastName, email) "
//                    + "SELECT firstName, lastName, email FROM Student";
//            Query query = session.createQuery(hql);
//            int result = query.executeUpdate();
//            System.out.println("Rows affected: " + result);
//
//            // commit transaction
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        }
//        return true;
//    }

}
