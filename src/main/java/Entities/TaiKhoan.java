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
public class TaiKhoan implements Serializable{
    private static int taoId = 0;
    private int id = 0;
    private String username;
    private String password;

    public TaiKhoan() {
    }

    public TaiKhoan(String username, String password) {
        this.id += taoId;
        this.username = username;
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.username);
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
        final TaiKhoan other = (TaiKhoan) obj;
        return Objects.equals(this.username, other.username);
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
