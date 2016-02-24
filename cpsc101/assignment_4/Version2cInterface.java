import version2c.Time;
import version2c.TimeInterface;


class Version2cInterface {

  public static void main(String[] args) {
  
    TimeInterface ti = new Time(12,30,0);
    System.out.println("Hour:   " + ti.getHour() );
    System.out.println("Minute: " + ti.getMin() );
    System.out.println("Second: " + ti.getSec() );
    
    
    
  }
}