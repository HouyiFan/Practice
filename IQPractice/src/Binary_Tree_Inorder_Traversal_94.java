import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Binary_Tree_Inorder_Traversal_94 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    // recursive method
    // Time: O(n), T(n) = 2T(n/2) + 1
    // Space: O(n) in the worst case, O(logn) in the average case by the program stack
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        return helper(root, res);
    }

    private static List<Integer> helper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return res;
        }
        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
        return res;
    }

    // iterative method
    // Time: O(n)
    // Space: O(n)
    public static List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            //when cur is null, transfer cur to right of cur,
            //这样下次就pop中间，然后管右边的
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
