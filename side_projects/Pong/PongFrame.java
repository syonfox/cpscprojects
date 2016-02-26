/**
*@author Kier Lindsay
*The "OlympicRingViewer" class
**/

import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PongFrame extends JFrame {
  
  public PongFrame() {
    setTitle("Ping ... Pong ");
    setSize(600, 400);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    setVisible(true);
  }
  
  public void startGame() throws InterruptedException {
    PongKeyListener keyInput = new PongKeyListener();

    keyInput.addKey("W");
    keyInput.addKey("S");
    keyInput.addKey("Up");
    keyInput.addKey("Down");
    
    addKeyListener(keyInput);
    PongScreen ps = new PongScreen();
    add(ps);
    while(true) {
      ps.cheackSize();
      ps.repaint();
      
      if(keyInput.isPressed("W") && !keyInput.isPressed("S")) ps.movePaddle(1, false);
      else if(keyInput.isPressed("S") && !keyInput.isPressed("W")) ps.movePaddle(1, true);
      
      if(keyInput.isPressed("Up") && !keyInput.isPressed("Down")) ps.movePaddle(2, false);
      else if(keyInput.isPressed("Down") && !keyInput.isPressed("Up")) ps.movePaddle(2, true);
      ps.updatePaddles();
      ps.moveBall();
      
      //System.out.println(keyInput.isPressed("W"));
     // if(keyInput.isPressed("W") && !keyInput.isPressed("S")) ps.movePaddle(false);
     // else if(keyInput.isPressed("S") && !keyInput.isPressed("W")) ps.movePaddle(true);
      Thread.sleep(10);
      
    }
    
  }
}