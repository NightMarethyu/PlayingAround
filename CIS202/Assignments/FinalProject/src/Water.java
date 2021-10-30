import java.awt.*;

public class Water extends Sprite {

  public Water(int x, int y) {
    super();
    setLocation(x, y);
  }

  @Override
  public void draw(Graphics g) {
    if (absolutePosition != null) {
      g.setColor(Color.BLUE);
      g.fillRect(absolutePosition.x, absolutePosition.y, 60, 60);
    }
  }
}
