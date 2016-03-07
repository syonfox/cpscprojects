import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

public class Screen extends JPanel {

  int x;
  int y;
  int[] carx , winx;
  int[] cary , winy;
  int s,s2,s4,s8;
  public Screen() {


    s = 10;
    s2 = 2*s;
    s4 = 4*s;
    s8 = 8*s;
    x = 0;
    //int temp = (int) getSize().getHeight();

    y = 20;
    //y = 100 - s8;

  }

  public void moveCar(int speed) {
    x+=speed;
    if(x > (int) getSize().getWidth()) x = 0;

    y = (int) getSize().getHeight();
    y-= s8;
  }



  public void draw(Graphics g){
    //carx = {x   , x  , x+s2, x+s4+s2, x+s8, x+s8+s4, x+s8+s4};
    //cary = {y+s4, y+s, y   , y      , y+s2, y+s2   , y+s4 };
    carx = new int[7];
    cary = new int[7];

    carx[0] = x;
    cary[0] = y+s4;
    carx[1] = x;
    cary[1] = y+s;
    carx[2] = x+s2;
    cary[2] = y;
    carx[3] = x+s4+s2;
    cary[3] = y;
    carx[4] = x+s8;
    cary[4] = y+s2;
    carx[5] = x+s8+s4;
    cary[5] = y+s2;
    carx[6] = x+s8+s4;
    cary[6] = y+s4;

    winx = new int[3];
    winy = new int[3];
    winx[0] = x+s4+s2;
    winy[0] = y;
    winx[1] = x+s8;
    winy[1] = y+s2;
    winx[2] = x+s4+s2+s;
    winy[2] = y+s2;

    g.setColor(Color.GRAY);
    g.fillPolygon(carx, cary , 7);
    g.setColor(Color.CYAN);
    g.fillPolygon(winx, winy , 3);
    g.setColor(Color.BLACK);
    g.fillOval(x+s, y+s2+s, s2, s2);
    g.setColor(Color.LIGHT_GRAY);
    g.fillOval(x+s+(s/2), y+s2+s+s/2, s, s);

    g.setColor(Color.BLACK);
    g.fillOval(x+s8, y+s2+s, s2, s2);
    g.setColor(Color.LIGHT_GRAY);
    g.fillOval(x+s8+(s/2), y+s2+s+s/2, s, s);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    draw(g);
  }
}
