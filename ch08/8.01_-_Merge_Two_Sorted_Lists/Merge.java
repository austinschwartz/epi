import java.util.*;

public class Merge {
  public static class Node {
    public Node next;
    public int val;
    public Node(int val) {
      this.val = val;
    }
    @Override public String toString() {
      Node temp = this;
      StringBuilder sb = new StringBuilder();
      while (temp != null) {
        sb.append(temp.val);
        temp = temp.next;
        if (temp != null)
          sb.append(" ");
      }
      return sb.toString();
    }
  }

  public static Node append(Node node, Node tail) {
    tail.next = node;
    tail = node;
    return tail;
  }

  public static Node merge(Node a, Node b) {
    Node head = new Node(-1);
    Node tail = head;
    while (a != null && b != null) {
      if (a.val < b.val) {
        tail = append(a, tail);
        a = a.next;
      }
      else {
        tail = append(b, tail);
        b = b.next;
      } 
    }
    while (a != null) {
      append(a, tail);
      a = a.next;
    }
    while (b != null) {
      append(b, tail);
      b = b.next;
    }
    return head.next;
  }

  public static void main(String[] args) {
    Node a = new Node(2);
    Node b = new Node(5);
    Node c = new Node(7);
    a.next = b;
    b.next = c;
    System.out.println(a);

    Node d = new Node(3);
    Node e = new Node(11);
    d.next = e;
    System.out.println(d);

    System.out.println(merge(a, d));
  }
}
