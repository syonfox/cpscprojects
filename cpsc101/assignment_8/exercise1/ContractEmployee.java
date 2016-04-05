package exercise1;
import java.util.Scanner;

public class ContractEmployee extends Employee {

  public ContractEmployee() {
    //do nothing
  }
  public ContractEmployee(ContractEmployee fte) {
    super();
  }
  public ContractEmployee clone() {
    return new ContractEmployee(this);
  }

  public void setDefaultData() {
    this.setEClass( "CO" );
    this.setCommision( 0 );
    this.setHours( 0 );
    this.setRate( 0 );
    this.setDeductions( 0 );
  }

  public void readDetailsFrom( Scanner in ) {
    this.setENum( in.next() );
    this.setOther( in.nextDouble() );
  }

  public void calculateNeededResults() {
    this.calculateTakeHome();
  }
}
