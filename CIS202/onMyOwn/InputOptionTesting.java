import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Box;
import javax.swing.JComboBox;

import java.awt.Graphics;

public class InputOptionTesting extends JPanel {
	
	public InputOptionTesting() {
    String[] genderChoices = { "Male", "Female" };
    // I found this code here:
    // https://stackoverflow.com/questions/6555040/multiple-input-in-joptionpane-showinputdialog

    // Read these docs for the ConditionalLogicLab:
    // https://docs.oracle.com/javase/7/docs/api/javax/swing/JComboBox.html
    // https://www.geeksforgeeks.org/java-swing-jcombobox-examples/
		JTextField xField = new JTextField(5);
    JTextField yField = new JTextField(5);
    JComboBox listField = new JComboBox<>(genderChoices);

    JPanel myPanel = new JPanel();
    myPanel.add(new JLabel("x:"));
    myPanel.add(xField);
    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
    myPanel.add(new JLabel("y:"));
    myPanel.add(yField);
    myPanel.add(Box.createHorizontalStrut(15));
    myPanel.add(new JLabel("Gender:"));
    myPanel.add(listField);

    int result = JOptionPane.showConfirmDialog(null, myPanel, "Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION);
    if (result == JOptionPane.OK_OPTION) { 
      System.out.println("x value: " + xField.getText());
      System.out.println("y value: " + yField.getText());
      System.out.println("listField value: " + listField.getSelectedItem());
    }
	}

	@Override
	public void paintComponent(Graphics g) {
		//Your custom rendering code here
	}

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(400,400);
		window.setContentPane(new InputOptionTesting());
		window.setVisible(true);
	}
}