import java.util.Objects;
import java.util.Scanner;

public class Stacks {

  public Stacks() {
    Scanner s = new Scanner(System.in);
    AmmonStack<String> stack = new AmmonStack<>();
    String command = s.nextLine();
    while (!command.equals("***")) {
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