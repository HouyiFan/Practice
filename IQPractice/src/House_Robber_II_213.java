
public class House_Robber_II_213 {

    // Time: O(n)
    // Space: O(1)
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        return Math.max(helper(nums, 0, n - 1), helper(nums, 1, n));
    }

    private static int helper(int[] nums, int low, int high) {
        int curMax = 0, preMax = 0;
        for (int i = low; i < high; i++) {
            int temp = curMax;
            curMax = Math.max(preMax + nums[i], curMax); // dp[i] = max(dp[i - 2] + nums[i], dp[i - 1])
            preMax = temp;
        }
        return curMax;
    }

    public static void main(String[] args) {
        int[] test = new int[] { 1, 2, 3, 1 };
        System.out.println(rob(test)); // 4
        test = new int[] { 2, 3, 2 };
        System.out.println(rob(test)); // 3

    }

}
