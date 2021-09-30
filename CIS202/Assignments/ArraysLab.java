import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ArraysLab extends JPanel {

  static String filename;
  ArrayList coords;

  public ArraysLab() {
    try {
      File f = new File(filename);
      Scanner s = new Scanner(f, "UTF-8");

      while (s.hasNextLine()) {
        String curLine = s.nextLine();

        if (curLine == "200 200" || curLine == "300 300" || curLine == "400 400") {
          continue;
        }

        String[]  = curLine.split(" ");
        for (int i = 0; i < ints.length; i++) {
          int[] 
          if (i == 0) {

          }
        }
      }

      s.close();
    } catch (FileNotFoundException e) {
      System.out.println("File not found " + e);
      System.exit(1);
    }

  }

  @Override
  public void paintComponent(Graphics g) {
    // TODO
  }

  public static void main(String[] args) {
    JFrame window = new JFrame();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    filename = args[0];
    window.setContentPane(new ArraysLab());
    window.setSize(400, 400);
    window.setVisible(true);
  }

}