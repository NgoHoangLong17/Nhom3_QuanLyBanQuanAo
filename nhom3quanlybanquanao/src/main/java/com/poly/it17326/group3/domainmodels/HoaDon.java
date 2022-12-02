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
 * @author Admin
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
    @JoinColumn(name = "IDNHANVIEN", referencedColumnName = "id")
    private NhanVien nhanVien;

    @ManyToOne
    @JoinColumn(name = "IDKHACHHANG", referencedColumnName = "id")
    private KhachHang khachHang;

    @Column(name = "SDT")
    private String sdt;

    @Column(name = "DIACHI")
    private String diaChi;
    
    @Column(name = "NGAYTAO")
    private Date ngayTao;

    @Column(name = "NGAYTHANHTOAN")
    private Date ngayThanhToan;

    @ManyToOne
    @JoinColumn(name = "IDTINHTRANG", referencedColumnName = "id")
    private TinhTrang tinhTrang;

    @Column(name = "TONGTIEN")
    private int tongTien;

    @ManyToOne
    @JoinColumn(name = "IDKHUYENMAI", referencedColumnName = "id")
    KhuyenMai khuyenMai;

    @Column(name = "TIENSAUGIAMGIA")
    private int tienSauGiamGia;
}
