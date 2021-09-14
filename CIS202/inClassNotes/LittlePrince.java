import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;

public class LIttlePrince extends JPanel {
	
	public LIttlePrince() {
		//Your custom initialization code here
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
    g.fillOval((int)(w / 2.286), (h - 350), 50, 50);
    g.setColor(Color.BLACK);
    g.drawLine((int)((w / 2.286) + 15), (h - 320), (int)((w / 2.286) + 35), (h - 320));

    //draw his shirt and pants
    g.setColor(Color.GREEN);
    g.fillRect((int)(w / 2.286), (h - 300), 50, 150);
    g.fillRect((int)(w / 2.286), (h - 160), 15, 75);
    g.fillRect((int)((w / 2.286) + 35), (h - 160), 15, 75);

    //draw his scarf
    g.setColor(Color.YELLOW);
    g.fillRect((int)((w / 2.286) + 15), (h - 305), 150, 15);
    g.setColor(Color.BLACK);
    g.drawString("Le Petit Prince", (int)((w / 2.139) + 17), (h - 293));

	}

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(400,400);
		window.setContentPane(new LIttlePrince());
		window.setVisible(true);
	}
}