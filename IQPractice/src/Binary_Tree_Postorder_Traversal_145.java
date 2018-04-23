import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Binary_Tree_Postorder_Traversal_145 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        return helper(root, res);
    }

    private static List<Integer> helper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return res;
        }
        helper(root.left, res);
        helper(root.right, res);
        res.add(root.val);
        return res;
    }

    public static List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        TreeNode cur = root;

        if (root == null) {
            return res;
        }

        stack.push(root);
        while (!stack.isEmpty()) {
            cur = stack.peek();
            if (prev == null || prev.left == cur || prev.right == cur) { //traverse down the tree
                if (cur.left != null) {
                    stack.push(cur.left);
                } else if (cur.right != null) {
                    stack.push(cur.right);
                }
            } else if (cur.left == prev) { //traverse up the tree from left
                if (cur.right != null) {
                    stack.push(cur.right);
                }
            } else { //traverse up the tree from right
                res.add(cur.val);
                stack.pop();
            }
            prev = cur;
        }
        return res;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
