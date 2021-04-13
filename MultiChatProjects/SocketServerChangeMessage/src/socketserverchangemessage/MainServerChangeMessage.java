/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketserverchangemessage;

import constances.PortConstance;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static socketserverchangemessage.SocketServerChangeMessage.con;

/**
 *
 * @author Admin
 */
public class MainServerChangeMessage extends javax.swing.JFrame {
     private ServerSocket s;
     private String msg="";
     private String str="";
     private String strdata="";
     private Socket c;
     private BufferedReader brc;
     private PrintWriter out;
     private String name;
     private ArrayList<Socket> slist;
     private ArrayList<String> nlist;
     private ArrayList<String> onlist;
     Statement st;
     ResultSet rs;
     CallableStatement cs;
    public void loadList()
  {
      while(namelist.getRowCount()>0)
      {
          ((DefaultTableModel)namelist.getModel()).removeRow(0);
      }
      int row=0;
      for(int x=0;x<nlist.size();x++)
      {
          if(!nlist.get(x).equals(""))
          {
              ((DefaultTableModel)namelist.getModel()).addRow(new Object[]{});
              ((DefaultTableModel)namelist.getModel()).setValueAt(nlist.get(x), row, 0);
               row++;
          }
      }
  }
    public final void reloadUsers() throws SQLException{
        DefaultTableModel dm = (DefaultTableModel) namelist1.getModel();
        int rowCount = dm.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            dm.removeRow(i);
}   
        onlist = new ArrayList<>();
        st = con.createStatement();
        rs = st.executeQuery("select * from users");
        while(rs.next()){
            onlist.add(rs.getString(1));
            ((DefaultTableModel)namelist1.getModel()).addRow(new Object[]{rs.getString(1)});
       }
      }
    class HandleClient extends Thread
    {
        private int tid;

    public void SendToAllClients(String message)
    {
        Socket so;
        PrintWriter out;
        for(int x=0;x<slist.size();x++)
        {
            try{
                so=slist.get(x);
                out=new PrintWriter(so.getOutputStream(),true);
                out.println(message);
            }catch(IOException e){}
        }
    }
    class ProcessClient extends Thread
    {
        private int id;
        private String name;
        private Socket c;
        private BufferedReader brc;
        public ProcessClient(int id,String name,Socket c)
        {
            this.id=id;
            this.name=name;
            this.c=c;
        }
        public void run()
        {
            String msg;
            try{
            brc=new BufferedReader(new InputStreamReader(c.getInputStream()));
            reloadUsers();
           loadList();
           if (name!=null)
                SendToAllClients(name+" joined Chat");
            while((msg=brc.readLine())!=null)
            {
                if (name!=null){
                    txtdataclient.append("["+name+"] : "+msg+"\n");
                    SendToAllClients("["+name+"] : "+msg);
                }
            }
            if (name!=null)
                SendToAllClients(name+ " Left Chat");
            nlist.set(id, "");
            loadList();
           }catch(Exception e){}
        }
    }
    public void run()
    {
        while(true)
        {
            try {
                
                c=s.accept();
                System.out.println("Client accepted: " + c);
                String []ar1=c.toString().split(",");
                
                String strnew=ar1[0];
                str=str+"\n"+strnew+"\n"+"Port"+ar1[2];
                
                txtinforconnect.setText(""+str);
                brc=new BufferedReader(new InputStreamReader(c.getInputStream()));
            /*  
                out=new PrintWriter(c.getOutputStream(),true);
               
                name=brc.readLine();
              
                while((msg=brc.readLine())!=null)
                {
                    txtdataclient.append("["+name+"] : "+msg+"\n");
                
                   out.println(msg.toUpperCase());
              }
                */
                name=brc.readLine();
                slist.add(c);
                nlist.add(name+"["+tid+"]");
                ProcessClient t=new ProcessClient(tid, name, c);
                t.start();
                tid++;
               
                
            } catch (IOException ex) {
                Logger.getLogger(MainServerChangeMessage.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
      private HandleClient h;
    /**
     * Creates new form MainServerChangeMessage
     */
    public MainServerChangeMessage() throws SQLException {
       try {
             cs=con.prepareCall("{call updateS(?)}");
             cs.setInt(1, 1);
             cs.execute();
         } catch (SQLException ex) {
             Logger.getLogger(MainServerChangeMessage.class.getName()).log(Level.SEVERE, null, ex);
         }
       initComponents();
       reloadUsers();
       slist=new ArrayList<>();
       nlist=new ArrayList<>();
       cb_cmd.addItem("closedClient");
        cb_server_gui.addItem("ALL_USERS");
       cb_server_gui.addItem("OnLyUser");
        try
        {
            s=new ServerSocket(PortConstance.SERVER_PORT);
            System.out.println("Binding to port " + PortConstance.SERVER_PORT + ", please wait  ...");
            str=str+"Binding to port " + PortConstance.SERVER_PORT + ", please wait  ..."; 
            System.out.println("Server started: " + PortConstance.SERVER_PORT);
            str=str+"\n"+"Server started: " + PortConstance.SERVER_PORT;
            str=str+"\n"+"Waiting for a client ...";
          
            txtinforconnect.setText(str);
            h=new HandleClient();
            h.start();
            
  
            //((DefaultTableModel)namelist.getModel()).setValueAt("Raj[7]", 0, 0);
        }catch(Exception e){}
      
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtinforconnect = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtdataclient = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        txtmsg = new javax.swing.JTextField();
        btn_gui = new javax.swing.JButton();
        cb_server_gui = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        namelist = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        cb_cmd = new javax.swing.JComboBox<>();
        btn_thuchien = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        namelist1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Server ChangeAlphabet");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Connection information");

        txtinforconnect.setColumns(20);
        txtinforconnect.setRows(5);
        jScrollPane2.setViewportView(txtinforconnect);

        jLabel2.setText("Data sent from the client");

        txtdataclient.setColumns(20);
        txtdataclient.setRows(5);
        jScrollPane1.setViewportView(txtdataclient);

        jLabel4.setText("Send message to all client");

        btn_gui.setBackground(new java.awt.Color(102, 102, 255));
        btn_gui.setText("Send");
        btn_gui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(cb_server_gui, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(74, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(txtmsg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_gui))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_server_gui, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_gui, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmsg, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        namelist.setBackground(new java.awt.Color(0, 51, 255));
        namelist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Members Connecting"
            }
        ));
        jScrollPane4.setViewportView(namelist);

        jLabel3.setText("Send comment to client");

        btn_thuchien.setBackground(new java.awt.Color(0, 0, 255));
        btn_thuchien.setText("Execute");
        btn_thuchien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thuchienActionPerformed(evt);
            }
        });

        namelist1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Members"
            }
        ));
        jScrollPane5.setViewportView(namelist1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cb_cmd, 0, 276, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_thuchien))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_thuchien, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_cmd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_thuchienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thuchienActionPerformed
        // TODO add your handling code here:
        String cmd = (String)cb_cmd.getSelectedItem();
        String value = cb_cmd.getSelectedItem().toString();
        System.out.println(""+value);
        int column = 0;
        int row = namelist.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(null, "Chưa chọn client để thực hiện");
        }else{
        String valuetable = namelist.getModel().getValueAt(row, column).toString();
        System.out.println(""+valuetable);
        String data=String.valueOf(((DefaultTableModel)namelist.getModel()).getValueAt(namelist.getSelectedRow(), 0));
            System.out.println(""+data.substring(data.indexOf("[")+1, data.indexOf("]")));
            int id=Integer.parseInt(data.substring(data.indexOf("[")+1, data.indexOf("]")));
        
            Socket cl=slist.get(id);
            try
            {
                out=new PrintWriter(cl.getOutputStream(),true);
                out.println("cmd:"+value);
            }catch(Exception e){}
       
        }
    }//GEN-LAST:event_btn_thuchienActionPerformed

    private void btn_guiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guiActionPerformed
        // TODO add your handling code here:
        String cmd = (String)cb_server_gui.getSelectedItem();
        String value = cb_server_gui.getSelectedItem().toString();
     //   System.out.println(""+value);
        
        if(value.equalsIgnoreCase("ALL_USERS")){
        if(!txtmsg.getText().equals("") )
        {
               //Gửi tất cả user          
                String contents=txtmsg.getText();
                Socket sock;
                PrintWriter out;
                for(int x=0;x<slist.size();x++)
               {
                try{
                sock=slist.get(x);
                out=new PrintWriter(sock.getOutputStream(),true);
                out.println("[Server] : "+contents);
                }catch(Exception e){}
               }
           
        }
        }else if(value.equalsIgnoreCase("OnLyUser")){
            int column = 0;
            int row = namelist.getSelectedRow();
            if(row<0){
            JOptionPane.showMessageDialog(null, "Chưa chọn client để gửi");
            }else{
                 String data=String.valueOf(((DefaultTableModel)namelist.getModel()).getValueAt(namelist.getSelectedRow(), 0));
       
                 int id=Integer.parseInt(data.substring(data.indexOf("[")+1, data.indexOf("]")));
                Socket cl=slist.get(id);
            try
            {
                out=new PrintWriter(cl.getOutputStream(),true);
                String contents=txtmsg.getText();
                contents.replace("\n", "~");
                contents=contents+"\n";
                out.println("msg:"+txtmsg.getText());
            }catch(Exception e){}
        }
        }
    }//GEN-LAST:event_btn_guiActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
         try {
             // TODO add your handling code here:
             cs=con.prepareCall("{call updateS(?)}");
             cs.setInt(1, 0);
             cs.execute();
         } catch (SQLException ex) {
             Logger.getLogger(MainServerChangeMessage.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainServerChangeMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainServerChangeMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainServerChangeMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainServerChangeMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainServerChangeMessage().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(MainServerChangeMessage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_gui;
    private javax.swing.JButton btn_thuchien;
    private javax.swing.JComboBox<String> cb_cmd;
    private javax.swing.JComboBox<String> cb_server_gui;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable namelist;
    private javax.swing.JTable namelist1;
    private javax.swing.JTextArea txtdataclient;
    private javax.swing.JTextArea txtinforconnect;
    private javax.swing.JTextField txtmsg;
    // End of variables declaration//GEN-END:variables
}
