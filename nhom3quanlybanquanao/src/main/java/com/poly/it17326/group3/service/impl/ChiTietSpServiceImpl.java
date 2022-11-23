/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.service.impl;

import com.poly.it17326.group3.domainmodels.Anh;
import com.poly.it17326.group3.domainmodels.ChatLieu;
import com.poly.it17326.group3.domainmodels.ChiTietSp;
import com.poly.it17326.group3.domainmodels.DongSp;
import com.poly.it17326.group3.domainmodels.MauSac;
import com.poly.it17326.group3.domainmodels.NSX;
import com.poly.it17326.group3.domainmodels.SanPham;
import com.poly.it17326.group3.domainmodels.Size;
import com.poly.it17326.group3.repository.ChiTietSpRepository;
import com.poly.it17326.group3.service.ChiTietService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author doand
 */
public class ChiTietSpServiceImpl implements ChiTietService{
private  ChiTietSpRepository chiTietSpRepository = new ChiTietSpRepository();
    
    @Override
    public ArrayList<ChiTietSp> getAll() {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    return chiTietSpRepository.getAll();
    }

    @Override
    public List<Anh> getAnh() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   return chiTietSpRepository.getAnh();
    }

    @Override
    public List<SanPham> getSanPham() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    return chiTietSpRepository.getSanPham();
    }

    @Override
    public List<ChatLieu> getChatLieu() {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   return chiTietSpRepository.getChatLieu();
    }

    @Override
    public List<DongSp> getDongSp() {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    return chiTietSpRepository.getDongSp();
    }

    @Override
    public List<Size> getSize() {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  return  chiTietSpRepository.getSize();
    }

    @Override
    public List<NSX> getNsx() {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   return chiTietSpRepository.getNsx();
           
    }

    @Override
    public List<MauSac> getMauSac() {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   return chiTietSpRepository.getMauSac();
    }

    @Override
    public Boolean add(ChiTietSp chiTietSp) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    return chiTietSpRepository.add(chiTietSp);
    }

    @Override
    public Boolean update(ChiTietSp chiTietSp) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    return chiTietSpRepository.update(chiTietSp);
    }

    @Override
    public Boolean delete(ChiTietSp chiTietSp) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   return chiTietSpRepository.delete(chiTietSp);
    }
    
}
