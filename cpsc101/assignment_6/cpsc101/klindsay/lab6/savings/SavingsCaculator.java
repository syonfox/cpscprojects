/**Somthing**/

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class SavingsCaculator extends JFrame {

  JLabel balanceLB = new JLabel("Enter Balance:");
  JTextField balanceTF = new JTextField("", 15);

  JLabel yearsLB = new JLabel("Enter Years:");
  JTextField yearsTF = new JTextField("", 15);

  JLabel intrestLB = new JLabel("Enter Intrest(%):");
  JTextField intrestTF = new JTextField("", 15);

  JButton calculateBT = new JButton("Calculate");
  JTextArea resultsTA = new JTextArea("Results", 20, 20);

  public SavingsCaculator() {
    setTitle("Am I Rich ... NO");
    setSize(300, 600);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //JPanel panel = new JPanel();
    //panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

    //panel.add(new JLabel("Enter Balance:"));

    Container contentPane = this.getContentPane();
    FlowLayout layout = new FlowLayout(FlowLayout.TRAILING, 10, 10);
    contentPane.setLayout(layout);

    contentPane.add(balanceLB);
    contentPane.add(balanceTF);
    contentPane.add(yearsLB);
    contentPane.add(yearsTF);
    contentPane.add(intrestLB);
    contentPane.add(intrestTF);



    contentPane.add(calculateBT);

    JTextArea resultsTA = new JTextArea("Results", 20, 20);
    resultsTA.setEditable(false);

    calculateBT.addActionListener( new ActionListener() {
      @Override
      public static void actionPreformed(ActionEvent e) {
        calculate();
      }
    });

    contentPane.add(resultsTA);

  /*  layout.putConstraint(SpringLayout.WEST, balanceLB, 5,
                         SpringLayout.WEST, contentPane);
    layout.putConstraint(SpringLayout.NORTH, balanceLB, 5,
                         SpringLayout.NORTH, contentPane);

    layout.putConstraint(SpringLayout.WEST, balanceTF, 5,
                         SpringLayout.EAST, balanceLB);
    layout.putConstraint(SpringLayout.NORTH, balanceTF, 5,
                         SpringLayout.NORTH, contentPane);*/
    //pack();
    setVisible(true);
  }
  public void calculate() {

    String balance = balanceTF.getText();
    String years = yearsTF.getText();
    String intrest = years.getText();

    try {
      Double bal = Double.parseDouble(balance);
      Double yea = Double.parseDouble(years);
      Double inr = Double.parseDouble(intrest);

      resultsTA.setText("");
      for(int i = 0; i < (int) yea; i++){
        resultsTA.append(String.format("Year %4.2f : %.2f", i, bal * (1 + i*(inr / 100)) ));
      }

    } catch (NumberFormatException e) {
      resultsTA.setText("You don ****** up dat input");
    }
  }
  public static void main(String[] args) {
    SavingsCaculator sc = new SavingsCaculator();
  }
}
