/**Main class, uses FileManager and DegenCheck to take a filev of line seperated 
words and print the Degenerative words with more then 6 constanents to both a 
file and to System.out
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

/*aprice notes

file into an Array  aray list?
  if less then 6 cars deleat
  else remoce vawals
    if less then 6 cars w/ no vawals deleate
    else if inorder dont deleate
*/
/** Main takes no arguments but must have file names set inside of it **/
public class Main {
  
  public static void main(String[] args) {
  
    String inputFile = "words";
    FileManager words = new FileManager(inputFile);
    words.loadToArrayList();
    //words.printFile();
    
    String outputFile = "luminarist.txt";
    FileManager luminarist = new FileManager(outputFile);
    
    ArrayList<String> wordsArray = words.getArrayList();
    for(int i = 0; i < wordsArray.size(); i++) {
      if(DegenCheck.isDegen(wordsArray.get(i))) {
	luminarist.append(wordsArray.get(i));
      }
    }
    
    luminarist.writeToFile();
    luminarist.printFile();
  }
}