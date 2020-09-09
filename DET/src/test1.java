import java.util.Calendar;

public class test1 {
  public static void main(String[] args) {
    Calendar c = Calendar.getInstance();
    int month = c.get(2) + 1;
    String s = String.format("%1$tY %1$tm %1$te_%1$TH%1$TM%1$TS.zip", new Object[] { c });
    String zipfilename = "" + c.get(1) + "/" + (c.get(2) + 1) + "/" + c.get(5) + "_" + c.get(11) + ":" + c.get(12) + ":" + c.get(13) + ".zip";
    System.out.println(zipfilename);
    System.out.println(s);
  }
}
