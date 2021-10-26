import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Room currentRoom;

    Room[] rooms = new Room[9];
    for (int i = 0; i < 9; i++) {
      rooms[i] = new Room(i);
    }

    rooms[0].setSouthExit(rooms[3]);
    rooms[1].setEastExit(rooms[2]);
    rooms[1].setSouthExit(rooms[4]);
    rooms[3].setWestExit(rooms[4]);
    rooms[3].setSouthExit(rooms[6]);
    rooms[4].setEastExit(rooms[5]);
    rooms[5].setSouthExit(rooms[8]);
    rooms[7].setEastExit(rooms[8]);

    currentRoom = rooms[6];
    Scanner s = new Scanner(System.in);

    while (true) {
      // describe the current room to the player
      currentRoom.describe();

      // ask user where they want to go
      System.out.print("Which doorway will you take? ");
      String input = s.nextLine();

      switch (input) {
        case "n" -> currentRoom = currentRoom.getNorthExit();
        case "s" -> currentRoom = currentRoom.getSouthExit();
        case "e" -> currentRoom = currentRoom.getEastExit();
        case "w" -> currentRoom = currentRoom.getWestExit();
        default -> System.out.println("Please choose a valid room.");
      }
    }

  }
}
