import java.util.*;

public class ThreeSum {
  public static boolean threeSum(int[] nums, int target) {
    Arrays.sort(nums);
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      int newTarget = target - nums[i];
      boolean two = twoSum(nums, newTarget);
      if (two)
        return true;
    }
    return false;
  }
  
  public static boolean twoSum(int[] nums, int target) {
    int low = 0, high = nums.length - 1;
    while (low <= high) {
      if (nums[low] + nums[high] == target) {
        return true;
      } else if (target < nums[low] + nums[high]) {
        high--;
      } else if (target > nums[low] + nums[high]) {
        low++;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(threeSum(new int[]{6, 3, -2, 4, -5, 3, 1}, 5) ? "true" : false);
    System.out.println(threeSum(new int[]{6, 3, -2, 4, -5, 3, 1}, 13) ? "true" : false);
    System.out.println(threeSum(new int[]{6, 3, -2, 4, -5, 3, 1}, 1) ? "true" : false);
    System.out.println(threeSum(new int[]{6, 3, -2, 4, -5, 3, 1}, 184) ? "true" : false);
  }
}
