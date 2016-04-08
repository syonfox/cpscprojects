 /**The FullTimeEmployee class is a child of Employee whitch can handle fulltime Employees
* @author Kier Lindsay
**/
package exercise1;
import java.util.Scanner;

public class FullTimeEmployee extends Employee {


  //I dont think I need constructors here since the employey constructor should work
  //and it should be used when a subemploye is created

  //I know I dont need to add all of the "this.***" but I like knowing.
  //its not so importan for this project but for others I think it may be nice.
  public FullTimeEmployee() {
    //do nothing
  }
  public FullTimeEmployee(FullTimeEmployee fte) {
    super(fte);
  }
  public FullTimeEmployee clone() {
    return new FullTimeEmployee(this);
  }

  public String getCode() {
    return "FT";
  }

  public void setDefaultData() {
    this.setEClass( "FT" );
    this.setHours( 40 );
    this.setCommision( 0 );
    this.setOther( 0 );
  }

  public void readDetailsFrom(Scanner in) {
    this.setENum( in.next() );
    this.setRate( in.nextDouble() );
  }

  public void calculateNeededResults() {
    this.calculateDeductions();
    this.calculateTakeHome();
  }

  //calculates deduction
  public void calculateDeductions() {
    double deduction = 0;
    int rate = (int) this.getRate();
    //less then 20$ per hour then no deduction
    if( rate > 20 ) {
      rate -= 20;
      //10$/($/h) for 20 to 40$
      if ( rate > 20) {
	rate -= 20;
	//if more then 40$/h then 20*10 + extra
	deduction = 200 + ( rate * 20 );
      } else {
	//else its just 20 to x * 10
	deduction = rate * 10;
      }
    }
    this.setDeductions(deduction);
  }
}
