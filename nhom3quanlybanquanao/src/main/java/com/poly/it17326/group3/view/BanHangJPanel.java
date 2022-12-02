/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.poly.it17326.group3.view;

import com.poly.it17326.group3.domainmodels.ChiTietSp;
import com.poly.it17326.group3.domainmodels.HoaDon;
import com.poly.it17326.group3.domainmodels.HoaDonChiTiet;
import com.poly.it17326.group3.domainmodels.KhachHang;
import com.poly.it17326.group3.domainmodels.NhanVien;
import com.poly.it17326.group3.domainmodels.TinhTrang;
import com.poly.it17326.group3.service.ViewChiTietSPService;
import com.poly.it17326.group3.service.ViewHoaDonChiTietService;
import com.poly.it17326.group3.service.ViewHoaDonService;
import com.poly.it17326.group3.service.impl.ChiTietSpServiceImpl;
import com.poly.it17326.group3.service.impl.HoaDonChiTietServiceImpl;
import com.poly.it17326.group3.service.impl.HoaDonServiceImpl;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author longnh203
 */
public class BanHangJPanel extends javax.swing.JPanel {

    private ViewChiTietSPService chiTietSPService;
    private ViewHoaDonService hoaDonService;
    private ViewHoaDonChiTietService hoaDonChiTietService;
    private DefaultTableModel tableModel;
    private NhanVien user = null;
    int tongTien = 0;

    public BanHangJPanel(NhanVien userLogin) {
        initComponents();
        chiTietSPService = new ChiTietSpServiceImpl();
        hoaDonService = new HoaDonServiceImpl();
        hoaDonChiTietService = new HoaDonChiTietServiceImpl();
        loadTableCTSP(chiTietSPService.getAll());
        loadTableHoaDon(hoaDonService.getHoaDonByIdNV(userLogin.getId()));
        user = userLogin;
    }

    private void loadTableCTSP(List<ChiTietSp> chiTietSanPhams) {
        tableModel = (DefaultTableModel) tblDanhSachSP.getModel();
        tableModel.setRowCount(0);
        tableModel.setColumnIdentifiers(new String[]{"Mã sản phẩm", "Tên sản phẩm", "Màu sắc", "Đơn giá", "Số lượng"});
        chiTietSanPhams.forEach(ctsp
                -> tableModel.addRow(new Object[]{
            ctsp.getId(), ctsp.getSanPham().getTen(), ctsp.getMauSac().getTen(), ctsp.getGia(), ctsp.getSoLuongTon()
        })
        );

    }

    private void loadTableHoaDon(List<HoaDon> hoaDons) {
        tableModel = (DefaultTableModel) tblDsHoaDon.getModel();
        tableModel.setRowCount(0);
        tableModel.setColumnIdentifiers(new String[]{"Mã hóa đơn", "Ngày tạo", "Tên khách hàng", "Tình trạng"});
        hoaDons.forEach(hd
                -> tableModel.addRow(new Object[]{
            hd.getId(), hd.getNgayTao(), hd.getKhachHang().getTen(), hd.getTinhTrang().getTen()
        })
        );

    }

    private void loadTableHDCT(List<HoaDonChiTiet> hdcts) {
        tableModel = (DefaultTableModel) tblHoaDonCT.getModel();
        tableModel.setRowCount(0);
        tableModel.setColumnIdentifiers(new String[]{"Mã HDCT", "Tên sản phẩm", "Số lượng", "Đơn giá", "Thành tiền"});
        hdcts.forEach(hdct
                -> tableModel.addRow(new Object[]{
            hdct.getIdHoaDonCT(), hdct.getChiTietSp().getSanPham().getTen(), hdct.getSoLuong(), hdct.getDONGIA(), hdct.getSoLuong() * hdct.getDONGIA()
        })
        );
    }

    private int tongTien() {
        tongTien = 0;
        for (int i = 0; i < tblHoaDonCT.getRowCount(); i++) {
            tongTien += Integer.parseInt(tblHoaDonCT.getValueAt(i, 4).toString());
        }
        return tongTien;
    }

    private void setTongTien() {
        tongTien = 0;
        for (int i = 0; i < tblHoaDonCT.getRowCount(); i++) {
            tongTien += Integer.parseInt(tblHoaDonCT.getValueAt(i, 4).toString());
        }
        lblThanhTien.setText(tongTien + " đ");
    }

