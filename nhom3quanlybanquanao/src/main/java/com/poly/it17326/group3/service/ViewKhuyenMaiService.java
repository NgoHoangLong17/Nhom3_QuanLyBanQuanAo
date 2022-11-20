/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.service;

import com.poly.it17326.group3.domainmodels.KhuyenMai;

/**
 *
 * @author longnh203
 */
public interface ViewKhuyenMaiService {

    Boolean getKhuyenMai();

    Boolean save(KhuyenMai km);

    Boolean update(KhuyenMai km);

    Boolean delete(KhuyenMai km);
}
