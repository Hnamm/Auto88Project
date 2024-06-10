/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.io.Serializable;

/**
 *
 * @author admin
 */
public class NhanVien extends Person implements Serializable{
    private String chucVu;
    private long luong;
    private String caLamViec;
    private long thuong;

    public NhanVien(String chucVu, long luong, String caLamViec, long thuong, String id, String ten, String soDienThoai, String diaChi, String gioiTinh) {
        super(id, ten, soDienThoai, diaChi, gioiTinh);
        this.chucVu = chucVu;
        this.luong = luong;
        this.caLamViec = caLamViec;
        this.thuong = thuong;
    }

    public NhanVien(String id) {
        super(id);
    }
    
   

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public long getLuong() {
        return luong;
    }

    public void setLuong(long luong) {
        this.luong = luong;
    }

    public String getCaLamViec() {
        return caLamViec;
    }

    public void setCaLamViec(String caLamViec) {
        this.caLamViec = caLamViec;
    }

    public long getThuong() {
        return thuong;
    }

    public void setThuong(long thuong) {
        this.thuong = thuong;
    }

}
