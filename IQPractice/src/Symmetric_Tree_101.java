import java.util.LinkedList;
import java.util.Queue;

public class Symmetric_Tree_101 {
    // Recursive method
    // Time: O(n)
    // Space: O(h), in the worst case, O(n)
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }

    public static boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return (left.val == right.val) && helper(left.right, right.left)
                && helper(left.left, right.right);
    }

    // Iterative method
    // Time: O(n)
    // Space: O(n) in worst case
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        while (!q.isEmpty()) {
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null || left.val != right.val) {
                return false;
            }
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }
        return true;
    }

}
