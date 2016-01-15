/**
* cpsc101 lab 1
* date: January 2016
* Made By:
*  Kier Lindsay
**/


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
    
    
    //makes a list for the people to be in 
    ArrayList<Person> people = new ArrayList<Person>();
      
    //decuses the population of random vile  
    Random rand = new Random();
    int numberOfPeople = rand.nextInt(200) + 10;
    
    //create person objects in the people array
    for(int i = 0; i < numberOfPeople; i++) {
      people.add(new Person(getFullName()));
    }
    
    //start of the story
    System.out.print("In  small town called Random Ville there are "+Person.numberLiving()+" people living happy.\n");
    
    int murdererCount = rand.nextInt(10) + 1;
    System.out.print("Sadly this town has a few("+murdererCount+") murderers in it who plan to go on a rampage!\n");
    
    //picks the murderers
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
      
    } 
    System.out.print("Let the murderers say Hello!\n");
    
    for(int i = 0; i < murderers.size(); i++) {
      people.get(murderers.get(i)).sayHello();
    }
    System.out.println();
    System.out.print("Every night each murderer plans to kill one person.\n\n");
    int day = 1;
    while(murderers.size()>0){
      System.out.print("Day: "+ day + "\n");
      
      for(int i = 0; i < murderers.size(); i++) {
	boolean noMurder = true;
	int temp = 0;
	while(noMurder) {
	  temp = rand.nextInt( people.size() );
	  if(people.get(temp).isAlive()) {
	    
	    if(murderers.get( i ) == temp) {
	      System.out.print( people.get( murderers.get( i ) ).name() + " committed seppuku!\n");
	      
	    }
	    else System.out.print( people.get( murderers.get( i ) ).name() + " murdered " + people.get( temp ).name()+"!\n");
	    
	    people.get( murderers.get( i ) ).murder( people.get( temp ) );
	    //System.out.println(people.get(temp).name() );
	    noMurder = false;
	    
	    
	    for(int j = 0; j < murderers.size(); j++) {
	      if(temp == murderers.get(j)) {
		
		
		//we need to decrement the for loop as the murderer array is one smaller now and all
		//the fallowing murderers are shifted one spot down in the array
		//we only need to do this if someone bofore or at our cutrrent position is killed.
		if(murderers.get(j)<=i) {
		  murderers.remove(j);
		  i--;
		}else {
		  murderers.remove(j);
		}
		break;
	      }
	    }
	    
	  }
	}
      }
    System.out.println();
    day++;
    }
    
    System.out.println( Person.numberLiving() + " People survived the killing spree.  \nAs the survivors come out form hiding they all introduce themselves.\n" );
    Person.allSayHello();
    
  }
}
