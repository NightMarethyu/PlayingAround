import java.awt.*;

public class Water extends Sprite {

  public Water(int x, int y) {
    super();
    setLocation(x, y);
  }

  // the water doesn't have a separate sprite, instead it's just blue
  // this will add a blue square to the window in the sprite's location
  @Override
  public void draw(Graphics g) {
    if (absolutePosition != null) {
      g.setColor(Color.BLUE);
      g.fillRect(absolutePosition.x, absolutePosition.y, 60, 60);
    }
  }
}
