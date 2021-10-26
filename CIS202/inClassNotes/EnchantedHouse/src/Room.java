public class Room {
  private String name;
  private int id;
  private Room eastExit;
  private Room westExit;
  private Room northExit;
  private Room southExit;

  public Room(int id) {
    this.id = id;
    name = "" + id;
    eastExit = null;
    westExit = null;
    northExit = null;
    southExit = null;
  }

  public void setEastExit(Room r) {
    eastExit = r;
    r.westExit = this;
  }

  public void setWestExit(Room r) {
    westExit = r;
    r.eastExit = this;
  }

  public void setNorthExit(Room r) {
    northExit = r;
    r.southExit = this;
  }

  public void setSouthExit(Room r) {
    southExit = r;
    r.northExit = this;
  }

  public String getName() {
    return name;
  }

  public Room getEastExit() {
    return eastExit;
  }

  public Room getWestExit() {
    return westExit;
  }

  public Room getNorthExit() {
    return northExit;
  }

  public Room getSouthExit() {
    return southExit;
  }

  public void describe() {
    System.out.println("You are in room " + id);
    System.out.println("There are exits in the following directions:");
    if (northExit != null) {
      System.out.println("North");
    }
    if (southExit != null) {
      System.out.println("South");
    }
    if (eastExit != null) {
      System.out.println("East");
    }
    if (westExit != null) {
      System.out.println("West");
    }
  }
}
