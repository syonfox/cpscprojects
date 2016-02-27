/**
*@author Kier Lindsay
*/

import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.Color; 
import java.lang.Math;
import java.awt.Font;
import java.awt.Dimension;
import java.lang.String;
public class Board {
  
  private int left=0;
  private int right=0;
  private int h;
  private int w;
  
  public void setLeft(int l) {
  left = l;
  }
  public void setRight(int r) {
  right = r;
  }
  public void setW(int l) {
  w = l;
  }
  public void setH(int l) {
  h = l;
  }
  
  public void draw(Graphics g) {
  
  g.setColor(Color.GRAY);
  g.fillRect( ((w/2)-5) ,0,10,h);
  Font font = new Font("Impact", Font.BOLD,48);
               
                //set font for JLabel
  g.setFont(font);
  g.setColor(Color.GREEN);
  String s  = String.format("%03d   %03d", left, right);
  g.drawString(s, w/2 - 124, 48);
  //g.drawString( + "", w/2 + 10, 20);
  
    
  
  }
  
}
