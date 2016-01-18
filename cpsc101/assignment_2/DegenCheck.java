/**This class cheacks if a word is a Degenerative word with more then 6 constanents and returns a boolian 
* date: January 2016
* @author Kier Lindsay
**/

import java.text.Normalizer;



class DegenCheck {



/** Replaces acented characters with their non-acented equvalents, Source: http://stackoverflow.com/a/15190787 **/
  private static String stripAccents(String s) {
    s = Normalizer.normalize(s, Normalizer.Form.NFD);
    s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
    return s;
  }
  //removes all non alphabetic caractes suck as ' or . from the word
  /** Removes all non alpabetic characters, converts to lower case and strips accents. **/
  private static String strip(String word) {
    word = stripAccents(word);
    word = word.toLowerCase();
    word = word.replaceAll("[^a-z]", "");
    return word;
  }
  
  /** Retuens true if a word is a Degenerative word with more then 6 constanents **/
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