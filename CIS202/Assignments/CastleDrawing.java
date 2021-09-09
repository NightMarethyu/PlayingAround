import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;

public class CastleDrawing extends JPanel {
	
	public CastleDrawing() {
		//Your custom initialization code here
	}

	@Override
	public void paintComponent(Graphics g) {
		int w = getWidth();
    int h = getHeight();
    int sunSize = w / 6;
    
    // Draw The Background
    g.setColor(Color.CYAN);
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

    
	}

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    int windowSize = 400;

    if (args.length > 0) {
      if (args[0].chars().allMatch(Character::isDigit)) {
        windowSize = Integer.parseInt(args[0]);
      } 
    }

		window.setSize(windowSize,windowSize);
		window.setContentPane(new CastleDrawing());
		window.setVisible(true);
	}
}