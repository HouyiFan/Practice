
public class Search_Insert_Position_35 {

    // Binary search
    // Time: O(logn)
    // Space: O(1)
    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2; // avoid overflow
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid;
            } else {
                high = mid;
            }
        }
        if (nums[low] >= target) {
            return low;
        } else if (nums[high] >= target) {
            return high;
        }
        return high + 1; // if nums[high] < target, then return high + 1
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[] { 1, 3, 5, 6 }, 5)); // 2
        System.out.println(searchInsert(new int[] { 1, 3, 5, 6 }, 2)); // 1
        System.out.println(searchInsert(new int[] { 1, 3, 5, 6 }, 7)); // 4
        System.out.println(searchInsert(new int[] { 1, 3, 5, 6 }, 0)); // 0
    }

}
