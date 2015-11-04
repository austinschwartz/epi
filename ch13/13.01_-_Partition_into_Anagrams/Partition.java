import java.util.*;

public class Partition {
  public static List<List<String>> group(String[] strings) {
    Map<String, List<String>> map = new LinkedHashMap<String, List<String>>();
    for (int i = 0; i < strings.length; i++) {
      String str = strings[i];
      String sorted = sortString(str);
      if (map.containsKey(sorted)) {
        List<String> list = map.get(sorted);
        list.add(str);
      } else {
        List<String> list = new ArrayList<String>();
        list.add(str);
        map.put(sorted, list);
      }
    }
    List<List<String>> ret = new ArrayList<List<String>>();
    for (String key : map.keySet())
      ret.add(map.get(key));
    return ret;
  }

  public static String sortString(String str) {
    char[] arr = str.toCharArray();
    Arrays.sort(arr);
    return new String(arr);
  }

  public static void main(String[] args) {
    String[] test = new String[]{"debitcard", "elvis", "silent", 
                "badcredit", "lives", "freedom", "listen", "levis"};
    List<List<String>> groups = group(test);
    for (List<String> list : groups) {
      System.out.println(list);
    }
  }
}
