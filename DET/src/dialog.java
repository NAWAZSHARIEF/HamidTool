import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class dialog extends JFrame {
  private JButton jButton1;
  
  private JButton jButton2;
  
  private JTextField jTextField1;
  
  public dialog() {
    initComponents();
  }
  
  private void initComponents() {
    this.jButton1 = new JButton();
    this.jTextField1 = new JTextField();
    this.jButton2 = new JButton();
    setDefaultCloseOperation(3);
    this.jButton1.setText("jButton1");
    this.jButton1.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            dialog.this.jButton1ActionPerformed(evt);
          }
        });
    this.jTextField1.setText("'WH.W.AI.STN86700.X30INTR.Y10.XXXX.XXXXX'");
    this.jButton2.setText("jButton2");
    this.jButton2.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            dialog.this.jButton2ActionPerformed(evt);
          }
        });
    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(69, 69, 69).addComponent(this.jButton1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 39, 32767).addComponent(this.jButton2).addGap(34, 34, 34)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(26, 32767).addComponent(this.jTextField1, -2, 244, -2).addGap(18, 18, 18)));
    layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jTextField1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addComponent(this.jButton1).addGap(30, 30, 30)).addGroup(layout.createSequentialGroup().addComponent(this.jButton2).addContainerGap()))));
    pack();
  }
  
  private void jButton1ActionPerformed(ActionEvent evt) {
    FTPClient ftpClient = new FTPClient();
    try {
      ftpClient.connect("10.203.12.253");
    } catch (SocketException ex) {
      System.out.println("Exception in Connect");
      Logger.getLogger(dialog.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (IOException ex) {
      System.out.println("Exception in Connect");
      Logger.getLogger(dialog.class.getName()).log(Level.SEVERE, (String)null, ex);
    } 
    try {
      ftpClient.login("adcavf9", "dell@1234");
    } catch (IOException ex) {
      System.out.println("Exception in login ");
      Logger.getLogger(dialog.class.getName()).log(Level.SEVERE, (String)null, ex);
    } 
    try {
      if (FTPReply.isPositiveCompletion(ftpClient.getReply()) == true) {
        System.out.println("reply of the last command is sucess");
      } else {
        System.out.println("reply of the last command is false");
        return;
      } 
    } catch (IOException ex) {
      Logger.getLogger(dialog.class.getName()).log(Level.SEVERE, (String)null, ex);
    } 
    System.out.println("Login Successfull ");
    try {
      OutputStream output = new FileOutputStream("saveas.txt");
      ftpClient.retrieveFile(this.jTextField1.getText(), output);
      output.close();
      ftpClient.disconnect();
    } catch (Exception ex) {
      Logger.getLogger(dialog.class.getName()).log(Level.SEVERE, (String)null, ex);
      System.out.println("exception in retriving file ... means file does not exists ");
    } 
  }
  
  private void jButton2ActionPerformed(ActionEvent evt) {
    FTPClient ftpClient = new FTPClient();
    try {
      ftpClient.connect("10.203.12.253");
    } catch (SocketException ex) {
      System.out.println("Exception in Connect");
      Logger.getLogger(dialog.class.getName()).log(Level.SEVERE, (String)null, ex);
      return;
    } catch (IOException ex) {
      System.out.println("Exception in Connect");
      Logger.getLogger(dialog.class.getName()).log(Level.SEVERE, (String)null, ex);
      return;
    } 
    try {
      ftpClient.login("adcavf9", "dell@1234");
    } catch (IOException ex) {
      System.out.println("Exception in login ");
      Logger.getLogger(dialog.class.getName()).log(Level.SEVERE, (String)null, ex);
      return;
    } 
    try {
      if (FTPReply.isPositiveCompletion(ftpClient.getReply()) == true) {
        System.out.println("reply of the last command is sucess");
      } else {
        System.out.println("reply of the last command is false");
        return;
      } 
    } catch (IOException ex) {
      Logger.getLogger(dialog.class.getName()).log(Level.SEVERE, (String)null, ex);
      return;
    } 
    System.out.println("Login Successfull ");
  }
  
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
          public void run() {
            (new dialog()).setVisible(true);
          }
        });
  }
}
