import java.io.FileInputStream;
import java.io.OutputStream;

public class FTPupload {
  protected FTPclientConn cconn;
  
  public final String localfile;
  
  public final String targetfile;
  
  public FTPupload(String _host, String _user, String _password, String _localfile, String _targetfile) {
    this.cconn = new FTPclientConn(_host, _user, _password);
    this.localfile = _localfile;
    this.targetfile = _targetfile;
    doit();
  }
  
  public FTPupload(String _host, String _user, String _password, String _file) {
    this.cconn = new FTPclientConn(_host, _user, _password);
    this.localfile = _file;
    this.targetfile = _file;
    doit();
  }
  
  protected void doit() {
    try {
      OutputStream os = this.cconn.openUploadStream(this.targetfile);
      FileInputStream is = new FileInputStream(this.localfile);
      byte[] buf = new byte[16384];
      while (true) {
        int c = is.read(buf);
        if (c <= 0)
          break; 
        os.write(buf, 0, c);
      } 
      os.close();
      is.close();
      this.cconn.close();
    } catch (Exception E) {
      System.err.println(E.getMessage());
      E.printStackTrace();
    } 
  }
  
  public static void main(String[] args) {
	  FTPupload ff =new FTPupload("10.204.244.17", "adcavf9", "dell@1234", "test2.txt");
	 
  }
}
