import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Main extends JPanel implements KeyListener {

  public static final int CELL_SIZE = 60;

  public int rows;
  public int columns;
  public Ammon ammon;
  public ArrayList<Robber> robbers;
  public ArrayList<Sheep> flock;
  public ArrayList<Tree> trees;
  public ArrayList<Water> waters;
  public ArrayList<Sprite> sprites;
  private int sheepCount;
  private int robberCount;

  // The constructor sets up the basic scene for
  // the game by assigning locations to all the
  // sprites that will be used. It calls the
  // reset method to instantiate the movable sprites.
  public Main() {
    rows = 10;
    columns = 10;
    sprites = new ArrayList<>();

    // We need a keyListener
    addKeyListener(this);

    // Add the trees
    trees = new ArrayList<>();
    trees.add(new Tree(2, 2));
    trees.add(new Tree(3, 2));
    trees.add(new Tree(6, 2));
    trees.add(new Tree(7, 2));
    trees.add(new Tree(2, 3));
    trees.add(new Tree(3, 3));
    trees.add(new Tree(6, 3));
    trees.add(new Tree(7, 3));

    // Add the water
    waters = new ArrayList<>();
    waters.add(new Water(4, 4));
    waters.add(new Water(5, 4));
    waters.add(new Water(4, 5));
    waters.add(new Water(5, 5));
    waters.add(new Water(4, 6));
    waters.add(new Water(5, 6));
    waters.add(new Water(4, 7));
    waters.add(new Water(5, 7));

    sprites.addAll(trees);
    sprites.addAll(waters);

    // add the sheep and robbers
    reset();
  }

  // We need to draw the sprites and background
  @Override
  public void paintComponent(Graphics g) {
    int w = getWidth();
    int h = getHeight();
    this.requestFocusInWindow();

    int gameHeight = rows * CELL_SIZE;
    int gameWidth = columns * CELL_SIZE;

    // Draw the background
    g.setColor(Color.LIGHT_GRAY);
    g.fillRect(0, 0, w, h);
    g.setColor(Color.BLACK);
    g.drawRect(9, 9, gameWidth + 2, gameHeight + 2);
    g.setColor(new Color(152, 229, 126));
    g.fillRect(10, 10, gameWidth, gameHeight);

    g.setColor(Color.BLACK);
    String sheepInfo = "Sheep remaining: " + sheepCount;
    g.drawString(sheepInfo, 10, gameHeight + 25);
    String robberInfo = "Robbers remaining: " + robberCount;
    g.drawString(robberInfo, gameWidth - 120, gameHeight + 25);

    // Draw the sprites
    for (Sprite sprite : sprites) {
      sprite.draw(g);
    }

  }

  // The key pressed method checks if Ammon can move
  // and then move him to the new location
  // This will also call noTree to check for trees
  // before moving Ammon.
  @Override
  public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();
    Point nextPos = new Point(ammon.getRelativePosition());

    switch (key) {
      case KeyEvent.VK_UP -> nextPos.y = nextPos.y != 0 ? nextPos.y - 1 : nextPos.y;
      case KeyEvent.VK_DOWN -> nextPos.y = nextPos.y < this.rows - 1 ? nextPos.y + 1 : nextPos.y;
      case KeyEvent.VK_LEFT -> nextPos.x = nextPos.x != 0 ? nextPos.x - 1 : nextPos.x;
      case KeyEvent.VK_RIGHT -> nextPos.x = nextPos.x < this.columns - 1 ? nextPos.x + 1 : nextPos.x;
      case KeyEvent.VK_W -> shoot('n');
      case KeyEvent.VK_A -> shoot('w');
      case KeyEvent.VK_S -> shoot('s');
      case KeyEvent.VK_D -> shoot('e');
    }
    if (noTree(nextPos)) {
      checkSprites(nextPos);
    }
  }

  // This method will check if there is a tree in the
  // position that Ammon will move to. It will return
  // true if there is not a tree there.
  public boolean noTree(Point p) {
    boolean value = true;
    for (Tree tree : trees) {
      if (tree.isTouching(p)) {
        value = false;
        break;
      }
    }
    return value;
  }

  // This method checks if Ammon is near a robber,
  // if he picks up a sheep or if he has fallen in
  // the water it will take the appropriate action
  // if any of those action happen. It will check
  // to make sure that there are still sheep left and
  // end the game if all sheep have been rescued.
  private void checkSprites(Point nextPos) {
    ammon.setLocation(nextPos);

    for (Robber rob : robbers) {
      if (rob.isNear(ammon)){
        var choice = JOptionPane.showConfirmDialog(this, "Oh no, Ammon was killed by a robber");
        if (choice == JOptionPane.YES_OPTION) {
          reset();
        } else {
          System.exit(0);
        }
      }
    }

    for (Sheep sheep : flock) {
      if (sheep.equals(ammon)) {
        sheep.setLocation(null);
        sheepCount--;
      }
    }

    for (Water water : waters) {
      if (water.equals(ammon)) {
        var choice = JOptionPane.showConfirmDialog(this, "Oh no, Ammon drowned! Play again?");
        if (choice == JOptionPane.YES_OPTION) {
          reset();
        } else {
          System.exit(0);
        }
      }
    }

    if (sheepCount == 0) {
      var choice = JOptionPane.showConfirmDialog(this, "You Win! Play Again?");
      if (choice == JOptionPane.YES_OPTION) {
        reset();
      } else {
        System.exit(0);
      }
    }

    repaint();
  }

  // This method resets all the removable sprites and puts Ammon
  // back in the starting position.
  private void reset() {
    ammon = new Ammon(0, 0);

    robberCount = 6;

    // Add the robbers to the screen
    robbers = new ArrayList<>();
    robbers.add(new Robber(0, 7));
    robbers.add(new Robber(1, 4));
    robbers.add(new Robber(3, 0));
    robbers.add(new Robber(5, 8));
    robbers.add(new Robber(7, 1));
    robbers.add(new Robber(7, 5));

    sprites.addAll(robbers);

    sheepCount = 9;

    // Add the Sheep
    flock = new ArrayList<>();
    flock.add(new Sheep(4, 3));
    flock.add(new Sheep(3, 5));
    flock.add(new Sheep(3, 6));
    flock.add(new Sheep(3, 7));
    flock.add(new Sheep(3, 8));
    flock.add(new Sheep(6, 5));
    flock.add(new Sheep(6, 6));
    flock.add(new Sheep(6, 7));
    flock.add(new Sheep(6, 8));

    sprites.addAll(flock);

    // I add ammon to the sprites array last so that he will
    // be the last thing drawn. This will put him on top of
    // other sprites. I found this looked better during my initial testing
    sprites.add(ammon);

  }

  // This method will check if Ammon hits anything
  // with his sling. It feeds into the spriteHit
  // method to check for hits. This will loop through
  // points to check if they are clear or not.
  public void shoot(char direction) {
    int x = ammon.getRelativePosition().x;
    int y = ammon.getRelativePosition().y;
    switch (direction) {
      case 'n':
        for (int i = y; i > 0; i--) {
          Point p = new Point(x, i);
          if (spriteHit(p)) {
            return;
          }
        }
        break;
      case 's':
        for (int i = y; i < rows; i++) {
          Point p = new Point(x, i);
          if (spriteHit(p)) {
            return;
          }
        }
        break;
      case 'e':
        for (int i = x; i < columns; i++) {
          Point p = new Point(i, y);

          if (spriteHit(p)) {
            return;
          }
        }
        break;
      case 'w':
        for (int i = x; i > 0; i--) {
          Point p = new Point(i, y);
          if (spriteHit(p)) {
            return;
          }
        }
        break;
    }
  }

  // this method works with the shoot method to
  // check if there is a sprite at the provided
  // point. It will take action based on if the
  // point is occupied.
  private boolean spriteHit(Point p) {
    for (Robber rob : robbers) {
      if (rob.isTouching(p)) {
        rob.setLocation(null);
        robberCount = robberCount - 1;
        return true;
      }
    }

    for (Sheep lamb : flock) {
      if (lamb.isTouching(p)) {
        JOptionPane.showMessageDialog(this, "Don't kill the sheep!");
        reset();
        return true;
      }
    }

    for (Tree tree : trees) {
      if (tree.isTouching(p)) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    JFrame window = new JFrame();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setSize(640, 680);
    window.setContentPane(new Main());
    window.setVisible(true);
  }

  // I don't need the keyTyped method for this project
  @Override
  public void keyTyped(KeyEvent e) {}
  // I don't need the keyReleased method for this project
  @Override
  public void keyReleased(KeyEvent e) {}
}
