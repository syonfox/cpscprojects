import javax.swing.SpringLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Container;

public class SavingsCaculator extends JFrame {
  public SavingsCaculator() {
    setTitle("Am I Rich ... NO");
    setSize(400, 600);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //JPanel panel = new JPanel();
    //panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

    //panel.add(new JLabel("Enter Balance:"));

    Container contentPane = this.getContentPane();
    SpringLayout layout = new SpringLayout();
    contentPane.setLayout(layout);
    JLabel balanceLB = new JLabel("Enter Balance:");
    JTextField balanceTF = new JTextField("", 15);
    contentPane.add(balanceLB);
    contentPane.add(balanceTF);

    layout.putConstraint(SpringLayout.WEST, balanceLB, 5,
                         SpringLayout.WEST, contentPane);
    layout.putConstraint(SpringLayout.NORTH, balanceLB, 5,
                         SpringLayout.NORTH, contentPane);

    layout.putConstraint(SpringLayout.WEST, balanceTF, 5,
                         SpringLayout.EAST, balanceLB);
    layout.putConstraint(SpringLayout.NORTH, balanceTF, 5,
                         SpringLayout.NORTH, contentPane);
    pack();
    setVisible(true);
  }

  public static void main(String[] args) {
    SavingsCaculator sc = new SavingsCaculator();
  }
}
