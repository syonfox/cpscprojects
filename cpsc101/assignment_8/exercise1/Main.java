/**This is the main class for the Employee report program.
* @author Kier Lindsay
**/
package exercise1;

import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Main {


  public static void processReport( Reader in, Writer out ) throws IOException {
    Report report = new Report( out );
    report.writeHeader();

    Scanner sc = new Scanner( in );

    Employee current = null;
    String eType;
    while( sc.hasNext() ) {
      //gets first paramiter in the file
      eType = sc.next();
      //makes the corasponding Employee
      switch(eType) {
	      case "FT":  current = new FullTimeEmployee(); break;
	      case "PT":  current = new PartTimeEmployee(); break;
	      case "CO":  current = new ContractEmployee(); break;
	      default:
          System.out.println("Error: UnknowenEmployeeType - Cheack configuration file and format.");
          System.exit(0);
      }
      //gives the rest of the line to the Employee
      current.setDefaultData();
      current.readDetailsFrom(sc);
      current.calculateNeededResults();
      //writes the Employee to the file
      report.writeLine(current);

    }
    //finishes the report
    report.writeReportTotals();
    report.finish();
  }

  private static void employeeTest() {
    System.out.println("Starting employeeTest");
    System.out.println("Making e1");
    ContractEmployee e1 = new ContractEmployee();
    e1.setDefaultData();
    System.out.println("Making e2 with copy constructor");
    ContractEmployee e2 = new ContractEmployee(e1);
    System.out.println("Making e3 with clone");
    ContractEmployee e3 = e1.clone();

    System.out.println("e1.getEClass() == e3.getEClass:" + (e1.getEClass() == e3.getEClass()));	
  }

  public static void main(String[] args) {

    //makes sure one argument is given

    employeeTest();

    if( args.length == 0 ) {
      System.out.println( "Error: NoInputFile - Please give a input file as parameter one" );
      System.exit( 0 );
    }

    File file = new File(args[0]);
    //makes it so that there shouldent be io exeptions
    if( !file.exists() ) {
      System.out.println( "Error: FileNotFound - No file found at "
	                        + file.getAbsolutePath() + " Could not be found");
      System.exit(0);
    } else if( !file.canRead() ) {
      System.out.println( "Error: CannotReadFile - Program Unable to read file at "
	                        + file.getAbsolutePath() + ", Cheack Permision");
      System.exit(0);
    }

    File out;
    if( args.length == 1 ) {
      out = new File( "Employee_Report.txt" );
      System.out.println( "No Output File Declared, using " + out.getAbsolutePath() );
    } else {
      out = new File( args[1] );
      System.out.println( "Output File Declared as " + out.getAbsolutePath() );
    }

    if(out.exists() && !out.canWrite() ) {
      System.out.println( "Error: CannotWriteToFile - Program Unable to write to file at "
	                        + file.getAbsolutePath() + ", Cheack Permision");
    }

    try {
      Reader reader = new FileReader(file);
      Writer writer = new FileWriter(out);
      processReport(reader , writer);
    } catch(IOException e) {
      System.out.println("Error: IOException" );
    }

  }
}
