/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thuchanhobject.bai1;

import gui.baitap1.FormNhanVien;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class ThucHanhObject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //1. Gọi hàm khởi tạo mặc định
        NhanVien nv1=new NhanVien();
        nv1.xuatTT();//Gọi thủ tục
        System.out.println(""+nv1.xuatTTHam());//Gọi hàm
        
        
        //Để thiết giá trị cho đối tượng nv1 có 1 cách sử dụng
        nv1.setManv("001");
        nv1.setName("Phụng");
        nv1.setQuequan("Bình thuận");
        nv1.setGt(true);
        nv1.xuatTT();//Gọi thủ tục
        System.out.println(""+nv1.xuatTTHam());//Gọi hàm
        
        //Để sử dụng xuất thông tin trực tiếp ta có thể sử dụng hàm nạp chồng toString() trong class NhanVien
        //Tạo ra nhân viên thứ 2, sử dụng constructor 
        NhanVien nv2=new NhanVien("002","Tran Thanh Nhan",false,"Campuchia");
        System.out.println(nv2); //Sẽ xuất thông tin là địa chỉ của đối tượng 
        //Do đó cách giải quyết viết hàm toString()
        //Gọi hàm nhapNhanVien sử dụng phương thức tình static
        //NhanVien.nhapNhanVien().xuatTT();
      //  NhanVien.nhapNhanVienInput().xuatTT();
   //   ArrayList<NhanVien> listnv=new ArrayList<>();
  //    NhanVien.nhaparrayNhanVien(listnv);
   //   NhanVien.xuatDSNhanVien(listnv);
         FormNhanVien fnv=new FormNhanVien();
         fnv.setVisible(true);
    }
    
}
