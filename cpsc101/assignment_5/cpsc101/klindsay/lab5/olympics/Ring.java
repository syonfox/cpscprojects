/**
*@author Kier Lindsay
*The "OlympicRing" class
**/
package cpsc101.klindsay.lab5.olympics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.Color; 

public class Ring {
  //x position, y position, outer radius, inner radius
  private int x, y, or, ir;
  //outer colour, inner colour
  private Color oc, ic;
  
  public Ring(int ix, int iy, int ior, int iir, Color ioc, Color iic) {
    x = ix;
    y = iy;
    or = ior;
    ir = iir;
    oc = ioc;
    ic = iic;
  }
  
  public void drawRing(Graphics g) {
  Graphics2D g2d = (Graphics2D) g;
  
  g2d.setColor(oc);
    g2d.drawOval( x, y, (2*or), (2*or) );
    for(int i = 1; i<=or-ir; i++) {
      g2d.drawOval( x+i, y+i, (2*or)-(2*i), (2*or)-(2*i) );
      g2d.drawOval( x+i+1, y+i, (2*or)-(2*i-1), (2*or)-(2*i) );
      g2d.drawOval( x+i-1, y+i, (2*or)-(2*i+1), (2*or)-(2*i) );
      g2d.drawOval( x+i, y+i+1, (2*or)-(2*i), (2*or)-(2*i-1) );
      g2d.drawOval( x+i, y+i-1, (2*or)-(2*i), (2*or)-(2*i+1) );
    }
  }
  
}