/**
*@author Kier Linsay
**/

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.Color; 
import java.lang.Math;
import java.awt.Dimension;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Ball {

  /**The speed of the ball*/
  private int speed;
  /**The size of the ball*/
  private int size;
  
  /**Pi as the angals are in radians*/
  private static final double pi = 3.1415; 
  /**The angle that the ball is moving in,  o = 0 is down or the +y*/
  private double o;
  /**The x coordinate of the ball*/
  private int x; 
  /**The y coordinate of the ball*/
  private int y;
  /**The balls maximum x position, the size of the windo usualy*/
  private int xMax;
  /**The balls maximum y position, the size of the windo usualy*/
  private int yMax;
  
  /**The balls min x position, the size of the windo usualy*/
  private int xMin;
  /**The balls min y position, the size of the windo usualy*/
  private int yMin;
  
  /**The maximum random deaveation of the ball when it reflects of a surface.*/
  private double rand;
  
  private ArrayList<int[]> paddles;
  
  
  /**A random number genorator for the randomness*/
  private Random r;
  /**
  *Creates a new ball.
  *
  *@param sp the speed of the ball
  *@param si the size of the ball
  */
  public Ball(int sp, int si) {
    speed = sp;
    size = si;
    x = 50;
    y = 60;
    o = pi/4;
    rand = pi/6;
    r = new Random();
    xMin = 0;
    yMin = 0;
    paddles = new ArrayList<int[]>();
  }
  
  public void draw(Graphics g) {
    g.setColor(Color.BLACK);
    g.fillRect(x,y,size,size);
  }
  
  public void addPaddle() {
    paddles.add(new int[4]);
    int[] temp = new int[4];
    //temp[0] = id;
    //paddles.set(paddles.size()-1, temp);
  }
  public void setPaddleStatus(int id, int px, int py ,int pw ,int ph) {
    int[] temp = new int[4];
    temp[0] = px;
    temp[1] = py;
    temp[2] = pw;
    temp[3] = ph;
    //System.out.println(px+" "+py+" "+pw+" "+ph);
    paddles.set(id, temp);
    
  }
  
  
  
  public void step() {
    double temp = Math.sin(o)*speed;
    x += (int) temp;
        
    temp = Math.cos(o)*speed;
    y += (int) temp;
    
    
    for(int i = 0; i < paddles.size(); i++ ) {
      int[] p = paddles.get(i);
      
      if( x<p[0]+p[2] && x+size>p[0] && y<p[1]+p[3] && y+size>p[1]) {
      
	o = 2*pi - o + (( (double) r.nextInt(101)/50 )-1)*rand;
      
      }
    }
    
    if(x > xMax) {
      x = xMax;
      o = 2*pi - o + (( (double) r.nextInt(101)/50 )-1)*rand;
    } else if(x < 0) {
      x = 0;
      o = 2*pi - o + (( (double) r.nextInt(101)/50 )-1)*rand;
    }
    
    if(y > yMax) {
      y  = yMax;
      o = pi - o + (( (double) r.nextInt(101)/100 )-1)*rand;
    } else if(y < 0) {
      y = 0;
      o = pi - o + (( (double) r.nextInt(101)/100 )-1)*rand;
    }
  }
  
  public void setRoom(Dimension d) {
    double temp = d.getWidth() - size;
    xMax = (int) temp;
    temp = d.getHeight() - size;
    yMax = (int) temp;
    
  }
  
  public int getX() {
    return x;
  }
  public int getY() {
    return y;
  }
  public int getSpeed() {
    return speed;
  }
  public double getAngle() {
    return o;
  }
  
  

}