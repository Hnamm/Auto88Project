/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Entities.Xe;
import java.util.ArrayList;
/**
 *
 * @author admin
 */
public class XeModel{
    private ArrayList<Xe> danhSachXe;

    public XeModel(ArrayList<Xe> danhSachXe) {
        this.danhSachXe = danhSachXe;
    }

    public XeModel() {
        this.danhSachXe = new ArrayList<>();
    }

    public ArrayList<Xe> getDanhSachXe() {
        return danhSachXe;
    }

    public void setDanhSachXe(ArrayList<Xe> danhSachXe) {
        this.danhSachXe = danhSachXe;
    }
    
    public int soLuongXe(){
        return danhSachXe.size();
    }
    
    public void themXe(Xe newXe){
        danhSachXe.add(newXe);
    }
    
    public void fakeData(){
        Xe xe1 = new Xe("Xe01", "VF5", "Vinfast", "Đỏ", "1-1-2020", "Xe điện", 400000000, 6);
        Xe xe2 = new Xe("Xe02", "VF6", "Vinfast", "Xanh", "1-1-2020", "Xe điện", 400000000, 6);
        Xe xe3 = new Xe("Xe03", "VF7", "Vinfast", "Tím", "1-1-2020", "Xe điện", 400000000, 6);
        danhSachXe.add(xe1);
        danhSachXe.add(xe2);
        danhSachXe.add(xe3);
    }  
}
