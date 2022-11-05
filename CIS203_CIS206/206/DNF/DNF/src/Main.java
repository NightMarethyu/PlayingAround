import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public Main() {
    Scanner s = new Scanner(System.in);
    ArrayList<String> bools = new ArrayList<>();
    var names = s.nextLine().split(" ");
    s.nextLine();
    for (int i = 0; i < Math.pow(2, names.length-1); i++) {
      bools.add(s.nextLine());
    }

    ArrayList<String> dnf = new ArrayList<>();
    ArrayList<String> cnf = new ArrayList<>();
    for (String b : bools) {
      var split = b.split(" ");
      var row = new StringBuilder();
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

    StringBuilder dnfAns = new StringBuilder();
    for (int i = 0; i < dnf.size(); i++) {
      dnfAns.append((i == dnf.size()-1) ? dnf.get(i) : dnf.get(i) + "+");
    }

    StringBuilder cnfAns = new StringBuilder();
    for (String value : cnf) {
      cnfAns.append(value);
    }

    System.out.println("DNF: " + dnfAns);
    System.out.println("CNF: " + cnfAns);
  }

  public static void main(String[] args) {
    new Main();
  }
}