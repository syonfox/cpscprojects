import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;


public class HacknClick extends JFrame {
  
  private JTextArea taDisplay;
  
  public HacknClick() {
    
    Container cp = getContentPane();
    cp.setLayout( new BorderLayout() );
    
    JPanel buttons = new JPanel(new GridLayout(5, 2));
    
    JPanel display = new JPanel(new FlowLayout());
    
    cp.add(buttons, BorderLayout.EAST);
    cp.add(display, BorderLayout.CENTER);
    
    taDisplay = new JTextArea(10, 20);
    taDisplay.setEditable(false);
    display.add(taDisplay);
    
    JButton btnBuy = new JButton("Buy");
    buttons.add(btnBuy);
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Hack'n Click");
    
    setSize(300, 100); 
    
    setVisible(true);
  }
  
  public static void main(String[] args) {
      // Run the GUI construction in the Event-Dispatching thread for thread-safety
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            new HacknClickjava(); // Let the constructor do the job
         }
      });
   }
}