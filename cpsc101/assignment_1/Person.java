/**
* Made By:
*  Kier Lindsay
*  Raymond Strohschein
**/
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Person {

/**Variables**/

private static int population = 0;
private static int alive = 0;
private static Person lastPerson = null;

private Person murderer;
private Person previousPerson;
private String name;
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
    if(isAlive) {
      isAlive=false;
      alive--;
    }
 }
  
  //is uses to make a person murder another person,  makes the murderer of a person knowen to that person.
  public void murder(Person victim) {
    victim.die();
    victim.murderer = this;
  }
  
  //causes a person to say hello,  dead persons canot say hello
  public void sayHello() {
    if(isAlive) {
      System.out.print(name+":  Hello, I'm " + name +"?\n");
    }
  }
  //causes a person to say somthing
  //hopefully you dont mind me adding this public method it just makes writing my store a lot easy
  public void say(String wordsToSay) {
    if(isAlive) {
      System.out.print(name+":  "+wordsToSay+"\n");
    }
  } 
  //so it dosent break with no argument :)
  public void say() {
    if(isAlive) {
      System.out.print(name+":  \n");
    }
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
  
  //causes every living person to say somthing
  //hopefully you dont mind me adding this public method it just makes writing my store a lot easy
  public static void allSay(String wordsToSay) {
    Person currentPerson = lastPerson;
    while(currentPerson != null) {
      currentPerson.say(wordsToSay);
      currentPerson = currentPerson.previousPerson;
    }
  }
  //so it dosent break with no argumetns :)
  public static void allSay() {
    Person currentPerson = lastPerson;
    while(currentPerson != null) {
      currentPerson.say("");
      currentPerson = currentPerson.previousPerson;
    }
  }
}
