
public class Count_Complete_Tree_Nodes_222 {

    // Binary Search
    // Time: O(logn * logn), there are logn times recursion, and height cost O(logn) time
    // Space: O(logn), stack used by recursion
    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if (leftHeight == rightHeight) {
            return (1 << leftHeight) + countNodes(root.right);
        } else {
            return (1 << rightHeight) + countNodes(root.left);
        }
    }

    // get the height of a complete binary tree
    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + height(root.left);
    }
}
