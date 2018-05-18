import java.util.Arrays;

public class Set_Mismatch_645 {

    // Time: O(n)
    // Space: O(1)
    public static int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        int n = nums.length;
        for (int i : nums) {
            if (nums[Math.abs(i) - 1] < 0) {
                res[0] = Math.abs(i); // find the duplicate number
            } else {
                nums[Math.abs(i) - 1] *= -1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                res[1] = i + 1; // find the missing number
            }
        }
        return res;
    }

    // XOR method
    // Time: O(n)
    // Space: O(1)
    public static int[] findErrorNums1(int[] nums) {
        int[] res = new int[2];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int val = Math.abs(nums[i]);
            res[1] ^= (i + 1) ^ val; // res[1] = a ^ b, where a is the duplicate number and b is the missing number
            if (nums[val - 1] < 0) {
                res[0] = val; // res[0] = a
            } else {
                nums[val - 1] *= -1;
            }
        }
        res[1] ^= res[0]; // res[1] = (a ^ b) ^ a = b
        return res;
    }

    public static void main(String[] args) {
        int[] test1 = new int[] { 2, 2 };
        System.out.println(Arrays.toString(findErrorNums(test1))); // [2, 1]
        int[] test2 = new int[] { 1, 2, 2, 4 };
        System.out.println(Arrays.toString(findErrorNums1(test2))); // [2, 3]
    }

}
