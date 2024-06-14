/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Models.HoaDonModel;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import Entities.HoaDon;
import Models.KhachHangModel;
import Models.NhanVienModel;
import Models.XeModel;
import Entities.KhachHang;
import Entities.NhanVien;
import Entities.Xe;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import Views.QuanLyKhachHangForm;
import Views.QuanLyNhanVienForm;
import Views.QuanLyXeForm;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author admin
 */
public class QuanLyHoaDonForm extends javax.swing.JFrame {

    public HoaDonModel hdm;
    public KhachHangModel khm;
    public ArrayList<HoaDon> list;
    public ArrayList<Xe> dsxe;
    public Set<KhachHang> dskh;
    public ArrayList<NhanVien> dsnv;
    public QuanLyNhanVienForm nvf;
    public QuanLyKhachHangForm khf;
    public QuanLyXeForm xef;
    public DefaultTableModel tb_model;
    String fileName = "src/main/java/Files/hoaDon.txt";
    private static int pos = 0;
    public SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public QuanLyHoaDonForm() {
        initComponents();
        this.setTitle("Quản lý hóa đơn");
        this.setLocationRelativeTo(null);
        hdm = new HoaDonModel();
        //hdm.fakeData();
        hdm.setDshd(hdm.docfile(fileName));
        list = hdm.getDshd();
        dsxe = docfile2("src/main/java/Files/Xe.txt");
        khm = new KhachHangModel();
        dskh = khm.readDateFromFile("src/main/java/Files/KhachHang.txt");
        dsnv = docfile("src/main/java/Files/NhanVien.txt");
        tb_model = (DefaultTableModel) tb_hoaDon.getModel();
        hienthidsfake();
    }

