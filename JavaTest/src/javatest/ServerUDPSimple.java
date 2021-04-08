/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatest;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author LN
 */
public class ServerUDPSimple {

    public final static int SERVER_PORT = 2222; // Cổng mặc định của Echo Server
    public final static byte[] BUFFER = new byte[8192]; // Vùng đệm chứa dữ liệu cho gói tin nhận

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DatagramSocket ds = null;
        try {
            System.out.println("Binding to port " + SERVER_PORT + ", please wait  ...");
            ds = new DatagramSocket(SERVER_PORT); // Tạo Socket với cổng là 7
            System.out.println("Server started ");
            System.out.println("Waiting for messages from Client ... ");

            String msggui = "";
            while (true) { // Tạo gói tin nhận
                DatagramPacket incoming = new DatagramPacket(BUFFER, BUFFER.length);
                ds.receive(incoming); // Chờ nhận gói tin gởi đến

                // Lấy dữ liệu khỏi gói tin nhận
                String message = new String(incoming.getData(), 0, incoming.getLength(), StandardCharsets.UTF_8);
                System.out.println("Received: " + message);

                // Tạo gói tin gởi chứa dữ liệu vừa nhận được
                System.out.println("Received newm: " + message.toUpperCase());
                String ms[] = message.trim().split(" ");
                String newmsg = "";
                for (int i = ms.length - 1; i >= 0; i--) {
                    newmsg = newmsg + " " + ms[i];
                }
                String messagew = new String(newmsg.getBytes(), 0, newmsg.length(), StandardCharsets.UTF_8);
                DatagramPacket outsending = new DatagramPacket(messagew.getBytes(), messagew.length(),
                        incoming.getAddress(), incoming.getPort());
                ds.send(outsending);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ds != null) {
                ds.close();
            }
        }
    }

}
