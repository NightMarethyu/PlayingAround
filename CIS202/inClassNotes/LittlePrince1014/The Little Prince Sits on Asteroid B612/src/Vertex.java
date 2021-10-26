import java.awt.Point;

public class Vertex {
  private int x;
  private int y;

  public Vertex(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public Vertex(Vertex v) {
    this(v.x, v.y);
  }

  public Vertex(Point p) { this(p.x, p.y); }

  public Vertex() {
    this(0, 0);
  }

  public void translate(int dx, int dy) {
    x += dx;
    y += dy;
  }

  public void setLocation(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public String toString() {
    return "{ " + x + ", " + y + " }";
  }

  public int getX(){
    return x;
  }

  public int getY() {
    return y;
  }
}
