import java.util.*;

public class StringsAndInts {
  public static String intToString(int a) {
    StringBuilder sb = new StringBuilder();
    while (a > 0) {
      sb.append(a % 10);
      a /= 10;
    }
    return sb.reverse().toString();
  }

  public static int stringToInt(String a) {
    a = a.trim();
    int ret = 0;
    boolean negative = false;
    int i = 0;
    if (a.charAt(0) == '-')
      negative = true;

    if (a.charAt(0) == '-' || a.charAt(0) == '+')
      i++;

    while (i < a.length()) {
      ret *= 10;
      ret += (a.charAt(i) - '0');
      i++;
    }
    return negative ? -ret : ret;
  }


  public static void main(String[] args) {
    String a = intToString(1725);
    System.out.println(a);
    int x = stringToInt("-19384");
    System.out.println(x);
  }
}
