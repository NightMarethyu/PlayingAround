import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

public class ArrayLearning extends JPanel {
	
	public ArrayLearning() {
		//Your custom initialization code here
	}

	@Override
	public void paintComponent(Graphics g) {
    int[] xArray = { 25, 175, 175, 25 };
    int[] yArray = { 25, 25, 175, 175 };
    g.drawPolyline(xArray, yArray, 4);
  }

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(400,400);
		window.setContentPane(new ArrayLearning());
		window.setVisible(true);
	}
}