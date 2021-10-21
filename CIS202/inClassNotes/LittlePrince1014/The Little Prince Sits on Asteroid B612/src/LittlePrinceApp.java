import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;

public class LittlePrinceApp extends JPanel {

  private final ImageIcon sheep;
  private ArrayList<LittlePrince> princes;

  public LittlePrinceApp() {
    sheep = new ImageIcon("sheep.png");

    princes = new ArrayList<>();

    princes.add(new LittlePrince());
    princes.add(new LittlePrince(new Vertex(150, -75), Color.DARK_GRAY));
    princes.add(new LittlePrince(new Vertex(100, 20)));
    princes.add(new LittlePrince(Color.BLUE));
    princes.get(3).move(-100, 10);

    //finding the area of Ami's circle
    var ami = getCircleArea(3);
    System.out.println("The area of Ami's circle is " + ami);
    System.out.printf("The area is %.5f%n", ami);
    System.out.println(howManyAs("Aaron"));
  }

  public double getCircleArea(double radius) {
    return Math.PI * radius * radius;
  }

  public double getTithing(double money) {
    return money / 10;
  }

  public int howManyAs(String word) {
    int count = 0;
    for (int i=0; i<word.length(); i++ ) {
      char ammon = word.charAt(i);
      if (ammon == 'a' || ammon == 'A') {
        count++;
      }
    }
    return count;
  }

  @Override
  public void paintComponent(Graphics g) {
    int w = getWidth();
    int h = getHeight();

    //draw the black vacuum of space
    g.setColor(Color.BLACK);
    g.fillRect(0,0,w,h);

    //draw asteroid B612
    g.setColor(Color.LIGHT_GRAY);
    g.fillOval(-100, 300, 600, 400);

    for (LittlePrince prince : princes) {
      prince.draw(g);
    }

    sheep.paintIcon(null, g, 10, h-150);
  }

  public static void main(String[] args) {
    JFrame window = new JFrame();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setSize(400,400);
    window.setContentPane(new LittlePrinceApp());
    window.setVisible(true);
  }
}