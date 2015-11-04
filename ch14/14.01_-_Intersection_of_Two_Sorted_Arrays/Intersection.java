import java.util.*;

public class Intersection {
  public static List<Integer> intersection(int[] a, int[] b) {
    List<Integer> ret = new ArrayList<Integer>();
    for (int i = 0; i < a.length; i++) {
      int anum = a[i];
      int bnum = bSearch(b, anum);
      if (bnum != -1)
        ret.add(anum);
    }
    return ret;
  }

  public static int bSearch(int[] nums, int num) {
    int low = 0, high = nums.length - 1;
    while (low <= high) {
      int mid = low + (high - low)/2;
      if (num < nums[mid]) {
        high = mid - 1;
      } else if (num > nums[mid]) {
        low = mid + 1;
      } else {
        return mid;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    int[] b = new int[]{2, 4, 6, 9, 12, 18};
    System.out.println(intersection(a, b));
  }
}
