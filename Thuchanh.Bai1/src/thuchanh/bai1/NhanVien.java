/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thuchanh.bai1;

/**
 *
 * @author Minh
 */
public class NhanVien {
    private String name;
    private String manv;
    private boolean gt;
    private String quequan;

    public NhanVien() {
    }

    public NhanVien(String name, String manv, boolean gt, String quequan) {
        this.name = name;
        this.manv = manv;
        this.gt = gt;
        this.quequan = quequan;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public boolean isGt() {
        return gt;
    }

    public void setGt(boolean gt) {
        this.gt = gt;
    }

    public String getQuequan() {
        return quequan;
    }

    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }
    
}