/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketjavachangeclient;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class SocketJavaChangeClient {

    public static Connection con;
    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws InterruptedException, IOException, SQLException, ClassNotFoundException {
        // TODO code application logic here
        //ClientContent co=new ClientContent();
        con = ConnectionUtils.getSQLServerConnection();
        if (con!=null)
            System.out.println("Successfully");
        LoginForm lf = new LoginForm();
        lf.setVisible(true);
        //co.setVisible(true);
    }   
}