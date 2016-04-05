/**The Employee class is a base class for multipul employclasses and is not verry usefull withough children.
* @author Kier Lindsay
**/

package exercise4;
import java.util.Scanner;


//Employee is abstrace becuse Im not allowing unknowen Employee types.
//so in order to make an Employee you nees to have a subclass.
public abstract class Employee {
  //the e in eClass, eNum, getEClass etc stands for employee
  private String eClass;
  private String eNum;
  private double hours;
  private double rate;
  private double commision;
  private double other;
  private double deductions;
  private double takeHome;

  /**Do nothing constructor*/
  public Employee(){
    //do nothing
  }

  /**copy constructor
  *	@param e The employee to copy from
  */
  public Employee(Employee e) {
    this.eClass = e.getEClass();
    this.eNum = e.getENum();
    this.hours = e.getHours();
    this.rate = e.getRate();
    this.commision = e.getCommision();
    this.other = e.getOther();
    this.deductions = e.getDeductions();
    this.takeHome = e.getTakeHome();
  }

  /**Returns a clone of this*/
  @Override
  public abstract Employee clone();
  public abstract String getCode();
  //lots of setters and getters for the children to use.
  //the setters could and probubaly should be protected.
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


  public abstract void readDetailsFrom(Scanner in);

  public abstract void calculateNeededResults();

  public abstract void setDefaultData();

  public void calculateTakeHome() {
    double takeHome = ( this.getRate() * this.getHours()) + this.getOther()
		                  + this.getCommision() - this.getDeductions();
    this.setTakeHome( takeHome );
  }
}
