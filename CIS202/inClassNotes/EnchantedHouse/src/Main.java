import java.util.Locale;
import java.util.Optional;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Room currentRoom;

    var room0 = new MagicRoom(0);
    var room1 = new Room(1);
    var room2 = new Room(2);
    var room3 = new Room(3);
    var room4 = new Room(4);
    var room5 = new Room(5);
    var room6 = new Room(6);
    var room7 = new MagicRoom(7);
    var room8 = new Room(8);

    room0.setSouthExit(room3);
    room1.setEastExit(room2);
    room1.setSouthExit(room4);
    room3.setEastExit(room4);
    room3.setSouthExit(room6);
    room4.setEastExit(room5);
    room5.setSouthExit(room8);
    room7.setEastExit(room8);

    room0.setTeleport(room7);
    room7.setTeleport(room0);

    currentRoom = room6;
    Scanner s = new Scanner(System.in);

    while (true) {
      //1. tell user which room we're in, and the available doorways
      currentRoom.describe();
      //2. Let user choose which direction to go
      System.out.print("Which doorway will you take? ");
      String input = s.nextLine();

      Optional<Room> r = currentRoom.getNextRoom(input.toLowerCase());

      //3. update which room the user is in
      if (r.isEmpty()) {
        System.out.println("There is a wall there");
      } else {
        currentRoom = r.get();
      }

      //4. goto 1.
    }
  }
}
