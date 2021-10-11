import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Color;

public class LittlePrince extends JPanel {
	ImageIcon sheep;
	
	public LittlePrince() {
		sheep = new ImageIcon("sheep.png");
		double tithing = getTithing(42.25);
		System.out.println("Tithing owed is " + tithing);
		int aCount = countA("a software tester walks into a bar.");
		System.out.println("The a count is: " + aCount);
	}

	public double getTithing(double increase) {
		double tithe = increase * .1;
		return tithe;
		// return increase * 0.1;
	}

	public int countA(String stuff) {
		int curCount = 0;
		for (int i = 0; i < stuff.length(); i++) {
			char cur = stuff.charAt(i);
			if (cur == 'a') curCount++;
		}
		return curCount;
	}

	public void drawLittlePrince(Graphics g) {
		Color lightGreen = new Color(202,254,131);
		Color lightBrown = new Color(202,141,60);
		int dy = 0;
		int dx = 0;

		//draw his shirt and pants
		g.setColor(lightGreen);
		g.fillRect(dx+175, dy+100, 50, 150);
		g.fillRect(dx+175, dy+250, 15, 75);
		g.fillRect(dx+210, dy+250, 15, 75);

		//draw his head
		g.setColor(lightBrown);
		g.fillOval(dx+175, dy+40, 50, 60);
		g.setColor(Color.BLACK);
		g.drawLine(dx+190, dy+80, dx+210, dy+80);

		//draw his scarf
		g.setColor(Color.YELLOW);
		g.fillRect(dx+170, dy+90, 150, 20);
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

		drawLittlePrince(g);

		sheep.paintIcon(null, g, 10, h-150);
	}

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(400,400);
		window.setContentPane(new LittlePrince());
		window.setVisible(true);
	}
}
