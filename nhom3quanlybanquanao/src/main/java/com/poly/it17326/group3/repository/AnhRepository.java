/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.repository;

import com.poly.it17326.group3.config.HibernateConfig;
import com.poly.it17326.group3.response.AnhReponse;
import com.poly.it17326.group3.domainmodels.Anh;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author doand
 */
public class AnhRepository {

    private Session session = HibernateConfig.getFACTORY().openSession();
    private String fromTable = "From Anh";

    public List<Anh> getAll() {
        Query query = session.createQuery(fromTable);
        return query.getResultList();
    }

    public Anh getOne(int id) {
        String sql = fromTable + "Where id = :id";
        Query query = session.createQuery(sql, Anh.class);
        query.setParameter("id", id);
        return (Anh) query.getSingleResult();
    }

    public Boolean add(Anh Anh) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession();) {

            transaction = session.beginTransaction();
            session.save(Anh);
            transaction.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean update(Anh Anh) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession();) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("UPDATE  Anh\n"
                    + "SET   Ten = :ten" + " Where id = :id");
            query.setParameter("ten",Anh.getTen());
            query.setParameter("id",Anh.getId());
            query.executeUpdate();
            transaction.commit();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
     
    }

    public Boolean Delete(Anh Anh) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession();) {
            transaction = session.beginTransaction();
            session.delete(Anh);
            transaction.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        List<Anh> list = new AnhRepository().getAll();
        for (Anh Anh : list) {
            System.out.println(Anh.toString());
        }
    }
}
