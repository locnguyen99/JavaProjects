package readkeyboard;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author LN
 */
public class ReadKeyBoard {

    public static void readKeyBoard() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Nhap vao 1 so");
        int num = reader.nextInt();
        if (num % 2 == 0) {
            System.out.println("" + num + " là số chẵn");
        } else {
            System.out.println("" + num + " là số lẻ");
        }
    }

    //1.Gợi ý: tiền xử lý input (về nhà làm)
    //Update ràng buộc lỗi nhập
    public static void readKeyBoardUpdate() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Nhap vao 1 so");
        try {
            int num = reader.nextInt();
            if (num % 2 == 0) {
                System.out.println("" + num + " là số chẵn");
            } else {
                System.out.println("" + num + " là số lẻ");
            }
        } catch (Exception e) {
            System.out.println("Đầu vào không hợp lệ");
        }
    }
    //Nhập vào 1 ký tự hỏi ký tự là ký tự nguyên âm hay phụ âm hoặc không phải
    //Các ký tự a,e,i,o,u la nguyên âm
    //Còn các ký tự còn lại la phụ âm.

    public static void readK() {
        boolean check = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào 1 ký tự: ");

        String ch = sc.nextLine();
        if (ch.length() != 1) {
            System.out.println("Nhiều hơn 1 ký tự");
        } else {
            char c = ch.charAt(0);
            switch (c) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                case 'A':
                case 'E':
                case 'I':
                case 'O':
                case 'U':
                    check = true;
            }
            if (check == true) {
                System.out.println(c + " Là nguyên âm");
            } else {
                if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                    System.out.println(c + " Là phụ âm");
                } else {
                    System.out.println("Không nằm trong bảng chữ cái!");
                }
            }
        }
    }

    //Về nhà làm:
    //Nhập vào kí tự chữ hoa hoặc chữ thường nếu là nguyên âm thì xuất ra là nguyên âm, phụ âm, hoặc là số
    public static void readKVeNha() {
        boolean check = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào 1 ký tự: ");

        String ch = sc.nextLine();
        if (ch.length() != 1) {
            System.out.println("Nhiều hơn 1 ký tự");
        } else {
            char c = ch.charAt(0);
            switch (c) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                case 'A':

                    check = true;
            }
            if (check == true) {
                System.out.println(c + " Là nguyên âm");
            } else {
                if ((c >= 97 && c <= 122) || (c >= 65 && c <= 90)) {
                    System.out.println(c + " Là phụ âm");
                } else {
                    System.out.println("Không nằm trong bảng chữ cái!");
                }
            }
        }
    }
    //yêu cầu nhập vào chuỗi chuyển toàn bộ chuỗi thành chữ hoa
    //str="a12A"-> A12A
    //str="abc"->ABC

    public static String ChangeUpperCase() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào chuỗi ký tự: ");
        String chr = sc.nextLine();//abc -> a =0, 
        char[] sa = chr.toCharArray();
        String s = "";
        for (int i = 0; i < sa.length; i++) {
            if (sa[i] >= 'a' && sa[i] <= 'z') {
                char a = (char) (sa[i] - 32);
                s = s + a;
            } else {
                char b = (char) (sa[i]);
                s = s + b;
            }
        }
        return s;
    }

    public static void Convert() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào 1 Chuỗi: ");
        String chf = "";
        String ch = sc.nextLine();
        for (int i = 0; i < ch.length(); i++) {
            if (ch.charAt(i) >= 'a' && ch.charAt(i) < 'z') {
                char c = (char) (ch.charAt(i) - 32);
                chf = chf + c;
            } else {
                chf = chf + ch.charAt(i);
            }
        }
        System.out.println("Chuỗi hoa: " + chf);
    }
    //Nhập vào 1 chuỗi kiểm tra chuỗi có phải là số điện thoại không? (biết rắng số đt là 10 hoặc 11)
}
