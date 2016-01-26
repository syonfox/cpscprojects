










import java.util.Scanner;


class Employee {
  
  private String eClass;
  private String eNum;
  private double hours;
  private double rate;
  private double commision;
  private double other;
  private double deductions;
  private double takeHome;
  
  public String getEClass() {
    return this.eClass;
  }
  
  public String getENum() {
    return this.eNum;
  }
  
  public double getHours() {
    return this.hours;
  }
  
  public double getRate() {
    return this.rate;
  }
  
  public double getCommision() {
    return this.commision;
  }
  
  public double getOther() {
    return this.other;
  }
  
  public double getDeductions() {
    return this.deductions;
  }
  
  public double getTakeHome() {
    return this.takeHome;
  }
  
  public void setEClass( String s ) {
  eClass = s;
  }
  
  public void setENum( String s ) {
    eNum = s;
  }
  
  public void setHours( double d ) {
    hours = d;
  }
  
  public void setRate( double d ) {
    rate = d;
  }
  
  public void setCommision( double d ) {
    commision = d;
  }
  
  public void setOther( double d ) {
    other = d;
  }
  
  public void setDeductions( double d ) {
    deductions = d;
  }
  
  public void setTakeHome( double d ) {
    takeHome = d;
  }
  
  
  public Employee() {
    String eClass;
    String eNum;
    double hours;
    double rate;
    double commision;
    double other;
    double deductions;
    double takeHome;
    
  }
  
  public void readDetailsFrom(Scanner in) {
    this.setEClass("EE");
    this.setENum(in.next());
    this.setRate(in.nextDouble());
    /*hours = 40;
    other = 0;
    commision = 0;
    deductions = 33.3;
    takeHome = 9999.26;*/
  }
  
}



class FullTimeEmployee extends Employee {
  
  public FullTimeEmployee() {
    String eClass;
    String eNum;
    double hours;
    double rate;
    double commision;
    double other;
    double deductions;
    double takeHome;
    
  }	
  
  public void readDetailsFrom(Scanner in) {
    
    this.setEClass("FT");
    this.setENum(in.next());
    this.setRate(in.nextDouble());
    System.out.println("good");
    /*hours = 40;
    other = 0;
    commision = 0;
    deductions = 33.3;
    takeHome = 9999.26;*/
  }
}




/*class PartTimeEmployee extends Employee {
  
  public void readDetailsFrom(Scanner in) {
  
  }
}



class ContractEmployee extends Employee {
  
  public void readDetailsFrom(Scanner in) {
  
  }
}*/