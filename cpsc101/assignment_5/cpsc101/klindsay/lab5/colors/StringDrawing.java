/**
*@author Kier Lindsay
**/

package cpsc101.klindsay.lab5.colors;

import javax.swing.JPanel;
import java.awt.Color; 
import java.awt.Graphics;
import java.awt.Graphics2D;

class StringDrawing extends JPanel {
  
  public void drawLines(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    Color[] color = new Color[12];
    color[0] = Color.BLACK;
    color[1] = Color.BLUE;
    color[2] = Color.CYAN;
    color[3] = Color.GRAY;
    color[4] = Color.DARK_GRAY;
    color[5] = Color.LIGHT_GRAY;
    color[6] = Color.GREEN;
    color[7] = Color.MAGENTA;
    color[8] = Color.ORANGE;
    color[9] = Color.PINK;
    color[10] = Color.RED;
    color[11] = Color.YELLOW;

    int height = (int) getSize().getHeight();
    for(int i = 10, j = 0; i < (height-10) - (height-10)%color.length;
	i += ((height-10) - (height-10)%color.length)/color.length, j++) {
      g2d.setColor(color[j]);
      g2d.drawString("================    <(^v^)>    ================", (int) getSize().getWidth()/4 , i);
    }
    
    
  }
  
  @Override
  public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawLines(g);
  }

  
}