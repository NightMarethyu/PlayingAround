import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;

public class LoopLab extends JPanel {
	
	public LoopLab() {
		// TODO
	}

	@Override
	public void paintComponent(Graphics g) {
		int w = getWidth();
		int h = getHeight();
		int stripeCount = 13;
		int stripeHeight = h / stripeCount;
		int starColumns = 8;
		int starRows = 6;
		int blueFieldWid = (int)(w * ( 2 / 5.0 ));
		int blueFieldHeight = stripeHeight * 7;
		int startY = 0;
		int starSize = starCalc(blueFieldWid, blueFieldHeight, starRows, starColumns);
		int starX = 0;
		int starY = 0;

		// Draw the Stripes
		for (int i = 0; i < stripeCount; i++) {

			// If the row is even draw a red stripe
			if ((i % 2) == 0) {
				g.setColor(Color.RED);
				g.fillRect(0, startY, w, stripeHeight);
				startY += stripeHeight;
				continue;
			} else {
				// Draw a white stripe if its an odd row
				g.setColor(Color.WHITE);
				g.fillRect(0, startY, w, stripeHeight);
				startY += stripeHeight;
				continue;
			}
		}

		// Draw the blue field
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, blueFieldWid, blueFieldHeight);

		// Time to add the stars
		g.setColor(Color.WHITE);
		for (int i = 0; i < starColumns; i++) {
			starY = 0;
			for (int j = 0; j < starRows; j++) {
				g.fillOval(starX, starY, starSize, starSize);
				starY += starSize;
			}
			starX += starSize;
		}

	}

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(400,400);
		window.setContentPane(new LoopLab());
		window.setVisible(true);
	}

	public static int starCalc(int w, int h, int rows, int columns) {
		int starH = h / rows;
		int starW = w / columns;

		if (starH < starW) {
			return starH;
		} else {
			return starW;
		}
		
	}
}