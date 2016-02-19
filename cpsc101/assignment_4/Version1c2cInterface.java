
import version2c.TimeInterface;
import java.util.Arrays;


class Version1c2cInterface {

  public static void main(String[] args) {
  
    TimeInterface[] ti = new TimeInterface[2];
    ti[0] = new version1c.Time(12,30,0);
    ti[1] = new version2c.Time(10,20,2);
    
  }
}