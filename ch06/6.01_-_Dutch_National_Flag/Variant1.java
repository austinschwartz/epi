import java.util.*;

public class Variant1 {
  public static void partition(int[] nums) {
    int n = nums.length;
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    int mid = 0;
    for (int i = 0; i < n; i++)
      if (nums[i] < min)
        min = nums[i];
      else if (nums[i] > max)
        max = nums[i];

    for (int i = 0; i < n; i++)
      if (nums[i] != min && nums[i] != max)
        mid = nums[i];

    int low = 0, equal = 0, high = n - 1;
    while (equal <= high) {
      if (nums[equal] < mid) {
        swap(nums, low, equal);
        equal++;
        low++;
      } else if (nums[equal] > mid) {
        swap(nums, high, equal);
        high--;
      } else {
        equal++;
      }
    }
  }

  public static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{3, 3, 2, 1, 3, 2, 1, 2, 1, 2, 1};
    partition(nums);
    System.out.println(Arrays.toString(nums));

    int[] nums2 = new int[]{9, 9, 9, 9, 8, 3, 3, 3, 8, 8, 9, 9, 3, 3};
    partition(nums2);
    System.out.println(Arrays.toString(nums2));
  }
}
