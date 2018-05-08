import java.util.Stack;

public class Path_Sum_112 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && sum - root.val == 0) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val)
                || hasPathSum(root.right, sum - root.val);
    }

    public static boolean hasPathSum1(TreeNode root, int sum) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> sums = new Stack<>();

        stack.push(root);
        sums.push(sum);
        while (!stack.isEmpty() && root != null) {
            int value = sums.pop();
            TreeNode top = stack.pop();

            if (top.left == null && top.right == null && value == top.val) {
                return true;
            }
            if (top.right != null) {
                stack.push(top.right);
                sums.push(value - top.val);
            }
            if (top.left != null) {
                stack.push(top.left);
                sums.push(value - top.val);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //               5
        //           4       8
        //        11      13    4
        //      7   2              1
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(7);
        root.right.right.right = new TreeNode(1);

        System.out.println(hasPathSum(root, 22));
        System.out.println(hasPathSum1(root, 18));
    }

}
