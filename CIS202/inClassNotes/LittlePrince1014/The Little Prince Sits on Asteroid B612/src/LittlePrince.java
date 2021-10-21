import java.awt.*;

public class LittlePrince {
  private final Vertex location;
  private Color scarfColor;

  public LittlePrince(Vertex v, Color c) {
    location = v;
    scarfColor = c;
  }

  public LittlePrince() {
    this(new Vertex(), Color.YELLOW);
  }

  public LittlePrince(Vertex v) {
    this(v, Color.YELLOW);
  }

  public LittlePrince(Color c) {
    this(new Vertex(), c);
  }

  public void draw(Graphics g) {
    final Color lightGreen = new Color(202,254,131);
    Color lightBrown = new Color(202,141,60);

    //draw his shirt and pants
    g.setColor(lightGreen);
    g.fillRect(location.getX()+175, location.getY()+100, 50, 150);
    g.fillRect(location.getX()+175, location.getY()+250, 15, 75);
    g.fillRect(location.getX()+210, location.getY()+250, 15, 75);

    //draw his head
    g.setColor(lightBrown);
    g.fillOval(location.getX()+175, location.getY()+40, 50, 60);
    g.setColor(Color.BLACK);
    g.drawLine(location.getX()+190, location.getY()+80, location.getX()+210, location.getY()+80);

    //draw his scarf
    g.setColor(scarfColor);
    g.fillRect(location.getX()+170, location.getY()+90, 150, 20);
  }

  public void move(int dx, int dy) {
    location.translate(dx, dy);
  }

  public void setScarfColor(Color c) {
    scarfColor = c;
  }
}
