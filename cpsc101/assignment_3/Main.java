/**Stuff
* @author Kier Lindsay
**/

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
    
    Employee current;
    String eType;
    while( sc.hasNext() ) {
      
      eType = sc.next();
      System.out.println(eType);
      switch(eType) {
	case "FT":  current = new FullTimeEmployee(); break; 
	//case "PT":  current = new Parttime(); break;
	//case "CO":  current = new Contract(); break;
	default: System.out.println("Bad config"); current = new Employee(); System.exit(0);
      }
      current.readDetailsFrom(sc);
    }
    
    report.finish();
  }


  public static void main(String[] args) {
  
    if( args.length == 0 ) {
      System.out.println( "Error: NoInputFile - Please give a input file as parameter one" );
      System.exit( 0 );
    } 
    
    File file = new File(args[0]);
    
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