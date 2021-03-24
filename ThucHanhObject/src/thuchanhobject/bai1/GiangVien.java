/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thuchanhobject.bai1;

import constance.Constance;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class GiangVien extends Person implements TinhLuongNhanVien{

   private String magv;
   private float hsl;

    public String getMagv() {
        return magv;
    }

    public void setMagv(String magv) {
        this.magv = magv;
    }

    public float getHsl() {
        return hsl;
    }

    public void setHsl(float hsl) {
        this.hsl = hsl;
    }

    public GiangVien(String name, boolean gt, String quequan) {
        super(name, gt, quequan);
    }

    public GiangVien(String magv,  String name, boolean gt, String quequan,float hsl) {
        super(name, gt, quequan);
        this.magv = magv;
        this.hsl = hsl;
    }
     //Tìm nhan viên x trong danh sách nhan vien
    public static int timNhanVienX(ArrayList<GiangVien> list,String x){
        int vt=-1;
        for(int i=0;i<list.size();i++){
            if((list.get(i).getMagv().equalsIgnoreCase(x)==true) ||(list.get(i).getName().equalsIgnoreCase(x)==true)){
                vt=i;
                break;
            }
        }
        return vt;
    }
    @Override
    public float tinhLuong() {
        return hsl*Constance.MUCLUONG+Constance.PCCVGV+Constance.PCKHAC;
    }

    @Override
    public String toString() {
        return ""+magv+";"+hsl+";"+tinhLuong()+";GV";
    }
    
}
