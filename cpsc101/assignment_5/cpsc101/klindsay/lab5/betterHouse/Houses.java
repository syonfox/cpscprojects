/**
*@author Kier Lindsay
**/
package cpsc101.klindsay.lab5.betterHouse;

import cpsc101.klindsay.lab5.betterHouse.BetterDrawing;
import javax.swing.JFrame;



public class Houses extends JFrame {
  
  public Houses() {
    setTitle(" More Houses ");
    setSize(400, 500);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    add(new BetterDrawing());

    setVisible(true);
  }

}