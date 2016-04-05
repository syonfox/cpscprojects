/**This report class can be uses to make an employee report and is uses with the employee class.
* @author Kier Lindsay
**/

package exercise4;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.io.IOException;
import java.util.Formatter;

public class Report {

  private Writer out;
  private int maxLines;
  private int lineCount;
  private double pageTotalCommision;
  private double pageTotalOther;
  private double pageTotalDeductions;
  private double pageTotalTakeHome;
  private double reportTotalCommision;
  private double reportTotalOther;
  private double reportTotalDeductions;
  private double reportTotalTakeHome;


  public Report(Writer o) {
    out = o;
    maxLines = 50;
    lineCount = 0;

    pageTotalCommision = 0;
    pageTotalOther = 0;
    pageTotalDeductions = 0;
    pageTotalTakeHome = 0;
    reportTotalCommision = 0;
    reportTotalOther = 0;
    reportTotalDeductions = 0;
    reportTotalTakeHome = 0;

  }

  private static String getSpaces(int length , String s) {
    int numOfSpaces = length - s.length();
    String spaces = "";
    if(numOfSpaces <= 0){
      System.out.println(
         "Warning: ValueToBigForFormating - One of the values is to big for the report formating,\n"
			  +"         report will still be generated but one line with not be aligned properly.");
      return " ";
    }
    for(int i=0; i<numOfSpaces; i++) {
      spaces = spaces+" ";
    }
    return spaces;
  }


  private void addToTotals(Employee e) {
    pageTotalCommision += e.getCommision();
    pageTotalOther += e.getOther();
    pageTotalDeductions += e.getDeductions();
    pageTotalTakeHome += e.getTakeHome();
    reportTotalCommision += e.getCommision();
    reportTotalOther += e.getOther();
    reportTotalDeductions += e.getDeductions();
    reportTotalTakeHome += e.getTakeHome();
  }

  public boolean canWrite(int xLines) {
    if(lineCount+xLines <= maxLines) return true;
    return false;
  }
  private void writePageTotal() throws IOException {
    out.write( "----------------------------------------------------------------------------\n"
	     + "Page Commision        Page Other        Page Deductions       Page Take Home\n"
	     + "----------------------------------------------------------------------------\n"
	     + getSpaces(14 , String.format("%.2f", pageTotalCommision ) ) + String.format("%.2f", pageTotalCommision )
	     + getSpaces(18 , String.format("%.2f", pageTotalOther ) ) + String.format("%.2f", pageTotalOther )
	     + getSpaces(23 , String.format("%.2f", pageTotalDeductions ) ) + String.format("%.2f", pageTotalDeductions )
	     + getSpaces(21 , String.format("%.2f", pageTotalTakeHome ) ) + String.format("%.2f", pageTotalTakeHome )
	     + "\n");
  }
  public void newPage() throws IOException {
    out.write("\f");

    lineCount=0;
    pageTotalCommision = 0;
    pageTotalOther = 0;
    pageTotalDeductions = 0;
    pageTotalTakeHome = 0;
  }

  public void writeHeader() throws IOException {

    if(!canWrite(7)) {
      writePageTotal();
      newPage();
      writeHeader();
    }

    out.write( "Employee  Employee  Hours/    Rate/   Commision   Other  Deductions  Take\n"
	     + "Class     Number    Week      Hour                                   Home\n"
	     + "----------------------------------------------------------------------------\n" );
    lineCount+=3;

  }

  public void writeLine(Employee e) throws IOException {

    if(!canWrite(5)) {
    writePageTotal();
      newPage();
      writeHeader();
    }

    String strToWrite = e.getEClass() + "        " + e.getENum();
    String temp;
    temp = String.format( "%.1f", e.getHours() );
    strToWrite += getSpaces(10 , temp) + temp;
    temp = String.format( "%.2f", e.getRate() );
    strToWrite += getSpaces(10 , temp) + temp;
    temp = String.format( "%.2f", e.getCommision() );
    strToWrite += getSpaces(11 , temp) + temp;
    temp = String.format( "%.2f", e.getOther() );
    strToWrite += getSpaces(9 , temp) + temp;
    temp = String.format( "%.2f", e.getDeductions() );
    strToWrite += getSpaces(12 , temp) + temp;
    temp = String.format( "%.2f", e.getTakeHome() );
    strToWrite += getSpaces(9 , temp) + temp;
    strToWrite += "\n";
    out.write(strToWrite);
    lineCount += 1;
    addToTotals(e);
  }

  public void writeReportTotals() throws IOException {
    writePageTotal();
    if(!canWrite(4)) {
      newPage();
    }
    out.write( "----------------------------------------------------------------------------\n"
	     + "Report Commision    Report Other      Report Deductions     Report Take Home\n"
	     + "----------------------------------------------------------------------------\n"
	     + getSpaces(14 , String.format("%.2f", reportTotalCommision ) ) + String.format("%.2f", reportTotalCommision )
	     + getSpaces(18 , String.format("%.2f", reportTotalOther ) ) + String.format("%.2f", reportTotalOther )
	     + getSpaces(23 , String.format("%.2f", reportTotalDeductions ) ) + String.format("%.2f", reportTotalDeductions )
	     + getSpaces(21 , String.format("%.2f", reportTotalTakeHome ) ) + String.format("%.2f", reportTotalTakeHome )
       + "\n" );

  }

  public void finish() throws IOException {
    out.close();
  }

}
