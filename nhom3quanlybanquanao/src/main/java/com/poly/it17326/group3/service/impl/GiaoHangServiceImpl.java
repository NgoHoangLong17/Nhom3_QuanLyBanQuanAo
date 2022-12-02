/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.service.impl;

import com.poly.it17326.group3.domainmodels.GiaoHang;
import com.poly.it17326.group3.repository.GiaoHangRepository;
import com.poly.it17326.group3.response.GiaoHangResponse;
import com.poly.it17326.group3.service.GiaoHangService;
import java.util.List;

/**
 *
 * @author Admin
 */
public class GiaoHangServiceImpl implements GiaoHangService{

    private GiaoHangRepository giaoHangRepository = new GiaoHangRepository();
    
    @Override
    public List<GiaoHangResponse> getAll() {        
        return giaoHangRepository.getAll();
    }
    
}
