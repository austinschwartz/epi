import java.util.*;

class TreeNode {
  TreeNode left, right;
  int val;
  public TreeNode(int val) {
    this.val = val;
  }
}

public class BalancedTree {
  /*        8
   *       / \
   *      4   9
   *     / \ 
   *    2   6 
   *   /
   *  1
   */
  public static int height(TreeNode root) {
    if (root == null) return 0;
    int left = height(root.left);
    int right = height(root.right);
    return Math.max(left, right) + 1;
  }
  public static boolean isBalanced(TreeNode root) {
    if (root == null) return true;
    if (isBalanced(root.left) && 
        isBalanced(root.right) &&
        Math.abs(height(root.left) - height(root.right)) <= 1)
        return true;
    return false;
  }
  public static void main(String[] args) {
    TreeNode a = new TreeNode(8);
    TreeNode b = new TreeNode(4);
    TreeNode c = new TreeNode(9);
    TreeNode d = new TreeNode(2);
    TreeNode e = new TreeNode(6);
    TreeNode f = new TreeNode(1);
    a.left = b;
    a.right = c;
    b.left = d;
    b.right = e;
    d.right = f;
    System.out.println(isBalanced(a) ? "Yes" : "No");
    System.out.println(isBalanced(b) ? "Yes" : "No");
  }
}
