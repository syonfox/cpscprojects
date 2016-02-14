
import version2.Time;
import java.util.Arrays;



class Version2Sort {

 public static void main(String[] args) {

    Time[] t = new Time[4];
    
    t[0] = new Time(2,2,2);
    t[1] = new Time(1,2,3);
    t[2] = new Time(20,19,18);
    t[3] = new Time(0,50,42);
    
    for(int i = 0; i < t.length; i++) {
      System.out.println( i+": "+t[i].toString() );
    }
    
    Arrays.sort(t);
    
    for(int i = 0; i < t.length; i++) {
      System.out.println( i+": "+t[i].toString() );
    }
  }
}