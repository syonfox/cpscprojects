import version2.Time;

class Version2Test {
  public static void main(String[] args) {
    
    Time a = new Time( 10, 10, 10 );
    
    System.out.println( "a: " + a.toString() );
    
    Time b = new Time();
    
    System.out.println("b: " + b.toString() );
    
    b.setHour( 5 );
    b.setMin( 55 );
    b.setSec( 3 );
    System.out.println( "	set b to 5:55:3" );
    System.out.println("b: " + b.toString() );
    
    System.out.println( "a.equals(b): " + a.equals(b) );
    
    System.out.println ( "a.compareTo(b): " + a.compareTo( b ) );
    System.out.println ( "b.compareTo(a): " + b.compareTo( a ) );
    
    Time c = new Time(b);
    System.out.println("	c = new Time(b)");
   
    b.advanceBy(a.compareTo(b));
    System.out.println( "	b.advanceBy(a.compareTo(b))" );
    
    System.out.println( "b: " + b.toString() );
     
    System.out.println( "a: " + a.toString() );
    
    System.out.println( "a.equals(b): " + a.equals(b) );
    
    
    System.out.println( "c: " + c.toString() );
     
    System.out.println( "b: " + b.toString() );
    
    c.advanceBy(36260);
    System.out.println( "	c.advanceBy(36260);" );
    
    System.out.println( "c:" + c.toString() );
    
    c.advanceBy(-36260);
    System.out.println( "	c.advanceBy(-36260);" );
    
    System.out.println( "c: " + c.toString() );
    
    c.advanceBy(36300);
    System.out.println( "	c.advanceBy(36300);" );
    
    System.out.println( "c: " + c.toString() );
    
    System.out.println( "c Hours: " + c.getHour() );
    System.out.println( "c Minutes: " + c.getMin() );
    System.out.println( "c seconds: " + c.getSec() );
  }
}