/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author admin
 */
public class Xe implements Serializable{
    
    private String maXe, tenXe, hangSanXuat, mauSac, ngaySanXuat, loaiXe;
    private long giaBan;
    private int soGhe;

    public Xe(String maXe, String tenXe, String hangSanXuat, String mauSac, String ngaySanXuat, String loaiXe, long giaBan, int soGhe) {
        this.maXe = maXe;
        this.tenXe = tenXe;
        this.hangSanXuat = hangSanXuat;
        this.mauSac = mauSac;
        this.ngaySanXuat = ngaySanXuat;
        this.loaiXe = loaiXe;
        this.giaBan = giaBan;
        this.soGhe = soGhe;
    }

    public Xe(String maXe) {
        this.maXe = maXe;
    }
     
    public String getMaXe() {
        return maXe;
    }

    public void setMaXe(String maXe) {
        this.maXe = maXe;
    }

    public String getTenXe() {
        return tenXe;
    }

    public void setTenXe(String tenXe) {
        this.tenXe = tenXe;
    }

    public String getHangSanXuat() {
        return hangSanXuat;
    }

    public void setHangSanXuat(String hangSanXuat) {
        this.hangSanXuat = hangSanXuat;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgaySanXuat(String ngaySanXuat) {
        this.ngaySanXuat = ngaySanXuat;
    }

    public String getLoaiXe() {
        return loaiXe;
    }

    public void setLoaiXe(String loaiXe) {
        this.loaiXe = loaiXe;
    }

    public long getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(long giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoGhe() {
        return soGhe;
    }

    public void setSoGhe(int soGhe) {
        this.soGhe = soGhe;
    }
    
    @Override
    public int hashCode() { 
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.maXe);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Xe other = (Xe) obj;
        return Objects.equals(this.maXe, other.maXe);
    }
            
}
