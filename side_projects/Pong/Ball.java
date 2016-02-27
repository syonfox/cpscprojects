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
  /**The balls maximum x position, the size of the window usualy*/
  private int xMax;
  /**The balls maximum y position, the size of the window usualy*/
  private int yMax;
  
  /**The balls min x position, the size of the window usualy*/
  private int xMin;
  /**The balls min y position, the size of the windo usualy*/
  private int yMin;
  
  /**The maximum random deaveation of the ball when it reflects of a surface.*/
  private double rand;
  
  /**An array list for storing the paddles a ball has to worry about.*/
  private ArrayList<int[]> paddles;
  
  private int leftScore=0;
  private int rightScore=0;
  
  /**A random number genorator for the randomness*/
  private Random r;
  /**
  *Creates a new ball. need to make more for diffrent inital settings
  *
  *@param sp the speed of the ball
  *@param si the size of the ball
  */
  public Ball(int sp, int si) {
    speed = sp;
    size = si;
    x = 100;
    y = 100;
    o = pi/2;
    rand = pi/6;
    r = new Random();
    xMin = 0;
    yMin = 0;
    paddles = new ArrayList<int[]>();
  }
  
  /**
  *Draws the ball
  */
  public void draw(Graphics g) {
    g.setColor(Color.GREEN);
    g.fillRect(x,y,size,size);
  }
  /**
  *adds a paddle to the known list of paddles 
  */
  public void addPaddle() {
    paddles.add(new int[4]);
    int[] temp = new int[4];
    //temp[0] = id;
    //paddles.set(paddles.size()-1, temp);
  }
  
  /**
  *tells the ball the location and size of a paddle.  
  *@param id array list index of the paddle you wish to define this is an unsafe and bad thing but it works
  *@param px the paddle x coordinate
  *@param py the paddle y coordinate
  *@param pw the paddle width
  *@param ph the paddle height
  */
  public void setPaddleStatus(int id, int px, int py ,int pw ,int ph) {
    int[] temp = new int[4];
    temp[0] = px;
    temp[1] = py;
    temp[2] = pw;
    temp[3] = ph;
    //System.out.println(px+" "+py+" "+pw+" "+ph);
    paddles.set(id, temp);
    
  }
  
  
  /**
  *this does the majority of the calculations and collision checking for the ball
  */
  public void step() {
    //finds the components of speed based on the angle
    double temp = Math.sin(o)*speed;
    x += (int) temp;
        
    temp = Math.cos(o)*speed;
    y += (int) temp;
    
    //for every paddle that the ball knows about
    for(int i = 0; i < paddles.size(); i++ ) {
      //sets p to the paddle we are checking
      int[] p = paddles.get(i);
      //poor collision cheack that checks if the ball hit and if so reflects it like 
      if( x<p[0]+p[2] && x+size>p[0] && y<p[1]+p[3] && y+size>p[1]) {
	
	
	//reflects the angle and adds a random change
	o = 2*pi - o + (( (double) r.nextInt(101)/50 )-1)*rand;
      
      }
    }
    
    //collision cheacking for the walls (better then the paddles)
    //only adds randomness when hiting the ends not the top and bottom.
    if(x > xMax) {
      
      x = xMax/2;
      y= yMax/2;
      leftScore++;
      o = 3*pi/2;
       
      //x = xMax;
      //o = 2*pi - o + (( (double) r.nextInt(101)/50 )-1)*rand;
    } else if(x < 0) {
      
      x = xMax/2;
      y= yMax/2;
      rightScore++;
      o = pi/2;
      
      
      //x = 0;
      //o = 2*pi - o + (( (double) r.nextInt(101)/50 )-1)*rand;
    }
    
    if(y > yMax) {
      y  = yMax;
      o = pi - o;
    } else if(y < 0) {
      y = 0;
      o = pi - o;
    }
  }
  
  /**
  *used to tell the ball where the edges of the window are so that resizing dosent break the game.
  */
  public void setRoom(Dimension d) {
    double temp = d.getWidth() - size;
    xMax = (int) temp;
    temp = d.getHeight() - size;
    yMax = (int) temp;
    
  }
  
  /**
  *getter for x coordinate
  *@return the x coordinate of the ball
  */
  public int getX() {
    return x;
  }
  /**
  *getter for y coordinate
  *@return the y coordinate of the ball
  */
  public int getY() {
    return y;
  }
  /**
  *getter for speed 
  *@return the speed of the ball
  */
  public int getSpeed() {
    return speed;
  }
  /**
  *getter for angle from +y
  *@return the angle of the ball in radians
  */
  public double getAngle() {
    return o;
  }
  
   public int getLeft() {
    return leftScore;
  }
  public int getRight() {
    return rightScore;
  }
  
  

}