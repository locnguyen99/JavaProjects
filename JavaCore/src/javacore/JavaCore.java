/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacore;

import javax.swing.JOptionPane;
import k59.tlus.core.Bai1;
import k59.tlus.core.Bai2;

/**
 *
 * @author LN
 */
public class JavaCore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Gọi ra nhưng class 
        /*   Bai1 b1=new Bai1();
        b1.tongn(3);
        int k=b1.tong(3);
        System.out.println(k);
        System.out.println(b1.tongnupdate(3));
     
        //Gọi hàm có static thì gọi theo cú pháp tenlop.tenham
        System.out.println(Bai1.chandautien(3));
        System.out.println(Bai1.chandautienfor(3));
         */
        System.out.println(Bai2.tong(3, 10));
        System.out.println(Bai2.tong(3.3, 10.2));
        System.out.println(Bai2.tong(3.3, 10.2, 3));
        JOptionPane.showMessageDialog(null, "Hello");
    }

}
