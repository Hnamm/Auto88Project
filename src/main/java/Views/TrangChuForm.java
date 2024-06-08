/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;


import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.ImageIcon;

import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

/**
 *
 * @author admin
 */
public class TrangChuForm extends javax.swing.JFrame {

    /**
     * Creates new form TrangChuForm
     */
    public TrangChuForm() {
        initComponents();
        this.setTitle("Trang chủ");
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnQuanLyXe = new javax.swing.JButton();
        btnQuanLyHoaDon = new javax.swing.JButton();
        btnQuanLyNhanVien = new javax.swing.JButton();
        btnQuanLyKhachHang = new javax.swing.JButton();
        btnDangXuat = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 700));

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("MENU");

        btnQuanLyXe.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnQuanLyXe.setText("Quản lý thông tin xe");
        btnQuanLyXe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyXeActionPerformed(evt);
            }
        });

        btnQuanLyHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnQuanLyHoaDon.setText("Quản lý hóa đơn");
        btnQuanLyHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyHoaDonActionPerformed(evt);
            }
        });

        btnQuanLyNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnQuanLyNhanVien.setText("Quản lý nhân viên");
        btnQuanLyNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyNhanVienActionPerformed(evt);
            }
        });

        btnQuanLyKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnQuanLyKhachHang.setText("Quản lý khách hàng");
        btnQuanLyKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyKhachHangActionPerformed(evt);
            }
        });

        btnDangXuat.setBackground(new java.awt.Color(255, 102, 102));
        btnDangXuat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDangXuat.setText("Đăng Xuất");
        btnDangXuat.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout
                                                .createSequentialGroup()
                                                .addComponent(btnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 170,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                jPanel1Layout.createSequentialGroup()
                                                        .addComponent(btnQuanLyXe)
                                                        .addContainerGap())))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(btnQuanLyKhachHang,
                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnQuanLyNhanVien,
                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnQuanLyHoaDon,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(68, 68, 68)
                                                .addComponent(jLabel1)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jSeparator1)))
                                .addContainerGap()));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel1)
                                .addGap(27, 27, 27)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 20,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(btnQuanLyXe, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(btnQuanLyHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(btnQuanLyNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btnQuanLyKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(btnQuanLyTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109,
                                        Short.MAX_VALUE)
                                .addComponent(btnDangXuat)
                                .addGap(24, 24, 24)));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setText("Những chiếc xe được nhập về mới nhất ");
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnQuanLyXe, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnQuanLyHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnQuanLyNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnQuanLyKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnQuanLyTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addComponent(btnDangXuat)
                .addGap(24, 24, 24))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setText("Những chiếc xe được nhập về mới nhất ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel2)
                                .addContainerGap(19, Short.MAX_VALUE)));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel2)
                                .addContainerGap(25, Short.MAX_VALUE)));

            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }));
        jScrollPane1.setViewportView(jTable1);
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1));
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 535,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 6, Short.MAX_VALUE)));
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))));
        layout.setVerticalGroup(

                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE));

            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
>>>>>>> cf9bb194bd3a6c1d1a704c5341e9f928216eba21

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnQuanLyXeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnQuanLyXeActionPerformed
        // TODO add your handling code here:
        QuanLyXeForm quanLyXeForm = new QuanLyXeForm();
        this.dispose();
        quanLyXeForm.setVisible(true);
    }// GEN-LAST:event_btnQuanLyXeActionPerformed

    private void btnQuanLyHoaDonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnQuanLyHoaDonActionPerformed
        // TODO add your handling code here:
        QuanLyHoaDonForm quanLyHoaDonForm = new QuanLyHoaDonForm();
        this.dispose();
        quanLyHoaDonForm.setVisible(true);
    }// GEN-LAST:event_btnQuanLyHoaDonActionPerformed

    private void btnQuanLyNhanVienActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnQuanLyNhanVienActionPerformed
        // TODO add your handling code here:
        QuanLyNhanVienForm quanLyNhanVienForm = new QuanLyNhanVienForm();
        this.dispose();
        quanLyNhanVienForm.setVisible(true);
    }// GEN-LAST:event_btnQuanLyNhanVienActionPerformed

    private void btnQuanLyKhachHangActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnQuanLyKhachHangActionPerformed
        // TODO add your handling code here:
        QuanLyKhachHangForm quanLyKhachHangForm = new QuanLyKhachHangForm();
        this.dispose();
        quanLyKhachHangForm.setVisible(true);
    }// GEN-LAST:event_btnQuanLyKhachHangActionPerformed

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDangXuatActionPerformed
        // TODO add your handling code here:
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Arial", Font.BOLD, 20)));
        int n = JOptionPane.showConfirmDialog(this, "Bạn có muốn đăng xuất không?", "Alert", JOptionPane.YES_NO_OPTION);
        if (n == JOptionPane.YES_OPTION) {
            this.dispose();
            DangNhapForm form = new DangNhapForm();
            form.setVisible(true);
        }
    }// GEN-LAST:event_btnDangXuatActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TrangChuForm.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrangChuForm.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrangChuForm.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrangChuForm.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrangChuForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnQuanLyHoaDon;
    private javax.swing.JButton btnQuanLyKhachHang;
    private javax.swing.JButton btnQuanLyNhanVien;
    private javax.swing.JButton btnQuanLyXe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
<<<<<<< HEAD
    private javax.swing.JScrollPane jScrollPane1;
=======
<<<<<<< HEAD
    private javax.swing.JScrollPane jScrollPane2;
=======
    private javax.swing.JScrollPane jScrollPane1;
>>>>>>> tuan
>>>>>>> cf9bb194bd3a6c1d1a704c5341e9f928216eba21
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
