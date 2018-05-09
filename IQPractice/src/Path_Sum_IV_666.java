import java.util.HashMap;
import java.util.Map;

public class Path_Sum_IV_666 {

    Map<Integer, Integer> tree = new HashMap<>();
    int sum = 0;

    // Time: O(n), where n is the size of nums
    // Space: O(n), system stack used by recursion
    public int pathSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        for (int num : nums) {
            int pos = num / 10;
            int value = num % 10;
            this.tree.put(pos, value);
        }
        this.dfs(nums[0] / 10, 0);
        return this.sum;
    }

    private void dfs(int root, int preSum) {
        int level = root / 10;
        int pos = root % 10;
        int left = 10 * (level + 1) + 2 * pos - 1;
        int right = 10 * (level + 1) + 2 * pos;

        int curSum = preSum + this.tree.get(root);
        if (!this.tree.containsKey(left) && !this.tree.containsKey(right)) {
            this.sum += curSum;
            return;
        }
        if (this.tree.containsKey(left)) {
            this.dfs(left, curSum);
        }
        if (this.tree.containsKey(right)) {
            this.dfs(right, curSum);
        }
    }

    // dp without using global variable
    // Time: O(n)
    // Space: O(1) = O(5 * 9)
    public int pathSum1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        int[][] nodes = new int[5][9]; //因为题目条件：1 <= depth <= 4, 1 <= pos <= 8
        for (int num : nums) {
            int i = num / 100; // i use 1 base
            int j = num / 10 % 10 - 1; // j use 0 base to add the root
            nodes[i][j] = nodes[i - 1][j / 2] + num % 10;
        }
        for (int i = 1; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 4 || nodes[i][j] != 0 && nodes[i + 1][j * 2] == 0
                        && nodes[i + 1][j * 2 + 1] == 0) {
                    sum += nodes[i][j];
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        //      3
        //    /   \
        //   5     1
        //The path sum is (3 + 5) + (3 + 1) = 12.
        int[] nums = new int[] { 113, 215, 221 };
        System.out.println(new Path_Sum_IV_666().pathSum(nums));
        System.out.println(new Path_Sum_IV_666().pathSum1(nums));

    }

}
