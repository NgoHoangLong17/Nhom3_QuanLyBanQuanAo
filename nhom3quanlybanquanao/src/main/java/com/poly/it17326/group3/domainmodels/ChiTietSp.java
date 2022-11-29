
package com.poly.it17326.group3.domainmodels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author doand
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class ChiTietSp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    //product
    @JoinColumn(name = "idSp", referencedColumnName = "id") //categpry
    private SanPham sanPham;
//    int idSp;
    @ManyToOne
    @JoinColumn(name = "idDongSp", referencedColumnName = "id")
    private DongSp dongSp;
//    int idDongSp;

    @ManyToOne
    @JoinColumn(name = "idMauSac", referencedColumnName = "id")
    private MauSac mauSac;
//    int idMauSac;

    @ManyToOne
    @JoinColumn(name = "idChatLieu", referencedColumnName = "id")
    private ChatLieu chatLieu;
//    int idChatLieu;

    @ManyToOne
    @JoinColumn(name = "idSize", referencedColumnName = "id")
    private Size size;
//    int idSize;
    @ManyToOne
    @JoinColumn(name = "idNsx", referencedColumnName = "id")
    private Nsx nsx;
//    int nsx;

    @OneToOne
    @JoinColumn(name = "idAnh", referencedColumnName = "id")
    private Anh anh;

//    @ManyToOne
//    @JoinColumn(name = "soLuongTon", referencedColumnName = "id")
    @Column(name = "soLuongTon")
    int soLuongTon;

    @Column(name = "gia")
    int gia;

    @Column(name = "moTa")
    String moTa;
}
