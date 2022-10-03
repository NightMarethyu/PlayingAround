import java.util.Scanner;

public class Main {

  /**
   * The constructor runs the bulk of the logic. It pulls data from System.in, converts the information to doubles,
   * then runs the closed form solution for the equation.
   */
  public Main() {
    Scanner s = new Scanner(System.in);
    double sOne = Double.parseDouble(s.nextLine().split(" ")[1]);
    double c = Double.parseDouble(s.nextLine().split(" ")[1]);
    double gx = Double.parseDouble(s.nextLine().split(" ")[1]);

    // This is the general formula for the closed form solution. Printed with variables
    System.out.printf("S(n) = %.2f^(n-1) * %.2f + sigma(%.2f^(n-i) * %.2f)\n", c, sOne, c, gx);

    // This loop calculates the first ten values of the algorithm
    for (int i=1; i<11; i++) {
      var sig = sigma(i, gx, c);
      double step = (Math.pow(c, i-1) * sOne) + sig;
      System.out.printf("S(%d) = %f\n", i, step);
    }
  }

  /**
   * Performs the Sigma summation calculation for the closed form solution of the first order algorithm. loops through
   * the values of n starting from one to n
   *
   * @param n   The iteration of the algorithm
   * @param gx  The equation at the end of the closed form solution
   * @param c   The constant that is being summed up
   * @return    The value of the summation of c to the n power multiplied by gx
   */
  public double sigma(int n, double gx, double c) {
    double sum = 0;
    for (int i=2; i<=n; i++) {
      sum += Math.pow(c, n-i);
    }
    return sum * gx;
  }

  // entry-point to the program, all it does is create a new Main object.
  public static void main(String[] args) {
    new Main();
  }
}