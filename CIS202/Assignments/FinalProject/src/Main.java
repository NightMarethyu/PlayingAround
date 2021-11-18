import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Main extends JPanel implements KeyListener {

  public int rows;
  public int columns;
  public Ammon ammon;
  public ArrayList<Robber> robbers;
  public ArrayList<Sheep> flock;
  public ArrayList<Tree> trees;
  public ArrayList<Water> waters;
  public ArrayList<Sprite> sprites;
  private int sheepCount;

  public Main() {
    rows = 10;
    columns = 10;

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

    // add the sheep and robbers
    reset();
  }

  @Override
  public void paintComponent(Graphics g) {
    int w = getWidth();
    int h = getHeight();
    this.requestFocusInWindow();

    // Draw the background
    g.setColor(Color.LIGHT_GRAY);
    g.fillRect(0, 0, w, h);
    g.setColor(Color.BLACK);
    g.drawRect(9, 9, (rows * 60) + 2, (columns * 60) + 2);
    g.setColor(new Color(152, 229, 126));
    g.fillRect(10, 10, rows * 60, columns * 60);

    // Draw the sheep
    for (Sprite sprite : sprites) {
      sprite.draw(g);
    }

  }

  public static void main(String[] args) {
    JFrame window = new JFrame();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setSize(640, 660);
    window.setContentPane(new Main());
    window.setVisible(true);
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
      case KeyEvent.VK_DOWN -> nextPos.y = nextPos.y < 9 ? nextPos.y + 1 : nextPos.y;
      case KeyEvent.VK_LEFT -> nextPos.x = nextPos.x != 0 ? nextPos.x - 1 : nextPos.x;
      case KeyEvent.VK_RIGHT -> nextPos.x = nextPos.x < 9 ? nextPos.x + 1 : nextPos.x;
    }
//    if (key == KeyEvent.VK_UP) {
//      if (nextPos.y != 0) {
//        nextPos.y = nextPos.y - 1;
//      }
//    } else if (key == KeyEvent.VK_DOWN) {
//      if (nextPos.y < 9) {
//        nextPos.y = nextPos.y + 1;
//      }
//    } else if (key == KeyEvent.VK_LEFT) {
//      if (nextPos.x != 0) {
//        nextPos.x = nextPos.x - 1;
//      }
//    } else if (key == KeyEvent.VK_RIGHT) {
//      if (nextPos.x < 9) {
//        nextPos.x = nextPos.x + 1;
//      }
//    }
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

  private void checkSprites(Point nextPos) {
    ammon.setLocation(nextPos);

    for (Robber rob : robbers) {
      if (rob.isNear(ammon)){
//        var choice = JOptionPane.showConfirmDialog(this, "Oh no, Ammon was killed by a robber");
//        if (choice == JOptionPane.YES_OPTION) {
//          reset();
//        } else {
//          System.exit(0);
//        }
      }
    }

    for (Sheep sheep : flock) {
      if (sheep.isTouching(ammon)) {
        sheep.setLocation(null);
        sheepCount--;
      }
    }

    for (Water water : waters) {
      if (water.isTouching(ammon)) {
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

  private void reset() {
    ammon = new Ammon(0, 0);
    sprites = new ArrayList<>();

    // Add the robbers to the screen
    robbers = new ArrayList<>();
    robbers.add(new Robber(0, 7));
    robbers.add(new Robber(1, 4));
    robbers.add(new Robber(3, 0));
    robbers.add(new Robber(5, 8));
    robbers.add(new Robber(7, 1));
    robbers.add(new Robber(7, 5));

    sprites.addAll(robbers);
    sprites.addAll(trees);
    sprites.addAll(waters);

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
    sprites.add(ammon);

  }

  // I don't need the keyTyped method for this project
  @Override
  public void keyTyped(KeyEvent e) {}
  // I don't need the keyReleased method for this project
  @Override
  public void keyReleased(KeyEvent e) {}
}
