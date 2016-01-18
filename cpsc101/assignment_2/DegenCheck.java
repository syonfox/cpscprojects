/**
* cpsc101 lab 2
* date: January 2016
* Made By:
*  Kier Lindsay
**/

import java.text.Normalizer;



class DegenCheck {


//taken from http://stackoverflow.com/a/15190787
//replaces acented characters suck as e hat with there non accented equivalent
//
public static String stripAccents(String s) {
    s = Normalizer.normalize(s, Normalizer.Form.NFD);
    s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
    return s;
}
  //removes all non alphabetic caractes suck as ' or . from the word
  private static String strip(String word) {
    word = stripAccents(word);
    word = word.toLowerCase();
    word = word.replaceAll("[^a-z]", "");
    return word;
  }

  public static boolean isDegen(String word) {
    //strips the word
    word = strip(word);
    //false untill proven true
    boolean isDegen = false;
    //if the words smaller then 6 chars we dont need to bother
    if(word.length()>5) {
      //remove vowals
      word = word.replaceAll("[aeiouy]", "");
      //if its smaller then 6 chars after removing vowals we still dont have to bother
      if(word.length()>5) {
	//for each constanent in the word (skiping the fist one so we can do (i-1) insted of (i+1))
	//thus avoiding null pointer exeptions
	for(int i = 1; i < word.length(); i++) {
	  if(word.charAt(i) < word.charAt(i-1)) {
	    isDegen = false;
	    //once this is false once we dont have to cheack the rest.
	    break;
	  } else isDegen = true;
	}
      } else isDegen = false;
    } else isDegen = false;
    return isDegen;
  }


}