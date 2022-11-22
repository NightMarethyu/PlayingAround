public class AmmonNode<T> {

  T data;
  AmmonNode<T> next;

  /**
   * Creates and returns a new node with the data being set by the input parameter d
   * @param d   The data to be stored in the node
   */
  public AmmonNode(T d) {
    data = d;
    next = null;
  }

  /**
   * Creates a new node and points the next variable at another node, thus creating a linked list.
   * @param d   The data to be stored in the node
   * @param n   The next item in the linked list
   */
  public AmmonNode(T d, AmmonNode<T> n) {
    data = d;
    if (n != null) {
      next = n;
    }
  }

  /**
   * This will make a string object out of the data stored in the node
   * @return    A string of the data in the node
   */
  @Override
  public String toString() {
    return data.toString();
  }
}
