import javax.swing.JFrame;


public class FunCar  extends JFrame {
  private Screen sc;
  public FunCar() {
    setTitle("Fun Car");
    setSize(600, 400);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    sc = new Screen();
    add(sc);
    setVisible(true);
  }

  public void start()throws InterruptedException {
    while(true) {
      sc.moveCar(4);
      sc.repaint();
      //System.out.println("Move");
      Thread.sleep(15);
    }
  }

  public static void main(String[] args) throws InterruptedException{
    FunCar fc = new FunCar();
    fc.start();
  }

}
