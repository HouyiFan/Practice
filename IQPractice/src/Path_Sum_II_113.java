import java.util.ArrayList;
import java.util.List;

public class Path_Sum_II_113 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    // Time: O(n), since it reaches every node
    // Space: O(n)
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<>();
        helper(root, sum, res, path);
        return res;
    }

    public static void helper(TreeNode node, int sum, List<List<Integer>> res,
            List<Integer> path) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        if (node.left == null && node.right == null && node.val == sum) {
            res.add(new ArrayList<>(path)); //这里如果直接加path,加的会是reference，这样到最后path会变成空，res里面会都是空list
        } else {
            helper(node.left, sum - node.val, res, path);
            helper(node.right, sum - node.val, res, path);
        }
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        //               5
        //           4         8
        //         11      13     4
        //       7   2         5    1
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        System.out.println(pathSum(root, 22));

    }

}
