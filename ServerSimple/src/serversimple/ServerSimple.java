/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serversimple;

//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.net.ServerSocket;
//import java.net.Socket;

// KT
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author PM
 */
public class ServerSimple {

//    private static int SERVER_PORT = 7000;
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) throws IOException {
//        ServerSocket serverSocket = null;
//        try {
//            System.out.println("Binding to port " + SERVER_PORT + ", please wait  ...");
//            serverSocket = new ServerSocket(SERVER_PORT);
//            System.out.println("Server started: " + serverSocket);
//            System.out.println("Waiting for a client ...");
//            while (true) {
//                try {
//                    Socket socket = serverSocket.accept();
//                    System.out.println("Client accepted: " + socket);
//
//                    OutputStream os = socket.getOutputStream();
//                    InputStream is = socket.getInputStream();
//                    int ch = 0;
//                    while (true) {
//                        ch = is.read(); // Receive data from client
//                        if (ch == -1) {
//                            break;
//                        }
//                        os.write(ch); // Send the results to client
//                    }
//                    socket.close();
//                } catch (IOException e) {
//                    System.err.println(" Connection Error: " + e);
//                }
//            }
//        } catch (IOException e1) {
//            e1.printStackTrace();
//        } finally {
//            if (serverSocket != null) {
//                serverSocket.close();
//            }
//        }
//
//    }
    // kiem tra ngay 31/3
    public final static int SERVER_PORT = 6000;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        ServerSocket serverSocket = null;
        try {
            System.out.println("Binding to port " + SERVER_PORT + ", please wait  ...");
            serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server started: " + serverSocket);
            System.out.println("Waiting for a client ...");
            String msg;
            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    System.out.println("Client accepted: " + socket);
                    BufferedReader brc = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    msg = brc.readLine();
                    //code o day 
                    //Tách từ như sau
                    socket.close();
                } catch (IOException e) {
                    System.err.println(" Connection Error: " + e);
                }
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }

}
