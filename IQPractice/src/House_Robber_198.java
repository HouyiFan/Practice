
public class House_Robber_198 {

    // dp with creating an array
    // TIme: O(n)
    // Space: O(n)
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];

    }

    // dp without array
    // Time: O(n)
    // Space: O(1)
    public static int rob1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int curMax = 0;
        int preMax = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = curMax;
            curMax = Math.max(preMax + nums[i], curMax); // dp[i] = max(dp[i - 2] + nums[i], dp[i - 1])
            preMax = temp;
        }
        return curMax;
    }

    public static void main(String[] args) {
        int[] test = new int[] { 1, 2, 3, 1 };
        System.out.println(rob(test));
        System.out.println(rob1(test));
    }

}
