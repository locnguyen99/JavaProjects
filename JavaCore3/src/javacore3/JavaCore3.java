/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacore3;

import java.util.ArrayList;
import oop.bai.SinhVien;

/**
 *
 * @author LN
 */
public class JavaCore3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*
        SinhVien sv=new SinhVien();
        //Thiết lập 1 dối tượng cho sinh viên
        sv.setMasv("180001");
        sv.setHosv("Tiếp sĩ");
        sv.setTensv("Minh Phụng");
        sv.setGt(true);
        String gt="Nữ";
        if(sv.isGt()==true){
            gt="Nam";
        }
        String data=sv.getMasv()+"-"+sv.getHosv()+" "+sv.getTensv()+"-"+gt;
        System.out.println(data);
        //cải tiến class SinhVien
        System.out.println(sv);
        //Gọi structor mặc định 
        SinhVien sv1=new SinhVien();
        System.out.println(sv1);
        //Gọi hàm dựng có 3 tham số
        SinhVien sv2=new SinhVien("00002","Nguyễn","Duy Cảnh");
        System.out.println(sv2);
        //Gọi hàm dựng có 3 tham số
        SinhVien sv3=new SinhVien("00003","Trần","Duy Cảnh",true);
        System.out.println(sv3);//Gọi hàm toString
        System.out.println(sv3.XuatSV());
        sv3.XuatTT();
         */
        //Phung
        /*  
        SinhVien svtest=new SinhVien();
        SinhVien.nhap(svtest);
        System.out.println(svtest);
         */
        ///
        /*
        SinhVien svquan = new SinhVien();
        
        svquan.NhapSV();
        System.out.print(svquan);
         */
        //Son
        /*
     SinhVien svn=new SinhVien();
     int n=3;
     SinhVien lis[]=new SinhVien[n];
     svn.nhaplistTT(lis, n);
     for(int i=0;i<n;i++){
         lis[i].XuatTT();
     }*/
        //Gọi minh
        ArrayList<SinhVien> listSv = new ArrayList<>();
        SinhVien.nhapMangSv(listSv, 2);
        for (int i = 0; i < 2; i++) {
            listSv.get(i).XuatTT();
        }
        for (SinhVien sv : listSv) {
            sv.XuatTT();
        }

    }
    // viet ham nhap n doi tuong goi duoc n sinh vien luon
}
