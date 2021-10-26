import javax.swing.*;
import java.awt.*;

public class ObjectsLabApp extends JPanel {

  FruitStand grapes;
  FruitStand grapes2;

  public ObjectsLabApp() {
    grapes = new FruitStand(50, 110);
    grapes2 = new FruitStand(new Point(450, 125));

    grapes2.setSignColor(new Color(252, 93, 228));
    grapes2.setTextColor(new Color(66, 0, 104));
  }

  @Override
  public void paintComponent(Graphics g) {
    int w = getWidth();
    int h = getHeight();

    g.setColor(Color.CYAN);
    g.fillRect(0, 0, w, h);
    g.setColor(Color.YELLOW);
    g.fillOval((w/15), (w/15), 66, 66);

    // Draw the Clouds
    g.setColor(Color.WHITE);
    g.fillOval((w / 25), (h / 2), (w / 4), (h / 8));
    g.fillOval((w / 20), ((h / 2) - (h / 20)), (w / 6), (h / 12));
    g.fillOval((w / 3), (h / 15), (w / 4), (h / 8));
    g.fillOval((w / 4), (h / 10), (w / 6), (h / 12));
    g.fillOval((w - (w / 3)), (h / 3), (w / 5), (h / 9));
    g.fillOval((w - (w / 4)), (h / 4), (w / 10), (h / 5));

    // Draw the Ground
    g.setColor(Color.GREEN);
    g.fillRect(0, (h-(h/6)), w, (h/6));

    grapes.draw(g);
    grapes2.draw(g);
  }

  public static void main(String[] args) {
    JFrame window = new JFrame();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setSize(800, 400);
    window.setContentPane(new ObjectsLabApp());
    window.setVisible(true);
  }

}
