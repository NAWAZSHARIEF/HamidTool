import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
  static final int BUFFER = 2048;
  
  public static void main(String[] argv) {
    try {
      BufferedInputStream origin = null;
      FileOutputStream dest = new FileOutputStream("dwndataset.zip");
      ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
      byte[] data = new byte[2048];
      String[] files = { "ftpcmd.txt", "CLICK-2010-DVDRiP-550Mb-Mkv-{Team XMR}-RD.mkv" };
      System.out.println(" " + files[0]);
      for (int i = 0; i < files.length; i++) {
        System.out.println("Adding: " + files[i]);
        FileInputStream fi = new FileInputStream(files[i]);
        origin = new BufferedInputStream(fi, 2048);
        ZipEntry entry = new ZipEntry(files[i]);
        out.putNextEntry(entry);
        int count;
        while ((count = origin.read(data, 0, 2048)) != -1)
          out.write(data, 0, count); 
        origin.close();
      } 
      out.close();
      System.out.println("zip done ");
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
}
