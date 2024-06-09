/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Entities.KhachHang;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author admin
 */
public class KhachHangModel {

    private static KhachHangModel instance;
    private Set<KhachHang> khachHangs;

    private KhachHangModel() {
        khachHangs = new LinkedHashSet<KhachHang>();
        Set<KhachHang> loadedKhachHangs = (Set<KhachHang>) KhachHangModel.readDateFromFile("src/main/java/files/KhachHang.txt");

        if (loadedKhachHangs != null) {
            khachHangs.addAll(loadedKhachHangs);
        }
    }

    public static synchronized KhachHangModel getInstance() {
        if (instance == null) {
            instance = new KhachHangModel();
        }
        return instance;
    }


    public Set<KhachHang> getKhachHangs() {
        return khachHangs;
    }

    public boolean isCustomerExist(KhachHang customer) {
        return khachHangs.stream().anyMatch(c -> c.getMaKhachHang().equals(customer.getMaKhachHang()));
    }

    public void addCustomer(KhachHang newCustomer) {
        khachHangs.add(newCustomer);
    }


    public KhachHang getCustomerById(String id) {
        return khachHangs.stream()
                .filter(c -> c.getMaKhachHang().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void removeCustomerByIndex(String customerId) {
        khachHangs.removeIf(c -> c.getMaKhachHang().equals(customerId));
    }


    public void updateCustomer(KhachHang updatedCustomer) {
        Optional<KhachHang> customerOtp = khachHangs.stream().filter(c -> c.getMaKhachHang().equals(updatedCustomer.getMaKhachHang())).findFirst();
        customerOtp.ifPresent(customer -> {
            customer.setTenKhachHang(updatedCustomer.getTenKhachHang());
            customer.setSoDienThoai(updatedCustomer.getSoDienThoai());
            customer.setGioiTinh(updatedCustomer.isGioiTinh());
            customer.setDiaChi(updatedCustomer.getDiaChi());
            customer.setLoaiKhachHang(updatedCustomer.getLoaiKhachHang());
        });
    }


    public Set<KhachHang> searchCustomers(String keyword) {
        return (Set<KhachHang>) khachHangs.stream()
                .filter(c -> c.getTenKhachHang().toLowerCase().contains(keyword.toLowerCase())
                || c.getDiaChi().toLowerCase().contains(keyword.toLowerCase())
                || c.getSoDienThoai().contains(keyword)
                || c.getMaKhachHang().contains(keyword)).collect(Collectors.toSet());
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        String regex = "0\\d{9}";
        return phoneNumber.matches(regex);
    }
    
    public static void writeDataToFile(Set<KhachHang> data, String fileName) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Set<KhachHang> readDateFromFile(String fileName) {
        Set<KhachHang> res = null;
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            res = (Set<KhachHang>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
