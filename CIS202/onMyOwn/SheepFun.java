import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;

public class SheepFun extends JPanel {
	
	public SheepFun() {
		//Your custom initialization code here
	}

	@Override
	public void paintComponent(Graphics g) {
		//Your custom rendering code here
    g.setColor(Color.GREEN);
    int w = getWidth();
    int h = getHeight();
    g.fillRect(0, 0, w, h);
    g.setColor(Color.WHITE);
    g.fillOval(75, 200, 225, 100);
    g.fillOval(50, 150, 75, 75);
	}

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(400,400);
		window.setContentPane(new SheepFun());
		window.setVisible(true);
	}
}