public class AmmonStack<T> {

  AmmonNode<T> head;

  public AmmonStack() {
    head = null;
  }

  public AmmonStack<T> push(T data) {
    AmmonNode<T> newNode = new AmmonNode<T>(data);

    if (head != null) {
      newNode.next = head;
    }
    head = newNode;
    return this;
  }

  public AmmonNode<T> pop() {
    if (head != null) {
      AmmonNode<T> second = head.next;
      AmmonNode<T> current = head;
      head = second;
      return current;
    } else {
      System.out.println("empty");
      return null;
    }
  }

  public AmmonStack<T> clear() {
    head = null;
    return this;
  }

  public void print() {
    AmmonNode<T> current = head;
    while (current != null) {
      System.out.println(current);
      current = current.next;
    }
  }
}
