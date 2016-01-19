/**This class checks if a word is a Degenerative word with more then 6 consonants and returns a boolean 
* date: January 2016
* @author Kier Lindsay
**/

import java.text.Normalizer;



class DegenCheck {


/** Replaces accented characters with their non-accented equivalents, Source: http://stackoverflow.com/a/15190787 **/
  private static String stripAccents(String s) {
    s = Normalizer.normalize(s, Normalizer.Form.NFD);
    s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
    return s;
  }
  //removes all non alphabetic characters such as ' or . from the word
  /** Removes all non alphabetic characters, converts to lower case and strips accents. **/
  private static String strip(String word) {
    word = stripAccents(word);
    word = word.toLowerCase();
    word = word.replaceAll("[^a-z]", "");
    return word;
  }
  
  /** Returns true if a word is a Degenerative word with more then 6 consonants **/
  public static boolean isDegen(String word) {
    //strips the word
    word = strip(word);
    //false until proven true
    boolean isDegen = false;
    //if the words smaller then 6 chars we dont need to bother
    if(word.length()>5) {
      //remove vowels
      word = word.replaceAll("[aeiouy]", "");
      //if its smaller then 6 chars after removing vowels we still dont have to bother
      if(word.length()>5) {
	//for each consonant in the word (skipping the first one so we can do (i-1) insted of (i+1))
	//thus avoiding null pointer exceptions
	for(int i = 1; i < word.length(); i++) {
	  if(word.charAt(i) < word.charAt(i-1)) {
	    isDegen = false;
	    //once this is false once we dont have to check the rest.
	    break;
	  } else isDegen = true;
	}
      } else isDegen = false;
    } else isDegen = false;
    return isDegen;
  }
}
