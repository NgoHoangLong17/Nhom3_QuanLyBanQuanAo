/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.service.impl;

import com.poly.it17326.group3.domainmodels.MauSac;
import com.poly.it17326.group3.repository.MauSacRepository;
import com.poly.it17326.group3.service.MauSacService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class MauSacServiceImpl implements MauSacService {

    private MauSacRepository mauSacRepository = new MauSacRepository();

    @Override
    public Boolean add(MauSac mauSac) {
        return mauSacRepository.add(mauSac);
    }

    @Override
    public Boolean delete(MauSac mauSac) {
        return mauSacRepository.delete(mauSac);
        
    }

    @Override
    public Boolean update(MauSac mauSac) {
        return mauSacRepository.Update(mauSac);
    }

    @Override
    public List<MauSac> getAll() {
        return mauSacRepository.getAll();
    }

    

   

}
