/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.domainmodels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Admin
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class GiaoHang {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "IDHOADON",referencedColumnName = "id")
    private HoaDon hoaDon;
    
    @ManyToOne
    @JoinColumn(name = "IDKHACHHANG",referencedColumnName = "id")
    private KhachHang khachHang;
    
    @Column(name="TRANGTHAI")
    private Boolean trangThai;
    
    @Column(name="TIENSHIP")
    private Integer tienShip;
    
    @Column(name="GHICHU")
    private String ghiChu;
}
