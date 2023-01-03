import java.util.*;

public class Main {

  ArrayList<String> depthFirstOrder;
  ArrayList<String> breadthFirstOrder;
  String start;
  HashMap<String, ArrayList<String>> map;

  public Main() {
    // Create a scanner to read in the values
    Scanner s = new Scanner(System.in);
    // get the list of nodes and separate it into an array
    var nodesRow = s.nextLine();
    var nodes = nodesRow.split(" ");

    // prepare the variables we will be working with for the traversal
    depthFirstOrder = new ArrayList<>();
    breadthFirstOrder = new ArrayList<>();
    start = s.nextLine();
    map = new HashMap<>();

    // Prepare the hashmap for adding the neighbors
    for (String key : nodes) {
      map.put(key, new ArrayList<>());
    }

    // start reading in the rest of the file
    var neighbor = s.nextLine();

    // Add the neighboring nodes to the map
    while (!neighbor.equals("***")) {
      var pair = neighbor.split(" ");
      map.get(pair[0]).add(pair[1]);
      map.get(pair[1]).add(pair[0]);

      neighbor = s.nextLine();
    }

    // By sorting the neighbors for each value we will visit them in the correct order
    for (ArrayList<String> list : map.values()) {
      Collections.sort(list);
    }

    // Now that the neighbors are sorted we can traverse the graph using the helper methods
    depthFirst(start);
    breadthFirst(start);

    //*****************************************************************
    // Print the output after this
    System.out.println("Node Neighbors:");
    for (Map.Entry<String, ArrayList<String>> kv : map.entrySet()) {
      printGraph(kv.getKey(), kv.getValue());
    }

    // Print out the depth-first list, I make it pretty using a StringBuilder
    System.out.println("\nDepth-First Search:");
    StringBuilder dfo = new StringBuilder();
    for (String n : depthFirstOrder) {
      dfo.append(n).append(" ");
    }
    System.out.println(dfo);

    // Now print the breadth-first search, again making it pretty with a StringBuilder
    System.out.println("\nBreadth-First Search:");
    StringBuilder bfo = new StringBuilder();
    for (String n : breadthFirstOrder) {
      bfo.append(n).append(" ");
    }
    System.out.println(bfo);
  }

  /**
   * This is an implementation of the pseudocode found on page 597 of the text book. Since the values in the neighbors of
   * the node are sorted the order in which they will be visited are sorted as well.
   *
   * @param node    The node to be checked and added to the list
   */
  private void depthFirst(String node) {
    if (!depthFirstOrder.contains(node)) {
      depthFirstOrder.add(node);
      for (String n : map.get(node)) {
        depthFirst(n);
      }
    }
  }

  /**
   * This is an implementation of the pseudocode found on page 599 of the text book. It will add each neighbor of the
   * node to the list and then begin adding those nodes neighbors.
   *
   * @param node    The first node to be checked and added to the list
   */
  private void breadthFirst(String node) {
    Queue<String> queue = new LinkedList<>();
    breadthFirstOrder.add(node);
    queue.offer(node);
    while(!queue.isEmpty()) {
      for (String s : map.get(queue.peek())) {
        if (!breadthFirstOrder.contains(s)) {
          breadthFirstOrder.add(s);
          queue.offer(s);
        }
      }
      queue.poll();
    }
  }

  /**
   * This will print out the neighbors of the nodes in the way that the assignment wants them to be printed.
   *
   * @param key   The node that is being listed
   * @param values  The neighbors of the node in the key
   */
  private void printGraph(String key, ArrayList<String> values) {
    StringBuilder sb = new StringBuilder();
    sb.append(key).append(": ");
    for (String v : values) {
      sb.append(v).append(" ");
    }
    System.out.println(sb.toString().strip());
  }

  public static void main(String[] args) {
    new Main();
  }
}