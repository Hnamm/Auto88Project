/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.util.Date;
import javax.naming.event.ObjectChangeListener;
import Entities.HoaDon;
import Models.HoaDonModel;
import java.io.Serializable;

/**
 *
 * @author admin
 */
public class HoaDon implements Serializable {
    private String maHoaDon;
    private Date ngayNhap;
    private String maKhachHang;
    private String maXe;
    private int soLuong;
    private int donGia;
    private String maNV;
    private String pttt;

    public long ThanhTien() {
        return (long) soLuong * donGia;
    }

    public HoaDon() {
    }

    public HoaDon(String maHoaDon, Date ngayNhap, String maKhachHang, String maXe, int soLuong, int donGia, String maNV,
            String pttt) {
        this.maHoaDon = maHoaDon;
        this.ngayNhap = ngayNhap;
        this.maKhachHang = maKhachHang;
        this.maXe = maXe;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.maNV = maNV;
        this.pttt = pttt;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getMaXe() {
        return maXe;
    }

    public void setMaXe(String maXe) {
        this.maXe = maXe;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getPttt() {
        return pttt;
    }

    public void setPttt(String pttt) {
        this.pttt = pttt;
    }

}
