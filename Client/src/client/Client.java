/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author LN
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public final static int SERVER_PORT = 7000;
    public final static String SERVER_IP = "192.168.43.48";

    public static void main(String[] args) throws IOException, InterruptedException {
        // TODO code application logic here
        Socket socket = null;
        try {
            socket = new Socket(SERVER_IP, SERVER_PORT); // Connect to server
            System.out.println("Connected: " + socket);

            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            for (char i = 'a'; i <= 'z'; i++) {
                os.write(i); // Send each number to the server
                int ch = is.read(); // Waiting for results from server
                System.out.print((char) ch + " "); // Display the results received from the server
                Thread.sleep(200);
            }
        } catch (IOException ie) {
            System.out.println("Can't connect to server");
        } finally {
            if (socket != null) {
                socket.close();
            }
        }

    }

}
