import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Level_Order_Traversal_II_107 {

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
    // Space: O(n), in the worst case, if the tree is a balanced search tree
    // the bottom level has 2^(Math.floor(log(n))) = n at most.
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (root == null) {
            return res;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                list.add(queue.poll().val);
            }
            res.add(0, list);
        }
        return res;
    }

    // DFS
    // Time: O(n), touches every node
    // Space:O(n), if the tree is a one-side tree(除根以外全部是左子树或全部是右子树), levelList will have n elements
    public static List<List<Integer>> levelOrderBottom1(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        helper(res, root, 0);
        return res;
    }

    private static void helper(List<List<Integer>> levelList, TreeNode node,
            int level) {
        if (node == null) {
            return;
        }
        if (levelList.size() <= level) {
            levelList.add(0, new LinkedList<Integer>());
        }
        helper(levelList, node.left, level + 1);
        helper(levelList, node.right, level + 1);
        levelList.get(levelList.size() - level - 1).add(node.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(levelOrderBottom(root));
        System.out.println(levelOrderBottom1(root));
    }

}
