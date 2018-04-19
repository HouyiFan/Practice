import java.util.Deque;
import java.util.LinkedList;

public class Convert_Sorted_Array_to_Binary_Search_Tree_108 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    // recursion method
    // Time: O(n)
    // Space: O(n) Because of recursion, O(h) function calls will be
    // placed on the stack in the worst case, where h is the height of the tree.
    // Because h ∈ O(n), the space complexity is O(n)
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int low = 0;
        int high = nums.length - 1;
        return helper(nums, low, high);
    }

    private static TreeNode helper(int[] nums, int low, int high) {
        // 如果有＝号的话，会忽略右边的
        // 会导致下面的例子产生的树变成：
        //              0
        //     -10              5
        //  null   null    null   null
        if (low > high) {
            return null;
        }
        int mid = low + (high - low) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode left = helper(nums, low, mid - 1);
        TreeNode right = helper(nums, mid + 1, high);
        root.left = left;
        root.right = right;
        return root;
    }

    // iterative method - three stacks
    // Time: O(n), add all nodes to node stack and pop it
    // Space: O(n), nodeStack will push the leaf level at most,
    // which is cell of n/2 (round up): ⌈n/2​​⌉=O(n)
    public static TreeNode sortedArrayToBST1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int low = 0;
        int high = nums.length - 1;
        // 0 as a placeholder
        TreeNode head = new TreeNode(0);

        Deque<TreeNode> nodeStack = new LinkedList<>();
        nodeStack.push(head);
        Deque<Integer> leftIndexStack = new LinkedList<>();
        leftIndexStack.push(low);
        Deque<Integer> rightIndexStack = new LinkedList<>();
        rightIndexStack.push(high);

        while (!nodeStack.isEmpty()) {
            TreeNode cur = nodeStack.pop();
            int left = leftIndexStack.pop();
            int right = rightIndexStack.pop();
            int mid = left + (right - left) / 2;
            cur.val = nums[mid];
            if (left <= mid - 1) {
                cur.left = new TreeNode(0);
                nodeStack.push(cur.left);
                leftIndexStack.push(left);
                rightIndexStack.push(mid - 1);
            }
            if (right >= mid + 1) {
                cur.right = new TreeNode(0);
                nodeStack.push(cur.right);
                leftIndexStack.push(mid + 1);
                rightIndexStack.push(right);
            }
        }
        return head;

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array = new int[] { -10, -3, 0, 5, 9 };
        sortedArrayToBST(array);
        //           0
        //   -10           5
        // null  -3   null    9
    }

}
