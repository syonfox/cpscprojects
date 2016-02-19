package version1c;


public class Time implements TimeInterface {

  private int hour;
  private int min;
  private int sec;
  
  
  
  
  public Time() {
    hour = 0;
    min = 0;
    sec = 0;
  }
  
  
  public Time( int h, int m, int s ) {
  
    if( h<0 || h>23 || m<0 || m>59 || s<0 || s>59 ){
    
      System.out.println( "Error: InvalidTime - The time " + h + ":" + m + ":" + s + " is not a time on Earth." );
      System.exit( 0 );
      
    } else {
    
      hour = h;
      min = m;
      sec = s;
      
    }
  }
  
  
  public Time( Time t ) {
  
   // this dosent really need to be cheacked but It fixes at least one bug :D.
  if( t.getHour()<0 || t.getHour()>23 || t.getMin()<0 || t.getMin()>59 || t.getSec()<0 || t.getSec()>59 ){
  
      System.out.println( "Error: InvalidTime - The time " + t.getHour() + ":" + t.getMin() + ":" + t.getSec() + " is not a time on Earth." );
      System.exit( 0 );
      
    } else {
    
      hour = t.getHour();
      min = t.getMin();
      sec = t.getSec();
      
    }
  }
  
  
  
  public int getHour() {
    return hour;
  }
  
  
  public int getMin() {
    return min;
  }

  
  public int getSec() {
    return sec;
  }
  
  
  
  public void setHour(int h) {
  
    if( h<0 || h>23 ) {
    
      System.out.println( "Error: InvalidTime - The hour " + h + " is not one of the valid Earth hours." );
      System.exit( 0 );
      
    } else {
    
      hour = h;
      
    }
  }
  
  
  public void setMin(int m) {
  
    if( m<0 || m>59 ) {
    
      System.out.println( "Error: InvalidTime - The minute " + m + " is not one of the valid Earth minutes." );
      System.exit( 0 );
      
    } else {
    
      min = m;
      
    }
  }
  
  
  public void setSec(int s) {
  
    if(s<0 || s>23 ) {
    
      System.out.println( "Error: InvalidTime - The second " + s + " is not one of the valid Earth seconds." );
      System.exit( 0 );
      
    } else {
    
      sec = s;
      
    }
  }
  
 
  public void advanceBy(int s) {
  
    this.setFromSeconds( this.toSeconds() + s);
    
  }
  
  
  public String toString() {
    
    return hour+":"+min+":"+sec;
    
  }


  public int compareTo(Time t) {
  
    return this.toSeconds() - t.toSeconds();
    
  }
  
  
  public boolean equals(Time t) {
    
    return this.toSeconds() == t.toSeconds();
    
  }
  
  
  
  private int toSeconds() {
  
    return hour * 3600 + min * 60 + sec;
  
  }
  
  
  private void setFromSeconds(int s) {
  
    while( s < 0 ) {
      s += 86400;
    }
    
    sec = s%60; 	//sets seconds to s%60
    s -= s%60;		//subtract the number of seconds we added leaving a number divisable by 60
    s = s/60;		//divide by 60 making s be in terms of minutes
    
    min = s%60;
    s -= s%60;
    s = s/60;
      
    hour = s;
    
    //removes extra days.
    if( hour > 23) { 
      hour -= 24;
    }
  }
}