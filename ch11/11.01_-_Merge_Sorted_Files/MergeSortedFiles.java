import java.util.*;

public class MergeSortedFiles {
  public static List<Integer> mergeFiles(List<int[]> files) {
    List<Integer> ret = new ArrayList<Integer>();
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    int[] heads = new int[files.size()];

    for (int i = 0; i < files.size(); i++) {
      if (files.get(i).length > 0) {
        minHeap.offer(files.get(i)[0]);
        heads[i]++;
      }
    }

    while (!minHeap.isEmpty()) {
      int smallestNum = minHeap.poll();
      ret.add(smallestNum);

      int minArrayFile = 0;
      int minArrayNum = Integer.MAX_VALUE;
      for (int i = 0; i < files.size(); i++) {
        int[] file = files.get(i);
        if (heads[i] >= file.length)
          continue;
        int num = file[heads[i]];
        if (num < minArrayNum) {
          minArrayNum = num;
          minArrayFile = i;
        }
      }
      int[] f = files.get(minArrayFile);
      if (heads[minArrayFile] < f.length)
        minHeap.offer(f[heads[minArrayFile]]);
      heads[minArrayFile]++;
    }

    return ret;
  }

  public static void main(String[] args) {
    int[] file1 = new int[]{1, 2, 8, 20, 28, 40, 89, 203};
    int[] file2 = new int[]{3, 4, 5, 6, 75, 91, 132, 135, 139, 140, 150, 160};
    int[] file3 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 500, 1000};
    List<int[]> files = new ArrayList<int[]>(){{
      add(file1);
      add(file2);
      add(file3);
    }};
    List<Integer> sorted = mergeFiles(files);
    System.out.println(sorted);

  }
}
