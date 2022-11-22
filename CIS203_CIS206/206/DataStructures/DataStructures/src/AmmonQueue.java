public class AmmonQueue<T> {

  private AmmonNode<T> head;
  private AmmonNode<T> tail;

  /**
   * Calling the constructor will return a new Queue with empty head and tail variables.
   */
  public AmmonQueue() {
    head = null;
    tail = null;
  }

  /**
   * Enqueue adds data to the end of the queue. it will first check if the head is empty i.e. a new queue, then it will
   * add the new node as the tail of the queue. Knowing what object the tail is makes the implementation much faster.
   * @param data  The data to be stored in the new node
   * @return      The updated queue with the new node at the end
   */
  public AmmonQueue<T> enqueue(T data) {
    AmmonNode<T> newNode = new AmmonNode<>(data);

    if (head == null) {
      head = newNode;
    } else {
      tail.next = newNode;
    }
    tail = newNode;
    return this;
  }

  /**
   * Dequeue will take whatever the head object is and remove it from the queue and return it. If the head is empty,
   * it will print empty and return a null object.
   * @return      The first item in the queue (the head) or a null object if no head exists
   */
  public AmmonNode<T> dequeue() {
    if (head != null) {
      AmmonNode<T> current = head;
      head = current.next;
      return current;
    } else {
      System.out.println("empty");
      return null;
    }
  }

  /**
   * Clear will remove that information pointing to the head and tail objects, this makes the queue go away and lets
   * Java's garbage collector remove it from memory.
   * @return      The now empty queue
   */
  public AmmonQueue<T> clear() {
    head = null;
    tail = null;
    return this;
  }

  /**
   * Print will print each item in the queue one at a time starting at the head.
   */
  public void print() {
    AmmonNode<T> current = head;
    while (current != null) {
      System.out.println(current);
      current = current.next;
    }
  }
}
