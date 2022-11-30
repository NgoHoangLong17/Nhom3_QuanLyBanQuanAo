/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.poly.it17326.group3.view;

import com.poly.it17326.group3.domainmodels.Anh;
import com.poly.it17326.group3.domainmodels.ChatLieu;
import com.poly.it17326.group3.domainmodels.ChiTietSp;
import com.poly.it17326.group3.domainmodels.DongSp;
import com.poly.it17326.group3.domainmodels.MauSac;
import com.poly.it17326.group3.domainmodels.Nsx;
import com.poly.it17326.group3.domainmodels.SanPham;
import com.poly.it17326.group3.domainmodels.Size;
import com.poly.it17326.group3.repository.ChiTietSpRepository;
import com.poly.it17326.group3.service.impl.ChiTietSpServiceImpl;
import java.util.ArrayList;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author doand
 */
public class ChiTietSanPhamFrm extends javax.swing.JPanel {

    private ChiTietSpRepository chiTietSpRepository = new ChiTietSpRepository();
    private ChiTietSpServiceImpl chiTietSpServiceImpl = new ChiTietSpServiceImpl();

    /**
     * Creates new form ChiTietSanPhamFrm
     */
    public void loadCboSp(List<SanPham> list) {
        DefaultComboBoxModel row = new DefaultComboBoxModel();
        for (SanPham sanPham : list) {
            row.addElement(sanPham.getTen());
        }
        cboSanPham.setModel(row);

    }

    public void loadCboAnh(List<Anh> list) {
        DefaultComboBoxModel row = new DefaultComboBoxModel();
        for (Anh anh : list) {
            row.addElement(anh.getTen());
        }
        cboAnh.setModel(row);

    }

    public void loadChatLieu(List<ChatLieu> list) {
        DefaultComboBoxModel row = new DefaultComboBoxModel();
        for (ChatLieu chatLieu : list) {
            row.addElement(chatLieu.getTen());
        }
        cboChatLieu.setModel(row);
    }

    public void loadDongSp(List<DongSp> list) {
        DefaultComboBoxModel row = new DefaultComboBoxModel();
        for (DongSp dongSp : list) {
            row.addElement(dongSp.getTen());
        }
        cboDongSp.setModel(row);
    }

    public void loadSize(List<Size> list) {
        DefaultComboBoxModel row = new DefaultComboBoxModel();
        for (Size size : list) {
            row.addElement(size.getTen());
        }
        cboSize.setModel(row);
    }

    public void loadNsx(List<Nsx> list) {
        DefaultComboBoxModel row = new DefaultComboBoxModel();
        for (Nsx nsx : list) {
            row.addElement(nsx.getTen());
        }
        cboNsx.setModel(row);
    }

    public void loadMauSac(List<MauSac> list) {
        DefaultComboBoxModel row = new DefaultComboBoxModel();
        for (MauSac mauSac : list) {
            row.addElement(mauSac.getTen());
        }
        cboMauSac.setModel(row);
    }

//    public void loadTableCtsp(<ChiTietSp> list) {
//        DefaultTableModel model = (DefaultTableModel) chiTietSpRepository.getAll();
//        model.setRowCount(0);
//
//        model.setColumnIdentifiers(new Object[]{
//            "id", "anh", "chatlieu", "dongsp", "size", "nsx", "mausac", "sanpham", "soluongton", "gia", "mota"
//        });
//        for (ChiTietSp chiTietSanPham : list) {
//            Object[] row = new Object[]{chiTietSanPham.getId(), chiTietSanPham.getAnh().getTen(), chiTietSanPham.getChatLieu().getTen(), chiTietSanPham.getDongSp().getTen(),
//                chiTietSanPham.getSize().getTen(), chiTietSanPham.getNsx().getTen(), chiTietSanPham.getMauSac().getTen(), chiTietSanPham.getSanPham().getTen(), chiTietSanPham.getSoLuongTon(),
//                chiTietSanPham.getGia(), chiTietSanPham.getMoTa()};
//            model.addRow(row);
//        }
//
//    }
    public void loadTable(ArrayList<ChiTietSp> list) {
        DefaultTableModel model = (DefaultTableModel) tblChiTietSp.getModel();
        model.setRowCount(0);

        model.setColumnIdentifiers(new Object[]{
            "id", "anh", "chatlieu", "dongsp", "size", "nsx", "mausac", "sanpham", "soluongton", "gia", "mota"
        });
        for (ChiTietSp chiTietSanPham : list) {
            Object[] row = new Object[]{chiTietSanPham.getId(), chiTietSanPham.getAnh().getTen(), chiTietSanPham.getChatLieu().getTen(), chiTietSanPham.getDongSp().getTen(),
                chiTietSanPham.getSize().getTen(), chiTietSanPham.getNsx().getTen(), chiTietSanPham.getMauSac().getTen(), chiTietSanPham.getSanPham().getTen(), chiTietSanPham.getSoLuongTon(),
                chiTietSanPham.getGia(), chiTietSanPham.getMoTa()};
            model.addRow(row);
        }
    }

