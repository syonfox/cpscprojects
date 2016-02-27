/**
*@author Kier Lindsay
**/


import javax.swing.JPanel;
import java.awt.Color; 
import java.awt.Graphics;
import java.awt.Graphics2D;

public class PongScreen extends JPanel {
  private Board b;
  private Ball ball;
  private Paddle p1, p2;
  
  public PongScreen() {
    ball = new Ball(8, 4);
    p1 = new Paddle(10, 160 ,10,80,15);
    p2 = new Paddle((int) getSize().getWidth()-30 , 160 ,10,80,15);
    ball.addPaddle();
    ball.addPaddle();
    
    b = new Board();
    
    setBackground(Color.BLACK);
    //setFont(new Font("Impact", 0,24));
    
  }
  public void cheackSize() {
    ball.setRoom(getSize());
    p1.setRoom(getSize());
    p2.setRoom(getSize());
    p2.setX( (int) getSize().getWidth()-30 );
    
    b.setW( (int) getSize().getWidth() );
    b.setH( (int) getSize().getHeight() );
  }
  public void moveBall(){
    //System.out.println("moveball");
    ball.step();
  }
  public void updateScore(){
    b.setLeft(ball.getLeft());
    b.setRight(ball.getRight());
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
    b.draw(g);
    ball.draw(g);
    p1.draw(g);
    p2.draw(g);
    
    //ball.draw(g);
  }


}  