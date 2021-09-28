import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Temples {

  public static void main(String[] args) {
    int tempCount = 0;
    int utCount = 0;
    ArrayList<String> alphaTemps = new ArrayList<String>();

    try {
      String filename = args[0];
      File f = new File(filename);
      Scanner s = new Scanner(f, "UTF-8");

      while (s.hasNextLine()) {
        String temple = s.nextLine();

        if (temple.startsWith("//")) {
          continue;
        }

        if (temple.contains("Utah")) {
          alphaTemps.add(temple);
          utCount++;
        }

        tempCount++;
        // System.out.println(temple);
      }

      Collections.sort(alphaTemps);

      for (String tName:alphaTemps) {
        System.out.println(tName);
      }

      System.out.println("Total temple count: " + tempCount);
      System.out.println("Utah temple count: " + utCount);

      s.close();

    } catch (FileNotFoundException e) {
      System.out.println("File not found" + e);
      System.exit(1);
    }
    
  }

}
