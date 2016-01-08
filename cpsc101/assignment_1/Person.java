/**
* Made By:
*  Kier Lindsay
*  Raymond Strohschein
**/
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Person {
//Variables
private static int population = 0;
private static int alive = 0;




private String name;

private Person murderer;
private Person previousPerson;
private static Person lastPerson = null;
private boolean isAlive;


  /**Constructor**/
  
  public Person(String n) {
    name = n;
    murderer = null;
    isAlive = true;
    population++;
    alive++;
    
    previousPerson = lastPerson;
    lastPerson = this;
    
    
    
    
    
    
  }
 
 /**Attributes**/
 
 //returns this persons murderer, Murderer is set when somone is murdered( see the murder method ).
  public Person murderer() {
    return this.murderer;
  }
  
  //return a persons name, if the person is dead it adds deceased after their name.
  public String name() {
    String returnString = name;
    if(!isAlive) returnString += ", deceased" ;
    return returnString;
  }
  
  //boolean method to cheack wether a person is alive or not
  public boolean isAlive() {
    if(isAlive) {
      return true;
    } else {
      return false;
    }
  }
  
 /**Actions**/
 
  //causes a person to die and changes the number of alive persons
  public void die() {
    isAlive=false;
    alive--;
 }
  
  //is uses to make a person murder another person,  makes the murderer of a person knowen to that person.
  public void murder(Person victim) {
    victim.die();
    victim.murderer = this;
  }
  
  //causes a person to say hello,  dead persons canot say hello
  public void sayHello() {
    System.out.print("Hello, I'm " + name +"?\n");
  }
 
 
  /**Class Attributes**/
  
  //returtns the number of living persons
  public static int numberLiving() {
    return alive;   
  }
  
  //returns the number of dead persons
  public static int numberDead() {
    int dead = population - alive;
    return dead;
  }
  
  /**Class Actions**/
  //causes every living person to say hello
  public static void allSayHello() {
    Person currentPerson = lastPerson;
    while(currentPerson != null) {
      currentPerson.sayHello();
      currentPerson = currentPerson.previousPerson;
    }
    
  }
}
