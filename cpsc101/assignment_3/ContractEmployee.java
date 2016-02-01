/**The ContractEmployee class is a child of Employee whitch can handle contract Employees
* @author Kier Lindsay
**/

import java.util.Scanner;

class ContractEmployee extends Employee {
  
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