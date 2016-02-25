package cpsc101.klindsay.lab5.colors
;

import cpsc101.klindsay.lab5.colors.StringDrawing;
import javax.swing.JFrame;

public class StringsFrame extends JFrame {
  
  public StringsFrame() {
    setTitle("Strings");
    setSize(600, 400);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    add(new StringDrawing());
    
    setVisible(true);
  }
  


  public static void main(String[] args) {
  
    StringsFrame s = new StringsFrame();
  
  }

}