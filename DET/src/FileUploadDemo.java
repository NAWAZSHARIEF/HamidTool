import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.net.ftp.FTPClient;

public class FileUploadDemo {
  public static void main(String[] args) {
    System.out.println("dasdsa");
    FTPClient client = new FTPClient();
    FileInputStream fis = null;
    try {
      client.connect("10.203.12.253");
      client.login("adcavf9", "dell@1234");
      System.out.println("connection done");
      String filename = "test2.txt";
      fis = new FileInputStream(filename);
      System.out.println("test2 found");
      client.storeFile("'WH.W.AI.STN86700.X30INTR.Y10.XXXX.DXXXX'", fis);
      System.out.println("upload done");
      client.logout();
      System.out.println("Done");
    } catch (IOException e) {
      System.out.println("Error in uploading file");
      e.printStackTrace();
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
}
