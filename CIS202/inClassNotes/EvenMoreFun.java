import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JFrame;

public class EvenMoreFun extends JPanel {

  @Override
  public void paintComponent(Graphics g) {
    g.drawString("Be sure to watch devotional after class!", 10, 15);
  }

  public static void main(String[] args) {

    var window = new JFrame();
    window.setSize(300,400);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setContentPane(new EvenMoreFun());
    window.setVisible(true);

  }

}