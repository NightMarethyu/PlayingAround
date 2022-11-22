import java.util.Scanner;

public class Queues {
  private Queues() {
    // scanner will read in the input
    Scanner s = new Scanner(System.in);
    // create a queue
    AmmonQueue<String> queue = new AmmonQueue<>();
    // read in a line
    String command = s.nextLine();
    // this while loop will repeat until the *** end of file marker
    while(!command.equals("***")) {
      // I use a switch statement to parse the commands in the file
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
