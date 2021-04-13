/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketserverchangemessage;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class SocketServerChangeMessage {

    public static Connection con;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // TODO code application logic here
        con = ConnectionUtils.getSQLServerConnection();
        if (con!=null)
            System.out.println("Succesfully");
        MainServerChangeMessage m=new MainServerChangeMessage();
        m.setVisible(true);
    }
    
}
