import java.util.*;

public class Search {
  public static int search(int[] nums, int k) {
    int low = 0, high = nums.length - 1;
    int result = -1;
    while (low <= high) {
      int mid = low + (high - low)/2;
      if (k > nums[mid]) {
        low = mid + 1;
      } else if (k < nums[mid]) {
        high = mid - 1;
      } else {
        high = mid - 1;
        result = mid;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{-14, -10, 2, 108, 108, 243, 285, 285, 285, 401};
    System.out.println(search(nums, 285)); // 6
    System.out.println(search(nums, 401)); // 9
    System.out.println(search(nums, 108)); // 3
  }
}
