import java.util.Optional;

public class MagicRoom extends Room {
  private Room teleport;

  public MagicRoom(int id) {
    super(id);
    teleport = null;
  }

  public void setTeleport(MagicRoom m) {
    this.teleport = m;
  }

  @Override
  public void describe() {
    super.describe();
    System.out.println("This is a magic room! Type 't' to teleport!");
  }

  @Override
  public Optional<Room> getNextRoom(String command) {
    Optional<Room> r = super.getNextRoom(command);

    if (command.equals("t")) {
      r = Optional.ofNullable(teleport);
    }

    return r;
  }
}
