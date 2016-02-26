/**
*@author Kier Lindsay
**/


import javax.swing.JPanel;
import java.awt.Color; 
import java.awt.Graphics;
import java.awt.Graphics2D;

public class PongScreen extends JPanel {
  
  private Ball ball;
  private Paddle p1, p2;
  public PongScreen() {
    ball = new Ball(5, 10);
    p1 = new Paddle(10,10,20,80,8);
    p2 = new Paddle((int) getSize().getWidth()-30 ,10,20,80,8);
    ball.addPaddle();
    ball.addPaddle();
  }
  public void cheackSize() {
    ball.setRoom(getSize());
    p1.setRoom(getSize());
    p2.setRoom(getSize());
    p2.setX( (int) getSize().getWidth()-30 );
  }
  public void moveBall(){
    //System.out.println("moveball");
    ball.step();
  }
  
  public void movePaddle(int paddle , boolean direction){
    if(paddle == 1) p1.step(direction);
    
    if(paddle == 2) p2.step(direction);
  }
  
  public void updatePaddles() {
   ball.setPaddleStatus(0 , p1.getX(), p1.getY(), p1.getW(), p1.getH());
   ball.setPaddleStatus(1 , p2.getX(), p2.getY(), p2.getW(), p2.getH()); 
  }
  
  @Override
  public void paint(Graphics g) {
    super.paint(g);
    ball.draw(g);
    p1.draw(g);
    p2.draw(g);
  }


}  