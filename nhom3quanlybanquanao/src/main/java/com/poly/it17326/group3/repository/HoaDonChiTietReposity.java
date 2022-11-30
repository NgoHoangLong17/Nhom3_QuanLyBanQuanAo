/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.repository;

import com.poly.it17326.group3.config.HibernateConfig;
import com.poly.it17326.group3.domainmodels.ChatLieu;
import com.poly.it17326.group3.domainmodels.HoaDonChiTiet;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author doand
 */
public class HoaDonChiTietReposity {
     private Session session = HibernateConfig.getFACTORY().openSession();
    
    private String fromTable = "FROM HoaDonChiTiet"; 
    
    public ArrayList<HoaDonChiTiet> getAll(){
        Query query = session.createQuery(fromTable,HoaDonChiTiet.class);
        return (ArrayList<HoaDonChiTiet>) query.getResultList();
    }
    
     public Boolean add(HoaDonChiTiet hoaDonChiTiet){
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.save(hoaDonChiTiet);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public Boolean update(HoaDonChiTiet hoaDonChiTiet){
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.saveOrUpdate(hoaDonChiTiet);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public Boolean delete(HoaDonChiTiet hoaDonChiTiet){
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.delete(hoaDonChiTiet);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public static void main(String[] args) {
        HoaDonChiTietReposity chiTietReposity = new HoaDonChiTietReposity();
        ArrayList<HoaDonChiTiet> list = (ArrayList<HoaDonChiTiet>) chiTietReposity.getAll();
        for (HoaDonChiTiet hoaDonChiTiet : list) {
            System.out.println(hoaDonChiTiet.toString());
        }
        
        
    }
}
