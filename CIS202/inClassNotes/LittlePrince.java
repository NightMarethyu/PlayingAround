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
		int w = 400;
    int h = 400;
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
    g.fillOval(175, 50, 50, 50);
    g.setColor(Color.BLACK);
    g.drawLine(190, 80, 210, 80);

    //draw his shirt and pants
    g.setColor(Color.GREEN);
    g.fillRect(175, 100, 50, 150);
    g.fillRect(175, 240, 15, 75);
    g.fillRect(210, 240, 15, 75);

    //draw his scarf
    g.setColor(Color.YELLOW);
    g.fillRect(185, 95, 150, 15);
    g.setColor(Color.BLACK);
    g.drawString("Le Petit Prince", 187, 107);

	}

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(400,400);
		window.setContentPane(new LIttlePrince());
		window.setVisible(true);
	}
}