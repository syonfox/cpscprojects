package cpsc101.klindsay.lab5.betterHouse;

import cpsc101.klindsay.lab5.betterHouse.BetterDrawing;
import javax.swing.JFrame;



public class Houses extends JFrame {
  
  public Houses() {
    setTitle(" More Houses ");
    setSize(600, 400);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    BetterDrawing a = new BetterDrawing(10, 10, 60, 200);
    BetterDrawing b = new BetterDrawing(80, 10, 80, 200);
    BetterDrawing c = new BetterDrawing(200, 10, 100, 300);
    BetterDrawing d = new BetterDrawing(145, 186, 42, 269);
    
    add(a);
    add(b);
    add(c);
    add(d);
    
    setVisible(true);
  }
  


  public static void main(String[] args) {
  
    Houses l = new Houses();
  
  }

}