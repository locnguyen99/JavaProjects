/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thuchanhobject.bai1;

import constance.Constance;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class NhanVien extends Object implements TinhLuongNhanVien{
    private float hsl;

    public float getHsl() {
        return hsl;
    }

    public void setHsl(float hsl) {
        this.hsl = hsl;
    }
    private String name;
    private String manv;
    private boolean gt;
    private String quequan;
    //1. taọ 1 constructor không tham số
    public NhanVien(){
        this.manv="";
        this.name="";
        this.gt=true;
        this.quequan="";
    }

    public NhanVien( String manv, String name,boolean gt, String quequan,float hsl) {
        this.hsl = hsl;
        this.name = name;
        this.manv = manv;
        this.gt = gt;
        this.quequan = quequan;
    }

    public NhanVien(String manv,String name, boolean gt, String quequan) {
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
    //3 Xuất thông tin đối tượng nhân viên
    public void xuatTT(){
        String gt=""; //Cục bộ trong hàm
        if(isGt()){
            gt="Nam";
        }else
        {
            gt="Nữ";
        }
        System.out.println(""+getManv()+"---"+getName()+"----"+getQuequan()+"--"+gt);
    }
    //Viet theo ham
    public String xuatTTHam(){
        String gt=""; //Cục bộ trong hàm
        if(isGt()){
            gt="Nam";
        }else
        {
            gt="Nữ";
        }
       return getManv()+"---"+getName()+"----"+getQuequan()+"--"+gt;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "name=" + name + ", manv=" + manv + ", gt=" + gt + ", quequan=" + quequan + '}';
    }
    //Viết ham nhap tu ban phim tao 1 nhan vien
    public static NhanVien nhapNhanVien(){
        Scanner re=new Scanner(System.in);
        NhanVien nv=new NhanVien();
        System.out.print("Nhap ma");
        nv.manv=re.next();
        System.out.print("Nhap ten");
        nv.name=re.next();
        System.out.print("Nhap gioi tinh");
        nv.gt=re.nextBoolean();
        System.out.print("Nhap Que quan");
        nv.quequan=re.next();
        
        
        return nv;
    }
     public static NhanVien nhapNhanVienInput(){
        Scanner re=new Scanner(System.in);
        NhanVien nv=new NhanVien();
        nv.manv=JOptionPane.showInputDialog("Nhap ma");
       
        nv.name= JOptionPane.showInputDialog("Nhập tên");
        
        String sex=JOptionPane.showInputDialog("Nhap giới tính");
        if(sex.equalsIgnoreCase("nam")==true){
            nv.setGt(true);
        }
        else{
            nv.setGt(false);
        }
         nv.quequan=JOptionPane.showInputDialog("Nhập quê quán");
      
        return nv;
    }
    public static void nhaparrayNhanVien(ArrayList<NhanVien> list){
        
        String strn=JOptionPane.showInputDialog("Nhập số nhân viên");
        try{
        int n=Integer.parseInt(strn);
        for(int i=1;i<=n;i++ ){
            list.add(nhapNhanVienInput());
        }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Phải là số nguyên");
        }
    } 
    public static void xuatDSNhanVien(ArrayList<NhanVien> list){
        for(int i=0;i<list.size();i++){
            System.out.println("Nhan vien thu "+(i+1));
            list.get(i).xuatTT();
            
        }
        
    }
    //Tìm nhan viên x trong danh sách nhan vien
    public static int timNhanVienX(ArrayList<NhanVien> list,String x){
        int vt=-1;
        for(int i=0;i<list.size();i++){
            if((list.get(i).getManv().equalsIgnoreCase(x)==true) ||(list.get(i).getName().equalsIgnoreCase(x)==true)){
                vt=i;
                break;
            }
        }
        return vt;
    }

    @Override
    public float tinhLuong() {
        //code vao
        return hsl*Constance.MUCLUONG+Constance.PCCVNV+Constance.PCKHAC;
   }
    
}
