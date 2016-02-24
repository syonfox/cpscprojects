import version2c.TimeInterface;


class Version2cEndQ2 {

  public static void main(String[] args) {
    
    TimeInterface ti = new version2c.Time(12,30,0) ;
    ti.setSec(12) ;
    System.out.println(ti.getSec()) ;
    
  }
}