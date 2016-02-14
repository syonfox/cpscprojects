import version1c.Time;
import version1c.TimeInterface;


class Version1cInterface {

  public static void main(String[] args) {
  
    TimeInterface ti = new version1c.Time(12,30,0);
    System.out.println("Hour:   " + ti.getHour() );
    System.out.println("Minute: " + ti.getMin() );
    System.out.println("Second: " + ti.getSec() );
  }
}