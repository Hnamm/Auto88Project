/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;
import java.util.ArrayList;
import Entities.HoaDon;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.nio.file.Files.list;
import java.util.Calendar;
import static java.util.Collections.list;
import java.util.Date;
/**
 *
 * @author admin
 */
public class HoaDonModel {
     private ArrayList<HoaDon> dshd;

    public HoaDonModel() {
        dshd=new ArrayList<>();
    }

    public ArrayList<HoaDon> getDshd() {
        return dshd;
    }

    public void setDshd(ArrayList<HoaDon> dshd) {
        this.dshd = dshd;
    }
     public int add(HoaDon hd){
         dshd.add(hd);
         return 1;
     }
     public HoaDon find(String mahd){
         for (HoaDon hoaDon : dshd) {
             if(hoaDon.getMaHoaDon().equals(mahd)){
                 return hoaDon;
             }
         }
         return null;
     }
     public int update(HoaDon hd){
        HoaDon oldHoaDon = find(hd.getMaHoaDon());
        if (oldHoaDon != null) {
            dshd.remove(oldHoaDon);
            dshd.add(hd);
         
        }
        return 1;
     }
     public int remove(String mahd){
         HoaDon hd =find(mahd);
         if( hd !=null){
             dshd.remove(hd);
         }
         return 1;
     }
     
     public void fakeData() {
        dshd.add(new HoaDon("HD001", createDate(2023, 1, 1), "KH001", "XE001", 1, 20000, "NV001", "offline"));
        dshd.add(new HoaDon("HD002", createDate(2023, 2, 15), "KH002", "XE002", 2, 30000, "NV002", "offline"));
        dshd.add(new HoaDon("HD003", createDate(2023, 3, 20), "KH003", "XE003", 1, 25000, "NV003", "offline"));
        dshd.add(new HoaDon("HD004", createDate(2023, 4, 25), "KH004", "XE004", 3, 35000, "NV004", "offline"));
    }

    private Date createDate(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day); // Tháng trong Calendar bắt đầu từ 0
        return cal.getTime();
    }
    public ArrayList<HoaDon> docfile(String filename) {
        ArrayList<HoaDon> list = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            list = (ArrayList<HoaDon>) ois.readObject();
        } catch (FileNotFoundException ex) {
            System.err.println("File không tìm thấy: " + ex.getMessage());
            ex.printStackTrace();
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println("Lỗi khi đọc file: " + ex.getMessage());
            ex.printStackTrace();
        }
        return list;
    }
    public void LuuFile(String fileName, ArrayList<HoaDon> list) {
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream objOutputStream = new ObjectOutputStream(fos)) {
            objOutputStream.writeObject(list);
            objOutputStream.flush();
            System.out.println("Lưu file thành công");
        } catch (FileNotFoundException ex) {
            System.err.println("File không tìm thấy: " + ex.getMessage());
            ex.printStackTrace();
        } catch (IOException ex) {
            System.err.println("Lỗi khi ghi file: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
