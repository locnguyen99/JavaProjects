/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package k59.tlus.core;

/**
 *
 * @author LN
 */
public class Bai1 {

    //tính tổng từ 1 đến n
    //input n là số nguyên 
    //1 thủ tục
    public void tongn(int n) {
        int s = 0;
        for (int i = 1; i <= n; i++) {
            s = s + i;
        }
        System.out.println("s(" + n + ")=" + s);
    }

    public int tong(int n) {
        int s = 0;
        for (int i = 1; i <= n; i++) {
            s = s + i;
        }
        return s;
    }

    //Cải tiến 
    public String tongnupdate(int n) {
        int s = 0;
        for (int i = 1; i <= n; i++) {
            s = s + i;
        }
        return "s(" + n + ")=" + s;
    }

    //Có cách nào viết 1 hàm hoặc thủ tục để bên ngoài class gọi trực tiếp nó  ? 
    //ví dụ: n=8, i=1,2,3,4,5,6,7,8 
    //
    public static String chandautien(int n) {

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                return "Số chẵn đầu tiên: " + i;
            }
        }
        return "Không có số chẵn";
    }

    public static String chandautienfor(int n) {
        int s = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                s = i;
                break;
            }
        }
        return "tong=" + s;
    }
    //1.Tính tổng các phần tử mà lớn hơn 5 và nhỏ hơn 10 với số nguyên n đã cho
    //Gửi qua zalo
}
