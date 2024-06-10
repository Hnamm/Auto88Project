/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Entities.NhanVien;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class NhanVienModel {
    ArrayList<NhanVien> danhSachNhanVien;

    public NhanVienModel() {
        this.danhSachNhanVien = new ArrayList<>();
    }

    public NhanVienModel(ArrayList<NhanVien> danhSachNhanVien) {
        this.danhSachNhanVien = danhSachNhanVien;
    }

    public ArrayList<NhanVien> getDanhSachNhanVien() {
        return danhSachNhanVien;
    }

    public void setDanhSachNhanVien(ArrayList<NhanVien> danhSachNhanVien) {
        this.danhSachNhanVien = danhSachNhanVien;
    }

    public void fakeData() {
        NhanVien xe1 = new NhanVien("Nhân viên thời vụ", 1000000, "Sáng", 500000, "1", "Nguyen Hai Nam", "098184743",
                "Thái Bình", "Nam");
        NhanVien xe2 = new NhanVien("Nhân viên chính thức", 5000000, "Đêm", 100000, "2", "Đỗ Duy Đạt", "098184543",
                "Thái Bình", "Nam");
        NhanVien xe3 = new NhanVien("Nhân viên thời vụ", 1000000, "Sáng", 500000, "3", "Nguyen Van A", "09818472243",
                "Thái Bình", "Nam");
        danhSachNhanVien.add(xe1);
        danhSachNhanVien.add(xe2);
        danhSachNhanVien.add(xe3);
    }
}
