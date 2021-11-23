import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MethodLab extends JPanel {

  ArrayList<String> instructions;

  public MethodLab() {

    try {
      // We create a text field to capture user input
      JTextField filename = new JTextField(20);

      // then we create the panel that will be shown
      JPanel input = new JPanel();

      // add to the panel to display what we want the user to see
      input.add(new JLabel("Enter Filename:"));
      input.add(filename);

      // display the okay choices
      var res = JOptionPane.showConfirmDialog(null, input, "Filename", JOptionPane.OK_CANCEL_OPTION);

      if (res == JOptionPane.OK_OPTION) {
        File f = new File(filename.getText());
        Scanner s = new Scanner(f);
        instructions = new ArrayList<>();

        while (s.hasNextLine()) {
          String line = s.nextLine();
          if (line.equals("")) {
            continue;
          }
          instructions.add(line);
        }
      } else {
        System.exit(-1);
      }

      // Close the program if the user selected a bad file
    } catch (FileNotFoundException e) {
      System.out.println("File not found " + e);
      System.exit(-1);
    }
  }

  @Override
  public void paintComponent(Graphics g) {
    // I just need to loop through the instructions field and pass
    // each item into the parse command method
    for (String c : instructions) {
      parseCommand(c, g);
    }
  }

  // boiler-plate code to display window
  public static void main(String[] args) {
    JFrame window = new JFrame();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setSize(400,400);
    window.setContentPane(new MethodLab());
    window.setVisible(true);
  }

  // This method will create a new color based on provided integers
  // it will then set the color of the Graphics variable
  public void changeColor(int red, int green, int blue, Graphics g) {
    Color customCol = new Color(red, green, blue);
    g.setColor(customCol);
  }

  // This method will draw a triangle by connecting three points provided as
  // 6 integers, it will draw lines between each of those points with the Graphics variable
  public void drawTriangle(int x1, int y1, int x2, int y2, int x3, int y3, Graphics g) {
    g.drawLine(x1, y1, x2, y2);
    g.drawLine(x2, y2, x3, y3);
    g.drawLine(x3, y3, x1, y1);
  }

  // This method draws a circle given its center and radius.
  // It calculates the x and y point by subtracting the radius from
  // the given center point.
  public void drawCircle(int xc, int yc, int r, Graphics g) {
    int tx = xc - r;
    int ty = yc - r;
    int d = r * 2;
    g.drawOval(tx, ty, d, d);
  }

  // parseCommand will take the given string and separate it into the individual
  // parts at each space. It will then loop through the integers and put them into
  // an ArrayList and pass those to the appropriate method based on the first
  // string in the command.
  public void parseCommand(String command, Graphics g) {
    String[] parts = command.split(" ");
    ArrayList<Integer> coords = new ArrayList<>();
    for (int i = 1; i < parts.length; i++) {
      coords.add(Integer.parseInt(parts[i]));
    }

    // Here is the logic to choose the drawing method
    // I choose a switch/case to learn a little more Java syntax
    // IntelliJ suggested I use an "enhanced switch" here which I found helpful
    switch (parts[0]) {
      case "CIRCLE" -> drawCircle(coords.get(0), coords.get(1), coords.get(2), g);
      case "TRIANGLE" -> drawTriangle(coords.get(0), coords.get(1), coords.get(2), coords.get(3), coords.get(4), coords.get(5), g);
      case "COLOR" -> changeColor(coords.get(0), coords.get(1), coords.get(2), g);
      default -> System.out.println("Not A valid Command");
    }
  }
}