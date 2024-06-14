/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Entities.TaiKhoan;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;

/**
 *
 * @author admin
 */
public class TaiKhoanModel implements Serializable{
    public static String filePath = "src/main/java/files/TaiKhoan.txt";
    private HashSet<TaiKhoan> taiKhoanSet;

    public TaiKhoanModel() {
        taiKhoanSet = new HashSet<>();
    }

    public TaiKhoanModel(HashSet<TaiKhoan> taiKhoanSet) {
        this.taiKhoanSet = taiKhoanSet;
    }

    public HashSet<TaiKhoan> getTaiKhoanSet() {
        return taiKhoanSet;
    }

    public void setTaiKhoanSet(HashSet<TaiKhoan> taiKhoanSet) {
        this.taiKhoanSet = taiKhoanSet;
    }
    public void addTaiKhoan(TaiKhoan taiKhoanMoi) {
        taiKhoanSet.add(taiKhoanMoi);
    }
    public static void writeToFile(HashSet<TaiKhoan> taiKhoanSet) throws FileNotFoundException, 
            IOException {
        FileOutputStream fos = new FileOutputStream(filePath); 
        ObjectOutputStream objOutputStream = new ObjectOutputStream(fos);   
        objOutputStream.writeObject(taiKhoanSet);
        objOutputStream.flush();  
    }
    
    public static HashSet<TaiKhoan> readFromFile () throws FileNotFoundException, IOException, 
            ClassNotFoundException, EOFException {
        HashSet<TaiKhoan> data = new HashSet<>();
        FileInputStream fis = new FileInputStream(filePath);
        try {
            ObjectInputStream objInputStream = new ObjectInputStream(fis);
            data = (HashSet<TaiKhoan>) objInputStream.readObject();
        } catch (Exception e) {
            e.getMessage();
        }
        return data;
    }
    
}
