/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatest;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author LN
 */
public class Adress {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress ip = InetAddress.getLocalHost();
        System.out.println("Host Name: " + ip.getHostName());
        System.out.println("IP Address: " + ip.getHostAddress());
        ip = InetAddress.getByName("www.infortlus.com");
        System.out.println("\nHost Name: " + ip.getHostName());
        System.out.println("IP Address: " + ip.getHostAddress());
        System.out.println("\nAll address of infortlus: ");
        InetAddress sw[] = InetAddress.getAllByName("www.google.com");
        for (int i = 0; i < sw.length; i++) {
            System.out.println(sw[i]);

        }
    }

}
