import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Screen extends JPanel {

  private int state;
  private int[] x;
  private int[] y;

  public Screen() {
    state = 0;
    x = new int[3];
    y = new int[3];
  }

  //State 0 = clear Screen
  //State 1 = Dot
  //State 2 = Line
  //State 3 = Triangle
  public void nextPoint(int newX, int newY){
    if(state == 3) state = 0;
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
    if(state == 2) g.drawLine(x[0], y[0], x[1], y[1]);
    if(state == 3) g.drawPolygon(x, y, 3);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    draw(g);
  }
}
