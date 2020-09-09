import javax.swing.JOptionPane;

public class test {
  static int t;
  
  static String reclength;
  
  public static void main(String[] args) {
    String val = validaterecordlength();
    if (val == null) {
      System.out.println("You Presed cancel button ");
      return;
    } 
    System.out.println("Record Length is :" + reclength);
    System.out.println("Reched end success");
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
}
