/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.response;

import com.poly.it17326.group3.domainmodels.Anh;
import com.poly.it17326.group3.domainmodels.ChatLieu;
import com.poly.it17326.group3.domainmodels.DongSp;
import com.poly.it17326.group3.domainmodels.MauSac;
import com.poly.it17326.group3.domainmodels.NSX;
import com.poly.it17326.group3.domainmodels.SanPham;
import com.poly.it17326.group3.domainmodels.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author doand
 */

@Getter
@Setter
@ToString
public class ChiTietSpReponse {

    private int id;
    private String tenSanPham;
    private String tenDongSp;
    private String tenMauSac;
    private String tenChatLieu;
    private String tenSize;
    private String tenNsx;
    private String tenAnh;
    private int soLuongTon;
    private int gia;
    private String moTa;

    public ChiTietSpReponse(int id,  SanPham sanPham, DongSp dongSp, MauSac mauSac, ChatLieu chatLieu, Size size, NSX nsx, Anh anh, int soLuongTon, int gia, String moTa) {
        this.id = id;
        this.tenSanPham = sanPham.getTen();
        this.tenDongSp =  dongSp.getTen();
        this.tenMauSac = mauSac.getTen();
        this.tenChatLieu = chatLieu.getTen();
        this.tenSize = size.getTen();
        this.tenNsx = nsx.getTen();
        this.tenAnh = anh.getTen();
        this.soLuongTon = soLuongTon;
        this.gia = gia;
        this.moTa = moTa;
    }

    
    

}
