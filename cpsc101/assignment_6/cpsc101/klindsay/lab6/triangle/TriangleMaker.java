
import javax.swing.JFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TriangleMaker  extends JFrame {

  public TriangleMaker() throws InterruptedException{
    setTitle("Triangle Maker");
    setSize(600, 400);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    final Screen sc = new Screen();
    sc.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        sc.nextPoint(e.getX(), e.getY());
        //System.out.println("x:"+e.getX()+" y:"+e.getY());
      }
    });

    add(sc);
    setVisible(true);
  }

  public static void main(String[] args) throws InterruptedException{
    TriangleMaker tm = new TriangleMaker();
  }

}
