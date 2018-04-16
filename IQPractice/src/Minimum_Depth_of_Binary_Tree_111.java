
public class Minimum_Depth_of_Binary_Tree_111 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        if (leftDepth == 0) {
            return rightDepth + 1;
        } else if (rightDepth == 0) {
            return leftDepth + 1;
        }
        return Math.min(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        //     1
        //   2
        Minimum_Depth_of_Binary_Tree_111 object = new Minimum_Depth_of_Binary_Tree_111();
        TreeNode tree = object.new TreeNode(1);
        tree.left = object.new TreeNode(2);
        System.out.println(minDepth(tree));
        tree.left.left = object.new TreeNode(2);
        //      1
        //    2
        //  2
        System.out.println(minDepth(tree));

    }

}
