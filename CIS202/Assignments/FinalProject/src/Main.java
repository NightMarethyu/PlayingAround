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

  public Main() {
    rows = 10;
    columns = 10;
    ammon = new Ammon(0,0);

    // We need a keyListener
    addKeyListener(this);

    // Add the robbers to the screen
    robbers = new ArrayList<>();
    robbers.add(new Robber(0, 7));
    robbers.add(new Robber(1, 4));
    robbers.add(new Robber(3, 0));
    robbers.add(new Robber(5, 8));
    robbers.add(new Robber(7, 1));
    robbers.add(new Robber(9, 9));

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
  }

  @Override
  public void paintComponent(Graphics g) {
    int w = getWidth();
    int h = getHeight();
    requestFocusInWindow();

    // Draw the background
    g.setColor(Color.LIGHT_GRAY);
    g.fillRect(0, 0, w, h);
    g.setColor(Color.BLACK);
    g.drawRect(9, 9, (rows * 60) + 2, (columns * 60) + 2);
    g.setColor(new Color(152, 229, 126));
    g.fillRect(10, 10, rows * 60, columns * 60);

    // Draw the sheep
    for (Sheep sheep : flock) {
      sheep.draw(g);
    }

    // draw the robbers
    for (Robber robber : robbers) {
      robber.draw(g);
    }

    // draw the water
    for (Water water : waters) {
      water.draw(g);
    }

    // draw the trees
    for (Tree tree : trees) {
      tree.draw(g);
    }

    // draw Ammon
    ammon.draw(g);

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
    Point curPos = ammon.getRelativePosition();
    Point nextPos = new Point(curPos);
    if (key == KeyEvent.VK_UP) {
      if (curPos.y != 0) {
        nextPos.y = curPos.y - 1;
      }
    } else if (key == KeyEvent.VK_DOWN) {
      if (curPos.y < 9) {
        nextPos.y = curPos.y + 1;
      }
    } else if (key == KeyEvent.VK_LEFT) {
      if (curPos.x != 0) {
        nextPos.x = curPos.x - 1;
      }
    } else if (key == KeyEvent.VK_RIGHT) {
      if (curPos.x < 9) {
        nextPos.x = curPos.x + 1;
      }
    }
    if (noTree(nextPos)) {
      ammon.setLocation(nextPos);
      repaint();
    }
  }

  // This method will check if there is a tree in the
  // position that Ammon will move to. It will return
  // true if there is not a tree there.
  public boolean noTree(Point p) {
    boolean value = true;
    for (Tree tree : trees) {
      Point treePos = tree.getRelativePosition();
      if (p.x == treePos.x && p.y == treePos.y) {
        value = false;
        break;
      }
    }
    return value;
  }

  // I don't need the keyTyped method for this project
  @Override
  public void keyTyped(KeyEvent e) {}
  // I don't need the keyReleased method for this project
  @Override
  public void keyReleased(KeyEvent e) {}
}
