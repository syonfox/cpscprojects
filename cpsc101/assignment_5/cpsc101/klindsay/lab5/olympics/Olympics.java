/**
*@author Kier Lindsay
*The "OlympicRingViewer" class
**/

package cpsc101.klindsay.lab5.olympics;

import cpsc101.klindsay.lab5.olympics.Drawing;
import javax.swing.JFrame;



public class Olympics extends JFrame {
  
  public Olympics() {
    setTitle(" Let The Games Begin! ");
    setSize(600, 400);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    add(new Drawing());

    setVisible(true);
  }
  


  public static void main(String[] args) {
  
    Olympics o = new Olympics();
  
  }

}