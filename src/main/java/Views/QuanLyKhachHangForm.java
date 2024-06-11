/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Entities.KhachHang;
import Entities.LoaiKhachHang;
import Models.KhachHangModel;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author admin
 */
public class QuanLyKhachHangForm extends javax.swing.JFrame {

    KhachHangModel khachHangModel = KhachHangModel.getInstance();

    public QuanLyKhachHangForm() {
        try {
            initComponents();
            initTable();
            initSelect();
            this.setLocationRelativeTo(null);
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                KhachHangModel.writeDataToFile(khachHangModel.getKhachHangs(), "src/main/java/files/KhachHang.txt");
            }));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Có lỗi trong quá trình khởi tạo: " + ex.getMessage() + "\n" + ex.toString() + "\n", "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private DefaultTableModel model;

    public final void initTable() {
        model = (DefaultTableModel) this.tblCustomers.getModel();
        model.setColumnIdentifiers(new String[] { "Mã Khách hàng", "Tên Khách hàng", "Số điện thoại", "Hà Nội",
                "Giới tính", "Loại khách hàng" });
        tblCustomers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        tblCustomers.setRowSorter(sorter);
        loadTable(khachHangModel.getKhachHangs());
    }

    public void loadTable(Set<KhachHang> khachHangs) {

        model.setNumRows(0);
        for (KhachHang kh : khachHangs) {
            model.addRow(new Object[] { kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getSoDienThoai(), kh.getDiaChi(),
                    kh.isGioiTinh() ? "Nam" : "Nữ", kh.getLoaiKhachHang().getDisplayName() });
        }
    }

    public final void initSelect() {
        for (LoaiKhachHang loai : LoaiKhachHang.values()) {
            this.typeCustomer.addItem(loai.getDisplayName());
        }
    }

    public void refresh() {
        this.txtId.setText("");
        this.txtName.setText("");
        this.txtPhone.setText("");
        this.txtAddress.setText("");
        this.radioMale.setSelected(true);
        this.typeCustomer.setSelectedIndex(0);
    }

    public void getSelectedRow() {
        int selectedRow = this.tblCustomers.getSelectedRow();
        if (selectedRow >= 0) {
            String customerId = (String) tblCustomers.getValueAt(selectedRow, 0);
            KhachHang selectedCustomer = khachHangModel.getCustomerById(customerId);

            this.txtId.setText(selectedCustomer.getMaKhachHang());
            this.txtName.setText(selectedCustomer.getTenKhachHang());
            this.txtAddress.setText(selectedCustomer.getDiaChi());
            this.txtPhone.setText(selectedCustomer.getSoDienThoai());
            this.radioMale.setSelected(selectedCustomer.isGioiTinh());
            this.radioFemale.setSelected(!selectedCustomer.isGioiTinh());
            this.typeCustomer.setSelectedItem(selectedCustomer.getLoaiKhachHang().getDisplayName());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCustomers = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtId = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        radioMale = new javax.swing.JRadioButton();
        radioFemale = new javax.swing.JRadioButton();
        typeCustomer = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();
        btnAlter = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnTroLai = new javax.swing.JButton();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 255));
        jLabel1.setText("Quản lý khách hàng");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.setForeground(new java.awt.Color(153, 153, 255));

        tblCustomers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblCustomers.setGridColor(new java.awt.Color(153, 153, 255));
        tblCustomers.setSelectionBackground(new java.awt.Color(153, 153, 255));
        tblCustomers.getTableHeader().setReorderingAllowed(false);
        tblCustomers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCustomersMouseClicked(evt);
            }
        });
        tblCustomers.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblCustomersKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblCustomers);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 255));
        jLabel2.setText("Mã khách hàng");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 255));
        jLabel3.setText("Tên Khách hàng");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 255));
        jLabel4.setText("Số điện thoại");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 255));
        jLabel5.setText("Địa chỉ");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 255));
        jLabel7.setText("Giới tính");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 255));
        jLabel6.setText("Loại khách hàng");

        txtPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioMale);
        radioMale.setForeground(new java.awt.Color(153, 153, 255));
        radioMale.setText("Nam");
        radioMale.setToolTipText("");

        buttonGroup1.add(radioFemale);
        radioFemale.setForeground(new java.awt.Color(153, 153, 255));
        radioFemale.setText("Nữ");
        radioFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioFemaleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(radioMale)
                .addGap(29, 29, 29)
                .addComponent(radioFemale)
                .addContainerGap(158, Short.MAX_VALUE))
            .addComponent(txtId)
            .addComponent(txtName)
            .addComponent(txtPhone)
            .addComponent(txtAddress)
            .addComponent(typeCustomer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioMale)
                    .addComponent(radioFemale))
                .addGap(18, 18, 18)
                .addComponent(typeCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addGap(4, 4, 4))
        );

        txtSearch.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtSearch.setForeground(new java.awt.Color(153, 153, 255));
        txtSearch.setCaretColor(new java.awt.Color(153, 153, 255));
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        btnCreate.setBackground(new java.awt.Color(153, 153, 255));
        btnCreate.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnCreate.setForeground(new java.awt.Color(255, 255, 255));
        btnCreate.setText("Tạo mới");
        btnCreate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCreateMouseClicked(evt);
            }
        });

        btnAlter.setBackground(new java.awt.Color(153, 153, 255));
        btnAlter.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnAlter.setForeground(new java.awt.Color(255, 255, 255));
        btnAlter.setText("Sửa");
        btnAlter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(153, 153, 255));
        btnDelete.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnRefresh.setBackground(new java.awt.Color(153, 153, 255));
        btnRefresh.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnRefresh.setForeground(new java.awt.Color(255, 255, 255));
        btnRefresh.setText("Làm mới");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAlter, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCreate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addGap(9, 9, 9)
                .addComponent(btnCreate, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAlter, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnTroLai.setText("Trở lại");
        btnTroLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTroLaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnTroLai, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTroLai, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTroLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTroLaiActionPerformed
        // TODO add your handling code here:
        TrangChuForm form = new TrangChuForm();
        this.dispose();
        form.setVisible(true);
    }//GEN-LAST:event_btnTroLaiActionPerformed

    private void radioFemaleActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_radioFemaleActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_radioFemaleActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnRefreshActionPerformed
        refresh();
    }// GEN-LAST:event_btnRefreshActionPerformed

    private void txtPhoneActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtPhoneActionPerformed

    }// GEN-LAST:event_txtPhoneActionPerformed

    private void btnCreateMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btnCreateMouseClicked
        String id = this.txtId.getText();
        String name = this.txtName.getText();
        String phone = this.txtPhone.getText();
        String address = this.txtAddress.getText();
        boolean sex = this.radioMale.isSelected();
        String selectedDisplayName = (String) this.typeCustomer.getSelectedItem();
        LoaiKhachHang selectedType = LoaiKhachHang.fromDisplayName(selectedDisplayName);
        if (id.trim().isEmpty() || name.trim().isEmpty() || phone.trim().isEmpty() || address.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Yêu cầu nhập đủ thông tin", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!KhachHangModel.isValidPhoneNumber(phone)) {
            JOptionPane.showMessageDialog(this, "Yêu cầu nhập số điện thoại đúng định dạng", "Thông báo",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {

            KhachHang newCustomer = new KhachHang(id, name, phone, address, sex, selectedType);
            if (khachHangModel.isCustomerExist(newCustomer)) {
                JOptionPane.showMessageDialog(this, "Khách hàng đã tồn tại", "Thông báo", JOptionPane.ERROR_MESSAGE);
            } else {
                khachHangModel.addCustomer(newCustomer);
                loadTable(khachHangModel.getKhachHangs());
                refresh();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Thêm khách hàng mới có lỗi, chi tiết: " + ex.getMessage() + "\n" + ex.toString() + "\n",
                    "Có lỗi xảy ra", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }// GEN-LAST:event_btnCreateMouseClicked

    private void tblCustomersMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tblCustomersMouseClicked
        getSelectedRow();
    }// GEN-LAST:event_tblCustomersMouseClicked

    private void tblCustomersKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_tblCustomersKeyReleased
        getSelectedRow();
    }// GEN-LAST:event_tblCustomersKeyReleased

    private void btnAlterActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAlterActionPerformed
        int selectedRow = this.tblCustomers.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một khách hàng để sửa.", "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        String id = this.txtId.getText();
        String name = this.txtName.getText();
        String phone = this.txtPhone.getText();
        String address = this.txtAddress.getText();
        boolean sex = this.radioMale.isSelected();
        String selectedDisplayName = (String) this.typeCustomer.getSelectedItem();
        LoaiKhachHang selectedType = LoaiKhachHang.fromDisplayName(selectedDisplayName);
        if (id.trim().isEmpty() || name.trim().isEmpty() || phone.trim().isEmpty() || address.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Yêu cầu nhập đủ thông tin", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!KhachHangModel.isValidPhoneNumber(phone)) {
            JOptionPane.showMessageDialog(this, "Yêu cầu nhập số điện thoại đúng định dạng", "Thông báo",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            KhachHang customer = new KhachHang(id, name, phone, address, sex, selectedType);
            int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn sửa thông tin khách hàng này?",
                    "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                khachHangModel.updateCustomer(customer);
                loadTable(khachHangModel.getKhachHangs());
                refresh();
                JOptionPane.showMessageDialog(this, "Thông tin khách hàng đã được sửa.", "Thông báo",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Có lỗi trong quá trình sửa thông tin khách hàng, chi tiết: "
                    + ex.getMessage() + "\n" + ex.toString() + "\n", "Có lỗi xảy ra", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }

    }// GEN-LAST:event_btnAlterActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDeleteActionPerformed
        int selectedRow = this.tblCustomers.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng cần xóa.", "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        try {
            int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa khách hàng này?", "Xác nhận",
                    JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                String customerId = (String) this.tblCustomers.getValueAt(selectedRow, 0);

                khachHangModel.removeCustomerByIndex(customerId);

                loadTable(khachHangModel.getKhachHangs());
                refresh();
                JOptionPane.showMessageDialog(this, "Khách hàng đã được xóa.", "Thông báo",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Có lỗi trong quá trình xóa khách hàng, chi tiết: " + ex.getMessage() + "\n" + ex.toString() + "\n",
                    "Có lỗi xảy ra", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }// GEN-LAST:event_btnDeleteActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtSearchKeyReleased
        try {
            String keyword = txtSearch.getText();
            Set<KhachHang> filteredCustomers = khachHangModel.searchCustomers(keyword);
            loadTable(filteredCustomers);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Tìm kiếm khách hàng bị lỗi, chi tiết: " + ex.getMessage() + "\n" + ex.toString() + "\n",
                    "Có lỗi xảy ra", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }// GEN-LAST:event_txtSearchKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanLyKhachHangForm.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyKhachHangForm.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyKhachHangForm.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyKhachHangForm.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyKhachHangForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlter;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnTroLai;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton radioFemale;
    private javax.swing.JRadioButton radioMale;
    private javax.swing.JTable tblCustomers;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JComboBox<String> typeCustomer;
    // End of variables declaration//GEN-END:variables
}