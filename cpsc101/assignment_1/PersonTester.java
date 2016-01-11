//import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Random;

import java.io.RandomAccessFile;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

public class PersonTester{


  //retuens a random line(name since there is a name on each line) form a file and retuensd it as a string
  //this method is modified form a stackoverflow post.
  //link to origanal post http://stackoverflow.com/a/19850005
  
  //NOTE only 4080 names can be generated after that the 
  //name fred will be used and filenotfound error wqill be printed
  public static String getRandomName() {
    String name = "Fred";
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
  public static String getFullName() {
    return getRandomName()+" "+getRandomName();
  }

  public static void main(String[] args) {
    
    ArrayList<Person> people = new ArrayList<Person>();
    people.add(new Person(getFullName()));
    //people.get(0).say("");
    
    Random rand = new Random();
    int population = rand.nextInt(1500) + 501;
    for(int i = 0; i < population; i++) {
      people.add(new Person(getFullName()));
      people.get(i).sayHello();
    }
    System.out.print("In  small town called Randville there are "+population+" people living their lives.\n");
    System.out.print("");
    
  }
}
