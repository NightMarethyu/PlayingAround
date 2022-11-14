import java.util.Scanner;

public class Queues {
  public Queues() {
    Scanner s = new Scanner(System.in);
    AmmonQueue<String> queue = new AmmonQueue<>();
    String command = s.nextLine();
    while(!command.equals("***")) {
      switch (command) {
        case "DEQUEUE" -> {
          AmmonNode<String> temp = queue.dequeue();
          if (temp != null) {
            System.out.println(temp);
          }
        }
        case "CLEAR" -> queue.clear();
        case "PRINT" -> queue.print();
        default -> {
          String[] temp = command.split(" ");
          queue.enqueue(temp[1]);
        }
      }
      command = s.nextLine();
    }
  }

  public static void main(String[] args) {
    new Queues();
  }
}
