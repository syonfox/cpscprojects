
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color; 



class Drawing extends JPanel {
  
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


    for(int i = 10, j = 0; i < getSize().getHeight() - getSize().getHeight()%color.length; i += getSize().getHeight()/color.length, j++) {
      g2d.setColor(color[j]);
      g2d.drawString("<(^v^)>", (int) getSize().getWidth()/2 , i);
    }
    
    
  }
  
  @Override
  public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawLines(g);
  }

}


public class Lines extends JFrame {
  
  public Lines() {
    setTitle("Lines");
    setSize(600, 400);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    add(new Drawing());
    
    setVisible(true);
  }
  


  public static void main(String[] args) {
  
    Lines l = new Lines();
  
  }

}