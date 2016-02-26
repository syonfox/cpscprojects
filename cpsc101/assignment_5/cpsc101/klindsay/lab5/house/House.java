/**
*@author Kier Lindsay
**/
package cpsc101.klindsay.lab5.house;

import cpsc101.klindsay.lab5.house.Drawing;
import javax.swing.JFrame;



public class House extends JFrame {
  
  public House() {
    setTitle(" I'm A House   /(-_-)\\ -<(NO you're a JFrame)");
    setSize(500, 800);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    add(new Drawing());
    
    setVisible(true);
  }

}