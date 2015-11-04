import java.util.*;

class MStack {
  private Stack<Integer> stack;
  private Stack<Integer> maxes;

  public MStack() {
    this.stack = new Stack<Integer>();
    this.maxes = new Stack<Integer>();
  }
  public Integer max() {
    return maxes.peek();
  }
  public Integer push(Integer item) {
    stack.push(item);
    if (maxes.size() == 0)
      maxes.push(item);
    else if (item.intValue() >= maxes.peek().intValue())
      maxes.push(item);
    return item;
  }
  public Integer pop() {
    Integer item = stack.pop();
    if (item.intValue() == maxes.peek().intValue())
      maxes.pop();
    return item;
  }
  public boolean empty() {
    return stack.empty();
  }
}

public class MaxStack {
  public static void main(String[] args) {
    MStack maxStack = new MStack();
    maxStack.push(5);
    maxStack.push(2);
    maxStack.push(6);
    maxStack.push(4);
    maxStack.push(5);
    maxStack.push(10);
    System.out.println(maxStack.max()); // 10
    maxStack.pop();
    System.out.println(maxStack.max()); // 6
    maxStack.pop();
    maxStack.pop();
    maxStack.pop();
    System.out.println(maxStack.max()); // 5
  }
}
