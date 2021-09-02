import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class WindowFun extends JPanel {

  @Override
  public void paintComponent(Graphics g) {
    g.drawString("This is a windowed program", 10, 10);
    g.drawString("This is another string", 10, 30);
  }

  public static void main(String[] args) {
    // create a new window
    var window = new JFrame();
    // set window to 200 x 200 pixels
    window.setSize(200,200);
    //close the app when the user closes the window
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //make the WindowFun class responsible for the contents of our window
    window.setContentPane(new WindowFun());

    //displays the window
    window.setVisible(true);
  }
}
