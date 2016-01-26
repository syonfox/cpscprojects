



import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.io.IOException;

class Report {

  private Writer out;
  private int maxLines;
  
  public Report(Writer o) {
    out = o;
    maxLines = 50;
  }
  
  
  public void writeHeader() throws IOException {
    out.write( "Employee  Employee  Hours/    Rate/   Commision   Other  Deductions  Take\n"
	     + "Class     Number    Week      Hour                                   Home\n"
	     + "----------------------------------------------------------------------------\n" );
  }
  
  public void finish() throws IOException {
    out.close();
  }
  
}