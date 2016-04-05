
/**This class is Made to Manage Files, Once you make a filemanager you can easily perfom a variaty of operations on the file including reading and writing.
* date: January 2016
* @author Kier Lindsay
**/



import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;


//  I know making this class is more work then I need to do but it will
//  hopefully be able to be reused in the future :D
class FileManager {
  /** file is a file object that links to the file's path **/
  private File file;
  /** that ArrayList filelines is uses to store a file within the fileManager **/
  private ArrayList<String> fileLines;

  /** Constuctor takes a file path as a string and makes the file, it also initalizes fileList **/
  public FileManager(String filePath) {

    file = new File(filePath);


    fileLines = new ArrayList<String>();
  }

  /** Loads a file into an ArrayList (fileLines) **/
  public void loadToArrayList() {
    if(fileLines.isEmpty()) {
      try {
	BufferedReader fileIn = new BufferedReader(new FileReader(file));

	String line = fileIn.readLine();
	while(line != null) {
	  fileLines.add(line);
	  line = fileIn.readLine();
	}

      } catch(FileNotFoundException e) {
	System.out.println("Error: " + file.getAbsolutePath() + " File Not found");
      } catch(IOException e) {
	System.out.println("Error: IO Exeption");
      }
    }
  }

  /** prints a file (must be loaded into an ArrayList first) **/
  public void printFile() {
    if(fileLines.isEmpty()) {
      System.out.print("Cannot Print File, If you jave not loaded the file or the file is empty/doesnt exist you canot print it.");
    } else {
      for(int i = 0; i < fileLines.size(); i++) {
	System.out.print(fileLines.get(i)+ "\n");
      }
    }
  }

  /** Returns the file as an ArrayList **/
  public ArrayList<String> getArrayList() {
    return fileLines;
  }

  /** Appends a string to the end of the ArrayList that represents a file **/
  public void append(String stringToAppend) {
    fileLines.add(stringToAppend);
  }

  /** Writes a file from its ArrayList, this must be run for a file to be changed or created **/
  public void writeToFile() {
    try {

      file.delete();
      file.createNewFile();
      BufferedWriter fileOut = new BufferedWriter(new FileWriter(file));

      for(int i = 0; i < fileLines.size(); i++) {
	fileOut.write(fileLines.get(i));
	fileOut.newLine();
      }
      fileOut.close();
    } catch(IOException e) {
      System.out.println("Error: IO Exeption");
    }
  }


}
