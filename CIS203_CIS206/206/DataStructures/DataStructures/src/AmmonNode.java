public class AmmonNode<T> {

  T data;
  AmmonNode<T> next;

  public AmmonNode(T d) {
    data = d;
    next = null;
  }

  @Override
  public String toString() {
    return data.toString();
  }
}
