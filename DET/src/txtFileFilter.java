import java.io.File;
import javax.swing.filechooser.FileFilter;

class txtFileFilter extends FileFilter {
  public boolean accept(File f) {
    return (f.isDirectory() || f.getName().toLowerCase().endsWith(".txt"));
  }
  
  public String getDescription() {
    return "Text files";
  }
}
