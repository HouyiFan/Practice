import java.util.Stack;

public class Convert_BST_to_Greater_Tree_538 {

    // Recursive method
    // Time: O(n)
    // Space: O(n), when there's only left and right subtrees
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        this.convertBST(root.right);
        this.sum += root.val;
        root.val = this.sum;
        this.convertBST(root.left);
        return root;
    }

    // Iterative method
    // Time: O(n)
    // Space: O(n)
    public TreeNode convertBST1(TreeNode root) {
        if (root == null) {
            return null;
        }
        int sum = 0;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.right;
            }
            node = stack.pop();
            sum += node.val;
            node.val = sum;
            node = node.left;
        }
        return root;
    }

}
