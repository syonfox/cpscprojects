/**
*@author Kier Lindsay
**/
package cpsc101.klindsay.lab5.betterHouse;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.Color; 

public class House {

  private int x,y,w,h;
  
  public House(int ix, int iy, int iw, int ih) {
    x=ix;
    y=iy;
    w=iw;
    h=ih;
  }
  

  public void drawHouse(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
  
    g2d.setColor(Color.BLACK);
    g2d.fillRect(x, y, w,h);
    g2d.setColor(Color.YELLOW);
    
    int wh = (3*h)/16;
    int ww = w/3;
    g2d.fillRect(x+(ww/3), y+(wh/4), ww,wh);
    g2d.fillRect(x+(ww/3), y+wh+(wh/2), ww,wh);
    g2d.fillRect(x+(ww/3), y+2*wh+(3*wh/4), ww,wh);
    g2d.fillRect(x+ww+(2*ww/3), y+(wh/4), ww,wh);
    g2d.fillRect(x+ww+(2*ww/3), y+wh+(wh/2), ww,wh);
    g2d.fillRect(x+ww+(2*ww/3), y+2*wh+(3*wh/4), ww,wh);
    
    g2d.setColor(Color.WHITE);
    int[] rx = new int[3];
    rx[0] = x+(w/8);
    rx[1] = x+(w/2);
    rx[2] = x+((w*7)/8);
    int[] ry =  { y+h-h/8 , y+h-h*3/16 , y+h-h*1/8 };
    g2d.fillPolygon( rx , ry , 3 );
    
    int ph = h/8;
    int pw = w/8;
    g2d.fillRect(x+w/4, ry[0] , pw , ph );
    g2d.fillRect( x+(3*w/4)-pw , ry[2] , pw , ph );
  }

}