import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Average_of_Levels_in_Binary_Tree_637 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    // BFS
    // Time: O(n), since we reach every node in the tree
    // Space: O(m), the size of queue can grow up to the maximum number
    // of nodes at any level in the given binary tree.
    // Here, m refers to the maximum number of nodes at any level in the input tree.
    public static List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> res = new ArrayList<>();
        double sum;
        int count;
        if (root == null) {
            return res;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            sum = 0;
            count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.peek();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                sum += queue.poll().val;
            }
            res.add(sum / count);
        }
        return res;

    }

    // DFS
    // Time: O(n), touches every node
    // Space:O(h). Here, h refers to the height(maximum number of levels)
    // of the given binary tree. Further, the depth of the recursive tree could go up to h only.
    // Could be O(n), if the tree is a one-side tree(除根以外全部是左子树或全部是右子树),
    // levelList will have n elements
    public static List<Double> averageOfLevels1(TreeNode root) {
        List<Double> res = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        helper(root, 0, res, count);
        for (int i = 0; i < res.size(); i++) {
            res.set(i, res.get(i) / count.get(i));
        }
        return res;
    }

    private static void helper(TreeNode node, int level, List<Double> sum,
            List<Integer> count) {
        if (node == null) {
            return;
        }
        if (level < sum.size()) {
            sum.set(level, sum.get(level) + node.val);
            count.set(level, count.get(level) + 1);
        } else {
            sum.add(1.0 * node.val);
            count.add(1);
        }
        helper(node.left, level + 1, sum, count);
        helper(node.right, level + 1, sum, count);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(Integer.MAX_VALUE);
        root.left = new TreeNode(Integer.MAX_VALUE);
        root.right = new TreeNode(Integer.MAX_VALUE);
        System.out.println(averageOfLevels(root));
        System.out.println(averageOfLevels1(root));
    }

}
