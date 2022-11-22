public class AmmonStack<T> {

  private AmmonNode<T> head;

  /**
   * A new stack contains nothing but an empty head object, the push command must be called to add a new object to the stack
   */
  public AmmonStack() {
    head = null;
  }

  /**
   * Push adds a new node at the head of the stack.
   * @param data  The contents of the new node
   * @return      The stack
   */
  public AmmonStack<T> push(T data) {
    head = new AmmonNode<T>(data, head);
    return this;
  }

  /**
   * Pop will take whatever the current head of the stack is and return it to the user. If the stack is empty it will
   * print out the word empty and return a null object.
   * @return      The head of the stack if there is one or a null object
   */
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

  /**
   * Clear will set the head to null, thus erasing the stack from existence.
   * @return      The now empty stack
   */
  public AmmonStack<T> clear() {
    head = null;
    return this;
  }

  /**
   * Print will create a string that contains the string form of the data of each node in the stack and print it out.
   */
  public void print() {
    AmmonNode<T> current = head;
    if (current != null) {
      String contents = "";
      while (current != null) {
        contents = current + " " + contents;
        current = current.next;
      }
      System.out.println(contents);
    }
  }
}
