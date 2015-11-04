import java.util.*;

public class FindBatteryCapacity {
  public static int minBattery(int[] nums) {
    int prev = 0;
    int max = Integer.MIN_VALUE;
    for (int i = 1; i < nums.length; i++) {
      int curr = 0;
      if (nums[i] > nums[i-1])
        curr = nums[i] - nums[i-1] + prev;
      else
        curr = 0;
      prev = curr;
      max = Math.max(max, curr);
    }
    return max;
  }
  public static void main(String[] args) {
    int[] nums = new int[]{1, 5, 6, 7, 2, 10, 4, 0, 3};
    System.out.println(minBattery(nums));
  }
}
