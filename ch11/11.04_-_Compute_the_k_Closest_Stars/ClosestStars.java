import java.util.*;

class Star {
  int distance, x, y, z;
  public Star(int x, int y, int z) {
    this.x = x; this.y = y; this.z = z;
    this.distance = (int)Math.sqrt(x * x + y * y + z * z);
  }
  public String toString() {
    return x + " " + y + " " + z;
  }
}

public class ClosestStars {
  public static List<Star> kClosest(List<Star> stars, int k) {
    List<Star> ret = new ArrayList<Star>();
    PriorityQueue<Star> minHeap = new PriorityQueue<Star>(new Comparator<Star>() {
      public int compare(Star a, Star b) {
        return new Integer(a.distance).compareTo(new Integer(b.distance));
      }
    });

    // Add first k
    for (int i = 0; i < k; i++) {
      minHeap.offer(stars.get(i));
    }
    
    int i = k;
    while (i < stars.size() - 1) {
      minHeap.offer(stars.get(i));
      ret.add(minHeap.poll());
      i++;
    }

    return ret;
  }

  public static void main(String[] args) {
    List<Star> list = new ArrayList<Star>(){{
      add(new Star(5, 2, 3));
      add(new Star(3, 4, 5));
      add(new Star(2, 3, 4));
      add(new Star(1, 4, 1));
      add(new Star(2, 5, 6));
    }};
    List<Star> closest = kClosest(list, 2);
    for (Star star : closest)
      System.out.println(star);
  }
}
