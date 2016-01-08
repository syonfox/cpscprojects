import java.io.RandomAccessFile;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

public class PersonTester{


  //retuens a random line(name since there is a name on each line) form a file and retuensd it as a string
  //this method is modified form a stackoverflow post.
  //link to origanal post http://stackoverflow.com/a/19850005
  
  //NOTE only 4080 names can be generated after that the name fred will be used
  public static String getRandomName()
  {
    String name = "FRED";
    try{
      RandomAccessFile f = new RandomAccessFile("namelist", "r");
      long randomLocation = (long) (Math.random() * f.length());
      f.seek(randomLocation);
      f.readLine();
      name = f.readLine();
    
    } catch(FileNotFoundException e) {
      System.out.println("Error: namelist File Not found");
    } catch(IOException e) {
      System.out.println("Error: IO Exeption");
    }
    
    return name;
  }

  public static void main(String[] args) {
    
    for(int i=0;i<4080;i++) {
      String name = getRandomName();
      System.out.println(i+" - "+name);
    }
  }
}
