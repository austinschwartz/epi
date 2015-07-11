public class MaximumSubarray {
  public static int maxSubarray(int[] arr) {
    int max_ending_here = 0;
    int max = 0;
    for (int i = 0; i < arr.length; i++) {
      if (max_ending_here + arr[i] > max_ending_here)
        max_ending_here += arr[i];
      else
        max_ending_here = 0;
      if (max_ending_here > max)
        max = max_ending_here;
    }
    return max;
  }
  public static void main(String[] args) {
    int[] arr = new int[]{904, 40, 523, 12, -335, -385, -124, 481, -31};
    System.out.println(maxSubarray(arr));
  }
}
