import java.util.ArrayList;

public class Longest_Increasing_Subsequence_300 {

    // dp solution
    // Time: O(n^2)
    // Space: O(n)
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length]; // dp[i] means the longest increasing subsequence from 0 to index i
        dp[0] = 1;
        int maxlen = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1; // Fill each position with value 1 in dp
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    //等于 if(dp[j] + 1 > dp[i]) { dp[i] = dp[j] + 1;}
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxlen = Math.max(maxlen, dp[i]); // update the maxlen
        }
        return maxlen;
    }

    // Binary Search and dp
    // Time: O(nlogn)
    // Space: O(n)
    public int lengthOfLIS1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] tails = new int[nums.length];
        int size = 0;
        //用bs找每个元素的插入位置，
        //如果这个元素大于tails的最后一个元素（或tails是空的），把这个元素加到最后，更新size
        //如果这个元素在中间位置，把这个元素的后一位（略大于这个元素的元素）替换成这个元素
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (j - i) / 2 + i;
                if (tails[m] < x) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            tails[i] = x;
            if (i == size) {
                size++;
            }
        }
        return size;
    }

    // Binary Search and a list, 比上一个方法更加直观
    // Time: O(nlogn)
    // Space: O(n)
    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        ArrayList<Integer> res = new ArrayList<>();
        //用bs找每个元素的插入位置，
        //如果这个元素大于tails的最后一个元素（或tails是空的），把这个元素加到最后，更新size
        //如果这个元素在中间位置，把这个元素的后一位（略大于这个元素的元素）替换成这个元素
        for (int x : nums) {
            if (res.size() == 0 || x > res.get(res.size() - 1)) {
                res.add(x);
            } else {
                int i = 0;
                int j = res.size() - 1;
                while (i < j) {
                    int mid = (j - i) / 2 + i;
                    if (res.get(mid) < x) {
                        i = mid + 1;
                    } else {
                        j = mid;
                    }
                }
                res.set(j, x);
            }
        }
        return res.size();
    }
}
