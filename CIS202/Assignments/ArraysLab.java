import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ArraysLab extends JPanel {

  static String filename;
  ArrayList<Integer[]> coords;

  public ArraysLab() {
    try {
      File f = new File(filename);
      Scanner s = new Scanner(f, "UTF-8");

      while (s.hasNextLine()) {
        String curLine = s.nextLine();

        if (curLine.equals("200 200") || curLine.equals("300 300") || curLine.equals("400 400")) {
          continue;
        } else {
          String[] coordinates  = curLine.split(" ");
          ArrayList<Integer> xCoords = new ArrayList<>();
          ArrayList<Integer> yCoords = new ArrayList<>();
          for (int i = 0; i < coordinates.length; i++) {
            if (i == 0) {
              continue;
            }

            if (i % 2 == 0) {
              yCoords.add(Integer.parseInt(coordinates[i]));
            } else {
              xCoords.add(Integer.parseInt(coordinates[i]));
            }
          }

          System.out.println(xCoords);
          System.out.println(yCoords);
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