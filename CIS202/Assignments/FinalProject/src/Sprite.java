import javax.swing.*;
import java.awt.*;

public class Sprite {

  // These are the necessary fields
  protected Point absolutePosition;
  protected Point relativePosition;
  protected ImageIcon image;

  public Sprite() {
    absolutePosition = new Point(0, 0);
    relativePosition = new Point(0, 0);
    image = null;
  }

  public void setLocation(int x, int y) {
    relativePosition.x = x;
    relativePosition.y = y;

    absolutePosition.x = (x * 60) + 10;
    absolutePosition.y = (y * 60) + 10;
  }

  public void setLocation(Point p) {
    if (p == null) {
      relativePosition = null;
      absolutePosition = null;
    } else {
      setLocation(p.x, p.y);
    }
  }

  public void draw(Graphics g) {
    if (absolutePosition != null) {
      image.paintIcon(null, g, absolutePosition.x, absolutePosition.y);
    }
  }
}
