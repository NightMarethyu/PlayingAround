import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

public class YourClassNameHere extends JPanel {
	
	public YourClassNameHere() {
		//Your custom initialization code here
	}

	@Override
	public void paintComponent(Graphics g) {
		//Your custom rendering code here
	}

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(400,400);
		window.setContentPane(new YourClassNameHere());
		window.setVisible(true);
	}
}