    public void validate() {
        if (Integer.parseInt(txtSoLuong.getText()) > 0 || Integer.parseInt(txtSoLuong.getText()) == 0) {
            JOptionPane.showMessageDialog(this, "phai là so hoac va lon hon 0");
            return;
        }

    }

    public ChiTietSanPhamFrm() {
        initComponents();
        loadCboSp(chiTietSpServiceImpl.getSanPham());
        loadCboAnh(chiTietSpServiceImpl.getAnh());
        loadChatLieu(chiTietSpServiceImpl.getChatLieu());
        loadDongSp(chiTietSpServiceImpl.getDongSp());
        loadSize(chiTietSpServiceImpl.getSize());
        loadNsx(chiTietSpServiceImpl.getNsx());
        loadMauSac(chiTietSpServiceImpl.getMauSac());
        loadTable(chiTietSpServiceImpl.getAll());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtMaChiTietSp = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cboAnh = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cboChatLieu = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cboDongSp = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cboSize = new javax.swing.JComboBox<>();
        txtGia = new javax.swing.JTextField();
        txtMoTa = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        cboSanPham = new javax.swing.JComboBox<>();
        cboMauSac = new javax.swing.JComboBox<>();
        cboNsx = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblChiTietSp = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jLabel1.setText("MaChiTietSp");

        txtMaChiTietSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaChiTietSpActionPerformed(evt);
            }
        });

        jLabel4.setText("Anh");

        cboAnh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("ChatLieu");

        cboChatLieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setText("DongSp");

        cboDongSp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel10.setText("Size");

        cboSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboMauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboNsx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("NSX");

        jLabel3.setText("MauSac");

        jLabel5.setText("SanPham");

        jLabel7.setText("SoLuongTon");

        jLabel9.setText("Gia");

        jLabel11.setText("MoTa");

        tblChiTietSp.setModel(new javax.swing.table.DefaultTableModel(
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
        tblChiTietSp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChiTietSpMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblChiTietSp);

        jButton1.setText("Them");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnSua.setText("Sua");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        jButton3.setText("Xoa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Tim kiem");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cboDongSp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cboChatLieu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cboAnh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaChiTietSp, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboNsx, 0, 209, Short.MAX_VALUE)
                    .addComponent(cboMauSac, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboSanPham, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(cboSize, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(53, 53, 53)
                                    .addComponent(jButton1)
                                    .addGap(44, 44, 44)
                                    .addComponent(btnSua)
                                    .addGap(37, 37, 37)
                                    .addComponent(jButton3)
                                    .addGap(60, 60, 60))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton4)
                                .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboNsx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtMaChiTietSp)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboAnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cboChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSoLuong))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboDongSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtGia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMoTa)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnSua)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaChiTietSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaChiTietSpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaChiTietSpActionPerformed

    private void tblChiTietSpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChiTietSpMouseClicked
        // TODO add your handling code here:
        int index = tblChiTietSp.getSelectedRow();
        txtMaChiTietSp.setText(tblChiTietSp.getValueAt(index, 0).toString());
        cboAnh.setSelectedItem(tblChiTietSp.getValueAt(index, 1));
        cboChatLieu.setSelectedItem(tblChiTietSp.getValueAt(index, 2));
        cboDongSp.setSelectedItem(tblChiTietSp.getValueAt(index, 3));
        cboSize.setSelectedItem(tblChiTietSp.getValueAt(index, 4));
        cboNsx.setSelectedItem(tblChiTietSp.getValueAt(index, 5));
        cboMauSac.setSelectedItem(tblChiTietSp.getValueAt(index, 6));
        cboSanPham.setSelectedItem(tblChiTietSp.getValueAt(index, 7));
        txtSoLuong.setText(tblChiTietSp.getValueAt(index, 8).toString());
        txtGia.setText(tblChiTietSp.getValueAt(index, 9).toString());
        txtMoTa.setText(tblChiTietSp.getValueAt(index, 10).toString());
    }//GEN-LAST:event_tblChiTietSpMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            ChiTietSp chiTietSp = new ChiTietSp();

            int index1 = cboAnh.getSelectedIndex();
            Anh anh = chiTietSpServiceImpl.getAnh().get(index1);
            chiTietSp.setAnh(anh);

            int index2 = cboChatLieu.getSelectedIndex();
            ChatLieu chatLieu = chiTietSpServiceImpl.getChatLieu().get(index2);
            chiTietSp.setChatLieu(chatLieu);

            int index3 = cboDongSp.getSelectedIndex();
            DongSp sp = chiTietSpServiceImpl.getDongSp().get(index3);
            chiTietSp.setDongSp(sp);

            int index4 = cboSize.getSelectedIndex();
            Size size = chiTietSpServiceImpl.getSize().get(index4);
            chiTietSp.setSize(size);

            int index5 = cboNsx.getSelectedIndex();
            Nsx nsx = chiTietSpServiceImpl.getNsx().get(index5);
            chiTietSp.setNsx(nsx);

            int index6 = cboMauSac.getSelectedIndex();
            MauSac ms = chiTietSpServiceImpl.getMauSac().get(index6);
            chiTietSp.setMauSac(ms);

