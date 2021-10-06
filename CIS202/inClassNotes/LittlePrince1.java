import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;

public class LittlePrince extends JPanel {
	int dx;
  int dy;

	public LittlePrince() {
		//Your custom initialization code here
    String input = JOptionPane.showInputDialog("Enter the x offset for the little prince");
    dx = Integer.parseInt(input);
    String yInput = JOptionPane.showInputDialog("Enter the y offset for the little prince");
    dy = Integer.parseInt(yInput);
	}

	@Override
	public void paintComponent(Graphics g) {
		int w = getWidth();
    int h = getHeight();
    Color tan = new Color(247, 216, 158);
    Color brown = new Color(115, 78, 8);

    //draw background
    g.setColor(Color.BLUE);
    g.fillRect(0, 0, w, h);
    g.setColor(brown);
    g.fillOval(-100, (h-125), (w + 200), h);

    //Draw the little prince
    //Draw his head
    g.setColor(tan);
    g.fillOval(dx, dy, 50, 50);
    g.setColor(Color.BLACK);
    g.drawLine((dx + 15), (dy + 30), (dx + 35), (dy + 30));

    //draw his shirt and pants
    g.setColor(Color.GREEN);
    g.fillRect(dx, (dy + 50), 50, 150);
    g.fillRect(dx, (dy + 190), 15, 75);
    g.fillRect((dx + 35), (dy + 190), 15, 75);

    //draw his scarf
    g.setColor(Color.YELLOW);
    g.fillRect((dx + 15), (dy + 45), 150, 15);
    g.setColor(Color.BLACK);
    g.drawString("Le Petit Prince", (dx + 17), (dy + 57));

	}

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(400,400);
		window.setContentPane(new LittlePrince());
		window.setVisible(true);
	}
}