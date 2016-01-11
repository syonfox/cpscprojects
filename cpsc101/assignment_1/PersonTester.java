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
    int numberOfPeople = rand.nextInt(15) + 5;
    for(int i = 0; i < numberOfPeople; i++) {
      people.add(new Person(getFullName()));
      //people.get(i).sayHello();
    }
    System.out.print("In  small town called Random Ville there are "+numberOfPeople+" people living their lives.\n");
    System.out.println( "alive:" + Person.numberLiving() + " , " + people.size() +" , "+numberOfPeople);
    
    
    
    
    
    int murdererCount = rand.nextInt(5) + 1;
    System.out.println(murdererCount);
    ArrayList<Integer> murderers = new ArrayList<Integer>();
    for(int i = 0; i < murdererCount; i++) {
      int temp = 0;
      boolean alreadyMurderer = true;
      while(alreadyMurderer) {
	alreadyMurderer=false;
	temp =rand.nextInt(numberOfPeople);
	for(int j = 0; j < murderers.size(); j++) {
	  if(temp == murderers.get(j)) {
	    alreadyMurderer=true;
	  }
	}
      }
      murderers.add(temp);
      
      //people.get(temp).sayHello();
      
    }
    
    
    //System.out.println( Person.numberLiving() );
    
    while(murderers.size()>0){
      for(int i = 0; i < murderers.size(); i++) {
	boolean noMurder = true;
	int temp = 0;
	while(noMurder) {
	  temp = rand.nextInt( people.size() );
	  if(people.get(temp).isAlive()) {
	    
	    System.out.print( people.get( murderers.get( i ) ).name() + " murdered " + people.get( temp ).name()+"!\n");
	    people.get( murderers.get( i ) ).murder( people.get( temp ) );
	    //System.out.println(people.get(temp).name() );
	    noMurder = false;
	    
	    for(int j = 0; j < murderers.size(); j++) {
	      if(temp == murderers.get(j)) {
		murderers.remove(j);
		break;
	      }
	    }
	    
	  }
	}
      }
      
     
    }
    
  //  for(int j = 0; j < murderers.size(); j++) {
     // murderers.get(j).name();
    //}
    //Person.allSay("hi");
   // while(population>1)
    Person.allSayHello();
    System.out.println( Person.numberLiving() );
  }
}
