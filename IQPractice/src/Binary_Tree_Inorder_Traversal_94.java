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

    // iterative method2
    // Time: O(n)
    // Space: O(n)
    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        //push the left path
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            res.add(node.val);
            //如果有右子树，push右子树的左子树
            if (node.right != null) {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            } else { //如果没有右子树，往上走，先pop掉node（因为已经加到res里面）
                node = stack.pop();
                //如果先前pop的node是现在的右子树，再pop掉右子树（后面会加），确保根先加进去
                //如果先前pop的是现在的左子树，什么都不干，进入上一层
                while (!stack.isEmpty() && stack.peek().right == node) {
                    node = stack.pop();
                }
            }
        }
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
            //这样下次就pop中间（右边的父母），然后管右边的
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
