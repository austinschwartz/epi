import java.util.*;

public class SquareRoot {
  public static int squareRoot(int num) {
    int low = 0, high = num;
    while (low <= high) {
      int mid = low + (high - low)/2;
      int square = mid * mid;
      if (square <= num) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return low - 1;
  }
  public static void main(String[] args) {
    System.out.println(squareRoot(16));
    System.out.println(squareRoot(14));
    System.out.println(squareRoot(11));
    System.out.println(squareRoot(300));
  }
}
