import javax.swing.*;

import org.w3c.dom.events.MouseEvent;

import java.awt.Color;
import java.awt.Graphics;

public class ConditionalLogicLab extends JPanel {
  String classAssign;
  ImageIcon img;

  public ConditionalLogicLab() {
    String imgFolder = "ConditionalLogicImages/";
    String[] genderChoices = { "Male", "Female" };

    // Get the user's age and convert it to an integer
    JTextField input = new JTextField(5);
    JComboBox genders = new JComboBox<>(genderChoices);
    int age = 0;
    String gender = "";

    JPanel dialog = new JPanel();
    dialog.add(new JLabel("Age at the end of the year:"));
    dialog.add(input);
    dialog.add(Box.createHorizontalStrut(15));
    dialog.add(new JLabel("Gender:"));
    dialog.add(genders);
    dialog.setLayout(new BoxLayout(dialog, BoxLayout.Y_AXIS));

    var result = JOptionPane.showConfirmDialog(null, dialog, "Enter Age and Gender", JOptionPane.OK_CANCEL_OPTION);
    
    if (result == JOptionPane.OK_OPTION) {
      age = input.getText().chars().allMatch(Character::isDigit) ? Integer.parseInt(input.getText()) : -1;
      gender = (String)genders.getSelectedItem();
    } else {
      System.exit(-1);
    }

    // This line is the same as above but it doesn't use the :: operator as a shortcut
    // I want to leave this in as a reference for me
    // int age = input.chars().allMatch(c-> Character.isDigit(c)) ? Integer.parseInt(input) : -1;

    // Get the user's gender and assign it to the field    
    // String gender = (String)JOptionPane.showInputDialog(null, "Choose one", "Input", JOptionPane.QUESTION_MESSAGE, null, genderChoices, genderChoices[0]);

    // Begin the big if block that checks user's age

    // This first one will check if they are in primary
    if (age >= 0 && age < 12) {
      classAssign = "You belong in primary";
      img = new ImageIcon(imgFolder + "rockchapel.jpg");

    // This block checks if they are in deacons/beehive
    } else if (age == 12 || age == 13) {
      if (gender.equals("Female")) {
        img = new ImageIcon(imgFolder + "beehive.gif");
        classAssign = "You belong to the Young Women 12-13 class";
      } else {
        img = new ImageIcon(imgFolder + "deacon.jpg");
        classAssign = "You belong to the Deacons quorum";
      }

    // This block checks if they are in teachers/miamaids
    } else if (age == 14 || age == 15) {
      if (gender.equals("Female")) {
        img = new ImageIcon(imgFolder + "miamaid.gif");
        classAssign = "You belong to the Young Women 14-15 class";
      } else {
        img = new ImageIcon(imgFolder + "teacher.jpg");
        classAssign = "You belong to the Teachers quorum";
      }

    // This block checks if they are in preists/laurels
    } else if (age == 16 || age == 17) {
      if (gender.equals("Female")) {
        img = new ImageIcon(imgFolder + "laurel.gif");
        classAssign = "You belong to the Young Women 16-17 class";
      } else {
        img = new ImageIcon(imgFolder + "priest.jpg");
        classAssign = "You belong to the Priests quorum";
      }

    // This block checks if they are in RS/Elders
    } else if (age >= 18 && age <= 119) {
      if (gender.equals("Female")) {
        img = new ImageIcon(imgFolder + "RS.jpg");
        classAssign = "You are a member of the Relief Society";
      } else {
        img = new ImageIcon(imgFolder + "elders.jpg");
        classAssign = "You are a member of the Elders quorum";
      }

    // This should chatch any age value outside 0 - 119
    } else {
      classAssign = "Are you sure you typed that correctly?";
    }
  }

  @Override
  public void paintComponent(Graphics g) {
    // draw the actual image

    g.setColor(Color.BLACK);
    g.drawString(classAssign, 10, 15);
    if (img != null) {
      img.paintIcon(null, g, 10, 25);
    }

    JButton refresh = new JButton();

    add(refresh);
    
  }

  public static void main(String[] args) {
    JFrame window = new JFrame();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setSize(400,400);
    window.setContentPane(new ConditionalLogicLab());
    window.setVisible(true);
  }

  private class ButtonAction implements MouseEvent {
    
  }
}