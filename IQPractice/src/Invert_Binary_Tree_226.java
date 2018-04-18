import java.util.LinkedList;
import java.util.Queue;

public class Invert_Binary_Tree_226 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    // recursion method
    // Time: O(n), where n is the number of nodes in the tree
    // Space: O(n), Because of recursion, O(h) function calls will be
    // placed on the stack in the worst case, where h is the height of the tree.
    // Because h ∈ O(n), the space complexity is O(n)
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        // exchange left child with right child
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        // get the inverted left subtree and right subtree
        TreeNode invertLeft = invertTree(root.left);
        TreeNode invertRight = invertTree(root.right);
        root.left = invertLeft;
        root.right = invertRight;
        return root;
    }

    // iterative method - BFS
    // Time: O(n)
    // Space: O(n), since the largest length of queue is when
    // reaching the leaf level, which is cell of n/2 (round up): ⌈n/2​​⌉=O(n)
    public static TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            // exchange left child with right child
            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        return root;
    }

    // Another recursive version
    // Time: O(n)
    // Space: O(n), Because of recursion, O(h) function calls will be
    // placed on the stack in the worst case, where h is the height of the tree.
    // Because h ∈ O(n), the space complexity is O(n)
    public static TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return root;
        }
        // get the inverted left subtree and right subtree
        TreeNode invertLeft = invertTree(root.left);
        TreeNode invertRight = invertTree(root.right);
        // assign left subtree to right child of root, right subtree to left child of root
        TreeNode temp = invertLeft;
        root.left = invertRight;
        root.right = temp;
        return root;
    }

    public static void main(String[] args) {
        //       3
        //    9     20
        //        15   7
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);

        invertTree1(tree);
        // I haven't found a appropriate way to test this method
    }

}
