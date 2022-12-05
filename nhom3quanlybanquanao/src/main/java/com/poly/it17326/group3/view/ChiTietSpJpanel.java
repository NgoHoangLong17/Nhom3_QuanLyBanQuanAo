/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.poly.it17326.group3.view;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import com.poly.it17326.group3.domainmodels.ChatLieu;
import com.poly.it17326.group3.domainmodels.ChiTietSp;
import com.poly.it17326.group3.domainmodels.DongSp;
import com.poly.it17326.group3.domainmodels.MauSac;
import com.poly.it17326.group3.domainmodels.Nsx;
import com.poly.it17326.group3.domainmodels.SanPham;
import com.poly.it17326.group3.domainmodels.Size;
import com.poly.it17326.group3.repository.ChiTietSpRepository;
import com.poly.it17326.group3.service.impl.ChiTietSpServiceImpl;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.xml.sax.Attributes;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

/**
 *
 * @author doand
 */
public class ChiTietSpJpanel extends javax.swing.JPanel implements Runnable, ThreadFactory {

    private ChiTietSpRepository chiTietSpRepository = new ChiTietSpRepository();
    private ChiTietSpServiceImpl chiTietSpServiceImpl = new ChiTietSpServiceImpl();
    String seletedImagePath = "";
    private DefaultTableModel model;
    String phonImage = "";
    String phoneImagePath = "";
    private WebcamPanel panel = null;
    private Webcam webcam = null;
    private Executor executor = Executors.newSingleThreadExecutor(this);

