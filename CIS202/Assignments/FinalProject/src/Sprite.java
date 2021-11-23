import javax.swing.*;
import java.awt.*;

public abstract class Sprite {

  // These are the necessary fields
  protected Point absolutePosition;
  protected Point relativePosition;
  protected ImageIcon image;

  // default constructor
  public Sprite() {
    absolutePosition = new Point(0, 0);
    relativePosition = new Point(0, 0);
    image = null;
  }

  // change the sprites location
  public void setLocation(int x, int y) {
    relativePosition.x = x;
    relativePosition.y = y;

    absolutePosition.x = (x * Main.CELL_SIZE) + 10;
    absolutePosition.y = (y * Main.CELL_SIZE) + 10;
  }

  // This will change the sprite's location to a new point
  public void setLocation(Point p) {
    if (p == null) {
      relativePosition = null;
      absolutePosition = null;
    } else {
      setLocation(p.x, p.y);
    }
  }

  // Get relative position of sprite
  public Point getRelativePosition() {
    return relativePosition;
  }

  // add the sprite to the window
  public void draw(Graphics g) {
    if (absolutePosition != null) {
      image.paintIcon(null, g, absolutePosition.x, absolutePosition.y);
    }
  }

  public boolean isTouching(Point p) {
    if (this.relativePosition == null) {
      return false;
    }
    return p.x == this.relativePosition.x && p.y == this.relativePosition.y;
  }

  public boolean isTouching(Sprite other) {
    Point rel = other.getRelativePosition();
    return this.isTouching(rel);
  }

  public boolean isNear(Sprite other) {
    Point rel = other.getRelativePosition();
    if (relativePosition.x == rel.x + 1 || relativePosition.x == rel.x - 1 || relativePosition.x == rel.x) {
      return relativePosition.y == rel.y + 1 || relativePosition.y == rel.y - 1 || relativePosition.y == rel.y;
    } else {
      return false;
    }
  }
}
