import java.awt.*;
import java.awt.event.*;

public class TestGUI extends Frame implements ActionListener, WindowListener {

  private Label lblCount;
  private TextField tfCount;
  private Button btnCount;
  private int count = 0;

  public TestGUI() {
    setLayout(new FlowLayout());
    
    lblCount = new Label("Counter");
    
    add(lblCount);
    
    tfCount = new TextField("0", 10);
    
    tfCount.setEditable(false);
    
    add(tfCount);
    
    btnCount = new Button("Counter");
    add(btnCount);
    
    btnCount.addActionListener(this);
    addWindowListener(this);
    
    
    setTitle("Super Counter");
    setSize(400, 600);
    
    setVisible(true);
    
  }
  
  public static void main(String[] args) { 
  
    TestGUI app = new TestGUI();
  
  }

  
 @Override
  public void actionPerformed(ActionEvent evt) {
    count++;
    
    tfCount.setText(count + "");
    
  }
  @Override
  public void windowClosing(WindowEvent e) {
    System.exit(0);  // Terminate the program
  }
 
  // Not Used, but need to provide an empty body
  @Override
  public void windowOpened(WindowEvent e) { }
  @Override
  public void windowClosed(WindowEvent e) { }
  @Override
  public void windowIconified(WindowEvent e) { }
  @Override
  public void windowDeiconified(WindowEvent e) { }
  @Override
  public void windowActivated(WindowEvent e) { }
  @Override
  public void windowDeactivated(WindowEvent e) { }

}