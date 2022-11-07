import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public Main() {
    // Scanner will read in values from System.in
    Scanner s = new Scanner(System.in);

    // This ArrayList will hold the strings that represent the output of the table
    ArrayList<String> bools = new ArrayList<>();

    // The names of the variable for the input
    var names = s.nextLine().split(" ");
    s.nextLine();

    // The size of the table with the 2 to the power of the number of variables
    for (int i = 0; i < Math.pow(2, names.length-1); i++) {
      bools.add(s.nextLine());
    }

    // Create two arraylists to hold the parts of the DNF and CNF solutions
    ArrayList<String> dnf = new ArrayList<>();
    ArrayList<String> cnf = new ArrayList<>();

    // Loop over the values to put them into either the DNF solution or the CNF solution
    for (String b : bools) {
      var split = b.split(" ");
      // I use the StringBuilder class to make a string inside a loop
      var row = new StringBuilder();

      // If the row ends with 1 it is part of the DNF solution, otherwise it's part of CNF
      if (split[names.length - 1].equals("1")) {
        for (int i = 0; i < split.length - 1; i++) {
          row.append((split[i].equals("1")) ? names[i] : names[i] + "'");
        }
        dnf.add(row.toString());
      } else {
        row.append("(");
        for (int i = 0; i < split.length - 1; i++) {
          row.append((split[i].equals("0")) ? names[i] + "" : names[i] + "'");
          if (i == split.length - 2) {
            continue;
          }
          row.append("+");
        }
        row.append(")");
        cnf.add(row.toString());
      }
    }

    // A StringBuilder and a loop to make the DNF String
    StringBuilder dnfAns = new StringBuilder();
    for (int i = 0; i < dnf.size(); i++) {
      dnfAns.append((i == dnf.size()-1) ? dnf.get(i) : dnf.get(i) + "+");
    }

    // Another StringBuilder and loop to make the CNF String
    StringBuilder cnfAns = new StringBuilder();
    for (String value : cnf) {
      cnfAns.append(value);
    }

    // Display the solutions to the user
    System.out.println("DNF: " + dnfAns);
    System.out.println("CNF: " + cnfAns);
  }

  public static void main(String[] args) {
    new Main();
  }
}