//        int index7 = cboSanPham.getSelectedIndex();
//        SanPham sp = chiTietSpRepository.getSanPham().get(index7);
//        chiTietSp.setSanPham(sp);
            int index7 = cboSanPham.getSelectedIndex();
            SanPham sanPham = chiTietSpServiceImpl.getSanPham().get(index7);
            chiTietSp.setSanPham(sanPham);

            chiTietSp.setSoLuongTon(Integer.parseInt(txtSoLuong.getText()));
            chiTietSp.setGia(Integer.parseInt(txtGia.getText()));
            chiTietSp.setMoTa(txtMoTa.getText());

            if (Integer.parseInt(txtSoLuong.getText()) < 0 || Integer.parseInt(txtSoLuong.getText()) == 0 ) {
                JOptionPane.showMessageDialog(this, "phai là so hoac va lon hon 0 k dk de trong");
                return;
            }

            if (chiTietSpServiceImpl.add(chiTietSp) == true) {
                JOptionPane.showMessageDialog(this, "thanh cong");
                loadTable(chiTietSpRepository.getAll());
            } else {
                JOptionPane.showMessageDialog(this, "that cong");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

//        int index1 = cboTenSanPham.getSelectedIndex();
//        SanPham sp = listSp.get(index1);
//        ctsp.setIdSP(sp.getIdSanPham());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        int index = tblChiTietSp.getSelectedRow();

        ChiTietSp chiTietSp = chiTietSpServiceImpl.getAll().get(index);

        int index1 = cboAnh.getSelectedIndex();
        Anh anh = chiTietSpServiceImpl.getAnh().get(index1);
        chiTietSp.setAnh(anh);

        int index2 = cboChatLieu.getSelectedIndex();
        ChatLieu chatLieu = chiTietSpServiceImpl.getChatLieu().get(index2);
        chiTietSp.setChatLieu(chatLieu);

        int index3 = cboDongSp.getSelectedIndex();
        DongSp sp = chiTietSpServiceImpl.getDongSp().get(index3);
        chiTietSp.setDongSp(sp);

        int index4 = cboSize.getSelectedIndex();
        Size size = chiTietSpServiceImpl.getSize().get(index4);
        chiTietSp.setSize(size);

        int index5 = cboNsx.getSelectedIndex();
        Nsx nsx = chiTietSpServiceImpl.getNsx().get(index5);
        chiTietSp.setNsx(nsx);

        int index6 = cboMauSac.getSelectedIndex();
        MauSac ms = chiTietSpServiceImpl.getMauSac().get(index6);
        chiTietSp.setMauSac(ms);

//        int index7 = cboSanPham.getSelectedIndex();
//        SanPham sp = chiTietSpRepository.getSanPham().get(index7);
//        chiTietSp.setSanPham(sp);
        int index7 = cboSanPham.getSelectedIndex();
        SanPham sanPham = chiTietSpServiceImpl.getSanPham().get(index7);
        chiTietSp.setSanPham(sanPham);

        chiTietSp.setSoLuongTon(Integer.parseInt(txtSoLuong.getText()));
        chiTietSp.setGia(Integer.parseInt(txtGia.getText()));
        chiTietSp.setMoTa(txtMoTa.getText());

        if (chiTietSpServiceImpl.update(chiTietSp) == true) {
            JOptionPane.showMessageDialog(this, "thanh cong");
            loadTable(chiTietSpServiceImpl.getAll());
        } else {
            JOptionPane.showMessageDialog(this, "that cong");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int index = tblChiTietSp.getSelectedRow();
        ChiTietSp chiTietSp = chiTietSpServiceImpl.getAll().get(index);
        if (chiTietSpServiceImpl.delete(chiTietSp) == true) {
            JOptionPane.showMessageDialog(this, " xoa thanh cong");
            loadTable(chiTietSpServiceImpl.getAll());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JComboBox<String> cboAnh;
    private javax.swing.JComboBox<String> cboChatLieu;
    private javax.swing.JComboBox<String> cboDongSp;
    private javax.swing.JComboBox<String> cboMauSac;
    private javax.swing.JComboBox<String> cboNsx;
    private javax.swing.JComboBox<String> cboSanPham;
    private javax.swing.JComboBox<String> cboSize;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblChiTietSp;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMaChiTietSp;
    private javax.swing.JTextField txtMoTa;
    private javax.swing.JTextField txtSoLuong;
    // End of variables declaration//GEN-END:variables
}
