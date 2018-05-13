
public class House_Robber_III_337 {

    // Time: O(n)
    // space: O(n), ignoring the system recursion stack, there is an array created for each node,
    // so the space complexity is O(2n) = O(n)
    public static int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] res = helper(root);
        return Math.max(res[0], res[1]); //res[0] represents the max rob value without robbing that node, res[1] is the max rob value with robbing that node
    }

    private static int[] helper(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] res = new int[2];
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }

    public static void main(String[] args) {
        //              3
        //            /   \
        //          2       3
        //            \       \
        //              3       1
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        System.out.println(rob(root)); // 7 = 3 + 3 + 1
        //              3
        //            /   \
        //          4       5
        //        /   \       \
        //       1      3       1
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(5);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);
        root1.right.right = new TreeNode(1);
        System.out.println(rob(root1)); // 9 = 4 + 5
    }

}
