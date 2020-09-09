import java.io.IOException;
import java.io.PrintWriter;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ProtocolCommandListener;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPConnectionClosedException;
import org.apache.commons.net.ftp.FTPReply;

public final class ftp {
  public static final String USAGE = "Usage: ftp [-s] [-b] <hostname> <username> <password> <remote file> <local file>\n\nDefault behavior is to download a file and use ASCII transfer mode.\n\t-s store file on server (upload)\n\t-b use binary transfer mode\n";
  
  public static final void main(String[] args) {
    int base = 0;
    boolean storeFile = false, binaryTransfer = false, error = false;
    for (base = 0; base < args.length; base++) {
      if (args[base].startsWith("-s")) {
        storeFile = true;
      } else if (args[base].startsWith("-b")) {
        binaryTransfer = true;
      } else {
        break;
      } 
    } 
    if (args.length - base != 5) {
      System.err.println("Usage: ftp [-s] [-b] <hostname> <username> <password> <remote file> <local file>\n\nDefault behavior is to download a file and use ASCII transfer mode.\n\t-s store file on server (upload)\n\t-b use binary transfer mode\n");
      System.exit(1);
    } 
    String server = args[base++];
    String username = args[base++];
    String password = args[base++];
    String remote = args[base++];
    String local = args[base];
    FTPClient fTPClient = new FTPClient();
    fTPClient.addProtocolCommandListener((ProtocolCommandListener)new PrintCommandListener(new PrintWriter(System.out)));
    try {
      fTPClient.connect(server);
      System.out.println("Connected to " + server + ".");
      int reply = fTPClient.getReplyCode();
      if (!FTPReply.isPositiveCompletion(reply)) {
        fTPClient.disconnect();
        System.err.println("FTP server refused connection.");
        System.exit(1);
      } 
    } catch (IOException e) {
      if (fTPClient.isConnected())
        try {
          fTPClient.disconnect();
        } catch (IOException f) {} 
      System.err.println("Could not connect to server.");
      e.printStackTrace();
      System.exit(1);
    } 
    try {
    
    } finally {
      if (fTPClient.isConnected())
        try {
          fTPClient.disconnect();
        } catch (IOException f) {} 
    } 
    System.exit(error ? 1 : 0);
  }
}
