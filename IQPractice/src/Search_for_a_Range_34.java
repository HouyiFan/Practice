import java.util.Arrays;

public class Search_for_a_Range_34 {

    // Do two binary search to find the lowest index and highest index respectively
    // Time: O(logn)
    // Space: O(1)
    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] { -1, -1 };
        }
        int[] res = new int[] { -1, -1 };
        // First BS to find the lowest index
        int low = 0;
        int high = nums.length - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                high = mid;
            } else {
                low = mid;
            }
        }
        if (nums[low] == target) {
            res[0] = low;
        } else if (nums[high] == target) {
            res[0] = high;
        }
        // Second BS to find the highest index
        low = 0;
        high = nums.length - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                high = mid;
            } else {
                low = mid;
            }
        }
        if (nums[high] == target) {
            res[1] = high;
        } else if (nums[low] == target) {
            res[1] = low;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test1 = new int[] { 5, 7, 7, 8, 8, 10 };
        int target1 = 8;
        System.out.println(Arrays.toString(searchRange(test1, target1))); // [3,4]

        int[] test2 = new int[] { 5, 7, 7, 8, 8, 10 };
        int target2 = 6;
        System.out.println(Arrays.toString(searchRange(test2, target2))); // [-1,-1]

    }

}
