import javax.swing.*;
import javax.swing.JPanel;

public class SavingsCaculator extends JFrame {
  public SavingsCaculator() {
    setTitle("Am I Rich ... NO");
    setSize(400, 600);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

    panel.add(new JLabel("Enter Balance:"));

    Container contentPane = getContentPane();
    
    setVisible(true);
  }

  public static void main(String[] args) {
    SavingsCaculator sc = new SavingsCaculator();
  }
}
