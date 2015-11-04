import java.util.*;

public class Dutch {
  public static void dutchPartition(int pivot, int[] nums) {
    int low = 0, equal = 0, high = nums.length - 1;
    while (equal <= high) {
      if (nums[equal] < pivot) {
        swap(nums, low, equal);
        low++;
        equal++;
      } else if (nums[equal] == pivot) {
        equal++;
      } else {
        swap(nums, high, equal);
        high--;
      }
    }
  }

  public static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1, 2, 3, 4, 1, 1, 2, 3, 4, 3, 3, 3};
    dutchPartition(3, nums);
    System.out.println(Arrays.toString(nums));
    nums = new int[]{1, 2, 3, 4, 1, 1, 2, 3, 4, 3, 3, 3};
    dutchPartition(2, nums);
    System.out.println(Arrays.toString(nums));
  }
}
