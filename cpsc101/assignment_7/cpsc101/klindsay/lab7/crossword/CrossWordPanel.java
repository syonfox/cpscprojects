/**
* @author Kier Lindsay
* @since 2016-03-20
**/

package cpsc101.klindsay.lab7.crossword;

import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.geom.Rectangle2D;


public class CrossWordPanel extends JPanel{

  private int cwH, cwW;
  private String[] lines;
  private Color[][] background;
  private String[][] letter;
  private int[][] number;
  private ArrayList<String> hWords;
  private ArrayList<String> vWords;
  private int boxW, boxH;
  private Font numberFont, letterFont;
  //private FontMetrics letterFM;

  public CrossWordPanel(String[] cwConfig) {
    //make sure that the file we hot has the two starting numbers
    //if is to avoid null pointer exeption
    if(cwConfig.length < 2) {
      System.out.println("Error: Bad Config File - please make sure that you entered a valid config.");
      System.exit(1);
    }
    try {
      cwH = Integer.parseInt(cwConfig[0]);
      cwW = Integer.parseInt(cwConfig[1]);
    } catch(NumberFormatException e) {
      System.out.println("Error: Bad Config File - please make sure that you entered a valid config.");
      System.exit(1);
    }
    //sets the number font, the other font is set in draw as it is size dependent
    numberFont = new Font ("Terminal", 1, 12);

    //sets the preferd dimeson based on the min box size
    setPreferredSize(new Dimension(50*cwW, 50*cwH));
    //makes an array of only the data (not the top two lines)
    lines = new String[cwConfig.length-2];
    for(int i = 0, j = 2; i < lines.length; i++, j++) {
      //makes sure that the top two lines didnt lie as we uses them alot
      if(cwConfig[j].length()<cwW) {
        System.out.println("Error: Bad Config File - please make sure that you entered a valid config.");
        System.exit(1);
      }
      lines[i] = cwConfig[j];
    }

    //initalizes the arrays for the data
    background = new Color[cwH][cwW];
    letter = new String[cwH][cwW];
    number = new int[cwH][cwW];
    hWords = new ArrayList<String>();
    vWords = new ArrayList<String>();
    int numberCounter = 1; //a counter for the corner numbers starts at 1
    //the two for loops go through every charater or "box"
    //i is the vertical and j is horazontal for future refrance
    for(int i = 0; i < cwH; i++) {
      for(int j = 0; j < cwW; j++) {
        //System.out.println("(i,j): ("+i+","+j+")" ); //debug
        //if the char is an X its easy :D
        if(lines[i].charAt(j) == 'X') {
          background[i][j] = Color.BLACK;
          letter[i][j] = "";
          number[i][j] = 0;
        } else { //but when its not an X :C
          background[i][j] = Color.WHITE;
          //set the letter to the capitalized virsion of the one in the string
          letter[i][j] = String.valueOf(lines[i].charAt(j)).toUpperCase();

          //number is set to 0 by deafult if it stays 0 then no number is displayed
          number[i][j] = 0;

          //the VerticalHorazontal States this is used for the switch case
          //in order to find out what the horaxontal and virtical words are.
          //0 is neather 1 is horazontal word 2 is virtical word
          //and 3 is both
          int vhState = 0;

          //if j is not out of bounds
          if(j>=0 && j<cwW-1) {
            //if j is next to the left wall and the letter to its right is not an X
            if(j==0 && lines[i].charAt(j+1) != 'X') {
              number[i][j] = numberCounter; //(i,j) is a word start
              vhState += 1;
              //else if j has an X on its left and a letter on its Right
            } else if( j>0 && lines[i].charAt(j-1) == 'X' && lines[i].charAt(j+1) != 'X' ) {
              number[i][j] = numberCounter; //(i,j) is a word start
              vhState += 1;
            }
          }
          //if i is not out of bounds
          if(i>=0 && i<cwH-1) {
            //if i is nect to a wall and has a letter below it
            if( i==0 && lines[i+1].charAt(j) != 'X') {
              number[i][j] = numberCounter; //(i,j) is a word start
              vhState += 2;
              //else if i has a X on top and a letter Bellow
            } else if( i>0 && lines[i-1].charAt(j) == 'X' && lines[i+1].charAt(j) != 'X') {
              number[i][j] = numberCounter; //(i,j) is a word start
              vhState += 2;
            }
          }
          int k = 0; // a counter for in the switch statment
          String hWord = "";
          String vWord = "";
          //System.out.print(" got to switch "+vhState);  //debug
          //
          //this switch adds the words to the virtical and hoazontal word arrays
          //if there is for example only a horaxontal word it adds a epting string
          //to the virtical array this is so that the array indexes coraspond
          //to the number of the word
          switch(vhState){
            //if (i,j) is not a start of any words
            case 0:
              break;
            //if (i,j) is the stat of a horazontal word
            case 1:
              numberCounter++;
              k = 0;
              hWord = "";
              //while there are letters to the right
              while(lines[i].charAt(j+k) != 'X') {
                hWord += String.valueOf(lines[i].charAt(j+k));
                k++;
                if(j+k>=cwW) break;
              }
              hWords.add(hWord);
              vWords.add("");
              break;
            //if (i,j) is the stat of a vertical word
            case 2:
              numberCounter++;
              k = 0;
              vWord = "";
              //while there are letters below
              while(lines[i+k].charAt(j) != 'X') {
                vWord += String.valueOf(lines[i+k].charAt(j));
                k++;
                if(i+k>=cwH) break;
              }
              hWords.add("");
              vWords.add(vWord);
              break;
            //if (i,j) is the stat of a vertical and horazontal word
            case 3:
              numberCounter++;
              hWord = "";
              vWord = "";
              k = 0;
              //while there are letters to the right
              while(lines[i].charAt(j+k) != 'X') {
                hWord += String.valueOf(lines[i].charAt(j+k));
                k++;
                if(j+k>=cwW) break;
              }
              k = 0;
              //while there are letters below
              while(lines[i+k].charAt(j) != 'X') {
                vWord += String.valueOf(lines[i+k].charAt(j));
                k++;
                if(i+k>=cwH) break;
              }
              hWords.add(hWord);
              vWords.add(vWord);
              break;
            default:
              break;
          }
        }
      }
    }
  }