    /**
     * Creates new form ChiTietSpJpanel
     */
    private void initWebcam() {
        Dimension size = WebcamResolution.QVGA.getSize();
        webcam = Webcam.getWebcams().get(0);
        webcam.setViewSize(size);

        panel = new WebcamPanel(webcam);
        panel.setPreferredSize(size);
        panel.setFPSDisplayed(true);

        jplCam.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 300));
        executor.execute(this);
    }

    @Override
    public void run() {
        do {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(ChiTietSpJpanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            Result result = null;
            BufferedImage image = null;

            if (webcam.open()) {
                if ((image = webcam.getImage()) == null) {
                    continue;
                }
            }
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
            try {
                result = new MultiFormatReader().decode(bitmap);
            } catch (NotFoundException ex) {
                Logger.getLogger(ChiTietSpJpanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (result != null) {
                txtTimKiem.setText(result.getText());
            }
        } while (true);
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "My Thread");
        t.setDaemon(true);
        return t;
    }

    public void loadCboSp(List<SanPham> list) {
        DefaultComboBoxModel row = new DefaultComboBoxModel();
        for (SanPham sanPham : list) {
            row.addElement(sanPham.getTen());
        }
        cboSanPham.setModel(row);

    }

//    public void loadAnh(List<Anh> list) {
//        DefaultComboBoxModel row = new DefaultComboBoxModel();
//        for (Anh anh : list) {
//            row.addElement(anh.getTen());
//        }
//        cboAnh.setModel(row);
//    }
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

    public void loadTable(ArrayList<ChiTietSp> list) {
        model = (DefaultTableModel) tblChiTietSp.getModel();
        model.setRowCount(0);

        model.setColumnIdentifiers(new Object[]{
            "id", "chatlieu", "dongsp", "size", "nsx", "mausac", "sanpham", "soluongton", "gia", "mota", "anh"
        });
        for (ChiTietSp chiTietSanPham : list) {
            Object[] row = new Object[]{chiTietSanPham.getId(), chiTietSanPham.getChatLieu().getTen(), chiTietSanPham.getDongSp().getTen(),
                chiTietSanPham.getSize().getTen(), chiTietSanPham.getNsx().getTen(), chiTietSanPham.getMauSac().getTen(), chiTietSanPham.getSanPham().getTen(), chiTietSanPham.getSoLuongTon(),
                chiTietSanPham.getGia(), chiTietSanPham.getMoTa(), chiTietSanPham.getAnh()};
            model.addRow(row);
        }
    }

    public void loadTable1() {
        model = (DefaultTableModel) tblChiTietSp.getModel();
        model.setRowCount(0);

        model.setColumnIdentifiers(new Object[]{
            "id", "chatlieu", "dongsp", "size", "nsx", "mausac", "sanpham", "soluongton", "gia", "mota", "anh"
        });
    }

    public ChiTietSpJpanel() {
        initComponents();
        loadCboSp(chiTietSpServiceImpl.getSanPham());
        loadChatLieu(chiTietSpServiceImpl.getChatLieu());
        loadDongSp(chiTietSpServiceImpl.getDongSp());
        loadSize(chiTietSpServiceImpl.getSize());
        loadNsx(chiTietSpServiceImpl.getNsx());
        loadMauSac(chiTietSpServiceImpl.getMauSac());
        loadTable(chiTietSpServiceImpl.getAll());
        initWebcam();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMaSp = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtSoLuongTon = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtMoTa = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblAnh = new javax.swing.JLabel();
        cboNsx = new javax.swing.JComboBox<>();
        cboSanPham = new javax.swing.JComboBox<>();
        cboDongSp = new javax.swing.JComboBox<>();
        cboMauSac = new javax.swing.JComboBox<>();
        cboChatLieu = new javax.swing.JComboBox<>();
        cboSize = new javax.swing.JComboBox<>();
        jButton7 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        txtFilePath = new javax.swing.JTextField();
        jplCam = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        btnNhapExcel = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblChiTietSp = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUAN LI SAN PHAM");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 846, 74));

        jLabel2.setText("Ma San Pham");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 86, 94, 25));
        jPanel1.add(txtMaSp, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 87, 282, -1));

        jLabel4.setText("San Pham");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(486, 86, 72, 25));

        jLabel5.setText("Dong Sp");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(486, 117, 72, 25));
        jPanel1.add(txtSoLuongTon, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 118, 282, -1));

        jLabel6.setText("So Luong Ton");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 117, 94, 25));
        jPanel1.add(txtGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 149, 282, -1));

        jLabel7.setText("Mau Sac");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(486, 148, 72, 25));

        jLabel8.setText("Gia");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 148, 94, 25));

        jLabel9.setText("Chat Lieu");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(486, 185, 72, 25));
        jPanel1.add(txtMoTa, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 186, 282, -1));

        jLabel10.setText("Mo Ta");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 185, 94, 25));

        jLabel11.setText("Size");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(486, 216, 72, 25));

        jLabel12.setText("Noi San Xuat");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 216, 94, 25));

        lblAnh.setText("jLabel13");
        jPanel1.add(lblAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(867, 86, 150, 203));

        cboNsx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cboNsx, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 217, 282, -1));

        cboSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cboSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(564, 87, 282, -1));

        cboDongSp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cboDongSp, new org.netbeans.lib.awtextra.AbsoluteConstraints(564, 118, 282, -1));

        cboMauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cboMauSac, new org.netbeans.lib.awtextra.AbsoluteConstraints(564, 149, 282, -1));

        cboChatLieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cboChatLieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(564, 186, 282, -1));

        cboSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cboSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(564, 217, 282, -1));

        jButton7.setText("Nguon anh");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(867, 295, -1, -1));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 295, 130, -1));
        jPanel1.add(txtFilePath, new org.netbeans.lib.awtextra.AbsoluteConstraints(973, 295, 88, -1));

        jplCam.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jplCam, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 6, 260, 230));

        jButton1.setText("Them");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Sua");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Xoa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Tim Kiem");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Xuat exel");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("In");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        btnNhapExcel.setText("Nhap Exel");
        btnNhapExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(29, 29, 29)
                .addComponent(jButton3)
                .addGap(27, 27, 27)
                .addComponent(jButton4)
                .addGap(43, 43, 43)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNhapExcel)
                .addGap(30, 30, 30)
                .addComponent(jButton5)
                .addGap(30, 30, 30)
                .addComponent(jButton6)
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(btnNhapExcel)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        String currentDirectoryPath = "F:\\NetBeansProject\\Nhom3_QuanLyBanQuanAo\\nhom3quanlybanquanao\\src\\main\\java\\com\\poly\\it17326\\group3\\anh";
        JFileChooser imageFileChooser = new JFileChooser(currentDirectoryPath);
        int imageChooser = imageFileChooser.showOpenDialog(null);
        imageFileChooser.setDialogTitle("Choose Image...");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("Images", "png", "jpg", "jpeg");
        if (imageChooser == JFileChooser.APPROVE_OPTION) {
            File imageFile = imageFileChooser.getSelectedFile();
            String imageFileName = imageFile.getName();
            String imageFilePath = imageFile.getAbsolutePath();
            jTextField1.setText(imageFileName);

            ImageIcon imageIcon = new ImageIcon(imageFilePath);
            Image image = imageIcon.getImage().getScaledInstance(lblAnh.getWidth(), lblAnh.getHeight(), Image.SCALE_SMOOTH);

            ImageIcon resizedImageIcon = new ImageIcon(image);
            lblAnh.setIcon(resizedImageIcon);
            txtFilePath.setText(imageFilePath);

        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            ChiTietSp chiTietSp = new ChiTietSp();

//            int index1 = cboAnh.getSelectedIndex();
//            Anh anh = chiTietSpServiceImpl.getAnh().get(index1);
//            chiTietSp.setAnh(anh);
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

            int index7 = cboSanPham.getSelectedIndex();
            SanPham sanPham = chiTietSpServiceImpl.getSanPham().get(index7);
            chiTietSp.setSanPham(sanPham);

            chiTietSp.setSoLuongTon(Integer.parseInt(txtSoLuongTon.getText()));
            chiTietSp.setGia(Integer.parseInt(txtGia.getText()));
            chiTietSp.setMoTa(txtMoTa.getText());

            chiTietSp.setAnh(txtFilePath.getText());

            if (chiTietSpServiceImpl.add(chiTietSp) == true) {
                JOptionPane.showMessageDialog(this, "thanh cong");
                loadTable(chiTietSpRepository.getAll());
            } else {
                JOptionPane.showMessageDialog(this, "that cong");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblChiTietSpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChiTietSpMouseClicked
        // TODO add your handling code here:
        int index = tblChiTietSp.getSelectedRow();
        txtMaSp.setText(tblChiTietSp.getValueAt(index, 0).toString());
        cboChatLieu.setSelectedItem(tblChiTietSp.getValueAt(index, 1));
        cboDongSp.setSelectedItem(tblChiTietSp.getValueAt(index, 2));
        cboSize.setSelectedItem(tblChiTietSp.getValueAt(index, 3));
        cboNsx.setSelectedItem(tblChiTietSp.getValueAt(index, 4));
        cboMauSac.setSelectedItem(tblChiTietSp.getValueAt(index, 5));
        cboSanPham.setSelectedItem(tblChiTietSp.getValueAt(index, 6));
        txtSoLuongTon.setText(tblChiTietSp.getValueAt(index, 7).toString());
        txtGia.setText(tblChiTietSp.getValueAt(index, 8).toString());
        txtMoTa.setText(tblChiTietSp.getValueAt(index, 9).toString());
        String imgURL = tblChiTietSp.getValueAt(index, 10).toString();
        ImageIcon i = new ImageIcon(imgURL);
        Image image = i.getImage().getScaledInstance(lblAnh.getWidth(), lblAnh.getHeight(), Image.SCALE_SMOOTH);
        lblAnh.setIcon(i);
    }//GEN-LAST:event_tblChiTietSpMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        String CurentDirectoryFilePath = "F:\\Học liệu kì 4\\da1";
        JFileChooser execlExportChooser = new JFileChooser(CurentDirectoryFilePath);
        FileNameExtensionFilter excelFNEF = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
        execlExportChooser.setFileFilter(excelFNEF);
        execlExportChooser.setDialogTitle("Save excel... ");

        int excelChooser = execlExportChooser.showSaveDialog(null);
        if (excelChooser == JFileChooser.APPROVE_OPTION) {
            XSSFWorkbook exceSSFWorkbookExprort = new XSSFWorkbook();
            XSSFSheet excelSheet = exceSSFWorkbookExprort.createSheet("Danh Sach");
            for (int i = 0; i < model.getRowCount(); i++) {
                XSSFRow excelRow = excelSheet.createRow(i);
                for (int j = 0; j < model.getColumnCount(); j++) {
                    XSSFCell excelCell = excelRow.createCell(j);
                    excelCell.setCellValue(model.getValueAt(i, j).toString());
                }

            }
            FileOutputStream excelFIS;
            BufferedOutputStream excelBOU;
            try {
                excelFIS = new FileOutputStream(execlExportChooser.getSelectedFile() + ".xlsx");
                excelBOU = new BufferedOutputStream(excelFIS);
                exceSSFWorkbookExprort.write(excelBOU);
                excelBOU.close();
                exceSSFWorkbookExprort.close();
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        try {
            boolean printJatable = tblChiTietSp.print();
            JOptionPane.showConfirmDialog(null, "Print Succesfully");
            if (!printJatable) {
                JOptionPane.showConfirmDialog(null, "Unable To Print");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btnNhapExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapExcelActionPerformed

        try {
            // TODO add your handling code here:
            File excelFile;
            FileInputStream excelFIS = null;
            BufferedInputStream excelBIS = null;
            String defaultCurrentDirectoryPath = "F:\\Học liệu kì 4\\da1";
            JFileChooser excelFileChooser = new JFileChooser(defaultCurrentDirectoryPath);
            int exelChooser = excelFileChooser.showOpenDialog(null);

            if (exelChooser == JFileChooser.APPROVE_OPTION) {
                excelFile = excelFileChooser.getSelectedFile();
                excelFIS = new FileInputStream(excelFile);
                excelBIS = new BufferedInputStream(excelFIS);

                XSSFWorkbook excelJTableImport = new XSSFWorkbook(excelBIS);
                XSSFSheet excelSheet = excelJTableImport.getSheetAt(0);

                for (int i = 0; i < excelSheet.getLastRowNum(); i++) {
                    XSSFRow excelrow = excelSheet.getRow(i); //row
//                    for (int j = 0; j < excelrow.getLastCellNum(); j++) {
//                        XSSFCell excelCell =excelrow.getCell(j);
//                        System.out.println(excelCell.getStringCellValue());
//                    }

//                    
//                    XSSFCell excelName = excelrow.getCell(0);
//                    System.out.println(excelName);
                    XSSFCell excelId = excelrow.getCell(0);
                    XSSFCell excelChatLieu = excelrow.getCell(1);
                    XSSFCell excelDongSp = excelrow.getCell(2);
                    XSSFCell excelSize = excelrow.getCell(3);
                    XSSFCell excelNSx = excelrow.getCell(4);
                    XSSFCell excelMau = excelrow.getCell(5);
                    XSSFCell excelSanPham = excelrow.getCell(6);
                    XSSFCell excelSoLuongTon = excelrow.getCell(7);
                    XSSFCell excelGia = excelrow.getCell(8);
                    XSSFCell excelMoTa = excelrow.getCell(9);
                    XSSFCell excelImage = excelrow.getCell(10);
                    JLabel excel = new JLabel(new ImageIcon(excelImage.toString()));
                    model.addRow(new Object[]{
                        excelId, excelChatLieu, excelDongSp, excelSize, excelNSx, excelMau, excelSanPham, excelSoLuongTon, excelGia, excelMoTa, excelImage
                    });

                }

            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnNhapExcelActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            ChiTietSp chiTietSp = new ChiTietSp();

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

            int index7 = cboSanPham.getSelectedIndex();
            SanPham sanPham = chiTietSpServiceImpl.getSanPham().get(index7);
            chiTietSp.setSanPham(sanPham);

            chiTietSp.setSoLuongTon(Integer.parseInt(txtSoLuongTon.getText()));
            chiTietSp.setGia(Integer.parseInt(txtGia.getText()));
            chiTietSp.setMoTa(txtMoTa.getText());

            chiTietSp.setAnh(txtFilePath.getText());

            if (chiTietSpServiceImpl.update(chiTietSp) == true) {
                JOptionPane.showMessageDialog(this, "thanh cong");
                loadTable(chiTietSpRepository.getAll());
            } else {
                JOptionPane.showMessageDialog(this, "that cong");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
        int id = Integer.parseInt(txtTimKiem.getText());
        ArrayList<ChiTietSp> lisy = chiTietSpRepository.getAll1(id);
        loadTable(lisy);
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNhapExcel;
    private javax.swing.JComboBox<String> cboChatLieu;
    private javax.swing.JComboBox<String> cboDongSp;
    private javax.swing.JComboBox<String> cboMauSac;
    private javax.swing.JComboBox<String> cboNsx;
    private javax.swing.JComboBox<String> cboSanPham;
    private javax.swing.JComboBox<String> cboSize;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel jplCam;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JTable tblChiTietSp;
    private javax.swing.JTextField txtFilePath;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMaSp;
    private javax.swing.JTextField txtMoTa;
    private javax.swing.JTextField txtSoLuongTon;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

    private void showPanel(ThuocTinhSanPhamJPanel thuocTinhSanPhamJPanel) {
        //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
