import com.jscape.inet.ftp.Ftp;
import com.jscape.inet.ftp.FtpException;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.net.ftp.FTPClient;

public class NewJFrame extends JFrame {
  JFileChooser fc = new JFileChooser(".");
  
  String filenameglob;
  
  static int t;
  
  static String reclength;
  
  static final int BUFFER = 2048;
  
  public static Ftp ftp;
  
  public static Ftp ftpup;
  
  public String[] str = new String[2000];
  
  public int noofdataset;
  
  public boolean[] jtransferdone = new boolean[2000];
  
  String[][] data = new String[][] { { null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null } };
  
  String[] cols = new String[] { "DataSet Name", "Progress", "Pass1", "Pass2", "Final Status" };
  
  DefaultTableModel model;
  
  Calendar c = Calendar.getInstance();
  
  private JButton jButton1;
  
  private JButton jButton2;
  
  private JButton jButton3;
  
  private JButton jButton4;
  
  private JCheckBox jCheckBox1;
  
  private JLabel jLabel1;
  
  private JLabel jLabel10;
  
  private JLabel jLabel2;
  
  private JLabel jLabel20;
  
  private JLabel jLabel3;
  
  private JLabel jLabel4;
  
  private JLabel jLabel5;
  
  private JLabel jLabel6;
  
  private JLabel jLabel7;
  
  private JLabel jLabel8;
  
  private JLabel jLabel9;
  
  private JPanel jPanel6;
  
  private JPasswordField jPasswordField1;
  
  private JTextField jTextField1;
  
  private JTextField jTextField2;
  
  private JTextField jTextField3;
  
  private JTextField jTextField4;
  
  public NewJFrame() {
    initComponents();
    this.model = new DefaultTableModel((Object[][])this.data, (Object[])this.cols);
    ImageIcon icon = createImageIcon("Logo.jpg", " logo ");
    this.jLabel6.setIcon(icon);
  }
  
