/**
* @author Kier Lindsay
* @since 2016-03-20
**/

package cpsc101.klindsay.lab7;

import cpsc101.klindsay.lab7.crossword.CrossWordGUI;

public class Main {

  public static void main(String[] args) {
    if (args.length > 0) {
      CrossWordGUI cw = new CrossWordGUI(args[0]);
    } else {
      System.out.println("Error: No File Given - Please give a input file as the first command line agument.");
    }
  }

}
