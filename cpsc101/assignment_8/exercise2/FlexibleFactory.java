
package exercise2;
import java.io.File;

public class FlexibleFactory implements EmployeeFactory {
  //emp is short for Employee
  private java.util.TreeMap<String, Employee> empCodeLinks;
  public FlexibleFactory()
  {
    empCodeLinks = new java.util.TreeMap<String, Employee> () ;
    setupFactory();

  }
  public void addLink(String empCode, Employee empClass) {
    boolean linkNotAdded = (empCodeLinks.get(empCode) == null);
    if(linkNotAdded) empCodeLinks.put(empCode, empClass);
  }
  public Employee getFreshEmployee(String empCode) {
    Employee e = empCodeLinks.get(empCode);

    if(e==null)  { //yes im making yopu know what type of rmployey your loading
      System.out.println("Error: UnknowenEmployeeCode - Cheack configuration file and format.");
      System.exit(0);
    }
    return e.clone();
  }

  private void setupFactory() {
    addLink("FT", new FullTimeEmployee());
    addLink("PT", new PartTimeEmployee());
    addLink("CO", new ContractEmployee());
  }
}
