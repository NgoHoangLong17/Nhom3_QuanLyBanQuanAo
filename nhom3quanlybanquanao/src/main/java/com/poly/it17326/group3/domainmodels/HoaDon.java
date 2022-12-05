/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17326.group3.domainmodels;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author doand
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "HOADON")
@Getter
@Setter
public class HoaDon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idNhanVien", referencedColumnName = "id")
    private NhanVien nhanVien;
//    private int idNhanVien;

    @ManyToOne
    @JoinColumn(name = "idKhachHang", referencedColumnName = "id")
    private KhachHang khachHang;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "ngayTao")
    private Date ngayTao;

    @Column(name = "ngayThanhToan")
    private Date ngayThanhToan;

    @Column(name = "tinhTrang")
    private int tinhTrang;
    
    @Column(name = "tongTien")
    private int tongTien;

    @ManyToOne
    @JoinColumn(name = "idKhuyenMai", referencedColumnName = "id")
//    private int idKhuyenMai;
    KhuyenMai khuyenMai;

    @Column(name = "tienSauGiamGia")
    private int tienSauGiamGia;
}
