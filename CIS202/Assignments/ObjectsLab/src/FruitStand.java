import java.awt.*;

public class FruitStand {
  private Point pos;
  private Color signColor;
  private Color textColor;

  public FruitStand(Point p) {
    pos = p;
    signColor = new Color(125, 72, 4);
    textColor = Color.BLACK;
  }

  public FruitStand(int x, int y) {
    this(new Point(x, y));
  }

  public FruitStand() {
    this(new Point(0, 0));
  }

  public void setSignColor(Color c) {
    signColor = c;
  }

  public void setTextColor(Color c) {
    textColor = c;
  }

  public void draw(Graphics g) {
    g.setColor(signColor);
    g.fillRect(pos.x, pos.y, 200, 75);
    g.fillRect(pos.x + 15, pos.y + 50, 15, 100);
    g.fillRect(pos.x + 170, pos.y + 50, 15, 100);
    g.setColor(Color.GRAY);
    g.fillRect(pos.x, pos.y + 125, 200, 75);

    drawGrapes(g, 40);
    drawGrapes(g, 80);
    drawGrapes(g, 120);

    g.setColor(textColor);

    // Letter A
    g.drawLine(pos.x + 10, pos.y + 10, pos.x + 10, pos.y + 65);
    g.drawLine(pos.x + 60, pos.y + 10, pos.x + 60, pos.y + 65);
    g.drawLine(pos.x + 10, pos.y + 10, pos.x + 60, pos.y + 10);
    g.drawLine(pos.x + 10, pos.y + 35, pos.x + 60, pos.y + 35);

    // Letter D
    g.drawLine((pos.x + 70), (pos.y + 10), (pos.x + 70), (pos.y + 65));
    g.drawLine((pos.x + 70), (pos.y + 10), (pos.x + 105), (pos.y + 10));
    g.drawLine((pos.x + 70), (pos.y + 65), (pos.x + 105), (pos.y + 65));
    g.drawLine((pos.x + 105), (pos.y + 10), (pos.x + 120), (pos.y + 25));
    g.drawLine((pos.x + 105), (pos.y + 65), (pos.x + 120), (pos.y + 50));
    g.drawLine((pos.x + 120), (pos.y + 25), (pos.x + 120), (pos.y + 50));

    // Letter T
    g.drawLine((pos.x + 130), (pos.y + 10), (pos.x + 180), (pos.y + 10));
    g.drawLine((pos.x + 155), (pos.y + 10), (pos.x + 155), (pos.y + 65));

    g.drawString("GRAPES: $1 A BUNCH", (pos.x + 40), (pos.y + 165));
  }

  private void drawGrapes(Graphics g, int xStart) {
    g.setColor(new Color(117, 50, 168));
    g.fillOval(pos.x + xStart, pos.y + 115, 10, 10);
    g.fillOval(pos.x + xStart + 9, pos.y + 115, 10, 10);
    g.fillOval(pos.x + xStart + 18, pos.y + 115, 10, 10);
    g.fillOval(pos.x + xStart + 4, pos.y + 108, 10, 10);
    g.fillOval(pos.x + xStart + 13, pos.y + 108, 10, 10);
    g.fillOval(pos.x + xStart + 9, pos.y + 101, 10, 10);
  }


}