    private void saveHdct(HoaDonChiTiet hdct) {
        HoaDon hd = hoaDonService.getOne(Integer.parseInt(lblMaHD.getText()));
        ChiTietSp ctsp = chiTietSPService.getOne(Integer.parseInt(tblDanhSachSP.getValueAt(tblDanhSachSP.getSelectedRow(), 0).toString()));
        hdct.setHoaDon(hd);
        hdct.setChiTietSp(ctsp);
        try {
            int soLuong = Integer.parseInt(JOptionPane.showInputDialog("Nhập số lượng:"));
            hdct.setSoLuong(soLuong);
            ctsp.setSoLuongTon(ctsp.getSoLuongTon() - soLuong);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Số lượng không hợp lệ!");
            return;
        } 
        hdct.setDONGIA(ctsp.getGia());
        hdct.setAnh(ctsp.getAnh().getTen());
        hdct.setDongSp(ctsp.getDongSp().getTen());
        hdct.setTenSp(ctsp.getSanPham().getTen());
        hdct.setSize(ctsp.getSize().getTen());
        hoaDonChiTietService.update(hdct);
        chiTietSPService.update(ctsp);
        loadTableHDCT(hoaDonChiTietService.getHdctByIdHD(Integer.parseInt(lblMaHD.getText())));
        loadTableCTSP(chiTietSPService.getAll());
        setTongTien();
    } 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhSachSP = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        tblKhach = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblMaHD = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblHoaDonCT = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        lblThanhTien = new javax.swing.JLabel();
        btnThanhToan = new javax.swing.JButton();
        btnHoaDonMoi = new javax.swing.JButton();
        btnDatHang = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDsHoaDon = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(0, 102, 0));

        jButton1.setBackground(new java.awt.Color(153, 255, 153));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Sản phẩm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 204, 102));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("Khách hàng");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tblDanhSachSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDanhSachSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachSPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDanhSachSP);

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(204, 0, 0));
        jTextField1.setText("Tìm kiếm sản phẩm");
        jTextField1.setPreferredSize(new java.awt.Dimension(119, 34));

        jLabel1.setText("Icon quét mã");

        jLabel7.setText("Danh sách sản phẩm");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tblKhach.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tblKhach.setText("Khách lẻ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Mã hóa đơn: ");

        lblMaHD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMaHD.setText("1234");

        tblHoaDonCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblHoaDonCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonCTMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblHoaDonCT);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Thành tiền:");

        lblThanhTien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblThanhTien.setText("1000000 đ");

        btnThanhToan.setBackground(new java.awt.Color(153, 255, 153));
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnHoaDonMoi.setBackground(new java.awt.Color(255, 255, 153));
        btnHoaDonMoi.setText("Hóa đơn mới");
        btnHoaDonMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoaDonMoiActionPerformed(evt);
            }
        });

        btnDatHang.setBackground(new java.awt.Color(153, 255, 255));
        btnDatHang.setText("Đặt hàng");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnHoaDonMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDatHang, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblThanhTien))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(tblKhach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tblKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblThanhTien))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHoaDonMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDatHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        tblDsHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblDsHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDsHoaDonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDsHoaDon);

        jLabel8.setText("Danh sách hóa đơn");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tblDanhSachSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachSPMouseClicked
        // TODO add your handling code here:
        HoaDonChiTiet hdct = new HoaDonChiTiet();
        int id1 = Integer.parseInt(tblDanhSachSP.getValueAt(tblDanhSachSP.getSelectedRow(), 0).toString());

        saveHdct(hdct);


    }//GEN-LAST:event_tblDanhSachSPMouseClicked

    private void btnHoaDonMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoaDonMoiActionPerformed
        // TODO add your handling code here:
        HoaDon hd = new HoaDon();
        hd.setKhachHang(new KhachHang(1, null, null, null));
        long millis = System.currentTimeMillis();
        java.util.Date date = new java.util.Date(millis);
        hd.setNgayTao(date);
        hd.setNhanVien(user);
        hd.setTinhTrang(new TinhTrang(2, null));
        hoaDonService.save(hd);
        loadTableHoaDon(hoaDonService.getHoaDonByIdNV(user.getId()));
    }//GEN-LAST:event_btnHoaDonMoiActionPerformed

    private void tblDsHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDsHoaDonMouseClicked
        // TODO add your handling code here:
        int row = tblDsHoaDon.getSelectedRow();
        int idhd = Integer.parseInt(tblDsHoaDon.getValueAt(row, 0).toString());
        System.out.println(idhd);
        loadTableHDCT(hoaDonChiTietService.getHdctByIdHD(idhd));
        lblMaHD.setText(idhd + "");
        setTongTien();
    }//GEN-LAST:event_tblDsHoaDonMouseClicked

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
        HoaDon hd = hoaDonService.getOne(Integer.parseInt(lblMaHD.getText()));
        hd.setTongTien(tongTien);
        
        HoaDonJFrame hdjf = new HoaDonJFrame(hd);
        System.out.println(hd.toString());
        hdjf.setVisible(true);
        hdjf.setLocationRelativeTo(null);

    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void tblHoaDonCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonCTMouseClicked
        // TODO add your handling code here:
        int row = tblHoaDonCT.getSelectedRow();

        int idhdct = Integer.parseInt(tblHoaDonCT.getValueAt(row, 0).toString());
        System.out.println(idhdct+"");
        HoaDonChiTiet hdct = hoaDonChiTietService.getOne(idhdct);
        ChiTietSp ctsp = chiTietSPService.getOne(hdct.getChiTietSp().getId());
        int soLuong = Integer.parseInt(JOptionPane.showInputDialog("Nhập số lượng:"));
        if (soLuong > hdct.getSoLuong()) {
            JOptionPane.showMessageDialog(this, "Số lượng không hợp lệ!");
            return;
        } else if (soLuong == hdct.getSoLuong()) {
            hoaDonChiTietService.delete(hdct);
        } else {
            hdct.setSoLuong(hdct.getSoLuong() - soLuong);
        }

        ctsp.setSoLuongTon(ctsp.getSoLuongTon() + soLuong);
        loadTableCTSP(chiTietSPService.getAll());
        loadTableHDCT(hoaDonChiTietService.getHdctByIdHD(Integer.parseInt(lblMaHD.getText())));
    }//GEN-LAST:event_tblHoaDonCTMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDatHang;
    private javax.swing.JButton btnHoaDonMoi;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblMaHD;
    private javax.swing.JLabel lblThanhTien;
    private javax.swing.JTable tblDanhSachSP;
    private javax.swing.JTable tblDsHoaDon;
    private javax.swing.JTable tblHoaDonCT;
    private javax.swing.JLabel tblKhach;
    // End of variables declaration//GEN-END:variables
}
