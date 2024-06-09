/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 *
 * @author intern
 */
public enum LoaiKhachHang {
    VIP("vip"),
    THAN_THIET("Thân thiết"),
    CONG_TY("Công ty"),
    CA_NHAN("Cá nhân"),;
    
    private final String displayName;

    public String getDisplayName() {
        return displayName;
    }

    private LoaiKhachHang(String displayName) {
        this.displayName = displayName;
    }
    
    public static LoaiKhachHang fromDisplayName(String displayName) {
        for (LoaiKhachHang loai : LoaiKhachHang.values()) {
            if (loai.getDisplayName().equals(displayName)) {
                return loai;
            }
        }
        throw new IllegalArgumentException("Không tìm thấy loại khách hàng với tên hiển thị: " + displayName);
    }
}
