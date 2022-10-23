import java.util.*;

public class Functions {
  public Functions() {
    // Scanner to read the input from System.in
    Scanner s = new Scanner(System.in);

    // Create ArrayLists of the user input
    ArrayList<String> domain = new ArrayList<>(List.of(s.nextLine().split(" ")));
    ArrayList<String> codomain = new ArrayList<>(List.of(s.nextLine().split(" ")));
    ArrayList<String> relationRaw = new ArrayList<>(List.of(s.nextLine().split(" ")));

    // This Arraylist is for displaying the data
    ArrayList<String> relationParsed = new ArrayList<>();

    // These are for parsing data, basically parallel arrays
    ArrayList<String> images = new ArrayList<>();
    ArrayList<String> preimages = new ArrayList<>();

    // Loop through the relation input array, add to the arrays for checking for functions and bijections
    for (int i = 0; i < relationRaw.size(); i++) {
      String preimage = relationRaw.get(i);
      i++;
      String image = relationRaw.get(i);
      images.add(image);
      preimages.add(preimage);
      relationParsed.add("("+preimage+","+image+")");
    }

    // print the input in the format requested
    System.out.print("DOMAIN: ");
    printSet(domain);
    System.out.print("CODOMAIN: ");
    printSet(codomain);
    System.out.print("RELATION: ");
    printSet(relationParsed);

    // I sort the data to make comparisons easier and more accurate
    Collections.sort(domain);
    Collections.sort(preimages);
    Collections.sort(codomain);
    Collections.sort(images);

    // I check for if it is a function
    if (isFunction(domain, preimages)) {
      // don't short-circuit the if statement, we need to have both things checked for printing
      // it's only a bijection if it is both onto and one-to-one
      if (checkOnto(codomain, images) & checkOneToOne(codomain, images, domain)) {
        System.out.println("It is a bijection");
      } else {
        System.out.println("It is *not* a bijection");
      }
    }
  }

  // this function compares two sorted arrays to check if they represent a domain and set of preimages for a function
  public boolean isFunction(ArrayList<String> d, ArrayList<String> p) {
    if (d.equals(p)) {
      System.out.println("This is a function.");
      return true;
    } else {
      System.out.println("This is *not* a function.");
      return false;
    }
  }

  // this function checks if the provided arrays represent the images of an onto function
  public boolean checkOnto(ArrayList<String> c, ArrayList<String> i) {
    Set<String> coSet = new HashSet<>(c);
    Set<String> imSet = new HashSet<>(i);
    if (c.size() == coSet.size() && coSet.equals(imSet)) {
      System.out.println("It is onto.");
      return true;
    } else {
      System.out.println("It is *not* onto.");
      return false;
    }
  }

  // This checks three arrays to see if there is only one value for each value in the domain, it also checks if the
  // domain is larger than the codomain because if the domain is larger, it can't be one-to-one
  public boolean checkOneToOne(ArrayList<String> c, ArrayList<String> i, ArrayList<String> d) {
    Set<String> set = new HashSet<>(i);
    if (c.size() < d.size() || !(d.size() == set.size())) {
      System.out.println("It is *not* one-to-one");
      return false;
    } else {
      System.out.println("It is one-to-one.");
      return true;
    }
  }

  // This function will print the array of strings to look like a set
  public void printSet(ArrayList<String> set) {
    StringBuilder prettified = new StringBuilder("{ ");
    int len = set.size();
    for (int i=0; i<len; i++) {
      if (i == len-1) {
        prettified.append(set.get(i)).append(" }");
      } else {
        prettified.append(set.get(i)).append(", ");
      }
    }
    System.out.println(prettified);
  }

  public static void main(String[] args) {
    new Functions();
  }
}