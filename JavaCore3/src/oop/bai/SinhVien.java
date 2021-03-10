/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.bai;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author LN
 */
public class SinhVien extends Object {

    //private che giấu dữ liệu
    private String masv;
    private String hosv;
    private String tensv;
    private boolean gt;
    //Hàm dựng(Constructor)
    //Đinh nghia tên của constructor thì giống tên lớp, không có kiểu trả về,phải là public

    //Hàm dựng mặc định
    public SinhVien() {
        this.masv = "";
        this.hosv = "";
        this.tensv = "";
        this.gt = true;
    }
    //Hàm dựng có tham số

    public SinhVien(String masv, String hosv, String tensv) {
        this.masv = masv;
        this.hosv = hosv;
        this.tensv = tensv;
    }

    public SinhVien(String masv, String hosv, String tensv, boolean gt) {
        this.masv = masv;
        this.hosv = hosv;
        this.tensv = tensv;
        this.gt = gt;
    }

    public String getMasv() {
        return masv;
    }

    //method/function
    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getHosv() {
        return hosv;
    }

    public void setHosv(String hosv) {
        this.hosv = hosv;
    }

    public String getTensv() {
        return tensv;
    }

    public void setTensv(String tensv) {
        this.tensv = tensv;
    }

    public boolean isGt() {
        return gt;
    }

    public void setGt(boolean gt) {
        this.gt = gt;
    }

    @Override
    public String toString() {
        String gt = "Nữ";
        if (this.isGt() == true) {
            gt = "Nam";
        }
        //return "SinhVien{" + "masv=" + masv + ", hosv=" + hosv + ", tensv=" + tensv + ", gt=" + gt + '}';
        return this.getMasv() + "-" + this.getHosv() + " " + this.getTensv() + "-" + gt;
    }
    //Method

    public void XuatTT() {
        String gt = "Nữ";
        if (this.isGt() == true) {
            gt = "Nam";
        }
        //return "SinhVien{" + "masv=" + masv + ", hosv=" + hosv + ", tensv=" + tensv + ", gt=" + gt + '}';
        System.out.println(this.getMasv() + "-" + this.getHosv() + " " + this.getTensv() + "-" + gt);
    }

    public String XuatSV() {
        String gt = "Nữ";
        if (this.isGt() == true) {
            gt = "Nam";
        }
        //return "SinhVien{" + "masv=" + masv + ", hosv=" + hosv + ", tensv=" + tensv + ", gt=" + gt + '}';
        return this.getMasv() + "-" + this.getHosv() + " " + this.getTensv() + "-" + gt;
    }

    //Viết  hàm nhập thông tinh cho đối tượng sinh viên và trả về 1 đối tượng nhập từ bàn phím
    //Phụng
    public static void nhap(SinhVien sv) {
        System.out.println("Nhập vào họ:");
        Scanner sc = new Scanner(System.in);
        sv.setHosv(sc.nextLine());
        System.out.println("Nhập vào tên:");
        sv.setTensv(sc.nextLine());
        System.out.println("Nhập vào mssv:");
        sv.setMasv(sc.nextLine());
        System.out.println("Nhập vào GT:(1 hoac 0)");
        int gt = sc.nextInt();
        if (gt == 1) {
            sv.setGt(Boolean.TRUE);
        } else {
            sv.setGt(Boolean.FALSE);
        }
        //  System.out.println(sv);
    }
//Hồng quân

    public SinhVien NhapSV() {
        Scanner sc = new Scanner(System.in);
        SinhVien sv = new SinhVien();
        System.out.println("Nhap mssv");
        setMasv(sv.masv = sc.nextLine());
        System.out.println("Nhap ho ");
        setHosv(sv.hosv = sc.nextLine());
        System.out.println("Nhap ten ");
        setTensv(sv.tensv = sc.nextLine());
        System.out.println("Nhap gt ");
        int gt = sc.nextInt();
        if (gt == 1) {
            sv.setGt(Boolean.TRUE);
        } else {
            sv.setGt(Boolean.FALSE);
        }
        return sv;
    }
    ///viết 1 hàm nhập n đối tượng sinh viên

    public static void nhapMangSv(ArrayList<SinhVien> listSv, int n) {

        for (int i = 0; i < n; i++) {
            listSv.add(new SinhVien());
            System.out.println("Nhập sinh viên " + (i + 1) + ":");
            nhap(listSv.get(i));
        }
    }

    public void nhaplistTT(SinhVien[] sv, int n) {
        for (int i = 0; i < n; i++) {
            sv[i] = this.NhapSV();
        }
    }
//Ghi chú bài tập về nhà làm

    public static SinhVien[] nhapMangSvUpdate(SinhVien[] listSv, int n) {
        //Code ?
        return null;
    }
}
