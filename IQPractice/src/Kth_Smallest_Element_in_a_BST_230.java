import java.util.Stack;

public class Kth_Smallest_Element_in_a_BST_230 {

    // Binary search
    // Time: O(logn)
    // Space: O(logn), used by recursion stack
    public int kthSmallest(TreeNode root, int k) {
        int countForLeft = count(root.left);
        if (k <= countForLeft) {
            return this.kthSmallest(root.left, k);
        } else if (k > countForLeft + 1) {
            return this.kthSmallest(root.right, k - countForLeft - 1);
        } else {
            return root.val;
        }
    }

    public static int count(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + count(node.left) + count(node.right);
    }

    // In-order (iterative)
    // Time: O(logn), in worst case, could be O(n)
    // Space: O(logn), in worst case, could be O(n)
    public int kthSmallest1(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            k--;
            if (k == 0) {
                return node.val;
            }
            if (node.right != null) {
                node = node.right;
                stack.push(node);
                while (node.left != null) {
                    stack.push(node.left);
                    node = node.left;
                }
            }
        }
        return -1;
    }

}
