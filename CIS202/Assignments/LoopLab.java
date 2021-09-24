import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class LoopLab extends JPanel {
	int tableSize = 10;
	char addMul;

	public LoopLab() {
		String[] addMulSel = { "Multiplication", "Addition" };

		// This is the code for the pop up dialog box
		// This will display both the table size question
		// and the addition/multiplication question
		// I'm pretty sure it's better UX Design to do it this way
		JTextField size = new JTextField(5);
		JComboBox<String> select = new JComboBox<>(addMulSel);
		JPanel input = new JPanel();
		input.add(new JLabel("Table Size:"));
		input.add(size);
		input.add(new JLabel("Table Type"));
		input.add(select);

		var res = JOptionPane.showConfirmDialog(null, input, "Table Settings", JOptionPane.OK_CANCEL_OPTION);

		// this sets the variables for the addition or multiplication
		// and it checks to make sure the value entered into the
		// text field is valid, otherwise set it to 10
		if (res == JOptionPane.OK_OPTION) {
			if (!size.getText().equals("")) {
				tableSize = size.getText().chars().allMatch(Character::isDigit) ? Integer.parseInt(size.getText()) : 10;
			} else {
				tableSize = 10;
			}

			if (select.getSelectedItem() == "Addition") {
				addMul = 'a';
			} else {
				addMul = 'm';
			}
		} else {
			System.exit(-1);
		}

	}

	@Override
	public void paintComponent(Graphics g) {
		int w = getWidth();
		int h = getHeight();
		int columnSpace = (w - 20) / tableSize;
		int rowSpace = (h - 20) / tableSize;
		int inX = 10;
		int inY = 10;
		int startX = inX;
		int startY = inY;
		int fontSize = rowSpace / 3;

		// set the font for the font scaling extra credit
		g.setFont(new Font("SansSerif", Font.PLAIN, fontSize));

		// add the colored background for extra credit
		g.setColor(Color.GREEN);
		g.fillRect(inX, inY, (columnSpace * tableSize), rowSpace);
		g.fillRect(inX, inY, columnSpace, (rowSpace * tableSize));

		// not set everything to black and begin drawing things
		g.setColor(Color.BLACK);
		// draw the lines of the table
		for (int i = 0; i < (tableSize + 1); i++) {
			g.drawLine(startX, startY, startX, (startY + (rowSpace * tableSize)));
			startX += columnSpace;
		}

		// the variables need to be reset for the next loop to work
		startX = inX;
		startY = inY;
		for (int i = 0; i < (tableSize + 1); i++) {
			g.drawLine(startX, startY, (startX + (columnSpace * tableSize)), startY);
			startY += rowSpace;
		}

		startY = inY + (rowSpace / 2);

		// Time to do the math for the table
		for (int i = 0; i < tableSize; i++) {
			startX = inX + 10;
			// I've noticed if the table gets too small, this setting
			// throws the whole thing off, hence the if statement
			if (startX > columnSpace) {
				startX = inX;
			}
			for (int j = 0; j < tableSize; j++) {
				String val;
				// I was going to get fancy here with a switch/case and methods
				// but this is much less code
				// technically the methods would be more reusable, but this
				// assignment is about loops
				if (addMul == 'a') {
					val = String.valueOf((i + 1) + (j + 1));
				} else {
					val = String.valueOf((i + 1) * (j + 1));
				}
				g.drawString(val, startX, startY);
				startX += columnSpace;
			}
			startY += rowSpace;
		}
	}

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(400,400);
		window.setContentPane(new LoopLab());
		window.setVisible(true);
	}
}