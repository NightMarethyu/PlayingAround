import java.util.Scanner;

public class Stacks {

  private Stacks() {
    // scanner will read in the input
    Scanner s = new Scanner(System.in);
    // create a stack
    AmmonStack<String> stack = new AmmonStack<>();
    // read in a line
    String command = s.nextLine();
    // this while loop will repeat until the *** end of file marker
    while (!command.equals("***")) {
      // I use a switch statement to parse the commands of the stack
      switch (command) {
        case "POP" -> {
          AmmonNode<String> res = stack.pop();
          if (res != null) {
            System.out.println(res);
          }
        }
        case "CLEAR" -> stack.clear();
        case "PRINT" -> stack.print();
        default -> {
          String[] temp = command.split(" ");
          stack.push(temp[1]);
        }
      }
      command = s.nextLine();
    }
  }

  public static void main(String[] args) {
    new Stacks();
  }
}