  //returns the array of virtical words
  public String[] getVirtWords() {
    return vWords.toArray(new String[vWords.size()]);
  }
  public String[] getHorzWords() {
    return hWords.toArray(new String[hWords.size()]);
  }

  //draws the Cross Word
  public void draw(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    //this if/else sets the size of the letter boxes based on the window
    if((int)getSize().getHeight()/cwH > (int)getSize().getWidth()/cwW) {
      boxW = boxH = (int)getSize().getWidth()/cwW;
    }else {
      boxW = boxH = (int)getSize().getHeight()/cwH;
    }
    //if the window is to small it sets them to 50 pixles
    if(boxH < 50) boxH=boxW=50;


    //sets the letter forn based on the box size
    letterFont = new Font ("Terminal", 1, boxH/2);
    //font metrix for centering
    FontMetrics letterFM = g2d.getFontMetrics(letterFont);
    //for each item in the (i,j) cordanet system i am using
    for(int i = 0; i < cwH; i++) {
      for(int j = 0; j < cwW; j++) {
        //drawbackground
        g2d.setColor(background[i][j]);
        g2d.fillRect(j*boxW, i*boxH, boxW, boxH);
        g2d.setColor(Color.BLACK);
        g2d.drawRect(j*boxW, i*boxH, boxW, boxH);
        //drawLetter if there is a letter
        if(!letter[i][j].equals("")) {
          //rekt = getStringBounds(letter[i][j],0,1,g).getHeight()
          g2d.setFont(letterFont);
          g2d.setColor(Color.BLUE);
          //funky centering letter stuff
          //all I know is it puts the letters in the center ... and i wrote it :C
          g2d.drawString(letter[i][j] ,
              (j*boxW)+(( boxW - letterFM.charWidth(letter[i][j].charAt(0)) )/2),
              (i*boxH)
                    + (( boxH - (int) letterFM.getStringBounds(letter[i][j],g2d).getHeight())/2)
                    +boxH/2
          );
        }
        //adds the numbers
        if(number[i][j] != 0) {
          g2d.setFont(numberFont);
          g2d.setColor(Color.RED);
          g2d.drawString(""+number[i][j],j*boxW+(boxW/10), i*boxH+(boxH/10)+12);
        }
      }
    }
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    draw(g);
  }
}
