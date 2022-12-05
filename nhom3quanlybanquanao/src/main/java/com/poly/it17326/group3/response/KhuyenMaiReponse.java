
package com.poly.it17326.group3.response;

import com.poly.it17326.group3.domainmodels.KhuyenMai;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class KhuyenMaiReponse {
    private int id;
    private String ma;
    private String ten;
    private int mucGiam;
    private Date ngayBD;
    private Date ngayKT;

    public KhuyenMaiReponse() {
    }

    public KhuyenMaiReponse(KhuyenMai khuyenMai) {
        this.id = khuyenMai.getId();
        this.ma = khuyenMai.getMa();
        this.ten = khuyenMai.getTen();
        this.mucGiam = khuyenMai.getMucGiamGia();
        this.ngayBD = khuyenMai.getNgayBatDau();
        this.ngayKT = khuyenMai.getNgayKetThuc();
    }
    
    
}
