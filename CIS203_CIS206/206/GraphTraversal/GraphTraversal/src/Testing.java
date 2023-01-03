import java.util.ArrayList;
import java.util.HashMap;

public class Testing {

  public static int[] nums = {1,2,3,4,5,6,7,8,9};
  public static String[] strings = {"A", "B", "C", "D"};

  public static void main(String[] args) {
    var temp = new HashMap<String, ArrayList<Integer>>();
    for (String s : strings) {
      temp.put(s, new ArrayList<>());
    }

    for (String s : temp.keySet()) {
      for (int i : nums) {
        temp.get(s).add(i);
      }
    }

    for (String s : temp.keySet()) {
      var vals = temp.get(s);
      var line = new StringBuilder(s).append(": ");

      for (int i : vals) {
        line.append(i).append(" ");
      }
      System.out.println(line);
    }
  }
}
