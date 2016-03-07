import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.lang.Math;

public class Screen extends JPanel {

  private int state;
  private int[] x;
  private int[] y;

  public Screen() {
    state = 0;
    x = new int[2];
    y = new int[2];
  }

  //State 0 = clear Screen
  //State 1 = Dot
  //State 2 = Circle

  public void nextPoint(int newX, int newY){
    if(state == 2) state = 0;
    else {
      x[state] = newX;
      y[state] = newY;
      state++;
    }
    repaint();
  }



  public void draw(Graphics g){
    //System.out.print("   State:" + state);
    if(state == 1) g.drawLine(x[0], y[0], x[0], y[0]);
    if(state == 2) {
      double temp;
      temp = Math.pow(Math.abs(x[0] - x[1]), 2)
           + Math.pow(Math.abs(y[0] - y[1]), 2);
      temp = Math.sqrt(temp);
      int radiusComponent = (int) Math.round(temp);
      g.drawOval(x[0]-radiusComponent, y[0] - radiusComponent,
          2 * radiusComponent, 2 * radiusComponent);
    }

  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    draw(g);
  }
}
