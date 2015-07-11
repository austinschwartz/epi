import java.util.*;

public class Parity {
  // O(n)
  public static int parity(int x) {
    int n = 0;
    while (x > 0) {
      n ^= x & 1;
      x >>= 1;
    }
    return n;
  }
  
  // O(k) where k = # of bits set to 1
  public static int parityFaster(int x) {
    int n = 0;
    while (x > 0) {
      n ^= 1;
      x = x & (x - 1);
    }
    return n;
  }

  public static void main(String[] args) {
    System.out.println(parityFaster(11)); // 1011
    System.out.println(parityFaster(136)); // 136
    System.out.println(parityFaster(1)); // 1
  }
}
