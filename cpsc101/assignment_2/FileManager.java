/**
* cpsc101 lab 2
* date: January 2016
* Made By:
*  Kier Lindsay
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
//  hopfully be able to be reuesd in the future :D
class FileManager {

  private File file;
  private ArrayList<String> fileLines;
  
  public FileManager(String filePath) {
  
    file = new File(filePath);
    
    /*if (!file.exists()) {
      System.out.print("The file: "+ filePath + " Does not exist.\n");
    } else if (!file.canRead()) {
      System.out.print("The file: "+ filePath + " can not be read.\n");
    }*/
    
    fileLines = new ArrayList<String>();
  }
  
  
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
  
  public void printFile() {
    if(fileLines.isEmpty()) {
      System.out.print("Cannot Print File, If you jave not loaded the file or the file is empty/doesnt exist you canot print it."); 
    } else {
      for(int i = 0; i < fileLines.size(); i++) {
	System.out.print(fileLines.get(i)+ "\n");
      }
    }
  }
  
  public ArrayList<String> getArrayList() {
    return fileLines;
  }
  
  public void append(String stringToAppend) {
    fileLines.add(stringToAppend);
  }
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