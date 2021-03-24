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
public class CanBo extends Person implements TinhLuongNhanVien{
    private String macb;
    private float hsl;

    public String getMacb() {
        return macb;
    }

    public void setMacb(String macb) {
        this.macb = macb;
    }

    public float getHsl() {
        return hsl;
    }

    public void setHsl(float hsl) {
        this.hsl = hsl;
    }
    public CanBo(String name, boolean gt, String quequan) {
        super(name, gt, quequan);
    }

    public CanBo(String macb, String name, boolean gt, String quequan, float hsl) {
        super(name, gt, quequan);
        this.macb = macb;
        this.hsl = hsl;
    }
public static int timNhanVienX(ArrayList<CanBo> list,String x){
        int vt=-1;
        for(int i=0;i<list.size();i++){
            if((list.get(i).getMacb().equalsIgnoreCase(x)==true) ||(list.get(i).getName().equalsIgnoreCase(x)==true)){
                vt=i;
                break;
            }
        }
        return vt;
    }
    @Override
    public float tinhLuong() {
        return hsl*Constance.MUCLUONG+Constance.PCCVCB+Constance.PCKHAC;
   }
    @Override
    public String toString() {
        return ""+macb+";"+hsl+";"+tinhLuong()+";CB";
    }
}
