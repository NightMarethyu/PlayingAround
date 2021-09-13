import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;

public class GraphicsLab extends JPanel {
	
	public GraphicsLab() {
		//Your custom initialization code here
	}

	@Override
	public void paintComponent(Graphics g) {
		// Declar Variables that will be used
    int w = getWidth();
    int h = getHeight();
    int standY = h - (200 + (h / 6));
    int standX = w - (200 + (w / 4));
    int sunSize = w / 6;
    int[] xCoords = {445, 460, 490, 500, 500, 480, 485, 445};
    int[] yCoords = {32, 22, 22, 15, 32, 32, 40, 32};
    Color brown = new Color(125, 72, 4);
    Color purple = new Color(117, 50, 168);
    
    // Draw The Background
    // Check if it is sunset
    if (sunSize > (h / 4)) {
      g.setColor(Color.ORANGE);
    } else {
      g.setColor(Color.CYAN);
    }
    g.fillRect(0, 0, w, h);
    g.setColor(Color.YELLOW);
    g.fillOval((w/15), (w/15), sunSize, sunSize);

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

    // Draw the Fruit Stand
    g.setColor(brown);
    g.fillRect(standX, standY, 200, 75);
    g.fillRect((standX + 15), (standY + 50), 15, 100);
    g.fillRect((standX + 170), (standY + 50), 15, 100);
    g.setColor(Color.GRAY);
    g.fillRect(standX, (standY + 125), 200, 75);

    // Draw the Grapes
    g.setColor(purple);
    drawGrapes(g, standX, standY, 40);
    drawGrapes(g, standX, standY, 80);
    drawGrapes(g, standX, standY, 120);

    // Add my initials
    g.setColor(Color.BLACK);

    // Letter A
    g.drawLine((standX + 10), (standY + 10), (standX + 10), (standY + 65));
    g.drawLine((standX + 60), (standY + 10), (standX + 60), (standY + 65));
    g.drawLine((standX + 10), (standY + 10), (standX + 60), (standY + 10));
    g.drawLine((standX + 10), (standY + 35), (standX + 60), (standY + 35));

    // Letter D
    g.drawLine((standX + 70), (standY + 10), (standX + 70), (standY + 65));
    g.drawLine((standX + 70), (standY + 10), (standX + 105), (standY + 10));
    g.drawLine((standX + 70), (standY + 65), (standX + 105), (standY + 65));
    g.drawLine((standX + 105), (standY + 10), (standX + 120), (standY + 25));
    g.drawLine((standX + 105), (standY + 65), (standX + 120), (standY + 50));
    g.drawLine((standX + 120), (standY + 25), (standX + 120), (standY + 50));

    // Letter T
    g.drawLine((standX + 130), (standY + 10), (standX + 180), (standY + 10));
    g.drawLine((standX + 155), (standY + 10), (standX + 155), (standY + 65));

    // Grape Price Text
    g.drawString("GRAPES: $1 A BUNCH", (standX + 40), (standY + 165));

    // Draw the Plane
    g.setColor(Color.RED);
    g.fillPolygon(xCoords, yCoords, 8);
    g.setColor(Color.WHITE);
    g.fillRect(510, 22, 100, 15);
    g.setColor(Color.BLACK);
    g.drawLine(500, 27, 510, 29);
    g.drawString("GO SEASIDERS!", 512, 34);    
	}

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    int windowSize = 400;

    if (args.length > 0) {
      if (args[0].chars().allMatch(Character::isDigit)) {
        windowSize = Integer.parseInt(args[0]);
      } else {
        System.out.println("Usage: GraphicsLab [int WindowSize]");
      }
    }

		window.setSize(windowSize,windowSize);
		window.setContentPane(new GraphicsLab());
		window.setVisible(true);
	}

  // This method builds the piles of grapes that sit on the stand
  public static void drawGrapes(Graphics g, int mainX, int mainY, int xPos) {
    g.fillOval((mainX + xPos), (mainY + 115), 10, 10);
    g.fillOval((mainX + xPos + 9), (mainY + 115), 10, 10);
    g.fillOval((mainX + xPos + 18), (mainY + 115), 10, 10);
    g.fillOval((mainX + xPos + 4), (mainY + 108), 10, 10);
    g.fillOval((mainX + xPos + 13), (mainY + 108), 10, 10);
    g.fillOval((mainX + xPos + 9), (mainY + 101), 10, 10);
  }
}