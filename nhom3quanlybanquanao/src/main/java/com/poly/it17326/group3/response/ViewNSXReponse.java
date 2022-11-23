/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.response;

import com.poly.it17326.group3.domainmodels.NSX;

/**
 *
 * @author ADMIN
 */
public class ViewNSXReponse {
    private Integer ID;
    private String TEN;

    public ViewNSXReponse() {
    }

    public ViewNSXReponse(NSX nsx) {
        this.ID = nsx.getId();
        this.TEN = nsx.getTen();
    }
    
    
}
