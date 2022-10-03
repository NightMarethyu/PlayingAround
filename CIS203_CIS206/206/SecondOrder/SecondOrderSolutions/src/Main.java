import java.util.Scanner;

public class Main {

  /**
   * the constructor for Main uses Scanner to get the definition of the recursive function from System.in, then uses that
   * to calculate the closed form solution. It will call the quadratic() method twice to calculate both roots, then it
   * will use those roots and the values of S(1) and S(2) to calculate the other constants in the closed form solution.
   * Once the values of r1, r2, p, and q are calculated they are printed to System.out along with the closed form solution,
   * and the first ten values of the recursive relation.
   */
  public Main() {
    boolean rEqual;
    double p, q;
    Scanner s = new Scanner(System.in);
    var sOne = Integer.parseInt(s.nextLine().split(" ")[1]);
    var sTwo = Integer.parseInt(s.nextLine().split(" ")[1]);
    var cOne = Integer.parseInt(s.nextLine().split(" ")[1]);
    var cTwo = Integer.parseInt(s.nextLine().split(" ")[1]);

    var rOne = quadratic(-cOne, -cTwo, true);
    var rTwo = quadratic(-cOne, -cTwo, false);

    if (rOne == rTwo) {
      rEqual = true;
      p = sOne;
      q = (sTwo - (p * rOne)) / rOne;
    } else {
      rEqual = false;
      q = (sTwo - (sOne * rOne)) / (rTwo - rOne);
      p = sOne - q;
    }
    System.out.println("r1 = "+rOne);
    System.out.println("r2 = "+rTwo);
    System.out.println("p = "+p);
    System.out.println("q = "+q);

    if(rEqual) {
      System.out.println("S(n) = ("+p+")("+rOne+")^(n-1) + ("+q+")(n-1)("+rOne+")^(n-1)");
    } else {
      System.out.println("S(n) = ("+p+")("+rOne+")^(n-1) + ("+q+")("+rTwo+")^(n-1)");
    }

    for (int i = 1; i < 11; i++) {
      System.out.println("S("+ i +") = "+closedForm(rOne, rTwo, p, q, i, rEqual));
    }

  }

  /**
   * A really simple implementation of the Quadratic formula. This is a use specific quadratic formula calculator.
   * It only barely handles imaginary numbers by returning 0, but for the specific use case here, it functions well.
   *
   * @param cOne the first constant in the recursive definition, equivalent to b in the standard quadratic formula
   * @param cTwo the second constant in the recursive definition, equivalent to c in the standard quadratic formula
   * @param isFirst a boolean to differentiate between the plus and minus to calculate both roots of the formula
   * @return returns a double that is one of the roots of the binomial equation
   */
  public double quadratic(int cOne, int cTwo, boolean isFirst) {
    var inside = Math.pow(cOne, 2) - 4 * (cTwo);
    if (inside < 0) {
      return 0;
    } else if(isFirst) {
      return (-cOne + Math.sqrt(inside)) / 2;
    } else {
      return (-cOne - Math.sqrt(inside)) / 2;
    }
  }

  /**
   * Calculates a value of the recursive function at the nth step. This uses the numbers calculated earlier in the program.
   *
   * @param rOne the first root found for the binomial equation
   * @param rTwo the second root found for the binomial equation
   * @param p the first constant in the equation
   * @param q the second constant in the equation
   * @param n the step in the recursive function to calculate at
   * @param rEqual a boolean for when the roots are equal, as the function is slightly different for equal roots
   * @return a double that is the nth value of the recursive function
   */
  public double closedForm(double rOne, double rTwo, double p, double q, int n, boolean rEqual) {
    var start = p * Math.pow(rOne, (n-1));
    if (rEqual) {
      return  start + q * (n-1) * Math.pow(rOne, (n-1));
    } else {
      return start + q * Math.pow(rTwo, (n-1));
    }
  }

  public static void main(String[] args) {
    new Main();
  }
}