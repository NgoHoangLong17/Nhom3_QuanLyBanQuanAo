/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.service.impl;

import com.poly.it17326.group3.repository.KhachHangRepository;
import com.poly.it17326.group3.response.KhachHangReponse;
import com.poly.it17326.group3.service.KhachHangService;
import com.poly.it17326.group3.domainmodels.KhachHang;
import java.util.List;

/**
 *
 * @author doand
 */
public class KhachHangServiceImpl implements KhachHangService {

    private KhachHangRepository KhachHangRepository = new KhachHangRepository();

    @Override
    public List<KhachHang> getAll() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return KhachHangRepository.getAll();
    }

    @Override
    public Boolean update(KhachHang KhachHang) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
        return true;
    }

    @Override
    public Boolean add(KhachHang KhachHang) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean Delete(KhachHang KhachHang) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    return KhachHangRepository.Delete(KhachHang);
    }

}
