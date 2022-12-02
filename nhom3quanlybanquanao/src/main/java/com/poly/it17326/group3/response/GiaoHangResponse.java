
package com.poly.it17326.group3.response;

import com.poly.it17326.group3.domainmodels.GiaoHang;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GiaoHangResponse {
    private Integer idGiaoHang;
    private Integer idHoaDon;
    private String tenKhachHang;
    private String sdt;
    private String diaChi;
    private Boolean trangThai;

    public GiaoHangResponse() {
    }

    public GiaoHangResponse(GiaoHang giaoHang) {
        this.idGiaoHang = giaoHang.getId();
        this.idHoaDon = giaoHang.getHoaDon().getId();
        this.tenKhachHang = giaoHang.getKhachHang().getTen();
        this.sdt = giaoHang.getKhachHang().getSdt();
        this.diaChi = giaoHang.getKhachHang().getDiaChi();
        this.trangThai = giaoHang.getTrangThai();
    }
    
    
}
