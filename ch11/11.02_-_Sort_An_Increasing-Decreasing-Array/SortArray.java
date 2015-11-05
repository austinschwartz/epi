import java.util.*;

public class SortArray {
  public enum Type {
    INCREASING, DECREASING
  }

  public static List<Integer> sortIncreasingDecreasing(List<Integer> nums) {
    List<List<Integer>> sorted = new ArrayList<List<Integer>>();
    Type type = Type.INCREASING;
    int startIndex = 0;
    for (int i = 1; i <= nums.size(); i++) {
      if (i == nums.size() ||
          type == Type.INCREASING && nums.get(i - 1) >= nums.get(i) ||
          type == Type.DECREASING && nums.get(i - 1) < nums.get(i)) {
        List<Integer> subList = nums.subList(startIndex, i);
        if (type == Type.DECREASING)
          Collections.reverse(subList);

        sorted.add(subList);
        startIndex = i;
        type = (type == Type.INCREASING ? 
                  Type.DECREASING : 
                  Type.INCREASING);
      }
    }
    List<Integer> ret = mergeLists(sorted);
    return ret;
  }

  public static List<Integer> mergeLists(List<List<Integer>> lists) {
    List<Integer> ret = new ArrayList<Integer>();
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    int n = lists.size();
    int[] heads = new int[n];
    for (int i = 0; i < n; i++) {
      List<Integer> list = lists.get(i);
      minHeap.offer(list.get(heads[i]));
      heads[i]++;
    }

    while (!minHeap.isEmpty()) {
      ret.add(minHeap.poll());
      
      int minValue = Integer.MAX_VALUE;
      int minIndex = -1;
      for (int i = 0; i < n; i++) {
        List<Integer> thisList = lists.get(i);
        if (heads[i] >= thisList.size())
          continue;
        if (thisList.get(heads[i]) < minValue) {
          minValue = thisList.get(heads[i]);
          minIndex = i;
        }
      }
      if (minIndex == -1)
        continue;
      minHeap.offer(lists.get(minIndex).get(heads[minIndex]));
      heads[minIndex]++;
    }

    return ret;
  }

  public static void main(String[] args) {
    List<Integer> nums = Arrays.asList(57, 131, 493, 294, 221, 339, 418, 452, 442, 190);
    List<Integer> sorted = sortIncreasingDecreasing(nums);
    System.out.println(sorted);
  }
}
