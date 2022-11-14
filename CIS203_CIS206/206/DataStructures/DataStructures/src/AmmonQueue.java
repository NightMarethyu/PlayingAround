public class AmmonQueue<T> {

  AmmonNode<T> head;
  AmmonNode<T> tail;

  public AmmonQueue() {
    head = null;
    tail = null;
  }

  public AmmonQueue<T> enqueue(T data) {
    AmmonNode<T> newNode = new AmmonNode<>(data);

    if (head == null) {
      head = newNode;
      tail = newNode;
    } else {
      tail.next = newNode;
    }
    return this;
  }

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

  public AmmonQueue<T> clear() {
    head = null;
    tail = null;
    return this;
  }

  public void print() {
    AmmonNode<T> current = head;
    do {
      System.out.println(current);
      current = current.next;
    } while (current != null);
  }
}
