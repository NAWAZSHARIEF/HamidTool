import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

class FTPclientConn {
  public final String host;
  
  public final String user;
  
  protected final String password;
  
  protected URLConnection urlc;
  
  public FTPclientConn(String _host, String _user, String _password) {
    this.host = _host;
    this.user = _user;
    this.password = _password;
    this.urlc = null;
  }
  
  protected URL makeURL(String targetfile) throws MalformedURLException {
    if (this.user == null)
      return new URL("ftp://" + this.host + "/" + targetfile + ";type=i"); 
    return new URL("ftp://" + this.user + ":" + this.password + "@" + this.host + "/" + targetfile + ";type=i");
  }
  
  protected InputStream openDownloadStream(String targetfile) throws Exception {
    URL url = makeURL(targetfile);
    this.urlc = url.openConnection();
    InputStream is = this.urlc.getInputStream();
    return is;
  }
  
  protected OutputStream openUploadStream(String targetfile) throws Exception {
    URL url = makeURL(targetfile);
    this.urlc = url.openConnection();
    OutputStream os = this.urlc.getOutputStream();
    return os;
  }
  
  protected void close() {
    this.urlc = null;
  }
}
