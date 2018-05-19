
public class Find_Peak_Element_162 {

    // Binary Search, iterative
    // Time: O(logn)
    // Space: O(1)
    public static int findPeakElement(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[mid + 1]) { // if nums[mid] < nums[mid + 1], then we search the peak from mid + 1
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if (low == nums.length - 1 || nums[low] > nums[low + 1]) { //if nums[low] is the end or it is larger than next element
            return low;
        } else {
            return high;
        }
    }

    // Binary Search, recursion
    // Time: O(logn)
    // Space: O(logn), system stack used by recursion
    public static int findPeakElement1(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        return helper(nums, 0, nums.length - 1);
    }

    private static int helper(int[] nums, int low, int high) {
        if (low == high) {
            return low;
        }
        int mid = low + (high - low) / 2;
        if (nums[mid] > nums[mid + 1]) {
            return helper(nums, low, mid); // if nums[mid] > nums[mid + 1], then search for left side
        }
        return helper(nums, mid + 1, high); // otherwise, search for right side
    }

    public static void main(String[] args) {
        int[] test1 = new int[] { 1, 2, 3, 1 };
        System.out.println(findPeakElement(test1)); // 2
        int[] test2 = new int[] { 1, 2, 1, 3, 5, 6, 4 };
        System.out.println(findPeakElement1(test2)); // 1 or 5
    }

}
