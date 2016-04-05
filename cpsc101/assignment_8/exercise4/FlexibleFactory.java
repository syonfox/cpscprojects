
package exercise4;
import java.io.File;

public class FlexibleFactory implements EmployeeFactory {
  //emp is short for Employee
  private java.util.TreeMap<String, Employee> empCodeLinks;
  public FlexibleFactory()
  {
    empCodeLinks = new java.util.TreeMap<String, Employee> () ;
    //setupFactory();
    detectEmployees();
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
  private void detectEmployees() {
    File dir = new File(".");
    String[] files = dir.list();
    Object o;
    for(int i = 0; i < files.length; i++) {
      if(files[i].endsWith(".class")) {
        o = null;
        try {
          Class c = Class.forName("exercise4."+files[i].substring(0,files[i].length()-6));
          o = c.getConstructor().newInstance();
          if(o instanceof Employee) {
            Employee e = (Employee) o;
            addLink(e.getCode(), e);
          }
        } catch(Throwable x) {}

      }
    }
  }

}