  private void initComponents() {
    this.jButton2 = new JButton();
    this.jLabel2 = new JLabel();
    this.jTextField1 = new JTextField();
    this.jLabel3 = new JLabel();
    this.jTextField2 = new JTextField();
    this.jLabel4 = new JLabel();
    this.jLabel5 = new JLabel();
    this.jTextField4 = new JTextField();
    this.jButton1 = new JButton();
    this.jPasswordField1 = new JPasswordField();
    this.jPanel6 = new JPanel();
    this.jLabel20 = new JLabel();
    this.jLabel6 = new JLabel();
    this.jLabel7 = new JLabel();
    this.jButton4 = new JButton();
    this.jLabel8 = new JLabel();
    this.jLabel9 = new JLabel();
    this.jButton3 = new JButton();
    this.jTextField3 = new JTextField();
    this.jLabel1 = new JLabel();
    this.jLabel10 = new JLabel();
    this.jCheckBox1 = new JCheckBox();
    this.jButton2.setText("jButton2");
    setDefaultCloseOperation(3);
    setTitle("Dataset Extraction Tool    Copyright | Data & CI Automation Team |");
    setBackground(Color.BLACK);
    setCursor(new Cursor(0));
    setFont(new Font("Arial", 0, 10));
    setLocationByPlatform(true);
    setName("Dataset Extraction Tool");
    setResizable(false);
    this.jLabel2.setText("IP Address");
    this.jTextField1.setEditable(true);
    this.jTextField1.setText("10.204.244.17");
    this.jTextField1.setToolTipText("IP Address");
    this.jLabel3.setText("User Name");
    this.jTextField2.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            NewJFrame.this.jTextField2ActionPerformed(evt);
          }
        });
    this.jLabel4.setText("Password");
    this.jLabel5.setText("Select Dataset");
    this.jTextField4.setEditable(false);
    this.jTextField4.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            NewJFrame.this.jTextField4ActionPerformed(evt);
          }
        });
    this.jButton1.setText("Browse");
    this.jButton1.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            NewJFrame.this.jButton1ActionPerformed(evt);
          }
        });
    this.jPasswordField1.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            NewJFrame.this.jPasswordField1ActionPerformed(evt);
          }
        });
    this.jPanel6.setBackground(UIManager.getDefaults().getColor("FormattedTextField.selectionBackground"));
    this.jPanel6.setBorder(new SoftBevelBorder(0));
    this.jLabel20.setFont(new Font("Tahoma", 0, 24));
    this.jLabel20.setText("Dataset Extraction Tool");
    GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
    this.jPanel6.setLayout(jPanel6Layout);
    jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup().addContainerGap(44, 32767).addComponent(this.jLabel20, -2, 258, -2).addGap(19, 19, 19)));
    jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel20).addContainerGap(-1, 32767)));
    this.jLabel20.getAccessibleContext().setAccessibleDescription("Dataset Extraction Tool");
    this.jLabel6.setText("jLabel6");
    this.jLabel7.setText("Copyright | Data & CI Automation Team |");
    this.jButton4.setText("Download");
    this.jButton4.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            NewJFrame.this.jButton4ActionPerformed(evt);
          }
        });
    this.jLabel8.setText("Status :  ");
    this.jLabel9.setText("Idle");
    this.jButton3.setText("Upload");
    this.jButton3.setMaximumSize(new Dimension(79, 23));
    this.jButton3.setMinimumSize(new Dimension(79, 23));
    this.jButton3.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            NewJFrame.this.jButton3ActionPerformed(evt);
          }
        });
    this.jTextField3.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            NewJFrame.this.jTextField3ActionPerformed(evt);
          }
        });
    this.jLabel1.setText("Upload Name ");
    this.jLabel10.setText("Compression   ");
    this.jCheckBox1.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            NewJFrame.this.jCheckBox1ActionPerformed(evt);
          }
        });
    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel6).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel8).addComponent(this.jLabel10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel2).addComponent(this.jLabel3).addComponent(this.jLabel4).addComponent(this.jLabel5, -1, -1, 32767)).addComponent(this.jLabel1, -2, 91, -2)).addGap(29, 29, 29).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCheckBox1).addComponent(this.jTextField1, -2, 92, -2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jTextField2, GroupLayout.Alignment.LEADING).addComponent(this.jPasswordField1, GroupLayout.Alignment.LEADING, -1, 92, 32767)).addComponent(this.jTextField3, -2, 275, -2).addGroup(layout.createSequentialGroup().addComponent(this.jTextField4, -2, 276, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton1)).addGroup(layout.createSequentialGroup().addComponent(this.jButton4, -2, 92, -2).addGap(18, 18, 18).addComponent(this.jButton3, -2, 82, -2)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel7).addComponent(this.jLabel9, -2, 408, -2)))).addGroup(layout.createSequentialGroup().addGap(45, 45, 45).addComponent(this.jPanel6, -2, -1, -2))).addGap(98, 98, 98)));
    layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel6).addGroup(layout.createSequentialGroup().addComponent(this.jPanel6, -2, -1, -2).addGap(43, 43, 43).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.jTextField1, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.jTextField2, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel4).addComponent(this.jPasswordField1, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel5).addComponent(this.jTextField4, -2, -1, -2).addComponent(this.jButton1)))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTextField3, -2, -1, -2).addComponent(this.jLabel1)).addGap(14, 14, 14).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCheckBox1).addGroup(layout.createSequentialGroup().addComponent(this.jLabel10).addGap(14, 14, 14).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel8).addComponent(this.jLabel9)))).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton4).addComponent(this.jButton3, -2, -1, -2)).addGap(28, 28, 28).addComponent(this.jLabel7).addContainerGap()));
    pack();
  }
  
  private void jButton1ActionPerformed(ActionEvent evt) {
    this.fc.addChoosableFileFilter(new txtFileFilter());
    int retval = this.fc.showOpenDialog(null);
    if (retval == 0) {
      File myFile = this.fc.getSelectedFile();
      this.jTextField4.setText(myFile.getPath());
      this.filenameglob = myFile.getName();
    } 
  }
  
  private void jPasswordField1ActionPerformed(ActionEvent evt) {}
  
  private void jTextField2ActionPerformed(ActionEvent evt) {}
  
  private void jButton4ActionPerformed(ActionEvent evt) {
    String zipfilename = String.format("%1$tY %1$tm %1$te_%1$TH%1$TM%1$TS.zip", new Object[] { this.c });
    if (this.jTextField2.getText().isEmpty()) {
      JOptionPane.showMessageDialog(null, "No User Name Specified");
      this.jLabel9.setForeground(Color.red);
      this.jLabel9.setText("No User Name Specified");
      return;
    } 
    if (this.jPasswordField1.getText().isEmpty()) {
      this.jLabel9.setForeground(Color.red);
      JOptionPane.showMessageDialog(null, "No Password Specified");
      this.jLabel9.setText("No Password Specified");
      return;
    } 
    if (this.jTextField4.getText().isEmpty()) {
      this.jLabel9.setForeground(Color.red);
      JOptionPane.showMessageDialog(null, "No DataSet File Specified");
      this.jLabel9.setText("No DataSet File Specified");
      return;
    } 
    this.jLabel9.setForeground(Color.BLACK);
    this.jLabel9.setText("Idle ...");
    Rectangle rect = this.jLabel9.getBounds();
    this.jLabel9.paintImmediately(0, 0, rect.width, rect.height);
    ftp = new Ftp(this.jTextField1.getText(), this.jTextField2.getText(), this.jPasswordField1.getText());
    int index = 0;
    jreaddataset();
    this.jLabel9.setForeground(Color.blue);
    this.jLabel9.setText("Connecting");
    rect = this.jLabel9.getBounds();
    this.jLabel9.paintImmediately(0, 0, rect.width, rect.height);
    this.jLabel9.setForeground(Color.black);
    try {
      jConnect();
    } catch (Exception e) {
      this.jLabel9.setForeground(Color.red);
      this.jLabel9.setText("Connection Failed ");
      rect = this.jLabel9.getBounds();
      this.jLabel9.paintImmediately(0, 0, rect.width, rect.height);
      try {
        Thread.sleep(5000L);
      } catch (InterruptedException ex) {
        Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, (String)null, ex);
      } 
      return;
    } 
    this.jLabel9.setForeground(Color.green);
    this.jLabel9.setText("Connection Established ");
    rect = this.jLabel9.getBounds();
    this.jLabel9.paintImmediately(0, 0, rect.width, rect.height);
    this.jLabel9.setForeground(Color.blue);
    jSetftpattrib();
    for (index = 0; index < this.noofdataset; index++) {
      try {
        this.jLabel9.setText("Processing ... " + this.str[index]);
        rect = this.jLabel9.getBounds();
        this.jLabel9.paintImmediately(0, 0, rect.width, rect.height);
        jftpdownload(this.str[index], index);
      } catch (Exception e) {
        System.out.println("exception thrown in jdownload  for File " + this.str[index] + "going for next dataset");
        try {
          ftp.disconnect();
        } catch (FtpException ex) {
          Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, (String)null, (Throwable)ex);
        } 
        ftp = null;
        ftp = new Ftp(this.jTextField1.getText(), this.jTextField2.getText(), this.jPasswordField1.getText());
        try {
          jConnect();
        } catch (FtpException ex) {
          Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, (String)null, (Throwable)ex);
        } 
        jSetftpattrib();
      } 
    } 
    jreport("pass1");
    for (index = 0; index < this.noofdataset; index++) {
      if (this.jtransferdone[index] != true)
        try {
          this.jLabel9.setText("Recalling ... " + this.str[index]);
          rect = this.jLabel9.getBounds();
          this.jLabel9.paintImmediately(0, 0, rect.width, rect.height);
          Thread.sleep(90000L);
          jftpdownload(this.str[index], index);
        } catch (Exception e) {
          System.out.println("Pass 2 exception thrown in jdownload  for File " + this.str[index] + "going for next dataset");
          try {
            ftp.disconnect();
          } catch (FtpException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, (String)null, (Throwable)ex);
          } 
          ftp = null;
          ftp = new Ftp(this.jTextField1.getText(), this.jTextField2.getText(), this.jPasswordField1.getText());
          try {
            jConnect();
          } catch (FtpException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, (String)null, (Throwable)ex);
          } 
          jSetftpattrib();
        }  
    } 
    jreport("Final pass2");
    try {
      ftp.disconnect();
    } catch (FtpException ex) {
      Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, (String)null, (Throwable)ex);
    } 
    if (this.jCheckBox1.isSelected() == true) {
      try {
        BufferedInputStream origin = null;
        FileOutputStream dest = new FileOutputStream(zipfilename);
        ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
        byte[] data = new byte[2048];
        for (int i = 0; i < this.noofdataset; i++) {
          if (this.jtransferdone[i]) {
            System.out.println("Adding: " + this.str[i] + ".txt");
            this.jLabel9.setText("Archiving ... " + this.str[i] + ".txt");
            rect = this.jLabel9.getBounds();
            this.jLabel9.paintImmediately(0, 0, rect.width, rect.height);
            FileInputStream fi = new FileInputStream(this.str[i] + ".txt");
            origin = new BufferedInputStream(fi, 2048);
            ZipEntry entry = new ZipEntry(this.str[i] + ".txt");
            out.putNextEntry(entry);
            int count;
            while ((count = origin.read(data, 0, 2048)) != -1)
              out.write(data, 0, count); 
            origin.close();
          } 
        } 
        out.close();
        System.out.println("zip done ");
        deletetxtfilesafterzip();
      } catch (Exception e) {
        e.printStackTrace();
      } 
      this.jLabel9.setText("Transfer Complete");
      rect = this.jLabel9.getBounds();
      this.jLabel9.paintImmediately(0, 0, rect.width, rect.height);
      JOptionPane.showMessageDialog(null, "Transfer Complete \n Zip File Created :" + zipfilename);
    } else {
      this.jLabel9.setText("Transfer Complete");
      rect = this.jLabel9.getBounds();
      this.jLabel9.paintImmediately(0, 0, rect.width, rect.height);
      JOptionPane.showMessageDialog(null, "Transfer Complete");
    } 
  }
  
  public void deletetxtfilesafterzip() {
    for (int i = 0; i < this.noofdataset; i++) {
      if (this.jtransferdone[i]) {
        System.out.println("Deleting : " + this.str[i] + ".txt");
        File fi = new File(this.str[i] + ".txt");
        if (fi.delete() == true) {
          System.out.println("File deleted :" + this.str[i] + ".txt");
        } else {
          System.out.println("Error deleting file : " + this.str[i] + ".txt");
        } 
      } 
    } 
  }
  
  private void jButton3ActionPerformed(ActionEvent evt) {
    if (this.jTextField2.getText().isEmpty()) {
      JOptionPane.showMessageDialog(null, "No User Name Specified");
      this.jLabel9.setForeground(Color.red);
      this.jLabel9.setText("No User Name Specified");
      return;
    } 
    if (this.jPasswordField1.getText().isEmpty()) {
      this.jLabel9.setForeground(Color.red);
      JOptionPane.showMessageDialog(null, "No Password Specified");
      this.jLabel9.setText("No Password Specified");
      return;
    } 
    if (this.jTextField4.getText().isEmpty()) {
      this.jLabel9.setForeground(Color.red);
      JOptionPane.showMessageDialog(null, "No File Selected");
      this.jLabel9.setText("No File Selected");
      return;
    } 
    if (this.jTextField3.getText().isEmpty()) {
      this.jLabel9.setForeground(Color.red);
      JOptionPane.showMessageDialog(null, "DataSet Name Must Be Specified");
      this.jLabel9.setText("DataSet Name Must Be Specified");
      return;
    } 
    if (this.jTextField3.getText().charAt(0) != '\'' || this.jTextField3.getText().charAt(this.jTextField3.getText().length() - 1) != '\'') {
      this.jLabel9.setForeground(Color.red);
      JOptionPane.showMessageDialog(null, "DataSet Name Must Be Specified in Single Quotes");
      this.jLabel9.setText("DataSet Name Must Be Specified in Single Quotes");
      return;
    } 
    FTPClient client = new FTPClient();
    FileInputStream fis = null;
    Rectangle rect = this.jLabel9.getBounds();
    try {
      this.jLabel9.setForeground(Color.blue);
      this.jLabel9.setText("Connecting");
      rect = this.jLabel9.getBounds();
      this.jLabel9.paintImmediately(0, 0, rect.width, rect.height);
      this.jLabel9.setForeground(Color.black);
      client.connect(this.jTextField1.getText());
      if (!client.login(this.jTextField2.getText(), this.jPasswordField1.getText())) {
        client.logout();
        this.jLabel9.setForeground(Color.red);
        this.jLabel9.setText("Connection Failed");
        rect = this.jLabel9.getBounds();
        this.jLabel9.paintImmediately(0, 0, rect.width, rect.height);
        return;
      } 
      System.out.println("Remote system is " + client.getSystemName());
      System.out.println("connection + login done");
      this.jLabel9.setForeground(Color.BLUE);
      this.jLabel9.setText("Connection Established ");
      rect = this.jLabel9.getBounds();
      this.jLabel9.paintImmediately(0, 0, rect.width, rect.height);
      int value = JOptionPane.showConfirmDialog(null, "Comfirm Copy \n" + this.filenameglob + " \nTo \n" + this.jTextField3.getText(), null, 2);
      if (value == 0) {
        String val = validaterecordlength();
        if (val == null) {
          System.out.println("You Presed cancel button ");
          this.jLabel9.setForeground(Color.black);
          this.jLabel9.setText("Idle");
          rect = this.jLabel9.getBounds();
          this.jLabel9.paintImmediately(0, 0, rect.width, rect.height);
          return;
        } 
        System.out.println("Record Length is :" + reclength);
        try {
          boolean reply = client.sendSiteCommand("LRECL=" + reclength);
          System.out.println("The reply is :" + reply);
        } catch (Exception e) {
          e.printStackTrace();
          System.out.println("Error sending the site command to remote server");
        } 
        String filename = this.jTextField4.getText();
        fis = new FileInputStream(filename);
        this.jLabel9.setForeground(Color.BLUE);
        this.jLabel9.setText("Uploading ... " + this.filenameglob);
        rect = this.jLabel9.getBounds();
        this.jLabel9.paintImmediately(0, 0, rect.width, rect.height);
        client.storeFile(this.jTextField3.getText(), fis);
        this.jLabel9.setForeground(Color.BLUE);
        this.jLabel9.setText("Idle");
        rect = this.jLabel9.getBounds();
        this.jLabel9.paintImmediately(0, 0, rect.width, rect.height);
        JOptionPane.showMessageDialog(null, "Transfer Complete");
        System.out.println("upload done");
        client.logout();
        System.out.println("Done");
      } else {
        this.jLabel9.setForeground(Color.black);
        this.jLabel9.setText("Idle");
        rect = this.jLabel9.getBounds();
        this.jLabel9.paintImmediately(0, 0, rect.width, rect.height);
        return;
      } 
    } catch (IOException e) {
      System.out.println("Error in uploading file");
      e.printStackTrace();
      this.jLabel9.setForeground(Color.red);
      this.jLabel9.setText("Connection Failed ");
      rect = this.jLabel9.getBounds();
      this.jLabel9.paintImmediately(0, 0, rect.width, rect.height);
      return;
    } finally {
      try {
        if (fis != null)
          fis.close(); 
        client.disconnect();
      } catch (IOException e) {
        e.printStackTrace();
      } 
    } 
  }
  
  public static String validaterecordlength() {
    reclength = JOptionPane.showInputDialog(null, "Specify Record Length :", "Record Length", 3);
    if (reclength == null)
      return reclength; 
    if (reclength.isEmpty()) {
      JOptionPane.showMessageDialog(null, "Record Length must be Positive", "Error", 0);
      validaterecordlength();
    } else {
      try {
        t = Integer.parseInt(reclength);
      } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Record Length must be Positive", "Error", 0);
        validaterecordlength();
      } 
    } 
    return reclength;
  }
  
  private void jTextField3ActionPerformed(ActionEvent evt) {}
  
  private void jTextField4ActionPerformed(ActionEvent evt) {}
  
  private void jCheckBox1ActionPerformed(ActionEvent evt) {}
  
  public void jConnect() throws FtpException {
    ftp.connect();
  }
  
  public void jSetftpattrib() {
    try {
      ftp.setTimeout(1000000);
      System.out.println("new time out info " + ftp.getTimeout());
      ftp.setAscii();
    } catch (FtpException ex) {}
  }
  
  public void jreaddataset() {
    this.noofdataset = 0;
    try {
      FileInputStream fstream = new FileInputStream(this.jTextField4.getText());
      DataInputStream in = new DataInputStream(fstream);
      while (in.available() != 0) {
        String temp = in.readLine().trim();
        if (temp.equalsIgnoreCase("") == true)
          continue; 
        this.str[this.noofdataset] = temp;
        System.out.println(this.str[this.noofdataset]);
        this.jtransferdone[this.noofdataset] = false;
        this.noofdataset++;
      } 
      in.close();
    } catch (Exception e) {
      System.err.println("Error loading the dataset file");
    } 
    System.out.println("Lenth of str is : " + this.str.length);
    ignore_duplicate_data();
  }
  
  public void ignore_duplicate_data() {
    String[] tempyy = new String[this.noofdataset];
    System.arraycopy(this.str, 0, tempyy, 0, this.noofdataset);
    for (int i = 0; i < tempyy.length; i++)
      System.out.println(tempyy[i]); 
    System.out.println("Length of tempyy :" + tempyy.length);
    Arrays.sort((Object[])tempyy);
    int k = 0;
    for (int j = 0; j < tempyy.length; j++) {
      if (j <= 0 || !tempyy[j].equals(tempyy[j - 1]))
        tempyy[k++] = tempyy[j]; 
    } 
    String[] unique = new String[k];
    System.arraycopy(tempyy, 0, unique, 0, k);
    int m;
    for (m = 0; m < unique.length; m++)
      System.out.println(unique[m]); 
    System.arraycopy(unique, 0, this.str, 0, unique.length);
    System.out.println(" After duplicate Elimination - the list of data set is ");
    this.noofdataset = k;
    for (m = 0; m < this.noofdataset; m++)
      System.out.println(this.str[m]); 
  }
  
  public void jftpdownload(String filename, int index) throws FtpException {
    if (ftp.isConnected() == true) {
      ftp.download(filename + ".txt", "'" + filename + "'");
      this.jtransferdone[index] = true;
    } else {
      throw new FtpException("connection not done");
    } 
  }
  
  public void jreport(String passname) {
    System.out.println(passname);
    for (int i = 0; i < this.noofdataset; i++)
      System.out.println("File :" + this.str[i] + " Done Status  " + this.jtransferdone[i]); 
  }
  
  public void uploadftp() {
    try {
      FileOutputStream out = new FileOutputStream("ftpcmd.txt");
      PrintStream p = new PrintStream(out);
      p.println("open " + this.jTextField1.getText());
      p.println(this.jTextField2.getText());
      p.println(this.jPasswordField1.getText());
      p.println("put " + this.jTextField4.getText() + " " + this.jTextField3.getText());
      p.println("close");
      p.println("quit");
      p.close();
      FileOutputStream out1 = new FileOutputStream("ftpex.bat");
      PrintStream p1 = new PrintStream(out1);
      p1.println("ftp -v -s:ftpcmd.txt");
      p1.println("exit");
      invokefunc();
      p1.close();
    } catch (Exception e) {
      System.err.println("Error writing to file");
    } 
  }
  
  public void invokefunc() {
    try {
      Process p = Runtime.getRuntime().exec("cmd.exe /C start ftpex.bat /A");
    } catch (IOException e) {
      System.out.println("exception happened - here's what I know: ");
      e.printStackTrace();
      System.exit(-1);
    } 
  }
  
  public void javaftp() {
    Ftp ftp1 = new Ftp(this.jTextField1.getText(), this.jTextField2.getText(), this.jPasswordField1.getText());
    JOptionPane.showMessageDialog(null, "ftp object created ... ");
    try {
      ftp1.connect();
      JOptionPane.showMessageDialog(null, "Connection Done .. Directory listing at console ");
      System.out.println(ftp1.getDirListingAsString());
      System.out.println("Passive required or not " + ftp1.getPassive());
      System.out.println("time out info " + ftp1.getTimeout());
      System.out.println("setting epasv mode");
      ftp1.setTimeout(1000000);
      System.out.println("new time out info " + ftp1.getTimeout());
      ftp1.setAuto(true);
      ftp1.setPassive(true);
      ftp1.setAscii();
      String inputValue = JOptionPane.showInputDialog("Please input a file name to retrive from remote server");
      System.out.print(inputValue);
      ftp1.download(inputValue);
      JOptionPane.showMessageDialog(null, "Transfer  Done ");
      ftp1.disconnect();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "error in try block of ftp");
      e.printStackTrace();
    } 
  }
  
  protected ImageIcon createImageIcon(String path, String description) {
    URL imgURL = getClass().getResource(path);
    if (imgURL != null) {
      this.jLabel6.setText("");
      return new ImageIcon(imgURL, description);
    } 
    System.err.println("Couldn't find file: " + path);
    this.jLabel6.setText("Image nOt Found !");
    return null;
  }
  
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
          public void run() {
            (new NewJFrame()).setVisible(true);
          }
        });
  }
}
