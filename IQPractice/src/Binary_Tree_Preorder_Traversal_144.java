import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Binary_Tree_Preorder_Traversal_144 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    // recursion method
    // Time: O(n)
    // Space: O(h), where h is the height of binary tree
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();

        return helper(root, res);
    }

    private static List<Integer> helper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return res;
        }
        res.add(root.val);
        helper(root.left, res);
        helper(root.right, res);

        return res;
    }

    public static List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root != null) {
            res.add(root.val);
            res.addAll(preorderTraversal1(root.left));
            res.addAll(preorderTraversal1(root.right));
        }

        return res;
    }

    // iterative method
    // Time: O(n)
    // Space: O(n), the stack stores
    public static List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                res.add(node.val);
                //push right node first, then left node, so when we pop,
                //we can get left first, then right
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
