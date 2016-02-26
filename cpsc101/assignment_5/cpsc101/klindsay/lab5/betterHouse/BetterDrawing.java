/**
*@author Kier Lindsay
**/
package cpsc101.klindsay.lab5.betterHouse;

import cpsc101.klindsay.lab5.betterHouse.House;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.Color; 
import java.util.ArrayList;
import java.util.List;

class BetterDrawing extends JPanel {
  private ArrayList<House> houses;
  public BetterDrawing() {
    houses = new ArrayList<House>();
 
    houses.add(new House(10, 10, 60, 200));
    houses.add(new House(80, 10, 80, 200));
    houses.add(new House(200, 10, 100, 300));
    houses.add(new House(145, 186, 42, 269));
    houses.add(new House(25, 210, 80, 200));
  }
  

  
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    for(int i = 0; i < houses.size(); i++) {
      houses.get(i).drawHouse(g);
    } 
  } 
}
