
public class Maximum_Product_of_Three_Numbers_628 {

    // One pass scan to find the 2 smallest values and 3 largest values
    // Time: O(n)
    // Space: O(1)
    // Note: if using Arrays.sort(), it will cost O(nlogn) time and O(logn) space
    public static int maximumProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int e = nums[i];
            if (e > max1) {
                max3 = max2;
                max2 = max1;
                max1 = e;
            } else if (e > max2) {
                max3 = max2;
                max2 = e;
            } else if (e > max3) {
                max3 = e;
            }
            if (e < min1) {
                min2 = min1;
                min1 = e;
            } else if (e < min2) {
                min2 = e;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(maximumProduct(new int[] { 1, 2, 3, -2, 3 }));
        System.out.println(maximumProduct(new int[] { 1, 2, 3, -2, 3, -10 }));

    }

}
