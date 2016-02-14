package version2;


public class Time {

  private int seconds;
  
  
  
  
  public Time() {
    
    seconds = 0;
    
  }
  
  
  public Time( int h, int m, int s ) {
  
    if( h<0 || h>23 || m<0 || m>59 || s<0 || s>59 ){
    
      System.out.println( "Error: InvalidTime - The time " + h + ":" + m + ":" + s + " is not a time on Earth." );
      System.exit( 0 );
      
    } else {
    
      seconds = h * 3600 + m * 60 + s;
      
    }
  }
  
  
  public Time( Time t ) {
  
   // this dosent really need to be cheacked but It fixes at least one side effect :D.
  if( t.getHour()<0 || t.getHour()>23 || t.getMin()<0 || t.getMin()>59 || t.getSec()<0 || t.getSec()>59 ){
  
      System.out.println( "Error: InvalidTime - The time " + t.getHour() + ":" + t.getMin() + ":" + t.getSec() + " is not a time on Earth." );
      System.exit( 0 );
      
    } else {
    
      seconds = t.getHour()*3600 + t.getMin()*60 + t.getSec();
      
    }
  }
  
  
  
  public int getHour() {
    // everything that is not an hour is a decamel and since it is an in it is cut off
    return seconds/3600; 
    
  }
  
  
  public int getMin() {
    //first cut off second precision then fund the remander if it waould have been turned into hours.
    return (seconds/60)%60; 
  }

  
  public int getSec() {
    //how many seconds whould be tyhere if we made it into minutes
    return seconds%60; 
    
  }
  
  
  
  public void setHour(int h) {
  
    if( h<0 || h>23 ) {
    
      System.out.println( "Error: InvalidTime - The hour " + h + " is not one of the valid Earth hours." );
      System.exit( 0 );
      
    } else {
      // first subtract the seconds that maku up the hour then add the new ones.
      seconds = seconds - getHour()*3600 + h*3600;
      
    }
  }
  
  
  public void setMin(int m) {
  
    if( m<0 || m>59 ) {
    
      System.out.println( "Error: InvalidTime - The minute " + m + " is not one of the valid Earth minutes." );
      System.exit( 0 );
      
    } else {
    
      seconds = seconds - getMin()*60 + m*60;
      
    }
  }
  
  
  public void setSec(int s) {
  
    if(s<0 || s>23 ) {
    
      System.out.println( "Error: InvalidTime - The second " + s + " is not one of the valid Earth seconds." );
      System.exit( 0 );
      
    } else {
    
      seconds = seconds - getSec()*60 + s*60;
      
    }
  }
  
  
  public void advanceBy(int s) {
    
    seconds += s;
    while( seconds < 0 ) {
      s += 86400;
    }
    
    while( seconds > 86399 ) {
      s -= 86400;
    }
    
  }
  
  
  public String toString() {
    
    return getHour()+":"+getMin()+":"+getSec();
    
  }


  public int compareTo(Time t) {
  
    return this.seconds - t.seconds;
    
  }
  
  
  public boolean equals(Time t) {
    
    return this.seconds == t.seconds;
    
  }
  
}