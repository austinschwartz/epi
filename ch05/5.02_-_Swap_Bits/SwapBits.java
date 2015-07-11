public class SwapBits {
  public static int swapBits(int x, int i, int j) {
    if (((x >> i) & 1) != ((x >> j) & 1)) {
      x ^= ((1 << i) | (1 << j));
    }
    return x;
  }

  public static void main(String[] args) {
    System.out.println(swapBits(73, 1, 6)); // should be 11
  }
}
