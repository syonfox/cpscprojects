/**
*@author Kier Lindsay
**/

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.Color; 
import java.lang.Math;
import java.awt.Dimension;

public class Paddle {

  /**The speed of the paddle*/
  private int speed;
  /**The x coordinate of the paddle*/
  private int x; 
  /**The y coordinate of the paddle*/
  private int y;
  /**The height of the paddle*/
  private int h;
  /**The width of the paddle*/
  private int w;
  /**The paddles maximum y position*/
  private int yMax;
  
  public Paddle(int ix, int iy, int iw, int ih, int is) {
    x = ix;
    y = iy;
    h = ih;
    w = iw;
    speed = is;
  }
  
  public void draw(Graphics g) {
    g.setColor(Color.BLACK);
    g.fillRect(x,y,w,h);
  }
  
  public void setRoom(Dimension d) {
    double temp = d.getHeight() - h;
    yMax = (int) temp;
  }
  
  public void setX(int nx) {
  x = nx; 
  }
  
  public int getX() {
    return x;
  }
  public int getY() {
    return y;
  }
  public int getW() {
    return w;
  }
  public int getH() {
    return h;
  }
  
  public void step(boolean direction) {
    System.out.println("movepaddle"+ direction);
    if(direction == true) {
      y += speed;
      System.out.println("TRUI"+y);
    }
    else if(direction == false) {
      y -= speed;
      System.out.println("False"+ y);
    }
    
    if( y < 0 ) y = 0;
    else if( y > yMax ) y = yMax;
    
  }
}