/**This is the emplyee factor class
* @author David Casperson / lab 8 creator
* this was essentialy copyed from the lab.
**/
package exercise2;
public interface EmployeeFactory {
  abstract public void addLink(String employeeCode, Employee example) ;
  abstract public Employee getFreshEmployee(String employeeCode) ;
}
