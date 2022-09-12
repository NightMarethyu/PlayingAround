import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // These variables are used for the basic math
    double[] nums;
    int count;
    double sum = 0;
    // I use scanner to get the values from System.in
    Scanner s = new Scanner(System.in);

    // The first integer in System.in is the number of items in the array
    count = s.nextInt();
    // I create a new array with the length of the number of variables we are being given
    nums = new double[count];

    // Here I pull in the numbers from System.in. I read them in as doubles for later floating point math
    // I also add them to the sum as they are pulled in for fewer iterations
    for (int i=0; i<count; i++) {
      nums[i] = s.nextDouble();
      sum += nums[i];
    }
    // Print out the sum in a formatted number
    System.out.printf("Sum: %.2f\n", sum);
    // calculate the average and print it
    double avg = sum / count;
    System.out.printf("Mean: %.2f\n", avg);

    // I use Java's built-in sort function on the array, calculate the midpoint, then if the count is even I calculate
    // the average of the two and display that as the median, or just display the median if the count is odd
    Arrays.sort(nums);
    int mid = count / 2;
    if (count % 2 == 0) {
      double median = (nums[mid] + nums[mid - 1])/2;
      System.out.printf("Median: %.2f\n", median);
    } else {
      System.out.printf("Median: %.2f\n", nums[mid]);
    }
  }
}
