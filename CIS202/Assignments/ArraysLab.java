import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ArraysLab extends JPanel {

  File file;
  ArrayList<Integer[]> coords;

  public ArraysLab() {
    // I wanted to use a file chooser rather than text input
    // I found this code in the documentation for Java
    // as such I'll comment each line to explain what it does

    // This line declares the variable like the JFrame or JPanel we've been using
    JFileChooser choose = new JFileChooser();
    // This line creates a filter so the user can only choose the specified file types
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Documents", "txt");
    // This applies the filter to the chooser
    choose.setFileFilter(filter);
    // This line both displays the file chooser and creates an int to ensure the user
    // clicked the Approve option rather than closed the window
    int returnVal = choose.showOpenDialog(null);
    // This if statement checks to make sure the Approve option was clicked
    if (returnVal == JFileChooser.APPROVE_OPTION) {
      // This sets the file field I created to it can be used in the Paint Component function
      file = choose.getSelectedFile();
    // This else statement closes the program if the user closes the file chooser window
    } else {
      System.exit(1);
    }
    
  }

  @Override
  public void paintComponent(Graphics g) {
    // I'm not sure I need a try/catch block since I already know
    // the file exists since it was chosen by the file picker, but
    // I'm using it since that is what was requested
    try {
      Scanner s = new Scanner(file, "UTF-8");

      // This loop scans the file for each line
      while (s.hasNextLine()) {

        // I need these variables to draw the lines
        int[] xPoints;
        int[] yPoints;
        int points = 0;
        String curLine = s.nextLine();

        // First I ignore the first line because I don't want to deal with it
        if (curLine.equals("200 200") || curLine.equals("300 300") || curLine.equals("400 400")) {
          continue;
        } else {
          // Here I take each line of the file and create an array for it
          String[] coordinates  = curLine.split(" ");
          // I need array lists because I need to ensure I don't go out of bounds
          // in the xPoints and yPoints arrays
          ArrayList<Integer> xCoords = new ArrayList<>();
          ArrayList<Integer> yCoords = new ArrayList<>();
          
          // This will assign the integers to the different variables above
          for (int i = 0; i < coordinates.length; i++) {
            if (i == 0) {
              points = Integer.parseInt(coordinates[i]);
            } else if (i % 2 == 0) {
              yCoords.add(Integer.parseInt(coordinates[i]));
            } else {
              xCoords.add(Integer.parseInt(coordinates[i]));
            }
          }

          // one last loop to convert the ArrayLists to primative int[]
          xPoints = new int[xCoords.size()];
          yPoints = new int[yCoords.size()];
          for (int k = 0; k < points; k++) {
            xPoints[k] = xCoords.get(k);
            yPoints[k] = yCoords.get(k);
          }
          
        }
        g.drawPolyline(xPoints, yPoints, points);
      }

      // I don't want my Code Editor getting mad at me for leaving a memory leak
      s.close();

    // I need to make sure the program quits properly if the file doesn't work
    } catch (FileNotFoundException e) {
      System.out.println("File not found " + e);
      System.exit(1);
    }
  }

  // boilerplate code to display a drawn window
  public static void main(String[] args) {
    JFrame window = new JFrame();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setContentPane(new ArraysLab());
    window.setSize(400, 400);
    window.setVisible(true);
  }

}