import java.util.LinkedList;
import java.util.Queue;

public class Same_Tree_100 {

    // Recursive method
    // Time: O(n)
    // Space: O(h), in the worst case, O(n)
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null & q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return (p.val == q.val) && this.isSameTree(p.left, q.left)
                && this.isSameTree(p.right, q.right);
    }

    // Iterative method, 把queue变成stack也行,这样会从bfs变成dfs，不过只需要把下面代码的queue变成stack就行
    // Time: O(n)
    // Space: O(n) in worst case
    public boolean isSameTree1(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);
        while (!queue.isEmpty()) {
            TreeNode pNode = queue.poll();
            TreeNode qNode = queue.poll();
            if (pNode == null && qNode == null) {
                continue;
            }
            if (pNode == null || qNode == null || pNode.val != qNode.val) {
                return false;
            }
            queue.add(pNode.left);
            queue.add(qNode.left);
            queue.add(pNode.right);
            queue.add(qNode.right);
        }
        return true;
    }
}
