import java.util.Optional;

public class Room {
  private String name;
  private int id;
  private Room eastExit;
  private Room westExit;
  private Room northExit;
  private Room southExit;

  public Room(int id) {
    this.id = id;
    name = ""+id;
    eastExit = null;
    westExit = null;
    northExit = null;
    southExit = null;
  }

  public void setEastExit(Room r) {
    this.eastExit = r;
    r.westExit = this;
  }

  public void setWestExit(Room r) {
    this.westExit = r;
    r.eastExit = this;
  }

  public void setSouthExit(Room r) {
    this.southExit = r;
    r.northExit = this;
  }

  public void setNorthExit(Room r) {
    this.northExit = r;
    r.southExit = this;
  }

  public void describe() {
    System.out.println("You are in room " + id);
    System.out.print("There are exits in the following directions: ");
    if (northExit != null) {
      System.out.print("North ");
    }
    if (southExit != null) {
      System.out.print("South ");
    }
    if (eastExit != null) {
      System.out.print("East ");
    }
    if (westExit != null) {
      System.out.print("West ");
    }
    System.out.println();
  }

  public Optional<Room> getNextRoom(String command) {
    Optional<Room> nextRoom = Optional.empty();

    if (command.equals("n")) {
      nextRoom = Optional.ofNullable(northExit);
    } else if (command.equals("s")) {
      nextRoom = Optional.ofNullable(southExit);
    } else if (command.equals("e")) {
      nextRoom = Optional.ofNullable(eastExit);
    } else if (command.equals("w")) {
      nextRoom = Optional.ofNullable(westExit);
    }

    return nextRoom;
  }

}
