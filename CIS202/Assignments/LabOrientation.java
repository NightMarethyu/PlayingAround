import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LabOrientation extends JPanel {

  // This is the variable that contains the limeric I'm using
  // No, I didn't come up with this myself I learned it from
  // Spongebob Squarepants
  String[] message = {
    "There once was a man from Peru",
    "Who dreamed he was eating his shoe",
    "He woke with a fright",
    "In the middle of the night",
    "To find that his dream had come true"
  };

  // Here I'm using the paintComponent method to 
  // add the limeric to the window
  @Override
  public void paintComponent(Graphics g) {
    int x = 10;
    int y = 15;
    for (int i = 0; i < message.length; i++) {
      g.drawString(message[i], x, y);
      y += 15;
    };
  }

  public static void main(String[] args) {
    var window = new JFrame();
    window.setSize(400,400);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setContentPane(new LabOrientation());
    window.setVisible(true);
  }
}