/**The PartTimeEmployee class is a child of Employee whitch can handle parttime Employees
* @author Kier Lindsay
**/
package exercise1;
import java.util.Scanner;

public class PartTimeEmployee extends Employee {

  //I dont think I need constructors here since the employey constructor should work
  //and it should be used when a subemploye is created
  public PartTimeEmployee() {
    //do nothing
  }
  public PartTimeEmployee(PartTimeEmployee fte) {
    super();
  }
  public PartTimeEmployee clone() {
    return new PartTimeEmployee(this);
  }

  public String getCode() {
    return "PT";
  }

  public void setDefaultData() {
    this.setEClass( "PT" );
    this.setCommision( 0 );
    this.setOther( 0 );
  }

  public void readDetailsFrom(Scanner in) {
    this.setENum( in.next() );
    this.setHours( in.nextDouble() );
    this.setRate( in.nextDouble() );
  }

  public void calculateNeededResults() {
    this.calculateDeductions();
    this.calculateTakeHome();
  }

  //same as fulltime Employee but with ernings rather then rates
  public void calculateDeductions() {
    double deduction = 0;
    double earnings = this.getRate() * this.getHours();
    if( earnings > 200 ) {
      earnings -= 200;
      if ( earnings > 300 ) {
	earnings -= 300;
	deduction = 30 + ( earnings * 0.30 );
      } else {
	deduction = earnings * 0.1;
      }
    }
    this.setDeductions( deduction );
  }
}
