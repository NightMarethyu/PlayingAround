import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

public class Convocation extends JPanel {
	
	String name1 = "Ammon";
	
	public Convocation() {
		greet("Lina", "tongan");
		greet("Aaron");
		greet("Kyle", "tongan");
		greet("Autumn", "french");
		greet("Ami");
		greet(name1, "french");
		greet(name1, 3);
	}
	
	public void greet(String name, String lang) {
		if (lang.equals("tongan")) {
			System.out.println("Malo e lelei, " + name);
		} else {
			System.out.println("Bonjour, " + name);
		}
	}

	public void greet(String name) {
		System.out.println("Hello, " + name);
	}

	public void greet(String name, int repeat) {
		for (int i = 0; i < repeat; i++) {
			System.out.println("Hello, " + name);
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		//behold! parallel arrays
		int[] xp = {150, 50, 50, 150};
		int[] yp = {175, 175, 25, 25};
		g.drawPolyline(xp, yp, 4);
	}

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(200,250);
		window.setContentPane(new Convocation());
		window.setVisible(true);
	}
}
