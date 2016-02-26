/**
*@author Kier Lindsay
*The "OlympicRingComponent" Class
**/
package cpsc101.klindsay.lab5.olympics;

import cpsc101.klindsay.lab5.olympics.Ring;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color; 
import java.awt.Graphics;

public class Drawing extends JPanel {
  private ArrayList<Ring> rings;
  public Drawing() {
    rings = new ArrayList<Ring>();
    rings.add(new Ring(0, 10, 100, 80, Color.BLUE, getBackground()));
    rings.add(new Ring(200, 10, 100, 80, Color.BLACK, getBackground()));
    rings.add(new Ring(400, 10, 100, 80, Color.RED, getBackground()));
    rings.add(new Ring(100, 110, 100, 80, Color.YELLOW, getBackground()));
    rings.add(new Ring(300, 110, 100, 80, Color.GREEN, getBackground()));
  }
  

  
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    for(int i = 0; i < rings.size(); i++) {
      rings.get(i).drawRing(g);
    } 
  } 
}
