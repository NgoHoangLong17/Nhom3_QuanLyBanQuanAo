/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.service.impl;

import com.poly.it17326.group3.repository.AnhRepository;

import com.poly.it17326.group3.domainmodels.Anh;
import java.util.List;
import com.poly.it17326.group3.service.ViewAnhService;

/**
 *
 * @author doand
 */
public class AnhServiceImpl implements ViewAnhService {

    private AnhRepository AnhRepository = new AnhRepository();

    @Override
    public List<Anh> getAll() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return AnhRepository.getAll();
    }

    @Override
    public Boolean update(Anh Anh) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
        return true;
    }

    @Override
    public Boolean add(Anh Anh) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean Delete(Anh Anh) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    return AnhRepository.Delete(Anh);
    }

}
