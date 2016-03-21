/**
* @author Kier Lindsay
* @since 2016-03-20
**/

package cpsc101.klindsay.lab7.crossword;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JViewport;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Font;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;


public class CrossWordGUI extends JFrame {

  public CrossWordGUI(String fileName) {
    //System.out.println("Made cwGUI");
    setTitle("Cross Word");
    setSize(800, 600);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());

    String[] cwConfig = readFile(fileName);
    //System.out.println("read file");
    //Makes a crossword panel with the suplied config file
    CrossWordPanel cwP = new CrossWordPanel(cwConfig);
    //System.out.println("made CrossWordPanel");

    //Scrole paint because resizable = true :D
    JScrollPane cwSP = new JScrollPane(cwP);
		cwSP.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		cwSP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		cwSP.getViewport().setScrollMode(JViewport.SIMPLE_SCROLL_MODE);

    //A text area for the words
    JTextArea listTA = new JTextArea();
    listTA.setEditable(false);
    listTA.setFont(new Font("monospaced", Font.PLAIN, 12));
    String strToAppend = String.format("%-15s%-15s\n", "Horazontal:", "Vertical:");
    listTA.append(strToAppend);
    //it was easyer  to just parse the config file in the CrossWordPanel
    //and take this list out.
    String[] hWords = cwP.getHorzWords();
    String[] vWords = cwP.getVirtWords();
    int i = 0;
    int j = 0;
    //while we arnot at the end of the arrays
    //This has a bunch of if statments just to avoid null pointers
    //it makes strings that will fo in the textarea
    while(i < hWords.length || j < vWords.length ) {
      //if bothe are in the arrays
      if(i < hWords.length && j < vWords.length ) {
        //if both have somthing at their respectiv index
        if(!hWords[i].equals("") && !vWords[j].equals("")) {
          //make that string
          strToAppend = String.format("%-15s%-15s\n", (i+1)+". "+hWords[i], (j+1)+". "+vWords[j]);
          listTA.append(strToAppend);
          //increment both
          i++;
          j++;
        }
      }

      //if i is in the range
      if(i < hWords.length) {
        //if j is above and i still has somthing
        if(!hWords[i].equals("") && j >= vWords.length) {
          strToAppend = String.format("%-15s%-15s\n", (i+1)+". "+hWords[i], "");
          listTA.append(strToAppend);
          i++;
        } else if(hWords[i].equals("")) i++;
      }

      //if j is in the range
      if(j < vWords.length) {
        //if i is abouth and j still has somthing
        if( i >= hWords.length && !vWords[j].equals("")) {
          strToAppend = String.format("%-15s%-15s\n", "", (j+1)+". "+vWords[j]);
          listTA.append(strToAppend);
          j++;
        } else if(vWords[j].equals("")) j++;
      }
    }

    //add the stuff
    add(cwSP, BorderLayout.CENTER);
    add(listTA, BorderLayout.EAST);

    setVisible(true);
  }

  //makes a string[] for the file you gave
  private static String[] readFile(String fn) {
    File file = new File(fn);
    ArrayList<String> fileLines = new ArrayList<String>();
    try {
      BufferedReader fileIn = new BufferedReader(new FileReader(file));

      String line = fileIn.readLine();
      while(line != null) {
        fileLines.add(line);
        line = fileIn.readLine();
      }
    } catch(FileNotFoundException e) {
      System.out.println("Error: " + file.getAbsolutePath() + " File Not found");
      System.exit(1);
    } catch(IOException e) {
      System.out.println("Error: IO Exeption");
      System.exit(1);
    }

    return fileLines.toArray(new String[fileLines.size()]);
  }

}
