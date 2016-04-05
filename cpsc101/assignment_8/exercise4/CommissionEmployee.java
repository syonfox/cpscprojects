/**The FullTimeEmployee class is a child of Employee whitch can handle fulltime Employees
* @author Kier Lindsay
**/

package exercise4;
import java.util.Scanner;

public class CommissionEmployee extends Employee {


 public CommissionEmployee() {
   //do nothing
 }
 public CommissionEmployee(CommissionEmployee cme) {
   super();
 }
 public CommissionEmployee clone() {
   return new CommissionEmployee(this);
 }

 public String getCode() {
   return "CM";
 }

 public void setDefaultData() {
   this.setEClass( "CM" );
   this.setHours( 37.5 );
 }

 public void readDetailsFrom(Scanner in) {
   this.setENum( in.next() );
   this.setRate( in.nextDouble() );
   this.setCommision( in.nextDouble() );
   this.setOther( in.nextDouble() );
 }

 public void calculateNeededResults() {
   this.calculateDeductions();
   this.calculateTakeHome();
 }

 //calculates deduction
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
   deduction += 0.15 * this.getCommision();

   this.setDeductions( deduction );
 }
}
