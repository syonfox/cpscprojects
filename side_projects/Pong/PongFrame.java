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
    ps.cheackSize();
    
    setVisible(true);
    while(true) {
      ps.cheackSize();
      ps.updateScore();
      for(int i = 0; i < 5; i++) {
	
	
	if(keyInput.isPressed("W") && !keyInput.isPressed("S")) ps.movePaddle(1, false);
	else if(keyInput.isPressed("S") && !keyInput.isPressed("W")) ps.movePaddle(1, true);
	
	if(keyInput.isPressed("Up") && !keyInput.isPressed("Down")) ps.movePaddle(2, false);
	else if(keyInput.isPressed("Down") && !keyInput.isPressed("Up")) ps.movePaddle(2, true);
	ps.updatePaddles();
	for(int j = 0; j < 3; j++) {
	ps.moveBall();
	ps.repaint();
	Thread.sleep(15);
	}
      }
    }
    
  }
}