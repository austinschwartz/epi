import java.util.*;

class TreeNode {
  TreeNode left, right;
  int val;
  public TreeNode(int val) {
    this.val = val;
  }
}

public class TestBST {
  public static boolean isBST(TreeNode root) {
    return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  public static boolean isBST(TreeNode root, int min, int max) {
    if (root == null) 
      return true;
    if (root.val < min || root.val > max)
      return false;
    return isBST(root.left, min, root.val) &&
           isBST(root.right, root.val, max);
  }

  public static void main(String[] args) {
    TreeNode a = new TreeNode(8);
    TreeNode b = new TreeNode(4);
    TreeNode c = new TreeNode(2);
    TreeNode d = new TreeNode(6);
    TreeNode e = new TreeNode(13);
    TreeNode f = new TreeNode(1);
    TreeNode g = new TreeNode(3);
    a.left = b;
    a.right = e;
    b.left = c;
    b.right = d;
    c.left = f;
    c.right = g;
    System.out.println(isBST(a));
    c.val = 8;
    System.out.println(isBST(a));

  }
}
