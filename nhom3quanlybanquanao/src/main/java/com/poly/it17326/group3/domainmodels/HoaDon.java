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
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity

public class HoaDon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idNhanVien", referencedColumnName = "id")
    private NhanVien nhanVien;
//    private int idNhanVien;

    @Column(name = "tenKhachHang")
    private String tenKhachHang;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "ngayTao")
    private Date ngayTao;

    @Column(name = "ngayThanhToan")
    private Date ngayThanhToan;

    @ManyToOne
    @JoinColumn(name = "idTinhTrang", referencedColumnName = "id")
    TinhTrang tinhTrang;
//    private int idTinhTrang;

    @Column(name = "tongTien")
    private int tongTien;

    @ManyToOne
    @JoinColumn(name = "idKhuyenMai", referencedColumnName = "id")
//    private int idKhuyenMai;
    KhuyenMai khuyenMai;

    @Column(name = "tienSauGiamGia")
    private int tienSauGiamGia;
}
