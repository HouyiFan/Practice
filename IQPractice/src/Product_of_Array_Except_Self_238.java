import java.util.Arrays;

public class Product_of_Array_Except_Self_238 {

    // Time: O(n)
    // Space: O(n), used by output
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        //乘每个元素左边的
        int left = 1;
        for (int i = 0; i < n; i++) {
            output[i] = left;
            left *= nums[i];
        }
        //乘每个元素右边的
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            output[i] *= right;
            right *= nums[i];
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(productExceptSelf(new int[] { 1, 2, 3, 4 }))); //[24, 12, 8, 6]
        System.out.println(
                Arrays.toString(productExceptSelf(new int[] { 1, 0, 3, 0 }))); //[0, 0, 0, 0]
    }

}
