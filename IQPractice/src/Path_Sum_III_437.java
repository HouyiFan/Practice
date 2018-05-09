import java.util.HashMap;
import java.util.Map;

public class Path_Sum_III_437 {

    // Time: O(n * height), do dfs for n node, worst case(no branch): O(n^2),
    // best case(balanced binary tree): O(nlogn)
    //
    // Space: O(n), system stack used by recursion
    public static int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return dfs(root, sum) + pathSum(root.left, sum)
                + pathSum(root.right, sum); //with root + left child of root + right child of root
    }

    private static int dfs(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        if (node.val == sum) {
            return 1 + dfs(node.left, sum - node.val)
                    + dfs(node.right, sum - node.val);
        } else {
            return dfs(node.left, sum - node.val)
                    + dfs(node.right, sum - node.val);
        }
    }

    // Time: O(n), touch every node
    // Space: O(n), system stack used by recursion
    public static int pathSum1(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        //key : the prefix sum, value : how many ways get to this prefix sum
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return findPathSum(root, 0, sum, map);
    }

    private static int findPathSum(TreeNode cur, int sum, int target,
            Map<Integer, Integer> map) {
        if (cur == null) {
            return 0;
        }
        // update the prefix sum by adding the current val
        sum += cur.val;
        // get the number of valid path, ended by the current node
        int numPathToCur = map.getOrDefault(sum - target, 0);//current sum - target
        // update the map with the current sum, so the map is good to be passed to the next recursion
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        // add the 3 parts:
        //- the total number of valid paths in the subtree rooted at the current node's left child
        //- the total number of valid paths in the subtree rooted at the current node's right child
        //- the number of valid paths ended by the current node
        int res = numPathToCur + findPathSum(cur.left, sum, target, map)
                + findPathSum(cur.right, sum, target, map);
        // restore the map, as the recursion goes from the bottom to the top
        map.put(sum, map.get(sum) - 1);
        return res;
    }

    public static void main(String[] args) {
        //              10
        //            /     \
        //          5        -3
        //        /   \        \
        //       3     2        11
        //     /  \      \
        //    3   -2      1
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        root.right.right = new TreeNode(11);
        System.out.println(pathSum(root, 10));
        System.out.println(pathSum1(root, 11));

    }

}