    public ArrayList docfile(String filename) {

        dsnv = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            dsnv = (ArrayList<NhanVien>) ois.readObject();

        } catch (IOException E) {
            System.out.println("Loi" + E.getMessage());
        } catch (Exception ex) {
            System.out.println("Loi" + ex.getMessage());
        }
        return dsnv;
    }

    public final ArrayList docfile2(String filename) {

        dsxe = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            dsxe = (ArrayList<Xe>) ois.readObject();

        } catch (IOException E) {
            System.out.println("Loi" + E.getMessage());
        } catch (Exception ex) {
            System.out.println("Loi" + ex.getMessage());
        }
        return dsxe;
    }

    public void view() {

        HoaDon x = list.get(pos);
        String ngayNhapFormatted = dateFormat.format(x.getNgayNhap());
        txt_maHoaDon.setText(x.getMaHoaDon());
        txt_ngayLap.setText(ngayNhapFormatted);
        txt_maKhachHang.setText(x.getMaKhachHang());
        txt_maXe.setText(x.getMaXe());
        txt_soLuong.setText("" + x.getSoLuong());
        txt_donGia.setText("" + x.getDonGia());
        txt_maNhanVien.setText(x.getMaNV());
        cb_pttt.setSelectedItem(x.getPttt());
    }

    public void resetForm() {
        txt_maHoaDon.setText("");
        txt_ngayLap.setText("");
        txt_maKhachHang.setText("");
        txt_maXe.setText("");
        txt_soLuong.setText("");
        txt_donGia.setText("");
        txt_maNhanVien.setText("");
        cb_pttt.setSelectedIndex(0); // Reset combobox về giá trị mặc định
    }

    public void hienthidsfake() {
        tb_model.setNumRows(0);
        for (HoaDon hoaDon : list) {
            String ngayNhapFormatted = dateFormat.format(hoaDon.getNgayNhap());
            tb_model.addRow(new Object[]{
                hoaDon.getMaHoaDon(),
                ngayNhapFormatted,
                hoaDon.getMaKhachHang(),
                hoaDon.getMaXe(),
                hoaDon.getSoLuong(),
                hoaDon.getDonGia(),
                hoaDon.ThanhTien(),
                hoaDon.getMaNV(),
                hoaDon.getPttt()});
        }
    }

    public HoaDon kiemtratontai(String maHoaDon) {
        for (HoaDon hoaDon : list) {
            if (hoaDon.getMaHoaDon().equals(maHoaDon)) {
                return hoaDon;
            }
        }
        return null;
    }

    public boolean kiemTraXe(String maXe) {
        for (Xe xe : dsxe) {
            if (xe.getMaXe().equals(maXe)) {
                return true;
            }
        }
        return false;
    }

    public boolean kiemTraNhanVien(String maNV) {
        for (NhanVien nv : dsnv) {
            if (nv.getId().equals(maNV)) {
                return true;
            }
        }
        return false;
    }
    public boolean kiemTraKhachHang(String maKH) {
        for (KhachHang kh : dskh) {
            if (kh.getId().equals(maKH)) {
                return true;
            }
        }
        return false;
    }

    public void getModel(HoaDon hd) {
        String ngayNhapFormatted = dateFormat.format(hd.getNgayNhap());
        txt_maHoaDon.setText(hd.getMaHoaDon());
        txt_ngayLap.setText(ngayNhapFormatted);
        txt_maKhachHang.setText(hd.getMaKhachHang());
        txt_maXe.setText(hd.getMaXe());
        txt_soLuong.setText("" + hd.getSoLuong());
        txt_donGia.setText("" + hd.getDonGia());
        txt_maNhanVien.setText(hd.getMaNV());
        cb_pttt.setSelectedItem(hd.getPttt());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txt_maHoaDon = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_ngayLap = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txt_maKhachHang = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_maXe = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txt_soLuong = new javax.swing.JTextField();
        lable_donGia = new javax.swing.JLabel();
        txt_donGia = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txt_maNhanVien = new javax.swing.JTextField();
        cbx_pttt = new javax.swing.JLabel();
        cb_pttt = new javax.swing.JComboBox<>();
        btn_giaGoc = new javax.swing.JButton();
        btn_them = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        btnTroLai = new javax.swing.JButton();
        btn_tim = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_hoaDon = new javax.swing.JTable();

        jLabel2.setText("jLabel2");

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản lí hóa đơn");

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));

        jPanel6.setBackground(new java.awt.Color(255, 204, 204));

        jLabel4.setText("Mã  hóa đơn :");

        txt_maHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_maHoaDonActionPerformed(evt);
            }
        });

        jLabel5.setText("Ngày lập : ");

        txt_ngayLap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ngayLapActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(255, 204, 204));

        jLabel6.setText("Mã khách hàng : ");

        txt_maKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_maKhachHangActionPerformed(evt);
            }
        });

        jLabel7.setText("Mã xe : ");

        txt_maXe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_maXeActionPerformed(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(255, 204, 204));

        jLabel8.setText("Số lượng : ");

        txt_soLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_soLuongActionPerformed(evt);
            }
        });

        lable_donGia.setText("Đơn giá : ");

        txt_donGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_donGiaActionPerformed(evt);
            }
        });

        jPanel9.setBackground(new java.awt.Color(255, 204, 204));

        jLabel10.setText("Mã nhân viên : ");

        txt_maNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_maNhanVienActionPerformed(evt);
            }
        });

        cbx_pttt.setText("Phương thức thanh toán : ");

        cb_pttt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "online", "offline" }));
        cb_pttt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_ptttActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_maNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121)
                .addComponent(cbx_pttt)
                .addGap(30, 30, 30)
                .addComponent(cb_pttt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbx_pttt)
                    .addComponent(txt_maNhanVien)
                    .addComponent(cb_pttt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        btn_giaGoc.setBackground(new java.awt.Color(204, 255, 204));
        btn_giaGoc.setForeground(new java.awt.Color(51, 51, 51));
        btn_giaGoc.setText("Giá gốc");
        btn_giaGoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_giaGocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(38, 38, 38)
                .addComponent(txt_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122)
                .addComponent(lable_donGia, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_donGia, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(btn_giaGoc)
                .addContainerGap(90, Short.MAX_VALUE))
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lable_donGia)
                    .addComponent(txt_donGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_giaGoc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_maKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_maXe, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txt_maKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_maXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_maHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_ngayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_maHoaDon, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5)
                        .addComponent(txt_ngayLap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        btn_them.setBackground(new java.awt.Color(255, 255, 102));
        btn_them.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_them.setText("Thêm ");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_xoa.setBackground(new java.awt.Color(255, 255, 51));
        btn_xoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_xoa.setText("Xóa");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        btn_sua.setBackground(new java.awt.Color(255, 255, 51));
        btn_sua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_sua.setText("Sửa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        btn_reset.setBackground(new java.awt.Color(255, 255, 51));
        btn_reset.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_reset.setText("Reset");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        btnTroLai.setText("Trở lại");
        btnTroLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTroLaiActionPerformed(evt);
            }
        });

        btn_tim.setBackground(new java.awt.Color(255, 255, 0));
        btn_tim.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_tim.setText("Tìm kiếm");
        btn_tim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnTroLai)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btn_tim, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnTroLai, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_tim, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 177, Short.MAX_VALUE)
        );

        tb_hoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Ngày lập", "Mã khách hàng", "Mã xe", "Số lượng", "Đơn giá", "Thành tiền", "Mã nhân viên", "Phương thức thanh toán"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tb_hoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_hoaDonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_hoaDon);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 907, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTroLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTroLaiActionPerformed
        // TODO add your handling code here:
        TrangChuForm form = new TrangChuForm();
        this.dispose();
        form.setVisible(true);
    }//GEN-LAST:event_btnTroLaiActionPerformed

    private void btn_timActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timActionPerformed
        String mahd = txt_maHoaDon.getText();
        HoaDon hd = kiemtratontai(mahd);
        if (hd != null) {
            txt_maHoaDon.setEnabled(false);
            getModel(hd);
        } else {
            if (mahd.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập mã hóa đơn", "Thông báo", HEIGHT);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Hóa đơn ko tồn tại", "Thông báo", HEIGHT);
                resetForm();
            }
        }
    }//GEN-LAST:event_btn_timActionPerformed

    private void btn_giaGocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_giaGocActionPerformed
        try {
            String maXe = txt_maXe.getText();
            if (maXe.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ma nhân viên phải tồn tại", "Thông báo",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (kiemTraXe(maXe)) {
                for (Xe xe : dsxe) {
                    if (xe.getMaXe().equals(maXe)) {
                        txt_donGia.setText("" + xe.getGiaBan());
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra: " + e.getMessage(), "Thông báo",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_giaGocActionPerformed

    private void txt_maXeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txt_maXeActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txt_maXeActionPerformed

    private void txt_maKhachHangActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txt_maKhachHangActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txt_maKhachHangActionPerformed

    private void txt_ngayLapActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txt_ngayLapActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txt_ngayLapActionPerformed

    private void txt_maHoaDonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txt_maHoaDonActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txt_maHoaDonActionPerformed

    private void txt_soLuongActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txt_soLuongActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txt_soLuongActionPerformed

    private void txt_donGiaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txt_donGiaActionPerformed

    }// GEN-LAST:event_txt_donGiaActionPerformed

    private void txt_maNhanVienActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txt_maNhanVienActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txt_maNhanVienActionPerformed

    private void cb_ptttActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cb_ptttActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_cb_ptttActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_suaActionPerformed
    try{
        String maHoaDon = txt_maHoaDon.getText();
        String ngayLap = txt_ngayLap.getText();
        String maKhachHang = txt_maKhachHang.getText();
        String maXe = txt_maXe.getText();
        String soLuongStr = txt_soLuong.getText();
        String donGiaStr = txt_donGia.getText();
        String pttt = (String) cb_pttt.getSelectedItem();
        String maNV = txt_maNhanVien.getText();

        // Kiểm tra các trường không được bỏ trống
        if (maHoaDon.isEmpty() || ngayLap.isEmpty() || maKhachHang.isEmpty() || maXe.isEmpty()
                || soLuongStr.isEmpty()
                || donGiaStr.isEmpty() || pttt.isEmpty() || maNV.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Bạn phải điền đầy đủ thông tin", "Thông báo",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!kiemTraXe(maXe)) {
            JOptionPane.showMessageDialog(null, "Mã xe phải tồn tại", "Thông báo",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!kiemTraNhanVien(maNV)) {
            JOptionPane.showMessageDialog(null, "Mã nhân viên phải tồn tại", "Thông báo",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!kiemTraKhachHang(maKhachHang)) {
            JOptionPane.showMessageDialog(null, "Mã khách hàng phải tồn tại", "Thông báo",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        // Kiểm tra số lượng và đơn giá phải là số nguyên và không nhỏ hơn 0
        int soLuong;
        int donGia;
        try {
            soLuong = Integer.parseInt(soLuongStr);
            donGia = Integer.parseInt(donGiaStr);
            if (soLuong < 0 || donGia < 0) {
                JOptionPane.showMessageDialog(rootPane,
                        "Số lượng và đơn giá phải là số nguyên không nhỏ hơn 0",
                        "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "Số lượng và đơn giá phải là số nguyên", "Thông báo",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Kiểm tra định dạng ngày nhập
        Date ngayNhap;
        try {
            ngayNhap = dateFormat.parse(ngayLap); // Chuyển đổi chuỗi ngày lập thành đối tượng Date
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(rootPane, "Ngày nhập phải đúng định dạng dd/MM/yyyy", "Thông báo",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Kiểm tra xem mã hóa đơn có tồn tại trong danh sách hay không
        HoaDon ktHoaDon = kiemtratontai(maHoaDon);
        HoaDon hoaDon = new HoaDon(maHoaDon, ngayNhap, maKhachHang, maXe, soLuong, donGia, maNV, pttt);
        if (ktHoaDon == null) {
            JOptionPane.showMessageDialog(rootPane, "Hóa đơn không tồn tại", "Thông báo",
                    JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            hdm.update(hoaDon);
        }

        // Cập nhật danh sách và giao diện
        hienthidsfake(); // Hàm này có thể là cập nhật bảng hoặc giao diện khác
        hdm.LuuFile(fileName, list); // Lưu danh sách vào file
        JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công", "Thông báo",
                JOptionPane.INFORMATION_MESSAGE);
        resetForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra: " + e.getMessage(), "Thông báo",
                    JOptionPane.ERROR_MESSAGE);
        } // Reset form sau khi cập nhật thành công
    }// GEN-LAST:event_btn_suaActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_themActionPerformed
        try {
            // Lấy giá trị từ các trường nhập liệu
            String maHoaDon = txt_maHoaDon.getText();
            String ngayLap = txt_ngayLap.getText();
            String maKhachHang = txt_maKhachHang.getText();
            String maXe = txt_maXe.getText();
            String soLuongStr = txt_soLuong.getText();
            String donGiaStr = txt_donGia.getText();
            String maNV = txt_maNhanVien.getText();
            String pttt = (String) cb_pttt.getSelectedItem();

            // Kiểm tra các trường không được bỏ trống
            if (maHoaDon.isEmpty() || ngayLap.isEmpty() || maKhachHang.isEmpty() || maXe.isEmpty()
                    || soLuongStr.isEmpty() || donGiaStr.isEmpty() || maNV.isEmpty()
                    || pttt.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Bạn phải điền đầy đủ thông tin", "Thông báo",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Kiểm tra mã hóa đơn không được trùng trong danh sách
            for (HoaDon hd : list) {
                if (hd.getMaHoaDon().equals(maHoaDon)) {
                    JOptionPane.showMessageDialog(null, "Mã hóa đơn đã tồn tại", "Thông báo",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
            if (!kiemTraXe(maXe)) {
                JOptionPane.showMessageDialog(null, "Mã xe phải tồn tại", "Thông báo",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (!kiemTraNhanVien(maNV)) {
                JOptionPane.showMessageDialog(null, "Ma nhân viên phải tồn tại", "Thông báo",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (!kiemTraKhachHang(maKhachHang)) {
                JOptionPane.showMessageDialog(null, "Mã khách hàng phải tồn tại", "Thông báo",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            // Kiểm tra số lượng và đơn giá phải là số nguyên và không nhỏ hơn 0
            int soLuong;
            int donGia;
            try {
                soLuong = Integer.parseInt(soLuongStr);
                donGia = Integer.parseInt(donGiaStr);
                if (soLuong < 0 || donGia < 0) {
                    JOptionPane.showMessageDialog(null,
                            "Số lượng và đơn giá phải là số nguyên lớn hơn 0", "Thông báo",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Số lượng và đơn giá phải là số nguyên",
                        "Thông báo",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Kiểm tra định dạng ngày nhập
            Date ngayNhap;
            try {
                ngayNhap = dateFormat.parse(ngayLap); // Chuyển đổi chuỗi ngày lập thành đối tượng Date
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Ngày nhập phải đúng định dạng dd/MM/yyyy",
                        "Thông báo",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Tạo đối tượng HoaDon mới
            HoaDon hoaDon = new HoaDon(maHoaDon, ngayNhap, maKhachHang, maXe, soLuong, donGia, maNV, pttt);

            // Thêm vào danh sách và cập nhật giao diện
            hdm.add(hoaDon);
            // Hàm này có thể là cập nhật bảng hoặc giao diện khác
            hdm.LuuFile(fileName, list); // Lưu danh sách vào file
            hienthidsfake();
            JOptionPane.showMessageDialog(null, "Thêm thành công", "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE);
            resetForm(); // Reset form sau khi thêm thành công
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra: " + e.getMessage(), "Thông báo",
                    JOptionPane.ERROR_MESSAGE);
        }
    }// GEN-LAST:event_btn_themActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_xoaActionPerformed
        try {
            String maHoaDon = txt_maHoaDon.getText();
            if (maHoaDon.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Bạn phải nhập mã hóa đơn", "Thông báo",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            HoaDon ktHoaDon = kiemtratontai(maHoaDon);
            if (ktHoaDon == null) {
                JOptionPane.showMessageDialog(rootPane, "Hóa đơn không tồn tại", "Thông báo",
                        JOptionPane.WARNING_MESSAGE);
                return;
            } else {
                hdm.remove(maHoaDon);
                hienthidsfake(); // Hàm này có thể là cập nhật bảng hoặc giao diện khác
                hdm.LuuFile(fileName, list);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra: " + e.getMessage(), "Thông báo",
                    JOptionPane.ERROR_MESSAGE);
        }
    }// GEN-LAST:event_btn_xoaActionPerformed

    private void tb_hoaDonMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tb_hoaDonMouseClicked
        pos = this.tb_hoaDon.getSelectedRow();
        view();
    }// GEN-LAST:event_tb_hoaDonMouseClicked

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_resetActionPerformed
        txt_maHoaDon.setEnabled(true);
        resetForm();
    }// GEN-LAST:event_btn_resetActionPerformed

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                    .getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanLyHoaDonForm.class.getName()).log(
                    java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyHoaDonForm.class.getName()).log(
                    java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyHoaDonForm.class.getName()).log(
                    java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyHoaDonForm.class.getName()).log(
                    java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyHoaDonForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTroLai;
    private javax.swing.JButton btn_giaGoc;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_tim;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JComboBox<String> cb_pttt;
    private javax.swing.JLabel cbx_pttt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lable_donGia;
    private javax.swing.JTable tb_hoaDon;
    private javax.swing.JTextField txt_donGia;
    private javax.swing.JTextField txt_maHoaDon;
    private javax.swing.JTextField txt_maKhachHang;
    private javax.swing.JTextField txt_maNhanVien;
    private javax.swing.JTextField txt_maXe;
    private javax.swing.JTextField txt_ngayLap;
    private javax.swing.JTextField txt_soLuong;
    // End of variables declaration//GEN-END:variables
}
