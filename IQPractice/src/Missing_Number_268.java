
public class Missing_Number_268 {

    // XOR method
    // Time: O(n)
    // Space: O(1)
    public static int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int miss = nums.length;
        for (int i = 0; i < nums.length; i++) {
            miss ^= i ^ nums[i];
        }
        return miss;
    }

    // Calculate the expected sum, then subtract all numbers, the final result will be the missing number
    // Time: O(n)
    // Space: O(1)
    public static int missingNumber1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int sum = 0;
        int i = 0;
        int n = nums.length;
        //this is equivalent to sum = n * (n - 1) / 2
        while (i <= n) {
            sum += i;
            i++;
        }
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] test1 = new int[] { 3, 0, 1 };
        System.out.println(missingNumber(test1)); // 2

        int[] test2 = new int[] { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
        System.out.println(missingNumber1(test2)); // 8
    }

}
