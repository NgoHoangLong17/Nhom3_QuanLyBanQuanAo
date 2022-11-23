/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.it17326.group3.service;

import com.poly.it17326.group3.domainmodels.Anh;
import java.util.List;

/**
 *
 * @author doand
 */
public interface AnhService {

    public List<Anh> getAll();

    public Boolean update(Anh Anh);

    public Boolean add(Anh Anh);
    
    public Boolean Delete(Anh Anh);
     
}
