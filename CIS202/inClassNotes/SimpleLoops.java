import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class SimpleLoops {

  public static void main(String[] args) {

    int i = 0;

    while (i < 5) {
      System.out.println("I'm inside a while loop! " + i);
      i++;
    }

    i = 0;

    do {
      System.out.println("I'm inside a do/while loop! " + i);
      i++;
    } while (i < 5);

    for (int j = 0; j < 5; j++) {
      System.out.println("I'm inside a for loop! " + j);
    }

    ArrayList<String> cosmere = new ArrayList<String>(
      List.of(
        "Way of Kings",
        "Words of Radiance",
        "Oathbringer",
        "Rhythm of War",
        "Elantris",
        "Warbreaker",
        "Final Empire",
        "Well of Ascension",
        "Hero of Ages",
        "Alloy of Law",
        "Shadows of Self",
        "Bands of Mourning",
        "The Lost Metal"
      )
    );

    for (String book:cosmere) {
      System.out.println(book);
    }

    var s = new Scanner(System.in);
    double sum = 0;
    while (true) {
      System.out.print("Please enter a number: ");
      String input = s.nextLine();

      if (input.equals("quit")) {
        break;
      }

      double ammon = Double.parseDouble(input);
      sum += ammon;
      System.out.println("Current total: " + sum);
    }

    System.out.println("Thank you. Your final total is: " + sum);

  }
  
}
