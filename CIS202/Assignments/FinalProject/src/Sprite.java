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

    absolutePosition.x = (x * 60) + 10;
    absolutePosition.y = (y * 60) + 10;
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

  // This will check if the point provided is the same as the
  // relative position of this object
  public boolean isTouching(Point p) {
    if (this.relativePosition == null || p == null) {
      return false;
    }
    return p.x == this.relativePosition.x && p.y == this.relativePosition.y;
  }

  // I've overloaded this method to allow both sprites and
  // points to be checked, I did this for the trees method
  public boolean isTouching(Sprite other) {
    return this.isTouching(other.getRelativePosition());
  }

  // This is included primarily for the Robbers, this will check
  // if a provided sprite is near this sprite. I could probably overload
  // this like I did the isTouching method, but I don't believe that is
  // necessary for this project.
  public boolean isNear(Sprite other) {
    Point rel = other.getRelativePosition();
    if (relativePosition.x == rel.x + 1 || relativePosition.x == rel.x - 1 || relativePosition.x == rel.x) {
      return relativePosition.y == rel.y + 1 || relativePosition.y == rel.y - 1 || relativePosition.y == rel.y;
    } else {
      return false;
    }
  }
}
