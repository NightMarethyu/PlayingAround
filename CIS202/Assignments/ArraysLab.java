import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

public class ArraysLab extends JPanel {

  public ArraysLab() {
    // TODO
  }

  @Override
  public void paintComponent(Graphics g) {
    // TODO
  }

  public static void main(String[] args) {
    JFrame window = new JFrame();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setContentPane(new ArraysLab());
    window.setSize(400, 400);
    window.setVisible(true);
  }

}